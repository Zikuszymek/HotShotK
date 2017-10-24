package ziku.app.hotshotk.customviews

import android.content.Context
import android.support.v4.widget.SwipeRefreshLayout
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.ViewConfiguration


class CustomSwipeRefreshLayout(context: Context, attributes: AttributeSet) : SwipeRefreshLayout(context, attributes) {

    private val mTouchSlop: Int by lazy {
        ViewConfiguration.get(context).scaledTouchSlop
    }
    private var mPrevX: Float = 0.toFloat()
    private var mDeclined: Boolean = false

    override fun onInterceptTouchEvent(event: MotionEvent): Boolean {

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                mPrevX = MotionEvent.obtain(event).x
                mDeclined = false
            }

            MotionEvent.ACTION_MOVE -> {
                val eventX = event.x
                val xDiff = Math.abs(eventX - mPrevX)

                if (mDeclined || xDiff > mTouchSlop) {
                    mDeclined = true
                    return false
                }
            }
        }

        return super.onInterceptTouchEvent(event)
    }
}



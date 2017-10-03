package ziku.app.hotshotk.activities.intro

import android.animation.ObjectAnimator
import android.os.Bundle
import android.os.Handler
import android.support.animation.DynamicAnimation
import android.support.animation.FlingAnimation
import android.view.animation.AccelerateInterpolator
import android.view.animation.Animation
import android.view.animation.DecelerateInterpolator
import android.view.animation.TranslateAnimation
import kotlinx.android.synthetic.main.activity_intro.*
import ziku.app.hotshotk.R
import ziku.app.hotshotk.activities.BaseActivity

class IntroActivity : BaseActivity() {

    val ANIMATION_START = 1000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
        randomizeFlameOutsidePosition()
        startFlameAnimationHandler()
    }

    private fun startFlameAnimationHandler() {
        Handler().postDelayed({ startFlameAnimation() }, ANIMATION_START)
    }

    private fun startFlameAnimation() {
        val locationArray = IntArray(2)
        shot_icon.getLocationOnScreen(locationArray)
//        flame_icon.animate().x(locationArray[0].toFloat()).y(locationArray[1].toFloat())
//        shot_icon.getLocationInWindow(locationArray)
//        flingAnimationY.setStartVelocity(2000f)
//        flingAnimationX.setStartVelocity(2000f)
//        flingAnimationY.start()
//        flingAnimationX.start()

        var moveAnimation = TranslateAnimation(Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF,
                locationArray[0].toFloat(), Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, locationArray[1].toFloat())
        moveAnimation.fillBefore = true
        moveAnimation.duration = 1000
        moveAnimation.interpolator = DecelerateInterpolator(2.0f)
        moveAnimation.fillAfter = true
        flame_icon.startAnimation(moveAnimation)
    }

    private fun randomizeFlameOutsidePosition() {

    }

    private val flingAnimationX: FlingAnimation by lazy(LazyThreadSafetyMode.NONE) {
        FlingAnimation(flame_icon, DynamicAnimation.X).setFriction(1.2f)
    }

    private val flingAnimationY: FlingAnimation by lazy(LazyThreadSafetyMode.NONE) {
        FlingAnimation(flame_icon, DynamicAnimation.Y).setFriction(1.2f)
    }
}

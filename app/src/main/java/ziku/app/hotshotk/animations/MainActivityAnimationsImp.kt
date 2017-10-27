package ziku.app.hotshotk.animations

import android.content.Context
import android.os.Handler
import android.support.transition.TransitionManager
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_hot_shot_main.view.*
import ziku.app.hotshotk.R
import javax.inject.Inject

class MainActivityAnimationsImp @Inject constructor(
        val context: Context
) : MainActivityAnimations {

    companion object {
        const val ANIMATION_DELAY = 80L
    }

    private var isMenuOpen = false
    private var animationRunning = false
    lateinit var animationView: View
    private val growMenuAnimation: Animation by lazy {
        initMenuAnimations(R.anim.grow_animation, View.VISIBLE)
    }

    private val shrinkMenuAnimation: Animation by lazy {
        initMenuAnimations(R.anim.shrink_animation, View.INVISIBLE)
    }

    lateinit var animationOrderView: List<View>

    override fun setView(animationView: View) {
        this.animationView = animationView
        animationOrderView = listOf(animationView.settings, animationView.play_store, animationView.share, animationView.info)
    }

    override fun invokeMenuAnimation(view: View) {
        onMenuClickListener()
    }

    private fun onMenuClickListener() {
        if (!animationRunning) {
            when (isMenuOpen) {
                false -> {
                    startCircularAnimation(true)
                    animationView.menu_and_settings.startAnimation(growMenuAnimation)
                    animationView.menu_icon.startAnimation(AnimationUtils.loadAnimation(context, R.anim.rotate_icon_animation))
                    animationOrderView.forEachIndexed { index, view ->
                        startMenuItemAnimation(view, !isMenuOpen, index * ANIMATION_DELAY)
                    }
                    isMenuOpen = true
                }
                true -> {
                    startCircularAnimation(false)
                    animationView.menu_and_settings.startAnimation(shrinkMenuAnimation)
                    animationView.menu_icon.startAnimation(AnimationUtils.loadAnimation(context, R.anim.rotate_back_icon_animation))
                    animationOrderView.forEachIndexed { index, view ->
                        startMenuItemAnimation(view, !isMenuOpen, index * ANIMATION_DELAY)
                    }
                    isMenuOpen = false
                }
            }
        }
    }

    private fun startCircularAnimation(shallExpand: Boolean) {
        when (shallExpand) {
            true -> {
                TransitionManager.beginDelayedTransition(animationView as ViewGroup)
                animationView.blocking_background.visibility = View.VISIBLE
            }
            false -> {
                TransitionManager.beginDelayedTransition(animationView as ViewGroup)
                animationView.blocking_background.visibility = View.GONE
            }
        }
    }

    private fun initMenuAnimations(animationId: Int, visibility: Int): Animation {
        var animation = AnimationUtils.loadAnimation(context, animationId)
        animation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {
                animationRunning = true
            }

            override fun onAnimationEnd(animation: Animation) {
                animationRunning = false
                animationOrderView.forEach { it.visibility = visibility }
            }

            override fun onAnimationRepeat(animation: Animation) {}
        })
        return animation
    }

    fun startMenuItemAnimation(view: View, showMenuItem: Boolean, delayTime: Long) {
        Handler().postDelayed({
            var animations: Animation
            when (showMenuItem) {
                true -> animations = AnimationUtils.loadAnimation(context, R.anim.fade_in_animation)
                false -> animations = AnimationUtils.loadAnimation(context, R.anim.fade_out_animation)
            }
            view.startAnimation(animations)
        }, delayTime)
    }

}

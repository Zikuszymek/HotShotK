package ziku.app.hotshotk.activities.intro

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.*
import kotlinx.android.synthetic.main.activity_intro.*
import ziku.app.hotshotk.R
import ziku.app.hotshotk.activities.BaseActivity
import android.view.animation.Animation
import ziku.app.hotshotk.activities.hotshotmain.HotShotMainActivity


class IntroActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
        startFlameAnimation()
    }

    private fun startFlameAnimation() {
        val locationArray = IntArray(2)
        shot_icon.getLocationOnScreen(locationArray)

        val animationSet = AnimationSet(false)
        animationSet.addAnimation(getTranslateAnimation())
        animationSet.addAnimation(getAlphaAnimation())
        animationSet.setAnimationListener(getAnimationListener())
        flame_icon.startAnimation(animationSet)
    }

    private fun getTranslateAnimation(): TranslateAnimation {
        val moveAnimation = TranslateAnimation(-600f, 0f, 0f, 0f)
        moveAnimation.fillBefore = true
        moveAnimation.duration = 2000
        moveAnimation.interpolator = DecelerateInterpolator(2.0f)
        moveAnimation.fillAfter = true
        return moveAnimation
    }

    private fun getAlphaAnimation(): AlphaAnimation {
        val alphaAnimation = AlphaAnimation(0f, 100f)
        alphaAnimation.interpolator = AccelerateInterpolator()
        alphaAnimation.fillBefore = true
        alphaAnimation.duration = 3000
        alphaAnimation.fillAfter = true
        return alphaAnimation
    }

    private fun getAnimationListener(): Animation.AnimationListener {
        return object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {
                flame_icon.visibility = View.VISIBLE
            }

            override fun onAnimationEnd(animation: Animation) {
                startMainActivity()
            }

            override fun onAnimationRepeat(animation: Animation) {}
        }
    }

    private fun startMainActivity() {
        startActivity(Intent(this, HotShotMainActivity::class.java))
        finish()
    }
}

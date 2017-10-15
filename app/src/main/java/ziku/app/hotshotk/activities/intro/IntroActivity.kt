package ziku.app.hotshotk.activities.intro

import android.animation.AnimatorInflater
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

        val animationSet = AnimationUtils.loadAnimation(this, R.anim.intro_animation)
        animationSet.setAnimationListener(getAnimationListener())
        flame_icon.startAnimation(animationSet)
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
        overridePendingTransition(0, R.anim.abc_fade_out)
        startActivity(Intent(this, HotShotMainActivity::class.java))
        finish()
    }
}

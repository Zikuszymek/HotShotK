package ziku.app.hotshotk.activities.hotshotmain

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_hot_shot_main.*
import ziku.app.hotshotk.R
import ziku.app.hotshotk.activities.BaseActivity
import ziku.app.hotshotk.activities.settings.SettingsActivity
import ziku.app.hotshotk.fragments.hotshot.FragmentViewPagerAdapter
import javax.inject.Inject

class HotShotMainActivity : BaseActivity(), HotShotContractor.View {

    @Inject
    lateinit var presenter: HotShotContractor.Presenter

    private var isMenuOpen = false
    private var animationRunning = false

    private val growMenuAnimation: Animation by lazy {
        initMenuAnimations(R.anim.grow_animation)
    }

    private val shringMenuAnimation: Animation by lazy {
        initMenuAnimations(R.anim.shrink_animation)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hot_shot_main)
        initViewComponents()
    }

    fun initViewComponents() {
        menu_and_settings.setOnClickListener { onMenuClickListener(it) }
        view_pager.adapter = FragmentViewPagerAdapter(supportFragmentManager)
        swipe_refresher.setOnRefreshListener {
            presenter.refreshOffer()
        }
        headers_tab_layout.setupWithViewPager(view_pager)
        for (i in 0 until headers_tab_layout.tabCount) {
            headers_tab_layout.getTabAt(i)?.icon = resources.getDrawable(R.drawable.ic_hotshotlogo)
        }
        play_store.setOnClickListener { startSettingsActivity(it) }
        share.setOnClickListener { startSettingsActivity(it) }
        info.setOnClickListener { startSettingsActivity(it) }
        settings.setOnClickListener { startSettingsActivity(it) }
    }

    private fun startSettingsActivity(view : View){
        startActivity(Intent(this, SettingsActivity::class.java))
    }

    private fun initMenuAnimations(animationId: Int): Animation {
        var animation = AnimationUtils.loadAnimation(this, animationId)
        animation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {
                animationRunning = true
            }

            override fun onAnimationEnd(animation: Animation) {
                animationRunning = false
            }

            override fun onAnimationRepeat(animation: Animation) {}
        })
        return animation
    }

    fun onMenuClickListener(view: View) {
        if (!animationRunning) {
            when (isMenuOpen) {
                false -> {
                    openMenuAnimation()
                    view.startAnimation(growMenuAnimation)
                    isMenuOpen = true
                }
                true -> {
                    closeMenuAnimation()
                    view.startAnimation(shringMenuAnimation)
                    isMenuOpen = false
                }
            }
        }
    }

    fun openMenuAnimation(){
        startMenuItemAnimation(play_store, true)
        startMenuItemAnimation(share, true)
        startMenuItemAnimation(info, true)
        startMenuItemAnimation(settings, true)
    }

    fun closeMenuAnimation(){
        startMenuItemAnimation(play_store, false)
        startMenuItemAnimation(share, false)
        startMenuItemAnimation(info, false)
        startMenuItemAnimation(settings, false)
    }

    fun startMenuItemAnimation(view : View, showMenuItem: Boolean){
        var animations : Animation
        when(showMenuItem){
            true -> animations = AnimationUtils.loadAnimation(this, R.anim.abc_fade_out)
            false -> animations = AnimationUtils.loadAnimation(this, R.anim.abc_fade_in)
        }
        animations.setAnimationListener(getMenuAnimationListener(view, showMenuItem))
        view.startAnimation(animations)
    }

    fun getMenuAnimationListener(view : View, showMenuItem : Boolean) : Animation.AnimationListener{
        return object : Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation) {
                if(showMenuItem) view.visibility = View.VISIBLE
            }

            override fun onAnimationEnd(animation: Animation) {
                if(!showMenuItem) view.visibility = View.GONE
            }

            override fun onAnimationRepeat(animation: Animation) {}
        }
    }

    override fun onPause() {
        super.onPause()
        presenter.deattachView()
    }

    override fun onResume() {
        super.onResume()
        presenter.attachView(this)
    }

    override fun refreshViewPagers() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showErrorNotification() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

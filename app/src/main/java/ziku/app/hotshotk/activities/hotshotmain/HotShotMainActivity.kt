package ziku.app.hotshotk.activities.hotshotmain

import android.content.Intent
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_hot_shot_main.*
import ziku.app.hotshotk.R
import ziku.app.hotshotk.activities.BaseActivity
import ziku.app.hotshotk.activities.settings.SettingsActivity
import ziku.app.hotshotk.animations.MainActivityAnimations
import ziku.app.hotshotk.fragments.hotshot.FragmentViewPagerAdapter
import javax.inject.Inject

class HotShotMainActivity : BaseActivity(), HotShotContractor.View {

    @Inject
    lateinit var presenter: HotShotContractor.Presenter

    @Inject
    lateinit var mainActivityAnimations: MainActivityAnimations

    private val broadcastReceiver: HotShotReceiver by lazy {
        HotShotReceiver(this::refreshViewPagers)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hot_shot_main)
        initViewComponents()
        mainActivityAnimations.setView(main_content_activity)
    }

    fun initViewComponents() {
        blocking_background.setOnClickListener({ onMenuClickListener(it) })
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

    private fun onMenuClickListener(view: View) {
        mainActivityAnimations.invokeMenuAnimation(view)
    }

    private fun startSettingsActivity(view: View) {
        startActivity(Intent(this, SettingsActivity::class.java))
    }

    override fun onPause() {
        super.onPause()
        presenter.deattachView()
        unregisterReceiver(broadcastReceiver)
        registerReceiver(broadcastReceiver, HotShotReceiver.REFRESH_MACIN_ACTIVITY_INTENT_FILTER)
    }

    override fun onResume() {
        super.onResume()
        presenter.attachView(this)
        registerReceiver(broadcastReceiver, HotShotReceiver.REFRESH_MACIN_ACTIVITY_INTENT_FILTER)
    }

    override fun refreshViewPagers() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showErrorNotification() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

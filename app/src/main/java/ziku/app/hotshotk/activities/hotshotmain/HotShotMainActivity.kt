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
import android.support.design.widget.Snackbar
import ziku.app.hotshotk.providers.NotificationsManager
import ziku.app.hotshotk.providers.SystemInfoProvider

class HotShotMainActivity : BaseActivity(), HotShotContractor.View {

    @Inject
    lateinit var presenter: HotShotContractor.Presenter
    @Inject
    lateinit var mainActivityAnimations: MainActivityAnimations
    @Inject
    lateinit var notificationsManager: NotificationsManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hot_shot_main)
        initViewComponents()
        initNavigationMenu()
        mainActivityAnimations.setView(main_content_activity)
    }

    override fun onPause() {
        super.onPause()
        presenter.deattachView()
    }

    override fun onResume() {
        super.onResume()
        notificationsManager.clearAllNotification()
        presenter.attachView(this)
        presenter.setSynchronizationsAndAlarm()
    }


    fun initViewComponents() {
        blocking_background.setOnClickListener({ onMenuClickListener(it) })
        menu_and_settings.setOnClickListener { onMenuClickListener(it) }
        view_pager.adapter = FragmentViewPagerAdapter(supportFragmentManager)
        swipe_refresher.apply {
            setOnRefreshListener { presenter.synchronizeHotShots() }
            setColorSchemeColors(resources.getColor(R.color.windowBackground),
                    resources.getColor(R.color.colorPrimaryDark), resources.getColor(R.color.windowBackground))
        }
        headers_tab_layout.setupWithViewPager(view_pager)
        for (i in 0 until headers_tab_layout.tabCount) {
            headers_tab_layout.getTabAt(i)?.icon = resources.getDrawable(R.drawable.ic_hotshotlogo)
        }
    }

    private fun initNavigationMenu() {
        play_store.setOnClickListener { startPlayStoreActivity(it) }
        share.setOnClickListener { startShareActivity(it) }
        info.setOnClickListener { startInfoActivity(it) }
        settings.setOnClickListener { startSettingsActivity(it) }
    }

    private fun onMenuClickListener(view: View) {
        mainActivityAnimations.invokeMenuAnimation(view)
    }

    private fun startSettingsActivity(view: View) {
        startActivity(Intent(this, SettingsActivity::class.java))
    }

    private fun startInfoActivity(view: View) {
        startActivity(Intent(this, SettingsActivity::class.java))
    }

    private fun startPlayStoreActivity(view: View) {
        startActivity(Intent(this, SettingsActivity::class.java))
    }

    private fun startShareActivity(view: View) {
        startActivity(Intent(this, SettingsActivity::class.java))
    }

    override fun refreshViewPagers() {
        (view_pager.adapter as FragmentViewPagerAdapter).refreshAllFragments()
        swipe_refresher.isRefreshing = false
    }

    override fun showErrorNotification() {
        swipe_refresher.isRefreshing = false
        val snackbar = Snackbar
                .make(findViewById(android.R.id.content), getString(R.string.synchronization_error), Snackbar.LENGTH_LONG)
        snackbar.apply {
            setAction(getString(R.string.refresh), { presenter.synchronizeHotShots() })
        }
        snackbar.show()
    }

}

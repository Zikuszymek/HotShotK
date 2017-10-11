package ziku.app.hotshotk.activities.hotshotmain

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_hot_shot_main.*
import ziku.app.hotshotk.R
import ziku.app.hotshotk.activities.BaseActivity
import ziku.app.hotshotk.fragments.hotshot.FragmentViewPagerAdapter
import javax.inject.Inject

class HotShotMainActivity : BaseActivity(), HotShotContractor.View {

    @Inject
    lateinit var presenter : HotShotContractor.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hot_shot_main)
        initViewComponents()

    }

    fun initViewComponents(){
        view_pager.adapter = FragmentViewPagerAdapter(supportFragmentManager)
        swipe_refresher.setOnRefreshListener {
            presenter.refreshOffer()
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

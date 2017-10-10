package ziku.app.hotshotk.activities.hotshotmain

import android.arch.persistence.room.Room
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_hot_shot_main.*
import ziku.app.hotshotk.R
import ziku.app.hotshotk.activities.BaseActivity
import ziku.app.hotshotk.activities.BaseView
import ziku.app.hotshotk.db.DatabaseHotShot
import ziku.app.hotshotk.fragments.FragmentViewPagerAdapter
import javax.inject.Inject

class HotShotMainActivity : BaseActivity() , BaseView{

    @Inject
    lateinit var presenter : HotShotMainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hot_shot_main)
        initViewComponents()

    }

    fun initViewComponents(){
        view_pager.adapter = FragmentViewPagerAdapter(supportFragmentManager)
        swipe_refresher.setOnRefreshListener {
            presenter.refreshOffer()}
    }

    override fun onPause() {
        super.onPause()
        presenter.deattachView()
    }

    override fun onResume() {
        super.onResume()
        presenter.attachView(this)
    }

}

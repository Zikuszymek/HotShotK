package ziku.app.hotshotk.activities.details

import android.os.Bundle
import ziku.app.hotshotk.R
import ziku.app.hotshotk.activities.BaseActivity
import javax.inject.Inject

class DetailsActivity : BaseActivity(), DetailsContractor.View {

    @Inject
    lateinit var presenter : DetailsContractor.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
    }

    override fun onResume() {
        super.onResume()
        presenter.attachView(this)
    }

    override fun onPause() {
        super.onPause()
        presenter.deattachView()
    }

}

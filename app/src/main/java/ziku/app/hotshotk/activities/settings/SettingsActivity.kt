package ziku.app.hotshotk.activities.settings

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import ziku.app.hotshotk.R
import ziku.app.hotshotk.activities.BaseActivity
import javax.inject.Inject

class SettingsActivity : BaseActivity(), SettingsContractor.View {

    @Inject
    lateinit var presenter : SettingsContractor.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        title = getString(R.string.settings)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
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

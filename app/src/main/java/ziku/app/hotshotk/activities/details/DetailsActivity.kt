package ziku.app.hotshotk.activities.details

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_details.*
import ziku.app.hotshotk.R
import ziku.app.hotshotk.activities.BaseActivity
import ziku.app.hotshotk.db.entities.HotShot
import javax.inject.Inject

class DetailsActivity : BaseActivity(), DetailsContractor.View {

    @Inject
    lateinit var presenter: DetailsContractor.Presenter

    val hotShot: HotShot by lazy {
        intent.extras.getParcelable<HotShot>(HOTSHOT_DETAILS)
    }

    companion object {
        val HOTSHOT_DETAILS = "hotshot_details"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        initViewDetails()
    }

    private fun initViewDetails() {
        outer_border.setOnClickListener(this::finishActivity)
        details_view.setOnClickListener(this::finishActivity)
        button_go_to_web_page.setOnClickListener(this::goToProductUrl)
        Glide.with(this).load(hotShot.img_url).into(details_image)
        details_description.text = hotShot.product_name
        details_old_price.text = hotShot.old_price.toString()
        details_new_price.text = hotShot.new_price.toString()
    }

    fun finishActivity(view : View){
        finish()
    }

    fun goToProductUrl(view : View){
        var intent = Intent(Intent.ACTION_VIEW, Uri.parse(hotShot.product_url))
        startActivity(intent)
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

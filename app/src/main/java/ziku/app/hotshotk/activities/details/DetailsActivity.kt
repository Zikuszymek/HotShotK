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
import ziku.app.hotshotk.providers.PriceManager
import ziku.app.hotshotk.providers.PriceModel
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
    }

    override fun loadDetailsView(priceDetails: PriceModel) {
        initPriceDetailsView(priceDetails)
        initViewDetails()
        initWebPageButton()
    }

    private fun initWebPageButton(){
        presenter.getTextForWebPage(hotShot.web_page, this::loadButtonName)
        button_go_to_web_page.setOnClickListener(this::goToProductUrl)
    }

    private fun loadButtonName(webPageName : String){
        button_go_to_web_page.text = webPageName
    }

    private fun initPriceDetailsView(priceDetails: PriceModel){
        details_new_price.text = priceDetails.newPrice
        if(priceDetails.oldPrice != PriceManager.EMPTY_STRING) {
            details_old_price.text = priceDetails.oldPrice
        } else {
            details_old_price.visibility = View.GONE
        }
        if(priceDetails.discount != PriceManager.EMPTY_STRING){
            details_discount.text = priceDetails.discount
        } else {
            details_discount.visibility = View.GONE
        }
    }

    private fun initViewDetails() {
        outer_border.setOnClickListener(this::finishActivity)
        details_view.setOnClickListener(this::finishActivity)
        Glide.with(this).load(hotShot.img_url).into(details_image)
        details_description.text = hotShot.product_name
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
        presenter.loadProperViewData(hotShot)
    }

    override fun onPause() {
        super.onPause()
        presenter.deattachView()
    }

}

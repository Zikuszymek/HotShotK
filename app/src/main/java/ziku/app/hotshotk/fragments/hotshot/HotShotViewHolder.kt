package ziku.app.hotshotk.fragments.hotshot

import android.app.Activity
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.View
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.hot_shot_view_holder.view.*
import ziku.app.hotshotk.activities.details.DetailsActivity
import ziku.app.hotshotk.db.entities.HotShot
import android.support.v4.view.ViewCompat
import android.support.v4.app.ActivityOptionsCompat
import android.widget.LinearLayout
import ziku.app.hotshotk.db.entities.WebPage
import ziku.app.hotshotk.providers.PriceManager

class HotShotViewHolder(var view: View, val priceManager: PriceManager) : RecyclerView.ViewHolder(view) {

    lateinit var hotShot: HotShot

    fun bindData(hotShot: HotShot, webPage: WebPage?, position: Int) {
        addPaddingTopIfFirst(position)
        this.hotShot = hotShot
        val priceModel = priceManager.getPriceDataForView(hotShot)
        view.product_description.text = hotShot.product_name
        if (priceModel.oldPrice != PriceManager.EMPTY_STRING && priceModel.discount != PriceManager.EMPTY_STRING) {
            view.old_price.text = priceModel.oldPrice
            view.discount.text = priceModel.discount
            view.old_price.visibility = View.VISIBLE
            view.discount.visibility = View.VISIBLE
        } else {
            view.old_price.visibility = View.GONE
            view.discount.visibility = View.GONE
        }
        view.new_price.text = priceModel.newPrice
        loadImageFromGlide(hotShot)
        view.setOnClickListener(this::onViewHolderClickListener)
        view.web_page_name.text = webPage?.name_web_page
    }

    fun onViewHolderClickListener(view: View) {
        val intent = Intent(view.context, DetailsActivity::class.java)
        val transitionOptions = ActivityOptionsCompat
                .makeSceneTransitionAnimation(view.context as Activity, view.product_image, ViewCompat.getTransitionName(view.product_image))
        intent.putExtra(DetailsActivity.HOTSHOT_DETAILS, hotShot)
        view.context.startActivity(intent, transitionOptions.toBundle())
    }

    private fun loadImageFromGlide(hotshot: HotShot) {
        Glide.with(view).load(hotshot.img_url).into(view.product_image)
    }

    private fun addPaddingTopIfFirst(position: Int) {
        if (position == 0) {
            var layoutParams = view.layoutParams as RecyclerView.LayoutParams
            layoutParams.setMargins(layoutParams.leftMargin, layoutParams.leftMargin, layoutParams.rightMargin, layoutParams.bottomMargin)
        }
    }

}
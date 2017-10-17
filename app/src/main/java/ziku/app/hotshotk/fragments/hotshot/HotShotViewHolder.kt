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
import ziku.app.hotshotk.db.entities.WebPage


class HotShotViewHolder(var view: View) : RecyclerView.ViewHolder(view) {

    lateinit var hotShot: HotShot

    fun bindData(hotShot: HotShot, webPage: WebPage?) {
        this.hotShot = hotShot
        view.product_description.text = hotShot.product_name
        view.old_price.text = hotShot.old_price.toString()
        view.new_price.text = hotShot.new_price.toString()
//        view.discount.text = String.format("- %s\%", calculateDiscount(hotShot.old_price.toInt(), hotShot.new_price.toInt()))
        view.discount.text = "-19%"
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

    fun calculateDiscount(oldPrice: Int, newPrice: Int): Int {
        return (oldPrice - newPrice) / oldPrice * 100
    }

}
package ziku.app.hotshotk.fragments.hotshot

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.View
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.hot_shot_view_holder.view.*
import ziku.app.hotshotk.activities.details.DetailsActivity
import ziku.app.hotshotk.db.entities.HotShot


class HotShotViewHolder(var view : View) : RecyclerView.ViewHolder(view){

    lateinit var hotShot : HotShot

    fun bindData(hotShot: HotShot){
        this.hotShot = hotShot
        view.product_description.text = hotShot.product_name
        view.old_price.text = hotShot.old_price.toString()
        view.new_price.text = hotShot.new_price.toString()
//        view.discount.text = String.format("- %s\%", calculateDiscount(hotShot.old_price.toInt(), hotShot.new_price.toInt()))
        view.discount.text = "-19%"
        loadImageFromGlide(hotShot)
        view.setOnClickListener(this::onViewHolderClickListener)
    }

    fun onViewHolderClickListener(view : View){
        var intent = Intent(view.context, DetailsActivity::class.java)
        intent.putExtra(DetailsActivity.HOTSHOT_DETAILS, hotShot)
        view.context.startActivity(intent)
    }

    private fun loadImageFromGlide(hotshot: HotShot) {
        Glide.with(view).load(hotshot.img_url).into(view.product_image)
    }

    fun calculateDiscount(oldPrice : Int, newPrice: Int) : Int{
        return (oldPrice - newPrice) / oldPrice * 100
    }

}
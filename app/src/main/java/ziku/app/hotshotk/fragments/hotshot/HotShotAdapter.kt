package ziku.app.hotshotk.fragments.hotshot

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import ziku.app.hotshotk.R
import ziku.app.hotshotk.db.entities.HotShot

class HotShotAdapter : RecyclerView.Adapter<HotShotViewHolder>() {

    var hotShotListData: List<HotShot> = listOf()

    fun passNewData(hotShotList: List<HotShot>){
        hotShotListData = hotShotList
    }

    override fun getItemCount(): Int = hotShotListData.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): HotShotViewHolder {
        return HotShotViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.hot_shot_view_holder, parent, false))
    }

    override fun onBindViewHolder(holder: HotShotViewHolder?, position: Int) {
        holder?.bindData(hotShotListData[position])
    }
}
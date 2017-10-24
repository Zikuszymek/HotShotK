package ziku.app.hotshotk.fragments.hotshot

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import ziku.app.hotshotk.R
import ziku.app.hotshotk.db.entities.HotShot
import ziku.app.hotshotk.db.entities.WebPage
import ziku.app.hotshotk.providers.PriceManager

class HotShotAdapter(val priceManager: PriceManager) : RecyclerView.Adapter<HotShotViewHolder>() {

    var hotShotListData: List<HotShot> = listOf()
    var webPageList: List<WebPage> = listOf()

    fun passNewData(hotShotList: List<HotShot>, webPageList: List<WebPage>) {
        this.hotShotListData = hotShotList
        this.webPageList = webPageList
    }

    override fun getItemCount(): Int = hotShotListData.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): HotShotViewHolder {
        return HotShotViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.hot_shot_view_holder, parent, false), priceManager)
    }

    override fun onBindViewHolder(holder: HotShotViewHolder?, position: Int) {
        holder?.bindData(hotShotListData[position], webPageList.firstOrNull { it.id == hotShotListData[position].web_page}, position)
    }
}
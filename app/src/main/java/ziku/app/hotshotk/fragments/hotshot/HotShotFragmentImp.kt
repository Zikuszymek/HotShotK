package ziku.app.hotshotk.fragments.hotshot

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_view_pager_promotion.*
import ziku.app.hotshotk.R
import ziku.app.hotshotk.db.dao.HotShotDao
import javax.inject.Inject

class HotShotFragmentImp : BaseFragment() {

    @Inject
    lateinit var verticalLayoutManager : LinearLayoutManager

    @Inject
    lateinit var hotShotDao : HotShotDao

    val hotshotAdapter : HotShotAdapter by lazy {
        HotShotAdapter()
    }

    val categoryId by lazy { arguments.getInt(FragmentViewPagerAdapter.CATEGORY_TYPE, -1) }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater?.inflate(R.layout.fragment_view_pager_promotion, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        hotshot_recycler_view.adapter = hotshotAdapter
        hotshot_recycler_view.layoutManager = verticalLayoutManager
        refreshList()
    }

    fun refreshList() {
        Single.fromCallable {
            if(categoryId == 0){
                hotShotDao.getAll().filter { it.product_name != "-" }
            } else{
                hotShotDao.getObjectByCategory(categoryId).filter { it.product_name != "-" }
            }}
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            hotshotAdapter.passNewData(it)
                            hotshotAdapter.notifyDataSetChanged()
                        },
                        {
                            hotshotAdapter.notifyDataSetChanged()}
                )
    }

}
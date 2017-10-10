package ziku.app.hotshotk.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ziku.app.hotshotk.R

class HotShotFragmentImp : Fragment(){

    val categoryId by lazy { arguments.getInt(FragmentViewPagerAdapter.CATEGORY_TYPE, -1) }

    fun refreshtList() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater?.inflate(R.layout.fragment_view_pager_promotion, container, false)
        return view
    }

}
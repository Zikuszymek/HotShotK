package ziku.app.hotshotk.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_view_pager_promotion.*
import ziku.app.hotshotk.R

class ViewPagerFragment : Fragment(){

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_view_pager_promotion, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        var fragmentAdapter = FragmentViewPagerAdapter(fragmentManager)
        view_pager_promotion.adapter = fragmentAdapter
    }
}
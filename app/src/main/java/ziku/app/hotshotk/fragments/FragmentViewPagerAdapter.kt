package ziku.app.hotshotk.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

class FragmentViewPagerAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager)  {

    val fragmentImpList: MutableMap<Int, HotShotFragmentImp> = mutableMapOf()

    companion object {
        val CATEGORY_TYPE = "Category_type"
        val NUMBER_OF_PAGES = 5
    }
    override fun getItem(position: Int): Fragment {
        refreshAllFragments()
        return addFragmentIfNew(position)
    }

    override fun getCount(): Int = NUMBER_OF_PAGES

    private fun addFragmentIfNew(position: Int) : HotShotFragmentImp{
        if(fragmentImpList.containsKey(position)){
            return fragmentImpList.getOrDefault(position, HotShotFragmentImp())
        } else {
            val hotShotFragment = HotShotFragmentImp()
            val bundle = Bundle()
            bundle.putInt(CATEGORY_TYPE, position)
            hotShotFragment.arguments = bundle
            fragmentImpList.put(position, hotShotFragment)
            return hotShotFragment
        }
    }

    fun refreshAllFragments(){

    }
}
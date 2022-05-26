package com.nasa.pictureapp.ui.detail.adapter

import java.util.*

class ViewPagerAdapter(fm: androidx.fragment.app.FragmentManager) :
    androidx.fragment.app.FragmentPagerAdapter(
        fm,
        BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
    ) {

    private val mFragmentList = ArrayList<androidx.fragment.app.Fragment>()
    private val mFragmentTitleList = ArrayList<String>()

    override fun getItem(position: Int): androidx.fragment.app.Fragment {
        return mFragmentList[position]
    }

    fun addFrag(fragment: androidx.fragment.app.Fragment, title: String) {
        mFragmentList.add(fragment)
        mFragmentTitleList.add(title)
    }

    override fun getPageTitle(position: Int): CharSequence {
        return mFragmentTitleList[position]
    }

    override fun getCount(): Int {

        return mFragmentList.size
    }
}

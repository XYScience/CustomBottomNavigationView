package com.sscience.custombottomnavigationview

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * @author SScience
 * @description
 * @email chentushen.science@gmail.com
 * @data 2017/10/30
 */
class ViewPagerAdapter : FragmentPagerAdapter {

    private var fragments: Array<Fragment>

    constructor(fm: FragmentManager?, fragments: Array<Fragment>) : super(fm) {
        this.fragments = fragments
    }

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }
}
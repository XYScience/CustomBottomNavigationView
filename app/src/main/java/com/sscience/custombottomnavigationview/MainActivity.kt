package com.sscience.custombottomnavigationview

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import q.rorbin.badgeview.Badge
import q.rorbin.badgeview.QBadgeView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        addBadge(0, 10)
    }

    private fun initView() {
        var workbenchFragment = BaseFragment()
        var bundle = Bundle()
        bundle.putString("title", getString(R.string.title_home))
        workbenchFragment.arguments = bundle

        var orderFragment = BaseFragment()
        bundle = Bundle()
        bundle.putString("title", getString(R.string.title_dashboard))
        orderFragment.arguments = bundle

        var tradeFragment = BaseFragment()
        bundle = Bundle()
        bundle.putString("title", getString(R.string.title_notifications))
        tradeFragment.arguments = bundle

        var myFragment = BaseFragment()
        bundle = Bundle()
        bundle.putString("title", getString(R.string.title_my))
        myFragment.arguments = bundle

        var fragments: Array<Fragment> = arrayOf(workbenchFragment, orderFragment, tradeFragment, myFragment)
        var pagerAdapter = ViewPagerAdapter(supportFragmentManager, fragments)
        viewPager.adapter = pagerAdapter

        navigation.setupWithViewPager(viewPager, object : CustomBottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem) {
                Toast.makeText(this@MainActivity, item.title, Toast.LENGTH_SHORT).show()
            }

        })

    }

    private fun addBadge(position: Int, number: Int) {
        QBadgeView(this).bindTarget(navigation.getBottomNavigationItemView(position))
                .setBadgeNumber(number)
                .setGravityOffset(40f, 0f, false)
                .setOnDragStateChangedListener({ dragState: Int, badge: Badge, targetView: View ->
                    if (Badge.OnDragStateChangedListener.STATE_SUCCEED == dragState) {
                        Toast.makeText(this, "已清除小红点", Toast.LENGTH_SHORT).show()
                    }
                })

    }
}

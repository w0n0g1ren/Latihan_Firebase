package com.example.latihanfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.latihanfirebase.adapter.ViewPagerAdapter
import com.example.latihanfirebase.databinding.ActivityMainBinding
import com.example.latihanfirebase.fragment.HomeFragment
import com.example.latihanfirebase.fragment.UserFragment
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var swipeRefreshLayout : SwipeRefreshLayout
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupTab()
//        swipeRefreshLayout.setOnRefreshListener {
//            swipeRefreshLayout.isRefreshing = true
//
//        }
    }

    private fun setupTab() {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(HomeFragment())

        adapter.addFragment(UserFragment())

        binding.viewPager.adapter = adapter
        binding.tabs.setupWithViewPager(binding.viewPager)

        binding.tabs.getTabAt(0)!!.setIcon(R.drawable.home)
        binding.tabs.getTabAt(1)!!.setIcon(R.drawable.user)


    }
}
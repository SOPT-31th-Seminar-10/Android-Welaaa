package com.sopt.welaaa.presentation

import android.os.Bundle
import com.sopt.welaaa.R
import com.sopt.welaaa.databinding.ActivityMainBinding
import com.sopt.welaaa.presentation.home.view.HomeFragment
import com.sopt.welaaa.presentation.search.view.SearchFragment
import com.sopt.welaaa.presentation.setting.view.SettingFragment
import com.sopt.welaaa.presentation.shelf.view.ShelfFragment
import com.sopt.welaaa.util.binding.BindingActivity
import com.sopt.welaaa.util.extension.replace

class MainActivity : BindingActivity<ActivityMainBinding>(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.bnvMain.itemIconTintList = null
        setOnItemSelectedListener()
        startTargetFragment(R.id.menu_home)
    }

    private fun setOnItemSelectedListener() {
        binding.bnvMain.setOnItemSelectedListener { item ->
            startTargetFragment(item.itemId)
            true
        }
    }

     private fun startTargetFragment(itemId: Int): Any = when (itemId) {
        R.id.menu_home -> replace<HomeFragment>(R.id.fcv_main)
        R.id.menu_search -> replace<SearchFragment>(R.id.fcv_main)
        R.id.menu_shelf -> replace<ShelfFragment>(R.id.fcv_main)
        R.id.menu_setting -> replace<SettingFragment>(R.id.fcv_main)
        else -> IllegalArgumentException("Not found error.")
    }
}
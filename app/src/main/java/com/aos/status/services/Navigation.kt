package com.aos.status.services

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.aos.status.R

class Navigation {
    companion object {
        private var history: MutableList<Fragment> = mutableListOf()
        private var mainLayout: Int = R.id.main_layout
        private lateinit var supportFragmentManager: FragmentManager

        fun init(parent: FragmentManager, mainFragment: Fragment, layout: Int? = null){
            supportFragmentManager = parent
            push(mainFragment)
            if(layout != null) mainLayout = layout
        }

        fun push(fragment: Fragment){
            history.add(fragment)
            supportFragmentManager
                .beginTransaction()
                .replace(mainLayout, history.last())
                .commit()
        }

        fun back(): Boolean {
            if(history.isEmpty() || history.count() == 1)  return false
            history.removeLastOrNull()
            push(history.last())

            return true
        }
    }
}
package com.aos.status.services

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class Navigation {
    companion object {
        private var history: ArrayList<Fragment> = arrayListOf()
        private var mainLayout: Int = 0
        private lateinit var supportFragmentManager: FragmentManager

        fun init(parent: FragmentManager, mainFragment: Fragment, layout: Int){
            supportFragmentManager = parent
            push(mainFragment)
            mainLayout = layout
        }

        fun push(fragment: Fragment){
            history.add(fragment)
            navigate()
        }

        fun back(): Boolean {
            if(history.isEmpty() || history.count() == 1) return false

            history.removeLastOrNull()
            navigate()

            return true
        }


        private fun navigate(){
            supportFragmentManager
                .beginTransaction()
                .replace(mainLayout, history.last())
                .commit()
        }
    }
}
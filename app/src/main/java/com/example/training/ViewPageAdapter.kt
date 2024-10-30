package com.example.training

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPageAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity)  {

    //List of Fragments
     private  val fragmentList = listOf(
         FragmentAll(),FragmentDev(), FragmentBawaseer(), FragmentCheck(), FragmentBook()
     )
    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
            return fragmentList[position]
    }
}
package com.example.classifiedapp.ui.launchfragment

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.classifiedapp.R
import com.example.classifiedapp.base.BaseFragment
import com.example.classifiedapp.databinding.FragmentSplashBinding

class SplashFragment : BaseFragment<FragmentSplashBinding>() {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initiateView(view)
        super.onViewCreated(view, savedInstanceState)
    }



    override fun getLayout(): Int = R.layout.fragment_splash

    override fun initiateView(view: View): FragmentSplashBinding = DataBindingUtil.bind(view)!!

}
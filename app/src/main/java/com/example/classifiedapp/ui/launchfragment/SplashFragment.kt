package com.example.classifiedapp.ui.launchfragment

import android.animation.Animator
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.Fragment
import com.example.classifiedapp.R
import com.example.classifiedapp.base.BaseFragment
import com.example.classifiedapp.databinding.FragmentSplashBinding

class SplashFragment : BaseFragment<FragmentSplashBinding>() {

    private lateinit var binding: FragmentSplashBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = initiateView(view)
        super.onViewCreated(view, savedInstanceState)


        setView(binding)


    }

    private fun setView(binding: FragmentSplashBinding) {
        binding.titleText.animate().setDuration(900).alphaBy(0f).alpha(1f).setListener(object :
            Animator.AnimatorListener {
            override fun onAnimationStart(p0: Animator?) {}

            override fun onAnimationEnd(p0: Animator?) {
                binding.titleText.visibility = View.VISIBLE

                Handler().postDelayed({
                    navController.navigate(R.id.navigate_from_splash_fragment_to_home_fragment)
                }, 1000)

            }

            override fun onAnimationCancel(p0: Animator?) {}

            override fun onAnimationRepeat(p0: Animator?) {}
        })
    }


    override fun getLayout(): Int = R.layout.fragment_splash

    override fun initiateView(view: View): FragmentSplashBinding =
        FragmentSplashBinding.bind(view)!!

}
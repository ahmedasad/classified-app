package com.example.classifiedapp.ui.homefragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.classifiedapp.R
import com.example.classifiedapp.base.BaseFragment
import com.example.classifiedapp.adapters.ClassifiedListAdapter
import com.example.classifiedapp.data.network.Result
import com.example.classifiedapp.databinding.FragmentHomeBinding
import com.example.classifiedapp.ui.detailsfragment.DetailsFragment.ITEM
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val viewModel: HomeViewModel by viewModel()
    private lateinit var adapter: ClassifiedListAdapter
    private lateinit var binding: FragmentHomeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = initiateView(view)
        super.onViewCreated(view, savedInstanceState)
        setView(binding)
        getItems()
    }

    private fun setView(binding: FragmentHomeBinding) {
        adapter = ClassifiedListAdapter(context!!)
        binding.itemsRecyclerView.adapter = adapter
        adapter.itemClickSubject.subscribe {
            val bundle = Bundle()
            bundle.putParcelable(ITEM, it)
            navController.navigate(
                R.id.navigate_from_home_fragment_to_details_fragment,
                bundle
            )
        }
    }

    private fun getItems() {
        viewModel.getItems.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Result.Loading -> {
                    binding.progressCircular.visibility = View.VISIBLE
                }
                is Result.Success -> {
                    binding.progressCircular.visibility = View.GONE
                    adapter.updateItems(it.data.results)
                }
                is Result.Error -> {
                    binding.progressCircular.visibility = View.GONE
                    Toast.makeText(context, it.data, Toast.LENGTH_SHORT).show()
                }
            }
        })
    }


    override fun getLayout(): Int = R.layout.fragment_home

    override fun initiateView(view: View) = FragmentHomeBinding.bind(view)!!

}

package com.android.flickrapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.android.flickrapp.databinding.HomeFragmentBinding
import com.android.flickrapp.di.Injectable
import com.android.flickrapp.di.ViewModelFactory
import javax.inject.Inject

class HomeFragment : Fragment(), Injectable, SearchView.OnQueryTextListener {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var adapter: MainAdapter
    private lateinit var binding: HomeFragmentBinding

    private val viewModel by viewModels<HomeViewModel> {
        viewModelFactory
    }

    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = HomeFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        adapter = MainAdapter()
        binding.recyclerView.adapter = adapter
        subscribeOnUi()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.searchView.setOnQueryTextListener(this)
    }

    private fun subscribeOnUi() {
        viewModel.flickrPhotos.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        query?.let {
            viewModel.getFlickrPhotos(it)
        }
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return false
    }
}

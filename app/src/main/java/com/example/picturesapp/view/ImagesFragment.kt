package com.example.picturesapp.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.picturesapp.R
import com.example.picturesapp.adapter.ImageAdapter
import com.example.picturesapp.databinding.ImagesFragmentBinding
import com.example.picturesapp.model.Data
import com.example.picturesapp.viewModel.ImageViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ImagesFragment : Fragment(R.layout.images_fragment) {

    private lateinit var viewModel: ImageViewModel
    private lateinit var binding: ImagesFragmentBinding

    private val imageAdapter = ImageAdapter()

    private val observerImage =
        Observer<List<Data>> {
            imageAdapter.update(it.toMutableList())
            binding.progressBar.visibility = View.GONE
            binding.imagesRecyclerView.visibility = View.VISIBLE
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = ImagesFragmentBinding.bind(view)
        viewModel = ViewModelProvider(this)[ImageViewModel::class.java]
        viewModel.imageList.observe(viewLifecycleOwner, observerImage)

        viewModel.getImages()

        setupRecyclerView()
    }

    private fun setupRecyclerView() = with(binding.imagesRecyclerView) {
        adapter = imageAdapter
        layoutManager = GridLayoutManager(requireContext(), 4)
        addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                (!recyclerView.canScrollHorizontally(1) && newState == RecyclerView.SCROLL_STATE_IDLE)
            }
        })
    }

}
package com.example.picturesapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.picturesapp.model.Image
import com.example.picturesapp.repository.ImgRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ImageViewModel @Inject constructor(
    private val repository: ImgRepository
) : ViewModel() {

    private val _list = MutableLiveData<List<Image>>()
    val imageList: LiveData<List<Image>> = _list

    fun getImages() {
        viewModelScope.launch {
            val returnedImages =
                repository.getImages()
            returnedImages?.let {
                _list.value = it
            }
        }
    }
}
package com.example.mybeautifulapp.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mybeautifulapp.data.model.BeanItem
import com.example.mybeautifulapp.data.repository.BeanRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val beanRepository: BeanRepository
): ViewModel()  {


    private val _allBeanList: MutableLiveData<List<BeanItem>> = MutableLiveData()
    val allBeanList: LiveData<List<BeanItem>> = _allBeanList


    fun getAllBeanItems() = viewModelScope.launch(Dispatchers.IO) {
        beanRepository.getBeanItem().collect {
            _allBeanList.value = it
        }
    }




}
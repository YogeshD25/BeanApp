package com.example.mybeautifulapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mybeautifulapp.databinding.ActivityMainBinding
import com.example.mybeautifulapp.ui.adapter.ItemAdapter
import com.example.mybeautifulapp.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private val mainViewModel by viewModels<MainViewModel>()
    private lateinit var adapter: ItemAdapter
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        adapter = ItemAdapter()
        setupUI()
        setupData()
    }

    private fun setupData() {
        mainViewModel.getAllBeanItems()
        mainViewModel.allBeanList.observe(this) {
            //adapter data
            adapter.setData(it)
        }
    }

    private fun setupUI() {
        val recyclerViewTopFeed = binding.recylerview
        recyclerViewTopFeed.adapter = adapter
        recyclerViewTopFeed.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
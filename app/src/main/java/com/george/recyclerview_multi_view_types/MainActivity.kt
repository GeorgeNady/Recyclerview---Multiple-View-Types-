package com.george.recyclerview_multi_view_types

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.george.recyclerview_multi_view_types.adapter.RVAdapter
import com.george.recyclerview_multi_view_types.databinding.ActivityMainBinding
import com.george.recyclerview_multi_view_types.repository.Repo.dummyData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivity"
    }

    private val mAdapter by lazy { RVAdapter() }
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        initialization()
        setListener()

    }

    private fun initialization() {
        binding.apply {
            setupRV()
        }
    }

    private fun setListener() {
        binding.apply {
            lifecycleScope.launchWhenCreated {
                delay(3000)
                progress.visibility = View.GONE
                recyclerView.visibility = View.VISIBLE
                mAdapter.submitList(dummyData)
            }
        }
    }

    private fun ActivityMainBinding.setupRV() {
        recyclerView.apply {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

}
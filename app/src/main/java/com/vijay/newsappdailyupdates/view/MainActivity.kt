package com.vijay.newsappdailyupdates.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.vijay.newsappdailyupdates.R
import com.vijay.newsappdailyupdates.databinding.ActivityMainBinding
import com.vijay.newsappdailyupdates.model.Repo
import com.vijay.newsappdailyupdates.model.local.DataDao
import com.vijay.newsappdailyupdates.model.local.TheDatabase
import com.vijay.newsappdailyupdates.model.remote.ArticlesItem
import com.vijay.newsappdailyupdates.view.adapter.OnItemClick
import com.vijay.newsappdailyupdates.view.adapter.RecyclerViewAdapter
import com.vijay.newsappdailyupdates.viewmodel.TheViewModel
import com.vijay.newsappdailyupdates.viewmodel.ViewModelFactory

class MainActivity : AppCompatActivity(),OnItemClick {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: TheViewModel
    private lateinit var repo: Repo
    private lateinit var dataDao: DataDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        dataDao = TheDatabase.getDatabaseInstance(this).getDao()
        repo = Repo(dataDao)

        viewModel = ViewModelProvider(this, ViewModelFactory(repo)).get(TheViewModel::class.java)

        val dataList = ArrayList<ArticlesItem>()
        viewModel.getData().observe(this@MainActivity, Observer {
            val list = it as ArrayList<ArticlesItem>
            list.forEach {
                Log.d("list2", it.toString())
            }
            setRecyclerView(list)
        })
    }

    private fun setRecyclerView(list: ArrayList<ArticlesItem>) {
        binding.progressBar.visibility = View.GONE
        val recyclerAdapter = RecyclerViewAdapter(list, this)
        binding.recyclerView.apply {
            adapter = recyclerAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }


    override fun onClick(articlesItem: ArticlesItem) {
        val intent = Intent(this, DetailedActivity::class.java)
        intent.putExtra("data", articlesItem)
        startActivity(intent)
    }
}
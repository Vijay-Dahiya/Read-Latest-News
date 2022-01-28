package com.vijay.newsappdailyupdates.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.vijay.newsappdailyupdates.R
import com.vijay.newsappdailyupdates.databinding.ActivityDetailedBinding
import com.vijay.newsappdailyupdates.model.remote.ArticlesItem

class DetailedActivity : AppCompatActivity() {
    private lateinit var detailedBinding: ActivityDetailedBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailedBinding = DataBindingUtil.setContentView(this, R.layout.activity_detailed)
        if (intent != null && intent.hasExtra("data")) {
            val data = intent.getSerializableExtra("data") as ArticlesItem
            detailedBinding.item = data
        }

        detailedBinding.backBtn.setOnClickListener {
            onBackPressed()
        }
    }
}
package com.vijay.newsappdailyupdates.view.adapter

import com.vijay.newsappdailyupdates.model.remote.ArticlesItem

interface OnItemClick {
    fun onClick(articlesItem: ArticlesItem)
}
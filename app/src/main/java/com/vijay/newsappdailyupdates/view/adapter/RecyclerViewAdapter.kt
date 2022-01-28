package com.vijay.newsappdailyupdates.view.adapter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.vijay.newsappdailyupdates.R
import com.vijay.newsappdailyupdates.databinding.ItemViewBinding
import com.vijay.newsappdailyupdates.model.remote.ArticlesItem

class RecyclerViewAdapter(
    private val list: ArrayList<ArticlesItem>,
    private val onnItemClick: OnItemClick
) :
    RecyclerView.Adapter<RecyclerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemViewBinding: ItemViewBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.item_view, parent, false)
        return RecyclerViewHolder(itemViewBinding)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.bindData(list[position], onnItemClick)
    }

    override fun getItemCount(): Int = list.size
}

class RecyclerViewHolder(private val itemViewBinding: ItemViewBinding) :
    RecyclerView.ViewHolder(itemViewBinding.root) {
    fun bindData(articlesItem: ArticlesItem, onnItemClick: OnItemClick) {
        itemViewBinding.item = articlesItem
        itemViewBinding.itemClick = onnItemClick
    }
}
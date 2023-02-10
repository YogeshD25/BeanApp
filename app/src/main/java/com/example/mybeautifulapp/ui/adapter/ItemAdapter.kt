package com.example.mybeautifulapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.mybeautifulapp.data.model.BeanItem
import com.example.mybeautifulapp.databinding.ItemBeanBinding

class ItemAdapter : RecyclerView.Adapter<ItemAdapter.MyViewHolder>() {

    private var beanList = emptyList<BeanItem>()
    private lateinit var context: Context
    lateinit var itemBinding: ItemBeanBinding

    class MyViewHolder(itemBinding: ItemBeanBinding) :
        RecyclerView.ViewHolder(itemBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        context = parent.context
        itemBinding =
            ItemBeanBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = beanList[position]
        itemBinding.beanImage.load(currentItem.image_link) {
            crossfade(true)
            crossfade(10)
        }

        itemBinding.beanTitle.text = currentItem.name
    }

    override fun getItemCount(): Int {
        return beanList.size
    }

    fun setData(categories: List<BeanItem>) {
        this.beanList = categories
        notifyDataSetChanged()
    }
}
package com.george.recyclerview_multi_view_types.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.*
import coil.load
import com.george.recyclerview_multi_view_types.databinding.*
import com.george.recyclerview_multi_view_types.model.Model

class RVAdapter : ListAdapter<Model,RecyclerView.ViewHolder>(Differ) {

    object Differ : DiffUtil.ItemCallback<Model>() {
        override fun areItemsTheSame(oldItem: Model, newItem: Model) = oldItem == newItem
        override fun areContentsTheSame(oldItem: Model, newItem: Model) = oldItem == newItem
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////// VIEW HOLDER
    ////////////////////////////////////////////////////////////////////////////////////////////////
    class TypeAViewHolder(private val binding: ItemATypeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun Model.bind() = binding.apply {
            imageView.load(image)
            tvTitle.text = title
            tvDescription.text = description
        }
    }

    class TypeBViewHolder(private val binding: ItemBTypeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun Model.bind() = binding.apply {
            imageView.load(image)
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////// MEMBERS
    ////////////////////////////////////////////////////////////////////////////////////////////////
    override fun getItemCount() = currentList.size

    override fun getItemViewType(position: Int) = if (getItem(position).type == 0) 0 else 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            0 -> TypeAViewHolder(ItemATypeBinding.inflate(LayoutInflater.from(parent.context),parent,false))
            1 -> TypeBViewHolder(ItemBTypeBinding.inflate(LayoutInflater.from(parent.context),parent,false))
            else -> TypeAViewHolder(ItemATypeBinding.inflate(LayoutInflater.from(parent.context),parent,false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val current = getItem(position)
        when (getItemViewType(position)) {
            0 -> (holder as TypeAViewHolder).apply {current.bind() }
            1 -> (holder as TypeBViewHolder).apply { current.bind() }
        }
    }




}
package com.example.breakingnews.view.home.headlines.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.breakingnews.R
import com.example.breakingnews.base.OnClickItem
import com.example.breakingnews.model.Article
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.headline_layout.view.*

class HeadlineAdapter(var context : Context , var headlines: List<Article>,var onClickItem: OnClickItem) :
    RecyclerView.Adapter<HeadlineAdapter.HeadlineViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeadlineViewHolder {
       return HeadlineViewHolder(
            LayoutInflater.from(context).inflate(R.layout.headline_layout, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return headlines.size
    }

    override fun onBindViewHolder(holder: HeadlineViewHolder, position: Int) {
        holder.headlineText.text = headlines[position].title
        holder.headlineLayout.setOnClickListener {
            onClickItem.onItemClicked(position)
        }
        Picasso.get().load(headlines[position].urlToImage).into(holder.headLineImage)
    }


    class HeadlineViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var headlineText = view.headlineTextView
        var headLineImage = view.headlineImage
        var headlineLayout = view.mainHeadlineLayout
    }
}


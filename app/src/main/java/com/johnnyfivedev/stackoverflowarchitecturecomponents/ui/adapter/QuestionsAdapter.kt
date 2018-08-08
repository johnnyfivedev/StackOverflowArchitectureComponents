package com.johnnyfivedev.stackoverflowarchitecturecomponents.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.johnnyfivedev.data.model.network.question.Question
import com.johnnyfivedev.stackoverflowarchitecturecomponents.R
import kotlinx.android.synthetic.main.list_item_question.view.tv_question_title

class QuestionsAdapter(val context: Context) : BaseAdapter<Question, QuestionsAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item_question, parent, false))


    override fun onBindViewHolder(viewHolder: ItemViewHolder, position: Int) {
        viewHolder.itemView.tv_question_title.text = items[position].title
    }


    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
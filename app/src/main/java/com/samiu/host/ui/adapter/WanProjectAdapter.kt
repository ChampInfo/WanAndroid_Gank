package com.samiu.host.ui.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.samiu.base.adapter.BaseSingleRecyclerAdapter
import com.samiu.host.R
import com.samiu.host.global.toBrowser
import com.samiu.host.model.bean.Article
import kotlinx.android.synthetic.main.item_wan_project.view.*

/**
 * @author Samiu 2020/3/5
 * @github https://github.com/SamiuZhong
 * @blog samiu.top
 */
class WanProjectAdapter(context: Context?) : BaseSingleRecyclerAdapter<Article>(context) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ProjectHolder(layoutInflater.inflate(R.layout.item_wan_project, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ProjectHolder)
            with(holder.itemView) {
                val data = mList[position]
                Glide.with(context).load(data.envelopePic).into(project_img)
                project_title.text = data.title
                project_desc.text = data.desc
                project_time.text = data.niceDate
                project_author.text = data.author
                setOnClickListener { context.toBrowser(data.link, data.title) }
            }
    }

    class ProjectHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}

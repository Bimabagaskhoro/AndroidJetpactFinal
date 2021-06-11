package com.bimabagaskhoro.submissionjetpactpro3.ui.content.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bimabagaskhoro.submissionjetpactpro3.R
import com.bimabagaskhoro.submissionjetpactpro3.databinding.ItemsShowBinding
import com.bimabagaskhoro.submissionjetpactpro3.repository.data.entity.MovieEntity
import com.bimabagaskhoro.submissionjetpactpro3.ui.DetailActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class MovieAdapter :
    PagedListAdapter<MovieEntity, MovieAdapter.MovieViewHolder>(DIFF_CALLBACK) {

    companion object {
        const val EXTRA_LINK = "https://image.tmdb.org/t/p/w500/"
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieEntity>() {
            override fun areItemsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean =
                oldItem == newItem
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieViewHolder {
        val itemsShowBinding =
            ItemsShowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(itemsShowBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val tvShow = getItem(position)
        if (tvShow != null) holder.bind(tvShow)
    }

    inner class MovieViewHolder(private val binding: ItemsShowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(show: MovieEntity) {
            with(binding) {
                tvItemTitle.text = show.title
                tvItemDate.text = show.date
                tvItemOriginalLanguage.text = show.original_language
                tvItemVoteCount.text = show.vote_average.toString()
                Glide.with(itemView.context)
                    .load(EXTRA_LINK + show.image)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(imgPoster)
                itemView.setOnClickListener {
                    Intent(itemView.context, DetailActivity::class.java).also {
                        it.putExtra(DetailActivity.EXTRAS_SHOW, show.id)
                        it.putExtra(DetailActivity.EXTRAS_CHOOSE, "MOVIE")
                        itemView.context.startActivity(it)
                    }
                }
            }
        }
    }
}
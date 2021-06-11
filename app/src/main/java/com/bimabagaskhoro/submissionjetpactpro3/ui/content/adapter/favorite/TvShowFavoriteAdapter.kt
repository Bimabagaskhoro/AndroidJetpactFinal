package com.bimabagaskhoro.submissionjetpactpro3.ui.content.adapter.favorite

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bimabagaskhoro.submissionjetpactpro3.R
import com.bimabagaskhoro.submissionjetpactpro3.databinding.ItemsShowBinding
import com.bimabagaskhoro.submissionjetpactpro3.repository.data.entity.TvShowEntity
import com.bimabagaskhoro.submissionjetpactpro3.ui.DetailActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class TvShowFavoriteAdapter :
    PagedListAdapter<TvShowEntity, TvShowFavoriteAdapter.TvShowViewHolder>(DIFF_CALLBACK) {

    companion object {
        const val EXTRA_LINK = "https://image.tmdb.org/t/p/w500/"
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvShowEntity>() {
            override fun areItemsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    fun getSwipedItem(swipedPosition: Int): TvShowEntity? = getItem(swipedPosition)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val view = ItemsShowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowViewHolder(view)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        val tvShow = getItem(position)
        if (tvShow != null) holder.bind(tvShow)
    }

    inner class TvShowViewHolder(private val binding: ItemsShowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(show: TvShowEntity) {
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
                        it.putExtra(DetailActivity.EXTRAS_CHOOSE, "TV_SHOW")
                        itemView.context.startActivity(it)
                    }
                }
            }
        }
    }
}
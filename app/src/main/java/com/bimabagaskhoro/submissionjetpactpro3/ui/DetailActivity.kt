package com.bimabagaskhoro.submissionjetpactpro3.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.bimabagaskhoro.submissionjetpactpro3.R
import com.bimabagaskhoro.submissionjetpactpro3.databinding.ActivityDetailBinding
import com.bimabagaskhoro.submissionjetpactpro3.databinding.ContentDetailBinding
import com.bimabagaskhoro.submissionjetpactpro3.repository.data.entity.MovieEntity
import com.bimabagaskhoro.submissionjetpactpro3.repository.data.entity.TvShowEntity
import com.bimabagaskhoro.submissionjetpactpro3.viewmodel.DetailViewModel
import com.bimabagaskhoro.submissionjetpactpro3.viewmodel.ViewModelFactory
import com.bimabagaskhoro.submissionjetpactpro3.vo.Status
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

class DetailActivity : AppCompatActivity() {
    private lateinit var contentDetailBinding: ContentDetailBinding
    private lateinit var detailViewModel: DetailViewModel

    companion object {
        const val EXTRAS_LINK = "https://image.tmdb.org/t/p/w500"
        const val EXTRAS_SHOW = "extras_show"
        const val EXTRAS_CHOOSE = "choose"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityDetailBinding = ActivityDetailBinding.inflate(layoutInflater)
        contentDetailBinding = activityDetailBinding.detailContent
        setContentView(activityDetailBinding.root)

        val factory = ViewModelFactory.getInstance(this)
        detailViewModel = ViewModelProvider(
                this, factory)[DetailViewModel::class.java]

        val receivedData = intent.getIntExtra(EXTRAS_SHOW, 0)
        val showChoose = intent.getStringExtra(EXTRAS_CHOOSE)
        if (receivedData != 0 && showChoose != null) {
            when (showChoose) {
                "MOVIE" -> {
                    getMovie(receivedData)
                }
                "TV_SHOW" -> {
                    getTvShow(receivedData)
                }
            }
        }
        setFav()
    }

    private fun getMovie(movieID: Int) {
        detailViewModel.setDataMovie(movieID).observe(this, {
            when (it.status) {
                Status.LOADING -> true.progressBar()
                Status.SUCCESS -> {
                    if (it.data != null) {
                        false.progressBar()
                        generateDataDetailMovie(it.data)
                    }
                }
                Status.ERROR -> {
                    false.progressBar()
                    Toast.makeText(applicationContext, "Data gagal dimuat", Toast.LENGTH_LONG)
                        .show()
                }
            }
        })
    }

    private fun getTvShow(tvShowID: Int) {
        detailViewModel.setDataTVShow(tvShowID).observe(this, {
            when (it.status) {
                Status.LOADING -> true.progressBar()
                Status.SUCCESS -> {
                    if (it.data != null) {
                        false.progressBar()
                        generateDataDetailTVShow(it.data)
                    }
                }
                Status.ERROR -> {
                    false.progressBar()
                    Toast.makeText(applicationContext, "Data gagal dimuat", Toast.LENGTH_LONG)
                        .show()
                }
            }
        })
    }

    private fun generateDataDetailMovie(detail: MovieEntity) {

        if (supportActionBar != null) {
            title = detail.title
        }

        contentDetailBinding.apply {
            with(detail) {
                tvTitle.text = title
                tvDate.text = date
                tvDesc.text = desc
                tvOriginalLanguage.text = original_language
                tvItemVoteCount.text = vote_average.toString()
                buttonFav.isChecked = addFav

                Glide.with(this@DetailActivity)
                    .load(EXTRAS_LINK + image)
                    .transform(RoundedCorners(20))
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(imgPosterDetail)

                Glide.with(this@DetailActivity)
                    .load(EXTRAS_LINK + imageBackdrop)
                    .transform(RoundedCorners(20))
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(imgBackdrop)
            }
        }
    }

    private fun generateDataDetailTVShow(detail: TvShowEntity) {
        if (supportActionBar != null) {
            title = detail.title
        }

        with(contentDetailBinding) {
            with(detail) {
                tvTitle.text = title
                tvDate.text = date
                tvDesc.text = desc
                tvOriginalLanguage.text = original_language
                tvItemVoteCount.text = vote_average.toString()
                buttonFav.isChecked = addFav

                Glide.with(this@DetailActivity)
                    .load(EXTRAS_LINK + image)
                    .transform(RoundedCorners(20))
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(imgPosterDetail)

                Glide.with(this@DetailActivity)
                    .load(EXTRAS_LINK + imageBackdrop)
                    .transform(RoundedCorners(20))
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(imgBackdrop)
            }
        }
    }

    private fun setFav() {
        val filmChoose = intent.getStringExtra(EXTRAS_CHOOSE)
        if (filmChoose != null) {
            contentDetailBinding.buttonFav.setOnClickListener {
                when (filmChoose) {
                    "MOVIE" -> {
                        detailViewModel.setMovieFavorite()
                    }
                    "TV_SHOW" -> {
                        detailViewModel.setTvShowFavorite()
                    }
                }
            }
        }
    }

    private fun Boolean.progressBar() {
        contentDetailBinding.progressBar.visibility = if (this) View.VISIBLE else View.GONE
    }
}
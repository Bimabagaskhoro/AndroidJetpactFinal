package com.bimabagaskhoro.submissionjetpactpro3.ui.content.fragment.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bimabagaskhoro.submissionjetpactpro3.R
import com.bimabagaskhoro.submissionjetpactpro3.databinding.FragmentFavoriteMovieBinding
import com.bimabagaskhoro.submissionjetpactpro3.ui.content.adapter.favorite.MovieFavoriteAdapter
import com.bimabagaskhoro.submissionjetpactpro3.viewmodel.FavoriteViewModel
import com.bimabagaskhoro.submissionjetpactpro3.viewmodel.ViewModelFactory
import com.google.android.material.snackbar.Snackbar

class FavoriteMovieFragment : Fragment() {
    private lateinit var movieFavoriteBinding: FragmentFavoriteMovieBinding
    private lateinit var viewModel: FavoriteViewModel
    private lateinit var movieFavoriteAdapter: MovieFavoriteAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        movieFavoriteBinding =
        FragmentFavoriteMovieBinding.inflate(layoutInflater, container, false)
        return movieFavoriteBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemTouchHelper.attachToRecyclerView(movieFavoriteBinding.rvMovieFavorite)

        if (activity != null) {

            true.progressBar()

            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[FavoriteViewModel::class.java]

            movieFavoriteAdapter = MovieFavoriteAdapter()

            viewModel.getFavListMovie().observe(viewLifecycleOwner, {
                false.progressBar()
                movieFavoriteAdapter.submitList(it)
            })

            movieFavoriteBinding.rvMovieFavorite.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = movieFavoriteAdapter
            }
        }
    }
    private val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.Callback() {
        override fun getMovementFlags(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
        ): Int = makeMovementFlags(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)


        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder,
        ): Boolean = true

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            if (view != null) {
                val swipePosition = viewHolder.bindingAdapterPosition
                val movieEntity = movieFavoriteAdapter.getSwipedItem(swipePosition)
                movieEntity?.let {
                    viewModel.setFavListMovie(it)
                }

                val snackbar = Snackbar.make(view as View, R.string.undo, Snackbar.LENGTH_LONG)
                snackbar.setAction("OK") {
                    movieEntity?.let {
                        viewModel.setFavListMovie(it)
                    }
                }
                snackbar.show()
            }
        }

    })

    private fun Boolean.progressBar() {
        movieFavoriteBinding.progressBar.visibility = if (this) View.VISIBLE else View.GONE
    }
}
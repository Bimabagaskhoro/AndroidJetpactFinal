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
import com.bimabagaskhoro.submissionjetpactpro3.databinding.FragmentFavoriteTvShowBinding
import com.bimabagaskhoro.submissionjetpactpro3.viewmodel.FavoriteViewModel
import com.bimabagaskhoro.submissionjetpactpro3.viewmodel.ViewModelFactory
import com.bimabagaskhoro.submissionjetpactpro3.ui.content.adapter.favorite.TvShowFavoriteAdapter
import com.google.android.material.snackbar.Snackbar

class FavoriteTvShowFragment : Fragment() {
    private lateinit var tvShowFavoriteBinding: FragmentFavoriteTvShowBinding
    private lateinit var viewModel: FavoriteViewModel
    private lateinit var tvShowFavAdapter: TvShowFavoriteAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tvShowFavoriteBinding =
            FragmentFavoriteTvShowBinding.inflate(layoutInflater, container, false)
        return tvShowFavoriteBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemTouchHelper.attachToRecyclerView(tvShowFavoriteBinding.rvTvShowFavorite)

        if (activity != null) {

            true.progressBar()

            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[FavoriteViewModel::class.java]

            tvShowFavAdapter = TvShowFavoriteAdapter()

            viewModel.getFavListTVShow().observe(viewLifecycleOwner, {
                false.progressBar()
                tvShowFavAdapter.submitList(it)
            })

            with(tvShowFavoriteBinding.rvTvShowFavorite) {
                layoutManager = LinearLayoutManager(context)
                adapter = tvShowFavAdapter
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
                val tvShowEntity = tvShowFavAdapter.getSwipedItem(swipePosition)
                tvShowEntity?.let {
                    viewModel.setFavListTVShow(it)
                }

                val snackbar = Snackbar.make(view as View, R.string.undo, Snackbar.LENGTH_LONG)
                snackbar.setAction("OK") {
                    tvShowEntity?.let {
                        viewModel.setFavListTVShow(it)
                    }
                }
                snackbar.show()
            }
        }

    })

    private fun Boolean.progressBar() {
        tvShowFavoriteBinding.progressBar.visibility = if (this) View.VISIBLE else View.GONE
    }
}
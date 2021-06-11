package com.bimabagaskhoro.submissionjetpactpro3.ui.content.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bimabagaskhoro.submissionjetpactpro3.databinding.FragmentMovieBinding
import com.bimabagaskhoro.submissionjetpactpro3.ui.content.adapter.MovieAdapter
import com.bimabagaskhoro.submissionjetpactpro3.viewmodel.ShowViewModel
import com.bimabagaskhoro.submissionjetpactpro3.viewmodel.ViewModelFactory
import com.bimabagaskhoro.submissionjetpactpro3.vo.Status

class MovieFragment : Fragment() {
    private lateinit var fragmentMovieBinding: FragmentMovieBinding
    private lateinit var moviesAdapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentMovieBinding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return fragmentMovieBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[ShowViewModel::class.java]

            moviesAdapter = MovieAdapter()
            viewModel.getListMovies().observe(viewLifecycleOwner, { movie ->
                if (movie != null) {
                    when (movie.status) {
                        Status.LOADING -> true.progressBar()
                        Status.SUCCESS -> {
                            false.progressBar()
                            with(moviesAdapter) {
                                submitList(movie.data)
                            }
                        }
                        Status.ERROR -> {
                            false.progressBar()
                            Toast.makeText(context, "Data gagal dimuat", Toast.LENGTH_LONG).show()
                        }
                    }
                }
            })
            setRecyclerView()

        }
    }

    private fun Boolean.progressBar() {
        fragmentMovieBinding.progressBar.visibility = if (this) View.VISIBLE else View.GONE
    }

    private fun setRecyclerView() {
        with(fragmentMovieBinding.rvMovie) {
            layoutManager = LinearLayoutManager(context)
            adapter = moviesAdapter
            setHasFixedSize(true)
        }
    }
}
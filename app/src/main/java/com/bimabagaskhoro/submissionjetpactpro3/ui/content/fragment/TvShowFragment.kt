package com.bimabagaskhoro.submissionjetpactpro3.ui.content.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bimabagaskhoro.submissionjetpactpro3.databinding.FragmentTvShowBinding
import com.bimabagaskhoro.submissionjetpactpro3.ui.content.adapter.TvShowAdapter
import com.bimabagaskhoro.submissionjetpactpro3.viewmodel.ShowViewModel
import com.bimabagaskhoro.submissionjetpactpro3.viewmodel.ViewModelFactory
import com.bimabagaskhoro.submissionjetpactpro3.vo.Status

class TvShowFragment : Fragment() {
    private lateinit var fragmentTvShowBinding: FragmentTvShowBinding
    private lateinit var tvShowAdapter: TvShowAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentTvShowBinding = FragmentTvShowBinding.inflate(layoutInflater, container, false)
        return fragmentTvShowBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {

            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[ShowViewModel::class.java]

            tvShowAdapter = TvShowAdapter()
            viewModel.getListTVShows().observe(viewLifecycleOwner, { tvShow ->
                if (tvShow != null) {
                    when (tvShow.status) {
                        Status.LOADING -> true.progressBar()
                        Status.SUCCESS -> {
                            false.progressBar()
                            with(tvShowAdapter) {
                                submitList(tvShow.data)
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
        fragmentTvShowBinding.progressBar.visibility = if (this) View.VISIBLE else View.GONE
    }

    private fun setRecyclerView() {
        with(fragmentTvShowBinding.rvTvShow) {
            layoutManager = LinearLayoutManager(context)
            adapter = tvShowAdapter
            setHasFixedSize(true)
        }
    }
}
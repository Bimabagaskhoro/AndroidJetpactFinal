@file:Suppress("DEPRECATION")

package com.bimabagaskhoro.submissionjetpactpro3.ui.content.adapter

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.bimabagaskhoro.submissionjetpactpro3.R
import com.bimabagaskhoro.submissionjetpactpro3.ui.content.fragment.favorite.FavoriteMovieFragment
import com.bimabagaskhoro.submissionjetpactpro3.ui.content.fragment.favorite.FavoriteTvShowFragment

@Suppress("DEPRECATION")
class SectionsPagerAdapterFavorite(private val mContext: Context, fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.moviefav, R.string.tvshowfav)
    }

    override fun getItem(position: Int): Fragment =
            when (position) {
                0 -> FavoriteMovieFragment()
                1 -> FavoriteTvShowFragment()
                else -> Fragment()
            }

    override fun getPageTitle(position: Int): CharSequence? = mContext.resources.getString(TAB_TITLES[position])

    override fun getCount(): Int = 2

}
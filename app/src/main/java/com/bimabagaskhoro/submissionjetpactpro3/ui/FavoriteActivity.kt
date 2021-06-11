package com.bimabagaskhoro.submissionjetpactpro3.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bimabagaskhoro.submissionjetpactpro3.R
import com.bimabagaskhoro.submissionjetpactpro3.databinding.ActivityFavoriteBinding
import com.bimabagaskhoro.submissionjetpactpro3.databinding.ActivityMainBinding
import com.bimabagaskhoro.submissionjetpactpro3.ui.content.adapter.SectionsPagerAdapter
import com.bimabagaskhoro.submissionjetpactpro3.ui.content.adapter.SectionsPagerAdapterFavorite

class FavoriteActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityFavoriteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        val actionbar = supportActionBar
        actionbar!!.title = getString(R.string.favorite)

        val sectionsPagerAdapterFavorite = SectionsPagerAdapterFavorite(this, supportFragmentManager)
        mainBinding.apply {
            viewPagerFavorite.adapter = sectionsPagerAdapterFavorite
            tabsFavorite.setupWithViewPager(viewPagerFavorite)
            supportActionBar?.elevation = 0f
        }
    }
}
package com.bimabagaskhoro.submissionjetpactpro3.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.bimabagaskhoro.submissionjetpactpro3.R
import com.bimabagaskhoro.submissionjetpactpro3.databinding.ActivityMainBinding
import com.bimabagaskhoro.submissionjetpactpro3.ui.content.adapter.SectionsPagerAdapter


class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    private val rotateOpen: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.rotate_open_anim) }
    private val rotateClose: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.rotate_close_anim) }
    private val fromBottom: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.from_botton_anim) }
    private val toBottom: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.to_botton_anim) }

    private var clicked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        val actionbar = supportActionBar
        actionbar!!.title = getString(R.string.app_name)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        mainBinding.apply {
            viewPager.adapter = sectionsPagerAdapter
            tabs.setupWithViewPager(viewPager)
            supportActionBar?.elevation = 0f

            floatingActionButton.setOnClickListener {
                onAddButtomClicked()
            }

            floatingButtonFavorite.setOnClickListener {
                val intent = Intent(this@MainActivity, FavoriteActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun onAddButtomClicked() {
        setVisibility(clicked)
        setAnimation(clicked)
        clicked = !clicked
    }

    private fun setVisibility(clicked: Boolean) {
        if(!clicked){
            mainBinding.apply {
                floatingButtonFavorite.visibility = View.VISIBLE
            }
        } else {
            mainBinding.apply {
                floatingButtonFavorite.visibility = View.INVISIBLE
            }
        }
    }

    private fun setAnimation(clicked: Boolean) {
        if (!clicked){
            mainBinding.apply {
                floatingButtonFavorite.startAnimation(fromBottom)
                floatingActionButton.startAnimation(rotateOpen)
            }
        } else {
            mainBinding.apply {
                floatingButtonFavorite.startAnimation(toBottom)
                floatingActionButton.startAnimation(rotateClose)
            }
        }
    }
}
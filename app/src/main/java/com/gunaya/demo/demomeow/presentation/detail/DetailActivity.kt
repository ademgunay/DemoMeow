package com.gunaya.demo.demomeow.presentation.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.gunaya.demo.demomeow.R
import com.gunaya.demo.demomeow.presentation.loadImage
import kotlinx.android.synthetic.main.activity_detail.*

const val EXTRA_CAT_IMAGE_URL = "EXTRA_CAT_IMAGE_URL"

class DetailActivity : AppCompatActivity() {

    companion object {
        // Whenever we want to create this Activity, we use it via this intent creation function.
        fun getStartIntent(context: Context, imageUrl: String): Intent {
            return Intent(context, DetailActivity::class.java)
                .putExtra(EXTRA_CAT_IMAGE_URL, imageUrl)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val imageUrl = intent.getStringExtra(EXTRA_CAT_IMAGE_URL)
        detailCatImage.loadImage(imageUrl)
    }
}
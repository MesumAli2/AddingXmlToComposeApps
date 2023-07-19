package com.example.juicetracker.ui.bottomsheet

import android.renderscript.ScriptGroup.Input
import android.widget.RatingBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun RatingInputRow(rating : Int, onRatingChange : (Int)-> Unit, modifier: Modifier= Modifier) {

    InputRow(inputLabel = stringResource(id = com.example.juicetracker.R.string.rating), modifier = Modifier) {
        AndroidView(factory = {
                 RatingBar(it).apply {
                     stepSize = 1f
                 }

        }, update = {ratingBar ->
          ratingBar.rating = rating.toFloat()
            ratingBar.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
                onRatingChange(ratingBar.rating.toInt())
            }
        })

    }
}
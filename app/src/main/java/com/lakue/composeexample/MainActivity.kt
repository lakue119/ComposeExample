package com.lakue.composeexample

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyLazyColumn()
        }
    }

    @Preview
    @Composable
    private fun TextCreate() {
        Text(text = "helloWorld")
    }

    @Preview
    @Composable
    fun NewStory() {

        MaterialTheme {
            val typography = MaterialTheme.typography
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = null,
                    modifier = Modifier
                        .height(180.dp)
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(4.dp)),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "A day wandering through the sandhills " +
                            "in Shark Fin Cove, and a few of the " +
                            "sights I saw",
                    style = typography.h6,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "Davenport, California",
                    style = typography.body2
                )
                Text(
                    text = "December 2018",
                    style = typography.body2
                )
            }
        }
    }

    @Preview
    @Composable
    fun ImageBlur() {
        setContent {

        }
    }

    private val itemsList = (0..2000).toList()
    private val itemsIndexedList = listOf("A", "B", "C")

    @Composable
    fun MyLazyColumn() {
        LazyColumn {
            items(itemsList) {
                Row(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        "Item",
                        textAlign = TextAlign.Start
                    )
                    Text(
                        "is",
                        textAlign = TextAlign.Center
                    )
                    Text(
                        "$it",
                        textAlign = TextAlign.End
                    )
                }

                Image(
                    painter = painterResource(id = R.drawable.zenitsu_agatsuma2),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(16.dp)
                        .height(180.dp)
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(4.dp)),
                    contentScale = ContentScale.Crop,
                )

            }

            item {
                Text("Single item")
            }

            itemsIndexed(itemsIndexedList) { index, item ->
                Text("Item at index $index is $item")
            }
        }
    }
}
package com.example.instaui

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun HomeTopStory()
{
    val list= mutableListOf<StoryRowItemData>()
    list.add(StoryRowItemData(img= painterResource(id = R.drawable.profile),text = "Your Story"))
    list.add(StoryRowItemData(img= painterResource(id = R.drawable.profile5),text = "Jilakara Revanth Kumar"))
    list.add(StoryRowItemData(img= painterResource(id = R.drawable.profile2),text = "Shiva Kumar"))
    list.add(StoryRowItemData(img= painterResource(id = R.drawable.profile3),text = "Nagarjuna"))
    list.add(StoryRowItemData(img= painterResource(id = R.drawable.profile4),text = "sai_vathshsal_vyas"))
    list.add(StoryRowItemData(img= painterResource(id = R.drawable.profile1),text = "Arman Ammu"))
    list.add(StoryRowItemData(img= painterResource(id = R.drawable.profile6),text = "Harshad Suri"))
    list.add(StoryRowItemData(img= painterResource(id = R.drawable.profile7),text = "Shanks"))


    LazyRow {
        itemsIndexed(list)
        {
                index, item ->
            StoryRowItem(img = item.img, text = item.text, Color.Magenta,80.dp)
        }
    }
}
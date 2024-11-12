package com.example.instagramclone.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.instagramclone.data.model.Feed
import com.example.instagramclone.data.model.Story
import com.example.instagramclone.data.repository.feedList
import com.example.instagramclone.data.repository.stories
import com.example.instagramclone.ui.theme.DividerColor
import com.example.instagramclone.ui.theme.spacingMedium

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(top = 16.dp)
    ) {
        InstagramToolBar()

        StoryList(stories = stories)

        HorizontalDivider(color = DividerColor, thickness = 0.2.dp)

        FeedList(feeds = feedList)
    }
}

@Composable
fun StoryList(stories: List<Story>) {
    LazyRow(
        modifier = Modifier.padding(top = spacingMedium)
    ) {
        itemsIndexed(stories) { _, item ->
            StoryItem(story = item)
        }
    }
}

@Composable
fun FeedList(feeds: List<Feed>) {
    LazyColumn (
        modifier = Modifier.padding(top = spacingMedium)
    ) {
        itemsIndexed(feeds) { _, item ->
            FeedItem(feed = item)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}
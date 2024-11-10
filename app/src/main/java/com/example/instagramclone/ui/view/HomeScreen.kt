package com.example.instagramclone.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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

        FeedItem(
            feed = Feed(
                userNickName = "deassis",
                localName = "Tiradentes - MG",
                userAvatar = "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Favatarfiles.alphacoders.com%2F216%2Fthumb-1920-216277.jpg&f=1&nofb=1&ipt=84259aa182480965fe70beae8ebcbd8baf38b4cdf133129fa71f03f7b8b33af6&ipo=images",
                imageUrl = "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fwallpapercave.com%2Fwp%2Fwp2861081.jpg&f=1&nofb=1&ipt=65713b41e1f29031a9b1380a4722f8a0ffcf19615e32f4d6303a814dc8ce4209&ipo=images",
                description = "De quando aprendi a usar o chidore",
                postedAgo = "Há 21 horas"
            )
        )
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

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}
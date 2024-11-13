package com.example.instagramclone.ui.view

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.instagramclone.R
import com.example.instagramclone.data.model.Feed
import com.example.instagramclone.data.repository.feedList
import com.example.instagramclone.ui.theme.Gray
import com.example.instagramclone.ui.theme.InstagramCloneTheme
import com.example.instagramclone.ui.theme.spacingLarge
import com.example.instagramclone.ui.theme.spacingMedium
import com.example.instagramclone.ui.theme.spacingSmall

@Composable
fun FeedItem(feed: Feed) {

    val likeIcon = R.drawable.ic_notification
    val messageIcon = R.drawable.ic_message
    val commentIcon = R.drawable.ic_comment
    val bookmarkIcon = R.drawable.ic_bookmark

    val userAvatarContentDesc = stringResource(R.string.content_description_feed_avatar)
    val feedImageContentDesc = stringResource(R.string.content_description_feed_image)
    val likeContentDesc = stringResource(R.string.button_like_content_description)
    val messageContentDesc = stringResource(R.string.button_message_content_description)
    val commentContentDesc = stringResource(R.string.button_coment_content_description)
    val bookmarkContentDesc = stringResource(R.string.button_bookmark_content_description)

    val iconsColor = MaterialTheme.colorScheme.onBackground

    Column(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
        Row(
            modifier = Modifier
                .padding(horizontal = spacingSmall)
                .padding(top = spacingLarge),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            AsyncImage(
                model = feed.userAvatar,
                contentDescription = userAvatarContentDesc,
                modifier = Modifier
                    .size(36.dp)
                    .fillMaxSize()
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            Column {
                Text(
                    text = feed.userNickName,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = spacingMedium),
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Start
                )

                Text(
                    text = feed.localName,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = spacingMedium),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Start
                )
            }
        }

        AsyncImage(
            model = feed.imageUrl,
            contentDescription = feedImageContentDesc,
            modifier = Modifier
                .padding(top = spacingLarge)
                .height(256.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .padding(start = spacingMedium)
                .padding(top = spacingLarge)
        ) {
            FeedIcon(
                icon = likeIcon,
                contentDesc = likeContentDesc
            )

            FeedIcon(
                icon = messageIcon,
                contentDesc = messageContentDesc
            )

            FeedIcon(
                icon = commentIcon,
                contentDesc = commentContentDesc
            )

            Image(
                painter = painterResource(id = bookmarkIcon),
                contentDescription = bookmarkContentDesc,
                modifier = Modifier
                    .size(40.dp)
                    .padding(end = spacingLarge)
                    .weight(1f)
                    .wrapContentWidth(align = Alignment.End),
                colorFilter = ColorFilter.tint(iconsColor)
            )
        }

        Row(
            modifier = Modifier
                .padding(horizontal = spacingMedium)
                .padding(top = spacingLarge)
        ) {
            val description = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append(feed.userNickName)
                }
                append(" ")
                append(feed.description)
            }

            Text(
                text = description,
                modifier = Modifier.padding(horizontal = spacingSmall),
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Start
            )
        }

        Text(
            text = feed.postedAgo,
            modifier = Modifier
                .padding(start = 12.dp)
                .padding(top = spacingSmall),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            color = Gray,
            textAlign = TextAlign.Start
        )
    }
}

@Composable
fun FeedIcon(
    @DrawableRes icon: Int,
    contentDesc: String,
) {
    Image(
        painter = painterResource(id = icon),
        contentDescription = contentDesc,
        modifier = Modifier
            .size(40.dp)
            .padding(end = spacingLarge),
        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onBackground)
    )
}

@Preview(showBackground = true)
@Composable
fun FeedItemPreview() {
    InstagramCloneTheme {
        FeedItem(
            feed = feedList[0]
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FeedItemDarkPreview() {
    InstagramCloneTheme(darkTheme = true) {
        FeedItem(
            feed = feedList[0]
        )
    }
}
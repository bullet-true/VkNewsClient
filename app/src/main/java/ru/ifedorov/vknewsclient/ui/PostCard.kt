package ru.ifedorov.vknewsclient.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.ifedorov.vknewsclient.R
import ru.ifedorov.vknewsclient.ui.theme.VKNewsClientTheme

@Composable
fun PostCard(modifier: Modifier = Modifier) {
    val secondaryTextColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)

    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface
        ),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape),
                painter = painterResource(R.drawable.post_comunity_thumbnail),
                contentDescription = null,
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "/dev/android",
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "12:12",
                    color = secondaryTextColor
                )
            }
            Icon(
                imageVector = Icons.Rounded.MoreVert,
                contentDescription = null,
                tint = secondaryTextColor
            )
        }
    }
}

@Preview
@Composable
fun PreviewLight() {
    VKNewsClientTheme(darkTheme = false) {
        PostCard()
    }
}

@Preview
@Composable
fun PreviewDark() {
    VKNewsClientTheme(darkTheme = true) {
        PostCard()
    }
}
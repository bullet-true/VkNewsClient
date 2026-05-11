package ru.ifedorov.vknewsclient.navigation

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import kotlinx.serialization.json.Json
import ru.ifedorov.vknewsclient.domain.FeedPost
import ru.ifedorov.vknewsclient.navigation.Screen.Companion.KEY_FEED_POST

fun NavGraphBuilder.homeScreenNavGraph(
    newsFeedScreenContent: @Composable () -> Unit,
    commentsScreenContent: @Composable (FeedPost) -> Unit,
) {
    navigation(
        startDestination = Screen.NewsFeed.route,
        route = Screen.Home.route
    ) {
        composable(Screen.NewsFeed.route) {
            newsFeedScreenContent()
        }
        composable(
            route = Screen.Comments.route,
            arguments = listOf(
                navArgument(KEY_FEED_POST) {
                    type = NavType.StringType
                },
            )
        ) {
            val feedPostJson = it.arguments?.getString(KEY_FEED_POST) ?: ""
            val decodedJson = Uri.decode(feedPostJson)
            val feedPost = Json.decodeFromString<FeedPost>(decodedJson)

            commentsScreenContent(feedPost)
        }
    }
}
package ru.ifedorov.vknewsclient.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import ru.ifedorov.vknewsclient.domain.FeedPost
import ru.ifedorov.vknewsclient.navigation.Screen.Companion.KEY_CONTENT_TEXT
import ru.ifedorov.vknewsclient.navigation.Screen.Companion.KEY_FEED_POST_ID

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
                navArgument(KEY_FEED_POST_ID) {
                    type = NavType.IntType
                },
                navArgument(KEY_CONTENT_TEXT) {
                    type = NavType.StringType
                }
            )) {
            val feedPostId = it.arguments?.getInt(KEY_FEED_POST_ID) ?: 0
            val contentText = it.arguments?.getString(KEY_CONTENT_TEXT) ?: ""
            commentsScreenContent(
                FeedPost(
                    id = feedPostId,
                    contentText = contentText
                )
            )
        }
    }
}
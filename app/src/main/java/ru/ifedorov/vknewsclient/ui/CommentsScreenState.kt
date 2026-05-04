package ru.ifedorov.vknewsclient.ui

import ru.ifedorov.vknewsclient.domain.FeedPost
import ru.ifedorov.vknewsclient.domain.PostComment

sealed class CommentsScreenState {

    object Initial : CommentsScreenState()

    class Comments(
        val feedPost: FeedPost,
        val comments: List<PostComment>
    ) : CommentsScreenState()
}
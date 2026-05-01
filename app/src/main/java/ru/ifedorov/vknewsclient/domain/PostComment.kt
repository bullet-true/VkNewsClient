package ru.ifedorov.vknewsclient.domain

import ru.ifedorov.vknewsclient.R

data class PostComment(
    val id: Int,
    val authorName: String = "Author",
    val authorAvatarId: Int = R.drawable.comment_author_avatar,
    val commentText: String = "Long comment text",
    val publicationData: String = "12:12"
)
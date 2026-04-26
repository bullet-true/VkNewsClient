package ru.ifedorov.vknewsclient.domain

import ru.ifedorov.vknewsclient.R

data class FeedPost(
    val id: Int = 0,
    val communityName: String = "/dev/android",
    val publicationData: String = "12:12",
    val avatarResId: Int = R.drawable.post_comunity_thumbnail,
    val contentText: String = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
    val contentImageResId: Int = R.drawable.post_content_image,
    val statistics: List<StatisticItem> = listOf(
        StatisticItem(type = StatisticType.VIEWS, count = 278),
        StatisticItem(type = StatisticType.SHARES, count = 12),
        StatisticItem(type = StatisticType.COMMENTS, count = 11),
        StatisticItem(type = StatisticType.LIKES, count = 7),
    )
)
package ru.ifedorov.vknewsclient.domain

import kotlinx.serialization.Serializable

@Serializable
data class StatisticItem(
    val type: StatisticType,
    val count: Int = 0
)

@Serializable
enum class StatisticType {
    VIEWS, COMMENTS, SHARES, LIKES
}
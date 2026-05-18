package ru.ifedorov.vknewsclient.presentation.comments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.ifedorov.vknewsclient.domain.FeedPost

class CommentsViewModelFactor(private val feedPost: FeedPost) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CommentsViewModel(feedPost) as T
    }
}
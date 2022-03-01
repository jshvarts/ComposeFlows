package com.jshvarts.composeflows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val messageList = listOf(
        "apple",
        "tomato",
        "banana"
    )
    private val _stateFlowMessage = MutableStateFlow("")
    val stateFlowMessage = _stateFlowMessage.asStateFlow()

    private val _sharedFlowMessage = MutableSharedFlow<String>()
    val sharedFlowMessage = _sharedFlowMessage.asSharedFlow()

    fun onButtonClicked() {
        viewModelScope.launch {
            val message = messageList.random()
            _stateFlowMessage.emit(message)
            _sharedFlowMessage.emit(message)
        }
    }
}
package com.bignerdranch.android.geoquiz

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

private const val TAG = "QuizViewModel"
const val CURRENT_INDEX_KEY = "CURRENT_INDEX_KEY"

class QuizViewModel (private val savedStateHandle: SavedStateHandle) : ViewModel() {
   // init {
      //  Log.d(TAG, "ViewModel instance created")
   // }

    //override fun onCleared() {
      //  super.onCleared()
      //  Log.d(TAG, "ViewModel instance about to be destroyed")
   // }

    private val questionBank = listOf(
        Question(R.string.question_one, true),
        Question(R.string.question_two, true),
        Question(R.string.question_three, true),
        Question(R.string.question_four, true),
        Question(R.string.question_five, false),
        Question(R.string.question_six, false),
        Question(R.string.question_seven, false),
        Question(R.string.question_eight, true),
        Question(R.string.question_nine, false),
        Question(R.string.question_ten, true))
    private var currentIndex : Int //= 0
        get() = savedStateHandle.get(CURRENT_INDEX_KEY) ?: 0
        set(value) = savedStateHandle.set(CURRENT_INDEX_KEY, value)

    val currentQuestionAnswer: Boolean
        get() = questionBank[currentIndex].answer
    val currentQuestionText: Int
        get() = questionBank[currentIndex].textResId
    fun moveToNext() {
        currentIndex = (currentIndex + 1) % questionBank.size
    }

}
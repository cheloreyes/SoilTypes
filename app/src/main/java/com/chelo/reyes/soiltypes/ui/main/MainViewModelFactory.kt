package com.chelo.reyes.soiltypes.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.chelo.reyes.soiltypes.DiManager
import com.chelo.reyes.soiltypes.domain.FindDescriptionByTypeUseCase
import com.chelo.reyes.soiltypes.domain.TopographicGradientUseCase
import com.chelo.reyes.soiltypes.ui.main.classification.ClassificationViewModel

class MainViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        when{
            modelClass.isAssignableFrom(MainViewModel::class.java) -> {
                return modelClass.getConstructor(TopographicGradientUseCase::class.java).newInstance(DiManager.topographicGradientUseCase)
            }
            modelClass.isAssignableFrom(ClassificationViewModel::class.java) -> {
                return modelClass.getConstructor(FindDescriptionByTypeUseCase::class.java).newInstance(DiManager.findDescriptionByTypeUseCase)
            }
        }
        throw IllegalArgumentException("${modelClass.name} is an unknown ViewModel")
    }
}
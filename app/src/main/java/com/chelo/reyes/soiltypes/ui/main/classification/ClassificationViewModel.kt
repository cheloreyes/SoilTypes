package com.chelo.reyes.soiltypes.ui.main.classification

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.chelo.reyes.soiltypes.domain.FindDescriptionByTypeUseCase

class ClassificationViewModel(private val findDescription: FindDescriptionByTypeUseCase): ViewModel() {
    val profileType = ObservableField<String>()
    val description = ObservableField<String>()
    val definition = ObservableField<String>()

    fun setType(profileType: String){
        findDescription.invoke(profileType)?.let {
            this.profileType.set(it.type)
            this.description.set(it.description)
            this.definition.set(it.definition)
        }
    }
}
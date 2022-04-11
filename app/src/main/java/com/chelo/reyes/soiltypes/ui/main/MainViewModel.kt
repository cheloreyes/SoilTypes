package com.chelo.reyes.soiltypes.ui.main

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.chelo.reyes.soiltypes.domain.TopographicGradientUseCase
import java.lang.NumberFormatException
import java.lang.StringBuilder

class MainViewModel(private val gradientUseCase: TopographicGradientUseCase) : ViewModel() {
    val activeGradientRange =  ObservableField<String>()
    val stableGradientRange =  ObservableField<String>()
    val active30GradientRange =  ObservableField<String>()
    private val currentProfile = StringBuilder()

    val getDefinitionOfProfile = MutableLiveData<String>()

    fun findRange(text: CharSequence){
        val range = try{
            Integer.parseInt(text.toString())
        } catch (ex: NumberFormatException) { null }
        findRange(range ?: 0)
    }

    private fun findRange(range: Int){
        gradientUseCase(range)?.let { model ->
            activeGradientRange.set(model.get9arcSegRange())
            stableGradientRange.set(model.geStable9arcSeg())
            active30GradientRange.set(model.get30arcSeg())
            currentProfile.clear()
            currentProfile.append(model.siteClassification)
        }
    }


    fun onGetDefinitionClick(){
        if(currentProfile.isEmpty()) return
        getDefinitionOfProfile.postValue(currentProfile.toString())
    }
}
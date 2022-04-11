package com.chelo.reyes.soiltypes

import com.chelo.reyes.soiltypes.domain.FindDescriptionByTypeUseCase
import com.chelo.reyes.soiltypes.domain.TopographicGradientUseCase

object DiManager {
    private val vs30Values = DataProvider.createVs30TableReference()
    private val profileTypes = DataProvider.createProfileTypes()
    val topographicGradientUseCase = TopographicGradientUseCase(vs30Values)
    val findDescriptionByTypeUseCase = FindDescriptionByTypeUseCase(profileTypes)
}
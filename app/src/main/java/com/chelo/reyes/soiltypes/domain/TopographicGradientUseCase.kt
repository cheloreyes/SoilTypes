package com.chelo.reyes.soiltypes.domain

class TopographicGradientUseCase(private val vs30Values: List<Vs30Model>) {
    operator fun invoke(range: Int): Vs30Model? = vs30Values.find {
        range in it.minVs30Value .. it.maxVs30Value
    }
}


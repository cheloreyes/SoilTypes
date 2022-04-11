package com.chelo.reyes.soiltypes.domain

class FindDescriptionByTypeUseCase(private val profiles: List<ProfileTypeModel>) {
    operator fun invoke(profileType: String): ProfileTypeModel?{
        return profiles.find { it.type == profileType }
    }
}
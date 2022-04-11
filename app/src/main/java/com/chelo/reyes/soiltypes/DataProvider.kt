package com.chelo.reyes.soiltypes

import com.chelo.reyes.soiltypes.domain.ProfileTypeModel
import com.chelo.reyes.soiltypes.domain.Vs30Model

object DataProvider {
    fun createVs30TableReference(): List<Vs30Model> = listOf(
        Vs30Model('E', Int.MIN_VALUE, 180, 0f, 0.0003f, 0f, 0.0003f, 0f, 0.0003f),
        Vs30Model('E', 180, 240, 0.0003f, 0.0035f, 0.0003f, 0.0085f, 0.0003f, 0.0035f),
        Vs30Model('D', 240, 300, 0.0035f, 0.010f, 0.0045f, 0.0085f, 0.0035f, 0.010f),
        Vs30Model('D', 300, 360, 0.010f, 0.024f, 0.0085f, 0.013f, 0.010f, 0.018f),
        Vs30Model('D', 360, 490, 0.024f, 0.08f, 0.013f, 0.022f, 0.018f, 0.05f),
        Vs30Model('C', 490, 620, 0.08f, 0.14f, 0.022f, 0.03f, 0.05f, 0.10f),
        Vs30Model('C', 620, 760, 0.14f, 0.20f, 0.03f, 0.04f, 0.10f, 0.14f),
        Vs30Model(
            'V',
            760,
            Int.MAX_VALUE,
            0.20f,
            Float.MAX_VALUE,
            0.004f,
            Float.MAX_VALUE,
            0.14f,
            Float.MAX_VALUE
        )
    )

    fun createProfileTypes(): List<ProfileTypeModel> = listOf(
        ProfileTypeModel("A", "Perfil de roca competente.", "Vs30 >= 1500 m/s"),
        ProfileTypeModel("B", "Perfil de roca de rigidez media.", "1500 > Vs30 >= 760 m/s"),
        ProfileTypeModel("C", "Suelos muy densos o roca blanda.", "760 > Vs30 >= 360 m/s"),
        ProfileTypeModel("D", "Suelos rígidos.", "360 > Vs30 >= 180 m/s"),
        ProfileTypeModel("E", "Suelos blandos.", "180 > Vs30"),
        ProfileTypeModel(
            "F",
            "Suelos licuables, sensitivos, dispersos, débilmente cementados. Turbas, archillas orgánicas, arcillas de muy alta plasticidad. Grandes espesores de arcillas de rigidez media a baja",
            ""
        )
    )
}
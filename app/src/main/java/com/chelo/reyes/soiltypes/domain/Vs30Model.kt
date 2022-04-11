package com.chelo.reyes.soiltypes.domain

import java.lang.StringBuilder

private const val RANGE_SEPARATOR = " - "
data class Vs30Model(
    val siteClassification: Char,
    val minVs30Value: Int,
    val maxVs30Value: Int,
    val minActive9arcSeg: Float,
    val MaxActive9arcSeg: Float,
    val minStable9arcSeg: Float,
    val MaxStable9arcSeg: Float,
    val min30arcSeg: Float,
    val max30arcSeg: Float
){
    fun get9arcSegRange(): String = StringBuilder().append(minActive9arcSeg).append(RANGE_SEPARATOR).append(MaxActive9arcSeg).toString()
    fun geStable9arcSeg(): String = StringBuilder().append(minStable9arcSeg).append(RANGE_SEPARATOR).append(MaxStable9arcSeg).toString()
    fun get30arcSeg(): String = StringBuilder().append(min30arcSeg).append(RANGE_SEPARATOR).append(max30arcSeg).toString()
}
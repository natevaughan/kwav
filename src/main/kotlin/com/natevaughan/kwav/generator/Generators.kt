@file:JvmName("NoiseGenerator")

package com.natevaughan.kwav.generator

import com.natevaughan.kwav.core.Channels
import com.natevaughan.kwav.core.SampleRate

fun generateNoise(seconds: Int, channels: Channels, sampleRate: SampleRate): Array<Int> {
    val size =  (seconds * channels.count * sampleRate.rate)

    return (0..size).map { (Math.random() * Short.MAX_VALUE * 2 - Short.MAX_VALUE).toInt() }.toTypedArray()
}

fun generateSine(frequency: Int, seconds: Int, channels: Channels, sampleRate: SampleRate): Array<Int> {
    val size =  (seconds * channels.count * sampleRate.rate)

    return (0..size).map { (Math.sin(it.toDouble() * Math.PI / frequency) * Short.MAX_VALUE * 2 - Short.MAX_VALUE).toInt() }.toTypedArray()
}
@file:JvmName("NoiseGenerator")

package com.natevaughan.kwav.generator

import com.natevaughan.kwav.core.Channels
import com.natevaughan.kwav.core.SampleRate
import com.natevaughan.kwav.core.interleave

fun generateNoise(seconds: Int, channels: Channels, sampleRate: SampleRate): Array<Int> {
    val size =  (seconds * channels.count * sampleRate.rate)

    return (0..size).map { (Math.random() * Short.MAX_VALUE * 2 - Short.MAX_VALUE).toInt() }.toTypedArray()
}

fun generateSine(frequency: Double, seconds: Int, channels: Channels, sampleRate: SampleRate): Array<Int> {
    val size =  (seconds * sampleRate.rate)
    val samplesPerCycle = sampleRate.rate / frequency

    return interleave((0 until channels.count).map {(0..size).map { outer ->
            (Math.sin(outer * Math.PI / samplesPerCycle) *
                    Short.MAX_VALUE * 2 - Short.MAX_VALUE).toInt()
        }.toTypedArray()
    }.toTypedArray())
}

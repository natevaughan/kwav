package com.natevaughan.kwav.generator

import com.natevaughan.kwav.core.BitDepth
import com.natevaughan.kwav.core.Channels
import com.natevaughan.kwav.core.SampleRate

/**
 * Created by nate on 10/17/17
 */
class WavHeaders(val channels: Channels, val bitDepth: BitDepth, val sampleRate: SampleRate, frameCount: Long) {

    val riff = byteArrayOf(
        'R'.toByte(),
        'I'.toByte(),
        'F'.toByte(),
        'F'.toByte()
    )

    val wave = byteArrayOf(
        'W'.toByte(),
        'A'.toByte(),
        'V'.toByte(),
        'E'.toByte()
    )

    val fmt = byteArrayOf(
        'f'.toByte(),
        'm'.toByte(),
        't'.toByte(),
        ' '.toByte()
    )
}
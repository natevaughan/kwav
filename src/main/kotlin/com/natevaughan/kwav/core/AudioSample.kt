package com.natevaughan.kwav.core

import java.util.*

/**
 * Created by nate on 10/21/17
 *
 * Generic container to contain array of samples with attached bitrate
 */
data class AudioSample<T>(override val bitRate: Int, override val samples: Array<T>) : AudioChunk<T> {

    override val size: Int
        get() = samples.size

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as AudioSample<*>

        if (bitRate != other.bitRate) return false
        if (!Arrays.equals(samples, other.samples)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = bitRate
        result = 31 * result + Arrays.hashCode(samples)
        return result
    }
}
package com.natevaughan.kwav.core

/**
 * Created by nate on 10/21/17
 *
 * Generic container to contain array of samples with attached bitrate
 */
data class LongSample(override val bitRate: Int, val audioData: LongArray) : Sample<Long> {

    override val samples: List<Long>
            get() = audioData.toList()

    override val size: Int
        get() = audioData.size

}
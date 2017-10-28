package com.natevaughan.kwav.core

/**
 * Created by nate on 10/21/17
 *
 * Generic container to contain array of samples with attached bitrate
 */
data class DoubleSample(override val bitRate: Int, val audioData: DoubleArray) : Sample<Double> {

    override val samples: List<Double>
            get() = audioData.toList()

    override val size: Int
        get() = audioData.size

}
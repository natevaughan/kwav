package com.natevaughan.kwav.core

/**
 * Created by nate on 10/21/17
 *
 * Generic container to contain array of samples with attached bitrate
 */
data class BasicSample<T>(override val bitRate: Int, override val samples: List<T>) : Sample<T> {

    override val size: Int
        get() = samples.size

}
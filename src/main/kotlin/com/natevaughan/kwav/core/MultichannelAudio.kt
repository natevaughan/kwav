package com.natevaughan.kwav.core

/**
 * Created by nate on 10/21/17
 *
 * Container for audio data with channel information
 */
interface MultichannelAudio<T: Comparable<T>> {
    val sampleRate: Int
    val channels: Channels
    fun getInterleavedAudio(): Array<T>
}
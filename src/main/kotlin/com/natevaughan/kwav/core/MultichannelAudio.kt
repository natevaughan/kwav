package com.natevaughan.kwav.core

/**
 * Created by nate on 10/21/17
 *
 * Container for audio data with channel information
 */
interface MultichannelAudio<T> {
    val bitRate: Int
    val channels: Channels
    fun getInterleavedAudio(): List<T>
}
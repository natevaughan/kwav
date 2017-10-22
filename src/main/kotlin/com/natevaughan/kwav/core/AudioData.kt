package com.natevaughan.kwav.core

/**
 * Created by nate on 10/21/17
 */
interface AudioData<T> {

    val channels: Channels
    val bitRate: Int
    fun getData(channel: Channel): List<AudioChunk<T>>
    fun getDataInterleaved(): Array<T>

    fun put(key: Channel, sample: T)
    fun putAll(key: Channel, samples: List<T>)
    fun putAll(samples: List<T>)
}
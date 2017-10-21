package com.natevaughan.kwav.core

/**
 * Created by nate on 10/21/17
 */
interface AudioData<T> {

    val channels: Channels
    fun getData(channel: Channel): Array<T>
    fun getDataInterleaved(): Array<T>

    fun put(key: Channel, sample: T)
    fun putAll(key: Channel, samples: Array<T>)
    fun putAll(samples: Array<T>)
}
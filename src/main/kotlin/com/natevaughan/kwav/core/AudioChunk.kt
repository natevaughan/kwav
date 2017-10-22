package com.natevaughan.kwav.core

/**
 * Created by nate on 10/21/17
 */
interface AudioChunk<T> {
    val bitRate: Int
    val samples: Array<T>
    val size: Int
}
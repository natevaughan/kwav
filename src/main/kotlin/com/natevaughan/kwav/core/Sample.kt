package com.natevaughan.kwav.core

/**
 * Created by nate on 10/21/17
 */
interface Sample<T: Number> {
    val bitRate: Int
    val samples: List<T>
    val size: Int
}
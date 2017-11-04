package com.natevaughan.kwav.core

import com.natevaughan.kwav.exception.ChannelMismatchException

/**
 * Created by nate on 11/4/17
 */

fun interleave(arrays: Array<Array<Int>>): Array<Int> = when (arrays.size) {
    0 -> emptyArray()
    1 -> arrays[0]
    else -> {
        val size = arrays[0].size
        for (idx in 0 until arrays.size) {
            if (size != arrays[idx].size) {
                throw ChannelMismatchException("Channel sizes did not match")
            }
        }
        (0 until size).map { idx ->
            arrays.map { arr ->
                arr[idx]
            }
        }.flatMap { it }.toTypedArray()
    }
}
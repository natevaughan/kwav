package com.natevaughan.kwav.extension

/**
 * Created by nate on 10/29/17
 */

// from https://stackoverflow.com/questions/38651192/how-to-correctly-handle-byte-values-greater-than-127-in-kotlin
fun Byte.unsigned() = toInt() and 0xFF
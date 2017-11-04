package com.natevaughan.kwav.core

import com.natevaughan.kwav.exception.ChannelMismatchException
import org.junit.Assert.assertArrayEquals
import org.junit.Test

/**
 * Created by nate on 11/4/17
 */
class UtilTest {
    @Test(expected = ChannelMismatchException::class)
    fun testInterleavedThrowsExceptionWhenUnmatchedArrayLengths() {
        interleave(arrayOf(
                arrayOf(1, 2),
                arrayOf(1)
        ))
    }

    @Test
    fun testInterleaved() {
        val result = interleave(arrayOf(
                arrayOf(1, 2),
                arrayOf(3, 4)
        ))
        assertArrayEquals(result, arrayOf(1, 3, 2, 4))
    }
}
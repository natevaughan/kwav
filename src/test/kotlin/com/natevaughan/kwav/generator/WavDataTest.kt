package com.natevaughan.kwav.generator

import com.natevaughan.kwav.core.AudioChunk
import com.natevaughan.kwav.core.Channels
import org.junit.Test
import org.junit.Assert.*

/**
 * Created by nate on 10/21/17
 */
class WavDataTest {

    @Test
    fun testStuff() {
        val wavData = AudioChunk<Double>(Channels.STEREO)
        wavData.putAll(arrayOf(1.0, 2.0))
        assertNotNull(wavData)

    }
}
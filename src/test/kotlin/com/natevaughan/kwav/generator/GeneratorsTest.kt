package com.natevaughan.kwav.generator

import com.natevaughan.kwav.core.Channels
import com.natevaughan.kwav.core.SampleRate
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Created by nate on 11/4/17
 */
class GeneratorsTest {

    @Test
    fun testSineGeneratorInterleavesChannels() {
        val generated: Array<Int> = generateSine(440.0, 1, Channels.STEREO, SampleRate.KHZ_44_1)

        for (i in 0 until generated.size step 2 ) {
            assertEquals(generated[i], generated[i+1])
        }

    }
}
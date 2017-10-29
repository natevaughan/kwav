package com.natevaughan.kwav.generator

import com.natevaughan.kwav.core.*
import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Created by nate on 10/17/17
 */
class AudioSampleTest {
    @Test
    fun testMonoSample() {
        val sample = LongSample(SampleRate.KHZ_44_1.rate, longArrayOf(1, 2, 3, 4))
        assertEquals(sample.size, 4)
    }

    @Test
    fun testMultichannelSample() {
        val sampleL = LongSample(SampleRate.KHZ_44_1.rate, longArrayOf(1, 3))
        val sampleR = LongSample(SampleRate.KHZ_44_1.rate, longArrayOf(2, 4))
        val multichannel = MultichannelSample(SampleRate.KHZ_44_1.rate, Channels.STEREO)
        multichannel.set(Channel.LEFT, sampleL)
        multichannel.set(Channel.RIGHT, sampleR)
        val interleaved = multichannel.getInterleavedAudio()
        assertArrayEquals(arrayOf(1L, 2L, 3L, 4L), interleaved)
    }

    fun getRand(sampleRate: Long): Int {
        return (Math.random() * Math.pow(2.0, sampleRate.toDouble())).toInt()
    }
}

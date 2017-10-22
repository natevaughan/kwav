package com.natevaughan.kwav.generator

import com.natevaughan.kwav.core.*
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Created by nate on 10/17/17
 */
class AudioSampleTest {
    @Test
    fun testMonoSample() {
        val sample = DoubleSample(SampleRate.KHZ_44_1.rate, listOf(1.0, 2.0, 3.0, 4.0))
        assertEquals(sample.size, 4)
    }

    @Test
    fun testMultichannelSample() {
        val sampleL = DoubleSample(SampleRate.KHZ_44_1.rate, listOf(1.0, 3.0))
        val sampleR = DoubleSample(SampleRate.KHZ_44_1.rate, listOf(2.0, 4.0))
        val multichannel = MultichannelSample<Double>(SampleRate.KHZ_44_1.rate, Channels.STEREO)
        multichannel.set(Channel.LEFT, sampleL)
        multichannel.set(Channel.RIGHT, sampleR)
        val interleaved = multichannel.getInterleavedAudio()
        assertEquals(interleaved, listOf(1.0, 2.0, 3.0, 4.0))
    }

    fun getRand(sampleRate: Long): Int {
        return (Math.random() * Math.pow(2.0, sampleRate.toDouble())).toInt()
    }
}

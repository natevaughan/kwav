package com.natevaughan.kwav.generator

import com.natevaughan.kwav.core.BitDepth
import com.natevaughan.kwav.core.Channels
import com.natevaughan.kwav.core.SampleRate
import com.natevaughan.kwav.extension.unsigned
import com.natevaughan.kwav.wav.WavFile
import org.junit.Test
import java.io.File

/**
 * Created by nate on 10/22/17
 */
class WavFileTest {

    @Test
    fun writeNoise() {
        val seconds = 5
        val wav =  WavFile(File("test-output/noise.wav"), WavHeaders(Channels.STEREO, BitDepth.BIT_16, SampleRate.KHZ_44_1))

        wav.audioData = generateNoise(seconds, Channels.STEREO, SampleRate.KHZ_44_1)

        for (byt in wav.getHeaderBytes())  {
            println(byt.unsigned())
        }
        wav.create()
    }


    @Test
    fun writeSine() {
        val seconds = 5
        val wav =  WavFile(File("test-output/sine.wav"), WavHeaders(Channels.STEREO, BitDepth.BIT_16, SampleRate.KHZ_44_1))

        wav.audioData = generateSine(440, seconds, Channels.STEREO, SampleRate.KHZ_44_1)

        wav.create()
    }
}
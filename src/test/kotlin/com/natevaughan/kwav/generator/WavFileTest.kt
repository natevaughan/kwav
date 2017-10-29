package com.natevaughan.kwav.generator

import com.natevaughan.kwav.extension.unsigned
import org.junit.Test

/**
 * Created by nate on 10/22/17
 */
class WavFileTest {

    @Test
    fun readWave() {
        val byteBuffer = ByteArray(256)
        val inStream = javaClass.classLoader.getResourceAsStream("sample.wav")
        inStream.use {
            var i = 0
            while (it.read(byteBuffer) != 1 && i < 100) {
                ++i
                for (byte in byteBuffer) {
                    println(byte.unsigned())
                }
            }
        }
    }
}
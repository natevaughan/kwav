package com.natevaughan.kwav.wav

import com.natevaughan.kwav.generator.WavHeaders
import java.io.File
import java.io.FileOutputStream

class WavFile(val file: File, val wavHeaders: WavHeaders) {

    var audioData: Array<Int>? = null

    fun create() {
        FileOutputStream(file).use {
            it.write(riff + wave + fmt + "hello, world".toByteArray())
        }
    }

    companion object {
        val riff = byteArrayOf(
                'R'.toByte(),
                'I'.toByte(),
                'F'.toByte(),
                'F'.toByte()
        )

        val wave = byteArrayOf(
                'W'.toByte(),
                'A'.toByte(),
                'V'.toByte(),
                'E'.toByte()
        )

        val fmt = byteArrayOf(
                'f'.toByte(),
                'm'.toByte(),
                't'.toByte(),
                ' '.toByte()
        )
    }
}
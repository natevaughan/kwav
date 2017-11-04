package com.natevaughan.kwav.wav

import com.natevaughan.kwav.generator.WavHeaders
import java.io.File
import java.io.FileOutputStream
import java.nio.ByteBuffer
import java.nio.ByteOrder

class WavFile(val file: File, val wavHeaders: WavHeaders) {

    var audioData: Array<Int>? = null

    fun create() {
        FileOutputStream(file).use {
            it.write(getHeaderBytes())
        }
    }

    val blockSize: Short
            get() = (wavHeaders.bitDepth.bits / 8 * wavHeaders.channels.count).toShort()

    val dataRate: Int
        get() = (wavHeaders.sampleRate.rate * blockSize)

    fun getHeaderBytes(): ByteArray {
        val dataSize = audioData?.size ?: 0
        val byteSize = 44 + dataSize * 4

        val buffer = ByteBuffer.allocate(byteSize).order(ByteOrder.LITTLE_ENDIAN)
        buffer.put('R'.toByte())
        buffer.put('I'.toByte())
        buffer.put('F'.toByte())
        buffer.put('F'.toByte())

        buffer.putInt(byteSize)

        buffer.put('W'.toByte())
        buffer.put('A'.toByte())
        buffer.put('V'.toByte())
        buffer.put('E'.toByte())

        buffer.put('f'.toByte())
        buffer.put('m'.toByte())
        buffer.put('t'.toByte())
        buffer.put(' '.toByte())

        buffer.putInt(16)
        buffer.putShort(1)
        buffer.putShort(wavHeaders.channels.count)
        buffer.putInt(wavHeaders.sampleRate.rate)
        buffer.putInt(dataRate)
        buffer.putShort(blockSize)
        buffer.putShort(wavHeaders.bitDepth.bits)
        buffer.put('d'.toByte())
        buffer.put('a'.toByte())
        buffer.put('t'.toByte())
        buffer.put('a'.toByte())
        buffer.putInt(dataSize * blockSize / wavHeaders.channels.count)
        val dataSnapshot = audioData ?: emptyArray()
        for (d in dataSnapshot) {
            buffer.putShort(d.toShort())
        }

        return buffer.array()
    }
}
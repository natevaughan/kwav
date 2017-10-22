package com.natevaughan.kwav.wav

import com.natevaughan.kwav.generator.WavHeaders
import java.io.File
import java.io.FileOutputStream

class WavFile(val file: File, val wavHeaders: WavHeaders) {
    fun create() {
        var outputStream: FileOutputStream? = null
        try {
            outputStream = FileOutputStream(file)
            outputStream.write("hello, world".toByteArray())
        } finally {
            try {
                outputStream?.close()
            } catch (e: Throwable) {
            }
        }
    }
}
package com.natevaughan.kwav.core

/**
 * Created by nate on 10/21/17
 */
enum class Channels(val count: Int) {
    MONO(1),
    STEREO(2),
    SURROUND_5_1(6),
    SURROUND_7_1(8);

    fun channelArray(): Array<Channel> {
        return when (this) {
            MONO -> arrayOf(Channel.MONO)
            STEREO -> arrayOf(Channel.LEFT, Channel.RIGHT)
            SURROUND_5_1 -> arrayOf(Channel.LEFT, Channel.RIGHT, Channel.CENTER, Channel.LOW_FREQUENCY, Channel.SURROUND_LEFT, Channel.SURROUND_RIGHT)
            SURROUND_7_1 -> arrayOf(Channel.LEFT, Channel.RIGHT, Channel.CENTER, Channel.LOW_FREQUENCY, Channel.SURROUND_LEFT, Channel.SURROUND_RIGHT, Channel.REAR_LEFT, Channel.REAR_RIGHT)
        }
    }
}

enum class Channel(val order: Int) {
    MONO(0),
    LEFT(1),
    RIGHT(2),
    CENTER(3),
    LOW_FREQUENCY(4),
    SURROUND_LEFT(5),
    SURROUND_RIGHT(6),
    REAR_LEFT(7),
    REAR_RIGHT(8);
}


enum class BitDepth(val bits: Byte) {
    BIT_16(16),
    BIT_24(24);

    val byteSize: Byte get() {
        return (bits / 8).toByte()
    }

    fun byteSignature(): ByteArray {
        return byteArrayOf(bits, 0)
    }
}

enum class SampleRate(val bytes: ByteArray) {
    KHZ_44_1(byteArrayOf(88, 58, 0, 0)),
    KHZ_48_0(byteArrayOf()),
    KHZ_88_2(byteArrayOf(88, 58, 1, 0)),
    KHZ_96_0(byteArrayOf());

    fun bytes(): ByteArray {
        return bytes
    }
}
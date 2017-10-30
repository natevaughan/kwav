package com.natevaughan.kwav.core

/**
 * Created by nate on 10/21/17
 *
 * Enums around common formats of channel data
 */
enum class Channels(val count: Short) {
    MONO(1),
    STEREO(2),
    SURROUND_5_1(6),
    SURROUND_7_1(8);

    val array: Array<Channel>
    get() = when (this) {
            MONO -> arrayOf(Channel.LEFT)
            STEREO -> arrayOf(Channel.LEFT, Channel.RIGHT)
            SURROUND_5_1 -> arrayOf(Channel.LEFT, Channel.RIGHT, Channel.CENTER, Channel.LOW_FREQUENCY, Channel.SURROUND_LEFT, Channel.SURROUND_RIGHT)
            SURROUND_7_1 -> arrayOf(Channel.LEFT, Channel.RIGHT, Channel.CENTER, Channel.LOW_FREQUENCY, Channel.SURROUND_LEFT, Channel.SURROUND_RIGHT, Channel.REAR_LEFT, Channel.REAR_RIGHT)
        }
}

enum class Channel(val order: Int) {
    LEFT(1),
    RIGHT(2),
    CENTER(3),
    LOW_FREQUENCY(4),
    SURROUND_LEFT(5),
    SURROUND_RIGHT(6),
    REAR_LEFT(7),
    REAR_RIGHT(8);
}


enum class BitDepth(val bits: Short) {
    BIT_16(16),
    BIT_24(24);
}

enum class SampleRate(val rate: Int) {
    KHZ_44_1(44100),
    KHZ_48(48000),
    KHZ_88_2(88200),
    KHZ_96(96000),
    KHZ_176_4(176400),
    KHZ_192(192000);
}
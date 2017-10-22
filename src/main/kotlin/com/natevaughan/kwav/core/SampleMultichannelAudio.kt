package com.natevaughan.kwav.core


/**
 * Created by nate on 10/21/17
 *
 * Container for audio data with channel information
 */
class SampleMultichannelAudio<T>(override val bitRate: Int,
                                 override val channels: Channels): MultichannelAudio<T> {

    val channelAudioData = HashMap<Channel, ArrayList<T>>()

    override fun getInterleavedAudio(): List<T>{
        val size = channelAudioData.values.first().size
        validate(size)
        val interleaved = ArrayList<T>(size * channelAudioData.size)

        for (i in 0 until size) {
            for (channel in channels.channelArray()) {
                val list = channelAudioData.get(channel)
                if (list != null) {
                    interleaved.add(list.get(i))
                }
            }
        }
        return interleaved
    }

    fun validate(size: Int) {
        for (channel in channels.channelArray()) {
            if (!size.equals(channelAudioData.get(channel)?.size)) {
                throw RuntimeException("Channel data not of the same length. Please pad data with silence")
            }
        }
    }
}
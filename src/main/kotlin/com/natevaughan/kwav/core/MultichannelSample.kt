package com.natevaughan.kwav.core


/**
 * Created by nate on 10/21/17
 *
 * Container for audio data with channel information
 */
class MultichannelSample<T>(override val bitRate: Int,
                            override val channels: Channels): MultichannelAudio<T> {

    val channelAudioData = HashMap<Channel, Sample<T>>()


    fun set(channel: Channel, sample: Sample<T>) {
        this.channelAudioData.put(channel, sample)
    }

    override fun getInterleavedAudio(): List<T>{
        val size = channelAudioData.values.first().size
        validate(size)
        val interleaved = ArrayList<T>(size * channelAudioData.size)

        for (i in 0 until size) {
            for (channel in channels.channelArray()) {
                val sample = channelAudioData.get(channel)
                if (sample != null) {
                    interleaved.add(sample.samples.get(i))
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
package com.natevaughan.kwav.core


/**
 * Created by nate on 10/21/17
 *
 * Container for audio data with channel information
 */
class MultichannelSample(override val sampleRate: Int,
                         override val channels: Channels): MultichannelAudio<Double> {

    val audioData = HashMap<Channel, DoubleSample>()


    fun set(channel: Channel, sample: DoubleSample) {
        this.audioData.put(channel, sample)
    }

    override fun getInterleavedAudio(): Array<Double>{
        if (audioData.values.size < 1) {
            throw RuntimeException("No data to interleave")
        }

        val size = audioData.values.first().size
        validate(size)
        val interleaved = DoubleArray(size * audioData.size)
        var index = 0

        for (i in 0 until size) {
            for (channel in channels.array) {
                val sample = audioData.get(channel)
                if (sample != null) {
                    interleaved[index] = sample.samples.get(i)
                    index++
                }
            }
        }
        return interleaved.toTypedArray()
    }

    fun getNormalizedAudio(bitDepth: Int, headroom: Int): List<Int> {
        val max = getInterleavedAudio().map { Math.abs(it) }.max()

        if (max != null) {
            val maxWithHeadroom = max - headroom
            return getInterleavedAudio().map { (it * bitDepth / max).toInt() }
        }

        throw RuntimeException("No data to normalize")
    }

    fun validate(size: Int) {
        for (channel in channels.array) {
            if (!size.equals(audioData.get(channel)?.size)) {
                throw RuntimeException("Channel data not of the same length. Please pad data with silence")
            }
        }
    }
}
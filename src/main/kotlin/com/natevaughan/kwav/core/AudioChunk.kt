package com.natevaughan.kwav.core

/**
 * Created by nate on 10/21/17
 */
class AudioChunk<T>(override val channels: Channels): AudioData<T> {

    override fun getData(channel: Channel): Array<T> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getDataInterleaved(): Array<T> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private val channelData = HashMap<Channel, Array<T>>()


    override fun put(key: Channel, sample: T) {
        putAll(key, arrayOf(sample))
    }

    override fun putAll(key: Channel, samples: Array<T>) {
        val array = channelData.get(key)
        if (array == null) {
            channelData.put(key, samples)
        } else {
            channelData.put(key, array + samples)
        }
    }

    override fun putAll(samples: Array<T>) {
        validate(samples.size)
        when (channels) {
            Channels.MONO -> putAll(Channel.MONO, samples)
            else -> {
                // very naive implementation that iterates n times
                for (channel in channels.channelArray()) {
                    putAll(channel, samples.withIndex().filter { (i, value) ->
                        (i + channel.order - 1) % channels.count == 0
                    }.map { (i, value) ->
                        value
                    })
                }
            }
        }
    }

    private fun validate(size: Int) {
        if (size % (channels.count) > 0) {
            throw RuntimeException("Incorrect size.")
        }
    }
}
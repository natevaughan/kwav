package com.natevaughan.kwav.generator

import com.natevaughan.kwav.core.BitDepth
import com.natevaughan.kwav.core.Channels
import com.natevaughan.kwav.core.SampleRate

/**
 * Created by nate on 10/17/17
 */
data class WavHeaders(val channels: Channels, val bitDepth: BitDepth, val sampleRate: SampleRate)
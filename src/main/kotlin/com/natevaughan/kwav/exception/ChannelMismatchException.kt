package com.natevaughan.kwav.exception

/**
 * Created by nate on 11/4/17
 */
class ChannelMismatchException: RuntimeException {
    constructor(): super()
    constructor(message: String): super(message)
    constructor(message: String, cause: Exception): super(message, cause)

}
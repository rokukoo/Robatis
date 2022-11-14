package io.rokuko.robatis.io

import java.io.IOException
import java.io.InputStream

object Resources {

    private val classLoaderWrapper = ClassLoaderWrapper()

    fun getResourceAsStream(resource: String) = getResourceAsStream(resource, null)

    private fun getResourceAsStream(resource: String, loader: ClassLoader?) = classLoaderWrapper.getResourceAsStream(resource, loader)
        ?: throw IOException("Could not find resource $resource")


}
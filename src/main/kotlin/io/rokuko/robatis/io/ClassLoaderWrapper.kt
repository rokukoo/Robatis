package io.rokuko.robatis.io

import java.io.InputStream

class ClassLoaderWrapper{

    private var defaultClassLoader: ClassLoader? = null

    private val systemClassLoader: ClassLoader = ClassLoader.getSystemClassLoader()

    fun getResourceAsStream(resource: String, classLoader: ClassLoader?) = getResourceAsStream(resource, getClassLoaders(classLoader))

    private fun getResourceAsStream(resource: String, classLoaders: Array<ClassLoader?>): InputStream? {
        classLoaders.forEach {
            it?.let {
                // try to find the resource as passed
                // now, some class loaders want this leading "/", so we'll add it and try again if we didn't find the resource
                val returnValue = it.getResourceAsStream(resource) ?: it.getResourceAsStream("/$resource")
                if (null != returnValue) {
                    return returnValue
                }
            }
        }
        return null
    }

    private fun getClassLoaders(classLoader: ClassLoader?) = arrayOf(
        classLoader,
        defaultClassLoader,
        Thread.currentThread().contextClassLoader,
        javaClass.classLoader,
        systemClassLoader
    )

}
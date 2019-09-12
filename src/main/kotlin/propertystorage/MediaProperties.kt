package propertystorage

import propertystorage.interfaces.IMediaProperties
import java.util.*

object MediaProperties: IMediaProperties {
    private val properties = Properties()
    private val presetsStream = MediaProperties::class.java.classLoader.getResourceAsStream("media/media.properties")

    init {
        updateProperties()
    }

    private fun updateProperties() = properties.load(presetsStream)

    @Synchronized
    override fun getPathDeviceImages(): String {
        val path = getProperty(property = "path.image.devices")
        return if (!path.endsWith("\\")) path + "\\" else path
    }

    @Synchronized
    override fun getPathGoboImages(): String {
        val path = getProperty(property = "path.image.gobos")
        return if (!path.endsWith("\\")) path + "\\" else path
    }

    @Synchronized
    private fun getProperty(property: String): String = properties.getProperty(property)
}
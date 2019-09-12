package propertystorage

import propertystorage.interfaces.IDdfProperties
import propertystorage.interfaces.IMediaProperties
import java.util.*

object DdfProperties: IDdfProperties {
    private val properties = Properties()
    private val presetsStream = DdfProperties::class.java.classLoader.getResourceAsStream("ddf/ddf.properties")

    init {
        updateProperties()
    }

    private fun updateProperties() = properties.load(presetsStream)

    @Synchronized
    override fun getPathDefaultDdfFiles(): String = getProperty(property = "path.ddf.default")

    @Synchronized
    override fun getPathCustomDdfFiles(): String = getProperty(property = "path.ddf.custom")

    @Synchronized
    private fun getProperty(property: String): String = properties.getProperty(property)
}
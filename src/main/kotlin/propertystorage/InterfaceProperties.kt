package propertystorage

import propertystorage.interfaces.IInterfaceProperties
import java.util.*

object InterfaceProperties: IInterfaceProperties {
    private val properties = Properties()
    private val presetsStream = InterfaceProperties::class.java.classLoader.getResourceAsStream("interface/interface.properties")

    init {
        updateProperties()
    }

    private fun updateProperties() = properties.load(presetsStream)

    @Synchronized
    override fun getInterfaceName(): String = getProperty(property = "interface.name")

    @Synchronized
    override fun getArtnetInterface(): String = getProperty(property = "interface.artnet")

    @Synchronized
    private fun getProperty(property: String): String = properties.getProperty(property)
}
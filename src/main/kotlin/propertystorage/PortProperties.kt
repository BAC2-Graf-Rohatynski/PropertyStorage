package propertystorage

import propertystorage.interfaces.IPortProperties
import java.util.*

object PortProperties: IPortProperties {
    private val properties = Properties()
    private val presetsStream = PortProperties::class.java.classLoader.getResourceAsStream("ports/ports.properties")

    init {
        updateProperties()
    }

    private fun updateProperties() = properties.load(presetsStream)

    @Synchronized
    override fun getPipelinePort(): Int = getProperty(property = "port.pipeline").toInt()

    @Synchronized
    override fun getBackendPort(): Int = getProperty(property = "port.backend").toInt()

    @Synchronized
    override fun getLicensePort(): Int = getProperty(property = "port.license").toInt()

    @Synchronized
    override fun getErrorPort(): Int = getProperty(property = "port.error").toInt()

    @Synchronized
    override fun getNetworkPort(): Int = getProperty(property = "port.network").toInt()

    @Synchronized
    override fun getSynchPort(): Int = getProperty(property = "port.synch").toInt()

    @Synchronized
    override fun getDatabasePort(): Int = getProperty(property = "port.database").toInt()

    @Synchronized
    override fun getDisplayPort(): Int = getProperty(property = "port.display").toInt()

    @Synchronized
    override fun getUdpPort(): Int = getProperty(property = "port.udp").toInt()

    @Synchronized
    override fun getUdpSlavesPort(): Int = getProperty(property = "port.udp.slaves").toInt()

    @Synchronized
    override fun getUdpMasterPort(): Int = getProperty(property = "port.udp.master").toInt()

    @Synchronized
    override fun getCom1Port(): Int = getProperty(property = "port.com1").toInt()

    @Synchronized
    override fun getCom2Port(): Int = getProperty(property = "port.com2").toInt()

    @Synchronized
    override fun getCom3Port(): Int = getProperty(property = "port.com3").toInt()

    @Synchronized
    override fun getCom4Port(): Int = getProperty(property = "port.com4").toInt()

    @Synchronized
    override fun getArtnetPort(): Int = getProperty(property = "port.artnet").toInt()

    @Synchronized
    private fun getProperty(property: String): String = properties.getProperty(property)
}
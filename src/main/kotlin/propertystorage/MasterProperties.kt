package propertystorage

import propertystorage.interfaces.IMasterProperties
import java.util.*

object MasterProperties: IMasterProperties {
    private val properties = Properties()
    private val presetsStream = MasterProperties::class.java.classLoader.getResourceAsStream("master/master.properties")

    init {
        updateProperties()
    }

    private fun updateProperties() = properties.load(presetsStream)

    @Synchronized
    override fun getIdentification(): String = getProperty(property = "master.identification")

    @Synchronized
    override fun getSerial(): String = getProperty(property = "master.serial")

    @Synchronized
    private fun getProperty(property: String): String = properties.getProperty(property)
}
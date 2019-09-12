package propertystorage

import propertystorage.interfaces.ILicenseProperties
import java.util.*

object LicenseProperties: ILicenseProperties {
    private val properties = Properties()
    private val presetsStream = LicenseProperties::class.java.classLoader.getResourceAsStream("license/license.properties")

    init {
        updateProperties()
    }

    private fun updateProperties() = properties.load(presetsStream)

    @Synchronized
    override fun getDefault(): String = getProperty(property = "license.default")

    @Synchronized
    override fun getBasic(): String = getProperty(property = "license.basic")

    @Synchronized
    override fun getAdvanced(): String = getProperty(property = "license.advanced")

    @Synchronized
    override fun getExtended(): String = getProperty(property = "license.extended")

    @Synchronized
    override fun getFull(): String = getProperty(property = "license.full")

    @Synchronized
    private fun getProperty(property: String): String = properties.getProperty(property)
}
package propertystorage

import propertystorage.interfaces.IUpdateProperties
import java.util.*

object UpdateProperties: IUpdateProperties {
    private val properties = Properties()
    private val presetsStream = UpdateProperties::class.java.classLoader.getResourceAsStream("update/update.properties")

    init {
        updateProperties()
    }

    private fun updateProperties() = properties.load(presetsStream)
    private fun getProperty(property: String): String = properties.getProperty(property)
    private fun setProperty(property: String, value: String) = properties.setProperty(property, value)
    private fun isWindows(): Boolean = System.getProperty("os.name").startsWith("Windows")

    @Synchronized
    override fun getAutoUpdateOnlineEnabled(): Boolean = getProperty(property = "update.auto.online.enabled").toBoolean()

    @Synchronized
    override fun setAutoUpdateOnlineEnabled(enabled: Boolean): Any = setProperty(property = "update.auto.online.enabled", value = enabled.toString())

    @Synchronized
    override fun getAutoUpdateOfflineEnabled(): Boolean = getProperty(property = "update.auto.offline.enabled").toBoolean()

    @Synchronized
    override fun setAutoUpdateOfflineEnabled(enabled: Boolean): Any = setProperty(property = "update.auto.offline.enabled", value = enabled.toString())

    @Synchronized
    override fun getOfflinePackageName(): String = getProperty(property = "update.offline.package.name")

    @Synchronized
    override fun getSlaveUpdateFilePath(): String {
        val path = getProperty(property = "update.slave.package.path")
        return if (!path.endsWith("\\")) path + "\\" else path
    }

    @Synchronized
    override fun getSlaveUpdatePropertyPath(): String = getProperty(property = "update.slave.property.path")

    @Synchronized
    override fun getSlaveUpdateFileName(): String = getProperty(property = "update.slave.package.name")

    @Synchronized
    override fun getOfflinePackagePath(): String {
        val packageName = getProperty(property = "update.offline.package.name")
        val path = if (isWindows()) getProperty(property = "update.offline.package.path.windows") else getProperty(property ="update.offline.package.path.linux")
        return "$path\\$packageName"
    }
}
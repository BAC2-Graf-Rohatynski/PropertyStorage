package propertystorage

import propertystorage.interfaces.IShowProperties
import java.util.*

object ShowProperties: IShowProperties {
    private val properties = Properties()
    private val presetsStream = ShowProperties::class.java.classLoader.getResourceAsStream("show/show.properties")

    init {
        updateProperties()
    }

    private fun updateProperties() = properties.load(presetsStream)

    @Synchronized
    override fun getActiveShow(): String = getProperty(property = "show.active")

    @Synchronized
    override fun setActiveShow(show: String): Any = setProperty(property = "show.active", value = show)

    @Synchronized
    private fun getProperty(property: String): String = properties.getProperty(property)

    @Synchronized
    private fun setProperty(property: String, value: String): Any = properties.setProperty(property, value)
}
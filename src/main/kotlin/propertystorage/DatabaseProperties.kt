package propertystorage

import propertystorage.interfaces.IDatabaseProperties
import java.util.*

object DatabaseProperties: IDatabaseProperties {
    private val properties = Properties()
    private val presetsStream = DatabaseProperties::class.java.classLoader.getResourceAsStream("database/database.properties")

    init {
        updateProperties()
    }

    private fun updateProperties() = properties.load(presetsStream)

    @Synchronized
    override fun getDefaultDdfDatabaseName(): String = getProperty(property = "database.default")

    @Synchronized
    override fun getUsername(): String = getProperty(property = "database.username")

    @Synchronized
    override fun getPassword(): String = getProperty(property = "database.password")

    @Synchronized
    override fun getUrl(): String = getProperty(property = "database.url")

    @Synchronized
    private fun getProperty(property: String): String = properties.getProperty(property)
}
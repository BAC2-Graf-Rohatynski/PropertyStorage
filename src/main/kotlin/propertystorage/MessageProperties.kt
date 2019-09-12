package propertystorage

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import propertystorage.interfaces.IMessageProperties
import java.lang.Exception
import java.util.*

object MessageProperties: IMessageProperties {
    private val properties = Properties()
    private val presetsStream = MessageProperties::class.java.classLoader.getResourceAsStream("messages/messages.properties")
    private val logger: Logger = LoggerFactory.getLogger(MessageProperties::class.java)

    init {
        updateProperties()
    }

    private fun updateProperties() = properties.load(presetsStream)

    @Synchronized
    override fun getMessage(code: Int, language: String): String = getProperty(property = "$code.$language")

    @Synchronized
    override fun getLevel(code: Int): String = getProperty(property = "$code.level")

    @Synchronized
    private fun getProperty(property: String): String = properties.getProperty(property)
}
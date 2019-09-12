package propertystorage

import propertystorage.interfaces.IWatchdogProperties
import java.util.*

object WatchdogProperties: IWatchdogProperties {
    private val properties = Properties()
    private val presetsStream = WatchdogProperties::class.java.classLoader.getResourceAsStream("watchdog/watchdog.properties")

    init {
        updateProperties()
    }

    private fun updateProperties() = properties.load(presetsStream)

    @Synchronized
    override fun getAliveWatchdogTimeout(): Long = getWatchdogProperty(property = "watchdog.alive.timeout").toLong()

    @Synchronized
    override fun getConnectWatchdogTimeout(): Long = getWatchdogProperty(property = "watchdog.connect.timeout").toLong()

    @Synchronized
    override fun getWatchdogThreshold(): Long = getWatchdogProperty(property = "watchdog.threshold").toLong()

    @Synchronized
    override fun getWatchdogTimeout(): Long = getWatchdogProperty(property = "watchdog.timeout").toLong()

    @Synchronized
    override fun getMessageWatchdogTimeout(): Long = getWatchdogProperty(property = "watchdog.message.timeout").toLong()

    @Synchronized
    override fun getAliveWatchdogThreshold(): Long = getWatchdogProperty(property = "watchdog.alive.threshold").toLong()

    @Synchronized
    override fun getRotationInterval(): Long = getWatchdogProperty(property = "rotation.interval").toLong()

    @Synchronized
    override fun getSsidHandlerTimeout(): Long = getWatchdogProperty(property = "ssid.handler.timeout").toLong()

    @Synchronized
    override fun getLicenseRequestTimeout(): Long = getWatchdogProperty(property = "license.request.timeout").toLong()

    @Synchronized
    override fun getGreetingPeriod(): Long = getWatchdogProperty(property = "greeting.period").toLong()

    @Synchronized
    private fun getWatchdogProperty(property: String): String = properties.getProperty(property)
}
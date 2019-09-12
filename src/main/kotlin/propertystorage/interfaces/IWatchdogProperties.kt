package propertystorage.interfaces

interface IWatchdogProperties {
    fun getAliveWatchdogTimeout(): Long
    fun getAliveWatchdogThreshold(): Long
    fun getConnectWatchdogTimeout(): Long
    fun getMessageWatchdogTimeout(): Long
    fun getWatchdogThreshold(): Long
    fun getWatchdogTimeout(): Long
    fun getRotationInterval(): Long
    fun getSsidHandlerTimeout(): Long
    fun getLicenseRequestTimeout(): Long
    fun getGreetingPeriod(): Long
}
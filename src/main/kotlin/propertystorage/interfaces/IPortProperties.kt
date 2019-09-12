package propertystorage.interfaces

interface IPortProperties {
    fun getPipelinePort(): Int
    fun getBackendPort(): Int
    fun getLicensePort(): Int
    fun getErrorPort(): Int
    fun getNetworkPort(): Int
    fun getSynchPort(): Int
    fun getDatabasePort(): Int
    fun getDisplayPort(): Int
    fun getUdpPort(): Int
    fun getUdpSlavesPort(): Int
    fun getUdpMasterPort(): Int
    fun getCom1Port(): Int
    fun getCom2Port(): Int
    fun getCom3Port(): Int
    fun getCom4Port(): Int
    fun getArtnetPort(): Int
}
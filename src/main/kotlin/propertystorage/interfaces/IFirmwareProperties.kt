package propertystorage.interfaces

interface IFirmwareProperties {
    fun getFirmwarePath(): String
    fun getNetworkFolder(): String
    fun getLicenseFolder(): String
    fun getPortFolder(): String
    fun getDatabaseManagerFolder(): String
    fun getDatabaseClientFolder(): String
    fun getNotificationFolder(): String
    fun getErrorHandlerFolder(): String
    fun getSynchFolder(): String
    fun getEncryptionFolder(): String
    fun getNetworkFileName(): String
    fun getLicenseFileName(): String
    fun getPortFileName(): String
    fun getDatabaseManagerFileName(): String
    fun getDatabaseClientFileName(): String
    fun getNotificationFileName(): String
    fun getErrorHandlerFileName(): String
    fun getSynchFileName(): String
    fun getEncryptionFileName(): String
}
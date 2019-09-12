package propertystorage.interfaces

interface IUpdateProperties {
    fun getOfflinePackageName(): String
    fun getOfflinePackagePath(): String
    fun getAutoUpdateOnlineEnabled(): Boolean
    fun setAutoUpdateOnlineEnabled(enabled: Boolean): Any
    fun getAutoUpdateOfflineEnabled(): Boolean
    fun setAutoUpdateOfflineEnabled(enabled: Boolean): Any
    fun getSlaveUpdateFilePath(): String
    fun getSlaveUpdateFileName(): String
    fun getSlaveUpdatePropertyPath(): String
}
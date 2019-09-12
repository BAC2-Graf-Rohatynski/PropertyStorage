package propertystorage.interfaces

interface ILicenseProperties {
    fun getDefault(): String
    fun getBasic(): String
    fun getAdvanced(): String
    fun getExtended(): String
    fun getFull(): String
}
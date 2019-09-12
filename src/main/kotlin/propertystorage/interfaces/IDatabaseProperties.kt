package propertystorage.interfaces

interface IDatabaseProperties {
    fun getDefaultDdfDatabaseName(): String
    fun getUsername(): String
    fun getPassword(): String
    fun getUrl(): String
}
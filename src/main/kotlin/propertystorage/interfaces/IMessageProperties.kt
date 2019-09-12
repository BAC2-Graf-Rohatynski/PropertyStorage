package propertystorage.interfaces

interface IMessageProperties {
    fun getMessage(code: Int, language: String): String
    fun getLevel(code: Int): String
}
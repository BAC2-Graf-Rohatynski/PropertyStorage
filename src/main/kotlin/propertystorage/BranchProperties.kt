package propertystorage

import propertystorage.interfaces.IBranchProperties
import java.util.*

object BranchProperties: IBranchProperties {
    private val properties = Properties()
    private val presetsStream = BranchProperties::class.java.classLoader.getResourceAsStream("update/branch.properties")

    init {
        updateProperties()
    }

    private fun updateProperties() = properties.load(presetsStream)

    @Synchronized
    override fun getBranchName(): String = getProperty(property = "branch.name")

    @Synchronized
    private fun getProperty(property: String): String = properties.getProperty(property)
}
package propertystorage

import enumstorage.update.ApplicationName
import org.json.JSONObject

object PropertyStorageRunner {
    fun getUpdateInformation(): JSONObject = UpdateInformation.getAsJson(applicationName = ApplicationName.Property.name)
}
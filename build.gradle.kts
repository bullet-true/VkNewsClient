// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.kotlin.android) apply false
    id("vkid.manifest.placeholders") version "1.1.0" apply true
}

vkidManifestPlaceholders {
    // Вариант 1: если вы хотите хранить clientId/clientSecret в gradle.properties
    init(
        clientId = project.findProperty("VK_CLIENT_ID") as? String ?: "",
        clientSecret = project.findProperty("VK_CLIENT_SECRET") as? String ?: ""
    )
}
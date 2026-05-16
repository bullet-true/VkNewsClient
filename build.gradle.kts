import java.util.Properties

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.kotlin.android) apply false
    id("vkid.manifest.placeholders") version "1.1.0" apply true
}

val localProperties = Properties().apply {
    load(rootProject.file("local.properties").inputStream())
}

vkidManifestPlaceholders {
    init(
        clientId = localProperties.getProperty("VK_CLIENT_ID"),
        clientSecret = localProperties.getProperty("VK_CLIENT_SECRET")
    )
}
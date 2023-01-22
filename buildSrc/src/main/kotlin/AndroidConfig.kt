object AndroidConfig {
    const val compileSdk = 33
    const val minSdk = 28
    const val targetSdk = 33
    const val buildTools = "33.0.1"

    const val versionCode = 1
    const val versionName = "0.0.1"

    const val applicationId = "ru.sotnikov.marsbycuriosity"

    const val useSupportLibrary = true
}

interface BuildType {

    companion object {
        const val RELEASE = "release"
        const val DEBUG = "debug"
    }

    val isMinifyEnabled: Boolean
    val isDebuggable: Boolean
}

object BuildTypeDebug : BuildType {
    override val isMinifyEnabled = false
    override val isDebuggable = true
}

object BuildTypeRelease : BuildType {
    override val isMinifyEnabled = true
    override val isDebuggable = false
}

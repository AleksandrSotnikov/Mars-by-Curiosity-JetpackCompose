import org.gradle.api.initialization.resolve.RepositoriesMode.FAIL_ON_PROJECT_REPOS

include(":feature:marsbycuriosity_impl")


include(":feature:marsbycuriosity_api")


include(":ui:settings")


include(":navigation")


dependencyResolutionManagement {
    repositoriesMode.set(FAIL_ON_PROJECT_REPOS)

    repositories {
        google()
        gradlePluginPortal()
        jcenter()
        mavenCentral()
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
    }
}

rootProject.buildFileName = "build.gradle.kts"

rootProject.name = "Mars-by-Curiosity"

// App module
include(":app")

// Core modules
include(":core:ui")

// Navigation
include(":navigation")

// UI
include(
    ":ui:home",
    ":ui:settings"
)

// Features
include(
    ":feature:marsbycuriosity_api",
    ":feature:marsbycuriosity_impl"
)

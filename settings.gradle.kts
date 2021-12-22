import org.gradle.api.initialization.resolve.RepositoriesMode.FAIL_ON_PROJECT_REPOS

dependencyResolutionManagement {
    repositoriesMode.set(FAIL_ON_PROJECT_REPOS)

    repositories {
        google()
        mavenCentral()
        jcenter() // Warning: this repository is going to shut down soon
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
    ":ui:home"
)

// Features
include(
    ":feature:marsbycuriosity_api",
    ":feature:marsbycuriosity_impl"
)

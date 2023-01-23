plugins {
    id(Plugin.androidLibrary)
    kotlin(Plugin.android)
}

android {
    namespace = "ru.sotnikov.settings"
    compileSdk = AndroidConfig.compileSdk

    defaultConfig {
        minSdk = AndroidConfig.minSdk
        targetSdk = AndroidConfig.targetSdk
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    buildFeatures {
        compose = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.0"
    }
}

dependencies {
    implementation(project(ModuleDependency.Core.ui))
    implementation(project(ModuleDependency.navigation))
    implementation(project(ModuleDependency.Feature.marsByCuriosity_api))
    implementation(Dependency.Orbit.viewModel)
    implementation(Dependency.AndroidX.paging)
    implementation(Dependency.Koin.android)
    implementation(Dependency.Accompanist.flowlayout)
    implementation(Dependency.Koin.compose)
    implementation(Dependency.Other.toolbar)
    implementation(Dependency.Loggers.prettyLogger)
    implementation(Dependency.Accompanist.insets)
    implementation(Dependency.Navigation.compose)
}

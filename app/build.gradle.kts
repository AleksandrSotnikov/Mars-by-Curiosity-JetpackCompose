plugins {
    id(Plugin.androidApplication)
    kotlin(Plugin.android)
}

android {
    compileSdk = AndroidConfig.compileSdk

    defaultConfig {
        applicationId = AndroidConfig.applicationId
        minSdk = AndroidConfig.minSdk
        targetSdk = AndroidConfig.targetSdk
        versionCode = AndroidConfig.versionCode
        versionName = AndroidConfig.versionName

        vectorDrawables {
            @Incubating
            useSupportLibrary = AndroidConfig.useSupportLibrary
        }
    }

    buildTypes {
        release {
            @Incubating
            isMinifyEnabled = BuildTypeRelease.isMinifyEnabled
            proguardFiles("proguard-android-optimize.txt", "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    buildFeatures {
        @Incubating
        compose = true
    }

    composeOptions {
        @Incubating
        kotlinCompilerExtensionVersion = "1.4.0"
    }

    packagingOptions {
        resources {
            @Incubating
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
            @Incubating
            excludes += "kotlin/internal/internal.kotlin_builtins"
        }
    }
    namespace = "ru.sotnikov.marsbycuriosity"
}

dependencies {
    implementation(project(ModuleDependency.Core.ui))
    implementation(project(ModuleDependency.UI.home))
    implementation(project(ModuleDependency.Feature.marsByCuriosity_api))
    implementation(project(ModuleDependency.Feature.marsByCuriosity_impl))
    implementation(project(ModuleDependency.UI.settings))
    implementation(project(ModuleDependency.UI.selecter))

    implementation(Dependency.AndroidX.core)
    implementation(Dependency.AndroidX.appcompat)
    implementation(Dependency.AndroidX.material)
    implementation(Dependency.AndroidX.activityCompose)

    implementation(Dependency.AndroidX.Compose.ui)
    implementation(Dependency.AndroidX.Compose.tooling)
    implementation(Dependency.AndroidX.Compose.material)

    implementation(Dependency.Loggers.prettyLogger)
    implementation(Dependency.Loggers.timber)

    implementation(Dependency.Koin.android)

    implementation(Dependency.Loggers.prettyLogger)
    implementation(Dependency.Loggers.timber)
    implementation("androidx.core:core-ktx:+")
}

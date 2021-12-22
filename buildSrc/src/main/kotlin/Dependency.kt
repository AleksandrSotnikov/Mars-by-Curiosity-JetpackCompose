object Dependency {
    object Kotlin {
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Version.kotlin}"
        const val extensions = "org.jetbrains.kotlin:kotlin-android-extensions:${Version.kotlin}"

        object Coroutines {
            private const val version = "1.5.2"

            const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
            const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
        }
    }

    object AndroidX {
        const val activityCompose = "androidx.activity:activity-compose:1.4.0"
        const val core = "androidx.core:core-ktx:1.7.0"
        const val appcompat = "androidx.appcompat:appcompat:1.3.1"
        const val paging = "androidx.paging:paging-compose:1.0.0-alpha14"
        const val material = "com.google.android.material:material:1.4.0"

        object Compose {
            const val ui = "androidx.compose.ui:ui:${Version.compose}"
            const val material = "androidx.compose.material:material:${Version.compose}"
            const val toolingPreview = "androidx.compose.ui:ui-tooling-preview:${Version.compose}"
            const val tooling = "androidx.compose.ui:ui-tooling:${Version.compose}"
            const val foundation = "androidx.compose.foundation:foundation:${Version.compose}"
            const val runtime = "androidx.compose.runtime:runtime:${Version.compose}"
        }
    }

    object Loggers {
        const val timber = "com.jakewharton.timber:timber:5.0.1"
        const val prettyLogger = "com.orhanobut:logger:2.2.0"
        const val okhttpLogging = "com.squareup.okhttp3:logging-interceptor:4.9.2"
    }

    object Squareup {
        const val retrofit = "com.squareup.retrofit2:retrofit:2.9.0"
        const val okhttp = "com.squareup.okhttp3:okhttp:4.9.2"
    }

    object Orbit {
        private const val version = "4.3.0"

        const val core = "org.orbit-mvi:orbit-core:$version"
        const val viewModel = "org.orbit-mvi:orbit-viewmodel:$version"
        const val test = "org.orbit-mvi:orbit-test:$version"
    }

    object Other {
        const val coil = "io.coil-kt:coil-compose:1.4.0"
        const val insetter = "dev.chrisbanes.insetter:insetter:0.6.1"
        const val toolbar = "me.onebone:toolbar-compose:2.3.0"
        const val kotlinSerialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.1"
        const val kotlinSerializeConverter = "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.8.0"
    }

    object Accompanist {
        private const val version = "0.21.3-beta"

        const val flowlayout = "com.google.accompanist:accompanist-flowlayout:$version"
        const val insets = "com.google.accompanist:accompanist-insets:$version"
        const val navigationAnimation = "com.google.accompanist:accompanist-navigation-animation:$version"
    }

    object Koin {
        private const val version = "3.1.3"
        const val android = "io.insert-koin:koin-android:$version"
        const val compose = "io.insert-koin:koin-androidx-compose:$version"
        const val core = "io.insert-koin:koin-core:$version"
    }

    object Navigation {
        private const val version = "2.3.5"
        const val fragment = "androidx.navigation:navigation-fragment-ktx:$version"
        const val ui = "androidx.navigation:navigation-ui-ktx:$version"
        const val compose = "androidx.navigation:navigation-compose:2.4.0-beta02"
    }
}


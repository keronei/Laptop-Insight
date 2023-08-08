object Versions {
    //Kotlin
    const val kotlin = "1.8.10"
    const val coreKtx = "1.9.0"

    //Ui
    const val legacy = "1.0.0"
    const val appCompat = "1.3.1"
    const val constraintLayout = "2.1.0"
    const val material = "1.4.0"
    const val fragment = "1.3.1"

    //AndroidX
    const val navigation = "2.5.3"
    const val lifecycle = "2.4.0-alpha03"

    //Coroutines
    const val coroutines = "1.7.3"

    // Current version
    const val koin_version = "3.1.5"

    //Timber
    const val timber = "5.0.1"

    //Firebase
    const val firebaseBom = "28.4.0"

    //Room
    const val room = "2.4.3"

    //Coil
    const val coil = "2.4.0"

    //Ktor
    const val ktorClient = "1.6.7"
    const val logBack = "1.2.10"

    // Compose
    const val kotlinComposeCompile = "1.4.4"
    const val kotlinComposeBom = "2023.06.01"
    const val composeViewModel = "2.6.1"

    // Accompanist
    const val accompanist = "0.31.6-rc"

    // BottomBar
    const val bottomBarNav = "1.0.0"

    //Testing
    const val junit = "4.5"
    const val textExtJunit = "1.1.3"
    const val espresso = "3.4.0"
    const val mockito = "4.0.0"
    const val robolectric = "4.6"
}

object BuildPlugins {
    const val kotlinAndroid = "org.jetbrains.kotlin.android"
    const val navigationSafeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}"
}

object AndroidSdk {
    const val minSdkVersion = 24
    const val buildToolsVersion = "30.0.3"
    const val compileSdkVersion = 34
    const val targetSdkVersion = compileSdkVersion
    const val versionCode = 4
    const val versionName = "2.0"
}

object BuildModules {
    const val domainModule = ":domain"
    const val localModule = ":content:local"
    const val remoteModule = ":content:remote"
    const val repositoryModule = ":content:repository"
    const val safeArgs = "androidx.navigation.safeargs.kotlin"
    const val parcelize = "kotlin-parcelize"

}

object Libraries {
    const val kotlinStandardLibrary = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    const val ktxCore = "androidx.core:core-ktx:${Versions.coreKtx}"

    //UI
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val materialComponents = "com.google.android.material:material:${Versions.material}"
    const val legacySupport = "androidx.legacy:legacy-support-v4:${Versions.legacy}"
    const val fragment = "androidx.fragment:fragment-ktx:${Versions.fragment}"

    //Navigation Component
    const val navigationFragmentKtx =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"

    //Coroutines
    const val coroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val coroutinesPlayServices =
        "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:${Versions.coroutines}"

    //ViewModel, LiveData
    const val liveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val kaptLifecycle = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle}"
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"

    //Koin
    const val koinCore = "io.insert-koin:koin-core:${Versions.koin_version}"
    const val koinAndroid = "io.insert-koin:koin-android:${Versions.koin_version}"
    const val koinTestFeatures = "io.insert-koin:koin-test:${Versions.koin_version}"
    const val koinScope = "io.insert-koin:koin-androidx-scope:${Versions.koin_version}"
    const val koinViewModel = "io.insert-koin:koin-androidx-viewmodel:${Versions.koin_version}"

    //Timber
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    //Firebase
    const val firebaseBom = "com.google.firebase:firebase-bom:${Versions.firebaseBom}"
    const val firebaseAnalyticsKtx = "com.google.firebase:firebase-analytics-ktx"
    const val firebaseFirestoreKtx = "com.google.firebase:firebase-firestore-ktx"

    //Room
    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
    const val roomKapt = "androidx.room:room-compiler:${Versions.room}"

    //Ktor
    const val ktorCoreClient = "io.ktor:ktor-client-core:${Versions.ktorClient}"
    const val ktorClientCIO = "io.ktor:ktor-client-cio:${Versions.ktorClient}"
    const val ktorLoggingClient = "io.ktor:ktor-client-logging:${Versions.ktorClient}"
    const val ktorLogBack = "ch.qos.logback:logback-classic:${Versions.logBack}"

    // Compose
    const val composeBom = "androidx.compose:compose-bom:${Versions.kotlinComposeBom}"
    const val composeMaterial3 = "androidx.compose.material3:material3"
    const val composeFoundation = "androidx.compose.foundation:foundation"
    const val composeUi = "androidx.compose.ui:ui"
    const val toolingPreview = "androidx.compose.ui:ui-tooling-preview"
    const val uiTooling = "androidx.compose.ui:ui-tooling"
    const val materialExtendedIcons = "androidx.compose.material:material-icons-extended"
    const val composeViewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.composeViewModel}"
    const val composeActivity = "androidx.activity:activity-compose"

    // Coil
    const val coil = "io.coil-kt:coil-compose:${Versions.coil}"

    // Accompanist
    const val webView = "com.google.accompanist:accompanist-webview:${Versions.accompanist}"

    // Bottom Bar Nav
    const val bottomBarNav = "com.exyte:animated-navigation-bar:${Versions.bottomBarNav}"
}

object TestLibraries {
    const val jUnit = "junit:junit:${Versions.junit}"
    const val testExtjunit = "androidx.test.ext:junit:${Versions.textExtJunit}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val mockito = "org.mockito.kotlin:mockito-kotlin:${Versions.mockito}"
    const val robolectric = "org.robolectric:robolectric:${Versions.robolectric}"
}
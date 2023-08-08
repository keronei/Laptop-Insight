plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id(BuildModules.safeArgs)
}

android {
    compileSdk = AndroidSdk.compileSdkVersion

    defaultConfig {
        applicationId = "com.keronei.android.laptopReview"
        minSdk = AndroidSdk.minSdkVersion
        targetSdk = AndroidSdk.targetSdkVersion
        versionCode = AndroidSdk.versionCode
        versionName = AndroidSdk.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        getByName("debug") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
        viewBinding = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.kotlinComposeCompile
    }
    namespace = "com.keronei.android.laptopReview"
}

dependencies {

    //Data module
    implementation(project(BuildModules.domainModule))
    implementation(project(BuildModules.localModule))
    implementation(project(BuildModules.remoteModule))
    implementation(project(BuildModules.repositoryModule))

    //System dependencies
    implementation(Libraries.ktxCore)
    implementation(Libraries.appCompat)
    implementation(Libraries.materialComponents)
    implementation(Libraries.constraintLayout)
    implementation(Libraries.liveDataKtx)
    implementation(Libraries.viewModelKtx)
    implementation(Libraries.navigationFragmentKtx)
    implementation(Libraries.navigationUiKtx)
    implementation(Libraries.fragment)

    //Android
    implementation(Libraries.liveDataKtx)
    implementation(Libraries.viewModelKtx)

    //Koin
    implementation(Libraries.koinCore)
    implementation(Libraries.koinAndroid)
    //implementation(Libraries.koinScope)
    //implementation(Libraries.koinViewModel)

    //kTor
    implementation(Libraries.ktorCoreClient)
    implementation(Libraries.ktorClientCIO)
    implementation(Libraries.ktorLoggingClient)
    implementation(Libraries.ktorLogBack)

    //Timber
    implementation(Libraries.timber)

    //Room
    implementation(Libraries.roomRuntime)
    implementation(Libraries.roomKtx)
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    kapt(Libraries.roomKapt)

    // Compose
    val composeBom = platform(Libraries.composeBom)
    implementation(composeBom)
    androidTestImplementation(composeBom)
    implementation(Libraries.composeActivity)

    implementation(Libraries.composeMaterial3)
    implementation(Libraries.composeUi)
    debugImplementation(Libraries.uiTooling)
    implementation(Libraries.composeFoundation)
    implementation(Libraries.toolingPreview)

    implementation(Libraries.composeViewModel)

    implementation(Libraries.materialExtendedIcons)

    // Coil
    implementation(Libraries.coil)

    // Accompanist
    implementation(Libraries.webView)

    // Bottom Navigation
    implementation(Libraries.bottomBarNav)

    //Testing
    testImplementation(TestLibraries.jUnit)
    androidTestImplementation(TestLibraries.testExtjunit)
    androidTestImplementation(TestLibraries.espressoCore)
    androidTestImplementation(TestLibraries.robolectric)
}
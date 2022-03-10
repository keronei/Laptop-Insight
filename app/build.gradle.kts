plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
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
    kapt(Libraries.roomKapt)


    //Testing
    testImplementation(TestLibraries.jUnit)
    androidTestImplementation(TestLibraries.testExtjunit)
    androidTestImplementation(TestLibraries.espressoCore)
    androidTestImplementation(TestLibraries.robolectric)
}
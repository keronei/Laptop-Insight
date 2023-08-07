plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    compileSdk = AndroidSdk.compileSdkVersion

    defaultConfig {
        minSdk = AndroidSdk.minSdkVersion
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        //consumerProguardFiles "consumer-rules.pro"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    namespace = "com.keronei.android.repository"
}

dependencies {

    implementation(project(BuildModules.domainModule))
    implementation(project(BuildModules.localModule))
    implementation(project(BuildModules.remoteModule))

    //Room
    implementation(Libraries.roomRuntime)
    implementation(Libraries.roomKtx)
    kapt(Libraries.roomKapt)

    implementation(Libraries.ktxCore)
    implementation(Libraries.appCompat)
    implementation(Libraries.materialComponents)

    //Timber log
    implementation(Libraries.timber)

    //Test libs
    testImplementation(TestLibraries.jUnit)
    androidTestImplementation(TestLibraries.testExtjunit)
    androidTestImplementation(TestLibraries.espressoCore)
}
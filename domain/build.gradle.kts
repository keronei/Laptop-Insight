plugins {
    id ("com.android.library")
    id ("kotlin-android")
    id(BuildModules.parcelize)
}

android {
    compileSdk = AndroidSdk.compileSdkVersion

    defaultConfig {
        minSdk = AndroidSdk.minSdkVersion
        targetSdk = AndroidSdk.targetSdkVersion

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        //consumerProguardFiles "consumer-rules.pro"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles (getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    namespace = "com.keronei.android.domain"
}

dependencies {

    api (Libraries.ktxCore)
    api (Libraries.coroutinesCore)
    implementation (Libraries.appCompat)
    implementation (Libraries.materialComponents)
    implementation(Libraries.coroutinesAndroid)


    testImplementation (TestLibraries.jUnit)
    androidTestImplementation (TestLibraries.testExtjunit)
    androidTestImplementation (TestLibraries.espressoCore)
}
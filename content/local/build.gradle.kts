plugins {
    id ("com.android.library")
    id ("kotlin-android")
    id("kotlin-kapt")
}

android {
    compileSdk  = AndroidSdk.compileSdkVersion

    defaultConfig {
        minSdk = AndroidSdk.minSdkVersion
        targetSdk = AndroidSdk.targetSdkVersion

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        //consumerProguardFiles "consumer-rules.pro"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles (getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }

        getByName("debug"){
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
}

dependencies {

    //Modules
    implementation(project(BuildModules.domainModule))

    implementation (Libraries.ktxCore)
    implementation (Libraries.appCompat)
    implementation (Libraries.materialComponents)

    //Room
    implementation(Libraries.roomRuntime)
    implementation(Libraries.roomKtx)
    kapt(Libraries.roomKapt)

    //Koin
    implementation(Libraries.koinCore)
    implementation(Libraries.koinAndroid)

    testImplementation (TestLibraries.jUnit)
    androidTestImplementation (TestLibraries.testExtjunit)
    androidTestImplementation (TestLibraries.espressoCore)
}
plugins {
    id ("com.android.library")
    id ("kotlin-android")
}

android {
    compileSdk = AndroidSdk.compileSdkVersion

    defaultConfig {
        minSdk = AndroidSdk.minSdkVersion
        targetSdk = AndroidSdk.targetSdkVersion

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        //consumerProguardFiles  "consumer-rules.pro"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }

        getByName("debug"){
            isMinifyEnabled = false
        }

    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    packagingOptions {
        resources.excludes.add("META-INF/*.kotlin_module")
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

//    testOptions {
//        unitTests.isReturnDefaultValues = true
//    }
}

dependencies {

    //Modules
    implementation(project(BuildModules.domainModule))

    implementation (Libraries.ktxCore)
    implementation (Libraries.appCompat)
    implementation (Libraries.materialComponents)

    //kTor
    implementation(Libraries.ktorCoreClient)
    implementation(Libraries.ktorClientCIO)
    implementation(Libraries.ktorLoggingClient)
    implementation(Libraries.ktorLogBack)

    //Logging - Timber
    implementation(Libraries.timber)


    //Koin
    implementation(Libraries.koinCore)
    implementation(Libraries.koinAndroid)

    testImplementation (TestLibraries.jUnit)
    androidTestImplementation (TestLibraries.testExtjunit)
    androidTestImplementation (TestLibraries.espressoCore)
    testImplementation(TestLibraries.mockito)
    testImplementation(TestLibraries.robolectric)
}
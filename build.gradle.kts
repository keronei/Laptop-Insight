// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(BuildPlugins.kotlinAndroid) version Versions.kotlin apply false
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath ("com.android.tools.build:gradle:8.1.0")
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}")
        classpath(BuildPlugins.navigationSafeArgs)

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }

}

tasks.register("clean", Delete::class) {
    delete (rootProject.buildDir)
}
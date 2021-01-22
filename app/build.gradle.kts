plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    kotlin("android.extensions")
    id("com.haizhuo.version") apply false
}

android{
    compileSdkVersion(BuildConfig.compileSdkVersion)
    buildToolsVersion(BuildConfig.buildToolsVersion)

    defaultConfig{
        applicationId = BuildConfig.applicationId
        minSdkVersion(BuildConfig.minSdkVersion)
        targetSdkVersion(BuildConfig.targetSdkVersion)
        versionCode =BuildConfig.versionCode
        versionName =BuildConfig.versionName

        testInstrumentationRunner =BuildConfig.testInstrumentationRunner

        multiDexEnabled = true
    }

    buildTypes {
        getByName("release") {
            consumerProguardFiles("proguard-rules.pro")
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
    implementation(fileTree(mapOf("include" to listOf("*.jar"), "dir" to "libs")))
    implementation(BuildConfig.kt_stdlib)
    implementation(AndroidX.coreKtx)
    implementation(AndroidX.appcompat)
    implementation(Google.material)
    implementation(Google.gson)
    implementation(AndroidX.constraintlayout)
    testImplementation(Testing.jUnit)
    androidTestImplementation(Testing.androidJunit)
    androidTestImplementation(Testing.espresso)
}
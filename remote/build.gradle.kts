plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id ("kotlin-android-extensions")
    id ("kotlin-kapt")
}

android {
    namespace = "com.example.remote"
    compileSdk = Versions.compileSdk

    defaultConfig {
        minSdk = Versions.minSdk
        targetSdk = Versions.compileSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            buildConfigField("String", "BASE_ENDPOINT", "\"https://\"")
        }
        debug {
            isJniDebuggable = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            buildConfigField("String", "BASE_ENDPOINT", "\"https://\"")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(mapOf("path" to ":utils")))
    implementation(AndroidLibs.core)
    implementation(AndroidLibs.appcompat)
    implementation(AndroidLibs.coroutineCore)
    implementation(AndroidLibs.coroutineAndroid)
    implementation(Libs.gson)
    implementation(Libs.retrofit)
    implementation(Libs.retrofitConverterGson)
    implementation(Libs.retrofitCoroutineAdapter)
    implementation(Libs.okHttpInterceptor)
    implementation(Libs.okHttp)
    implementation(Libs.koin)
    implementation(Libs.koinScope)
    implementation(Libs.koinCompat)
    implementation(Libs.koinJetpack)
    implementation(Libs.koinNav)
}
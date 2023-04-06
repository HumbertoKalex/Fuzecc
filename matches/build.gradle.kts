plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.matches"
    compileSdk = 33

    defaultConfig {
        minSdk = 24
        targetSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")

    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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
    implementation(project(mapOf("path" to ":remote")))
    implementation(AndroidLibs.core)
    implementation(AndroidLibs.appcompat)
    implementation(AndroidLibs.material)
    implementation(AndroidLibs.constraint)
    implementation(AndroidLibs.navigation)
    implementation(AndroidLibs.navigationUi)
    implementation(AndroidLibs.recycler)
    implementation(AndroidLibs.lifecycle)
    implementation(AndroidLibs.lifecyclemodel)
    implementation(AndroidLibs.coroutineCore)
    implementation(AndroidLibs.coroutineAndroid)

    implementation(Libs.retrofit)
    implementation(Libs.gson)
    implementation(Libs.glide)
    implementation(Libs.koin)
    implementation(Libs.koinScope)
    implementation(Libs.koinCompat)
    implementation(Libs.koinJetpack)
    implementation(Libs.koinNav)

    implementation(AndroidLibs.junit)
    implementation(AndroidLibs.androidxJunit)
    implementation(AndroidLibs.espresso)
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
}
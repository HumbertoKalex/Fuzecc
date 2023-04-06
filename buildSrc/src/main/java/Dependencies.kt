object AppVersions {
    const val versionCode = 1
    const val versionName = "1.0"
}

object Versions {
    const val compileSdk = 33
    const val minSdk = 24
    const val core = "1.7.0"

    const val recyclerVersion = "1.2.1"
    const val courotinesVersion = "1.3.9"
    const val lifecycle = "2.5.1"
    const val retrofit = "2.9.0"
    const val retrofitCoroutines = "0.9.2"
    const val okhttp3 = "4.10.0"
    const val gson = "2.10.1"
    const val dataBinding = "3.5.0"
    const val viewBinding = "7.4.2"
    const val koin = "3.4.0"
    const val glide = "4.15.1"
    const val coil = "2.3.0"
    const val appCompat = "1.6.1"
    const val material = "1.8.0"
    const val constraint = "2.1.4"
    const val navigation = "2.5.3"
    const val navigationUi = "2.5.3"
    const val junit = "4.13.2"
    const val androidxJunit = "1.1.5"
    const val espresso = "3.5.1"
    const val dagger = "2.21"

}

object AndroidLibs {
    const val core = "androidx.core:core-ktx:${Versions.core}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraint = "androidx.constraintlayout:constraintlayout:${Versions.constraint}"
    const val navigation = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigationUi}"
    const val recycler = "androidx.recyclerview:recyclerview:${Versions.recyclerVersion}"
    const val lifecycle = "androidx.lifecycle:lifecycle-livedata:${Versions.lifecycle}"
    const val lifecyclemodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val coroutineCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.courotinesVersion}"
    const val coroutineAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.courotinesVersion}"
    const val junit = "junit:junit:${Versions.junit}"
    const val androidxJunit = "androidx.test.ext:junit:${Versions.androidxJunit}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"

}

object Libs {
    const val gson = "com.google.code.gson:gson:${Versions.gson}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitConverterGson =
        "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val retrofitCoroutineAdapter =
        "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.retrofitCoroutines}"
    const val okHttpInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp3}"
    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp3}"
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val coilSvg = "io.coil-kt:coil-svg:${Versions.coil}"
    const val coil = "io.coil-kt:coil:${Versions.coil}"
    const val dataBinding = "androidx.databinding:databinding-compiler:${Versions.dataBinding}"
    const val viewBinding = "androidx.databinding:databinding-runtime:${Versions.viewBinding}"

    const val koin = "io.insert-koin:koin-core:${Versions.koin}"
    const val koinScope = "io.insert-koin:koin-android:${Versions.koin}"
    const val koinCompat = "io.insert-koin:koin-android-compat:${Versions.koin}"
    const val koinJetpack = "io.insert-koin:koin-androidx-workmanager:${Versions.koin}"
    const val koinNav = "io.insert-koin:koin-androidx-navigation:${Versions.koin}"
    const val daggerPrecessor = "com.google.dagger:dagger-android-processor:${Versions.dagger}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    const val daggerAndroid = "com.google.dagger:dagger-android:${Versions.dagger}"
    const val daggerSupport = "com.google.dagger:dagger-android-support:${Versions.dagger}"

}

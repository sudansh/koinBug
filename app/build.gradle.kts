@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)
}

android {
    namespace = "app.sudansh.koinbug"
    compileSdk = 34

    defaultConfig {
        applicationId = "app.sudansh.koinbug"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildFeatures {
        compose = true
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.composeCompiler.get()
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}
ksp {
    arg("KOIN_CONFIG_CHECK","true")
}
dependencies {
    implementation(projects.data)

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.fragment)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.bundles.navigation)

    implementation(platform(libs.koin.bom))
    implementation(libs.koin.core)
    implementation(libs.bundles.koin.android)

    implementation(platform(libs.compose.bom))
    debugImplementation(libs.compose.ui.tooling)
    implementation(libs.bundles.compose.core)

    implementation(platform(libs.koin.annotation.bom))
    implementation(libs.koin.annotations)
    ksp(libs.koin.ksp.compiler)
}
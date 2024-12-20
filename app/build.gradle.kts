plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.mipt_3_praktinis"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.mipt_3_praktinis"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(files("libs\\MathParser.org-mXparser.jar"))
    implementation(files("libs\\MathParser.org-mXparser.jar"))
    implementation(files("libs\\MathParser.org-mXparser.jar"))
    implementation(files("libs\\MathParser.org-mXparser.jar"))
    implementation(files("libs\\MathParser.org-mXparser.jar"))
    implementation(files("libs\\MathParser.org-mXparser.jar"))
    implementation(files("libs\\MathParser.org-mXparser.jar"))
    implementation(files("libs\\MathParser.org-mXparser.jar"))
    implementation(files("libs\\MathParser.org-mXparser.jar"))
    testImplementation(libs.junit)
    testImplementation(libs.core)
    testImplementation(libs.ext.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}
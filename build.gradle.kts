// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
//    val room_version = "2.5.1"
    alias(libs.plugins.androidApplication) apply false
    id ("org.jetbrains.kotlin.android") version "1.7.20" apply false
//    id("androidx.room") version "$room_version" apply false
}
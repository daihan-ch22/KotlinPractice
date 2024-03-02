// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.2.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.22" apply false
}

extra {
    val paging_version = "3.1.1"
    val retrofit_version = "2.9.0"
    val lifecycle_version = "2.5.1"
}
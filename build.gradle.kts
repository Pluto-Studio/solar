plugins {
    kotlin("jvm") version "2.1.20"
}

val kotlinPrefix = "org.jetbrains.kotlin"

allprojects {
    apply {
        plugin("$kotlinPrefix.jvm")
    }

    group = "plutoproject.solar"
    version = "1.0.0-SNAPSHOT"

    repositories {
        mavenCentral()
    }

    dependencies {
    }

    kotlin {
        jvmToolchain(21)
    }
}

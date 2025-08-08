import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    id("java")
    id("java-library")
    kotlin("jvm")
    kotlin("plugin.serialization")
}

group = "plutoproject.solar"
version = "1.0.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://maven.nostal.ink/repository/maven-public")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(21))
}

kotlin {
    jvmToolchain(21)
}

tasks.compileKotlin {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_21)
        javaParameters = true
    }
}

dependencies {
    api(libs.kotlin.stdlib)
    api(libs.kotlin.reflect)
    api(libs.kotlinx.coroutine.core)
    api(libs.kotlinx.serialization.cbor)
}

plugins {
    application
    id("solar.base-conventions")
}

application {
    mainClass = "plutoproject.solar.server.MainKt"
}

dependencies {
    implementation(libs.netty.all)
    implementation(libs.logback.classic)
    implementation(libs.kotlinx.serialization.hocon)
}

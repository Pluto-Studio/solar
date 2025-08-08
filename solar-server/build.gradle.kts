plugins {
    application
    id("solar.base-conventions")
}

application {
    mainClass = "plutoproject.solar.server.MainKt"
}

dependencies {
    implementation(libs.netty.all)
}

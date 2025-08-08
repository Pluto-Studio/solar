plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

rootProject.name = "solar"

include("solar-server")
include("solar-client")
include("solar-shared")
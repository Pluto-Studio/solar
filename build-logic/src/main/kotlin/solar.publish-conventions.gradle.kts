import org.gradle.kotlin.dsl.`maven-publish`

plugins {
    `maven-publish`
}

val publishUrl = uri(
    if (version.toString().endsWith("SNAPSHOT")) {
        "https://maven.nostal.ink/repository/maven-snapshots/"
    } else {
        "https://maven.nostal.ink/repository/maven-releases/"
    }
)

publishing {
    repositories {
        maven {
            name = "nostal"
            url = publishUrl
            credentials(PasswordCredentials::class)
        }
    }

    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }
}

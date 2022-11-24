import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    `java-library`
    `maven-publish`
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

publishing {
    repositories {
        maven {
            name = "slf4j-fbl"
            url = uri("https://maven.pkg.github.com/BlockyDotJar/SLF4J-Fallback-Logger")
            credentials {
                username = project.findProperty("gpr.user") as String? ?: System.getenv("GITHUB_USERNAME")
                password = project.findProperty("gpr.key") as String? ?: System.getenv("GITHUB_TOKEN")
            }
        }
    }
    publications {
        register<MavenPublication>("gpr") {
            from(components["java"])
        }
    }
}

repositories {
    mavenCentral()
}

dependencies {
    api("org.slf4j:slf4j-api:2.0.4")
    api("org.apache.commons:commons-collections4:4.4")

    compileOnly("com.google.errorprone:error_prone_annotations:2.16")
    compileOnly("org.jetbrains:annotations:23.0.0")
}

group = "dev.blocky.library"
version = "1.0.4"
description = "A fallback logger for SLF4J, which triggers if there is no 'StaticLoggerBinder' or 'ServiceProvider' implementation."

java {
    sourceCompatibility = JavaVersion.VERSION_17

    withSourcesJar()
    withJavadocJar()
}

val jar by tasks.getting(Jar::class) {
    manifest {
        attributes["Automatic-Module-Name"] = "slf4jfbl"
    }
}

val shadowJar by tasks.getting(ShadowJar::class) {
    minimize()
}

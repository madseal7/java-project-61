import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    application
    jacoco
    id("checkstyle")
    id("io.freefair.lombok") version "8.6"
    id("com.github.ben-manes.versions") version "0.50.0"
}

group = "io.hexlet"

version = "1.0-SNAPSHOT"

application { mainClass.set("hexlet.code.Main") }

repositories { mavenCentral() }

tasks.jacocoTestReport { reports { xml.required.set(true) } }

tasks.getByName("run", JavaExec::class) {
    standardInput = System.`in`
}
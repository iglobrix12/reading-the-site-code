plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.mozilla:rhino-engine:1.7.15")
}

tasks.test {
    useJUnitPlatform()
}
plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.2")
    implementation("io.appium:java-client:8.3.0")
    implementation("com.codeborne:selenide-appium:7.0.3")
    implementation("commons-codec:commons-codec:1.16.1")
}

tasks.test {
    useJUnitPlatform()
    maxParallelForks = 3
    forkEvery = 1
}

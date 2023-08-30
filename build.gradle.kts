plugins {
    kotlin("jvm") version "1.8.0"
    application
}

group = "info.martindupuis"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
//    // https://mvnrepository.com/artifact/io.swagger.core.v3/swagger-core-jakarta
//    implementation("io.swagger.core.v3:swagger-core-jakarta:2.2.15")
//
//    // https://mvnrepository.com/artifact/io.swagger.core.v3/swagger-integration-jakarta
//    implementation("io.swagger.core.v3:swagger-integration-jakarta:2.2.15")

    // https://mvnrepository.com/artifact/io.swagger/swagger-inflector
    implementation("io.swagger:swagger-inflector:2.0.9")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}

application {
    mainClass.set("MainKt")
}
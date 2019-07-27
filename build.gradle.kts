import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.1.6.RELEASE"
    id("io.spring.dependency-management") version "1.0.7.RELEASE"
    kotlin("jvm") version "1.2.71"
    kotlin("plugin.spring") version "1.2.71"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
    mavenCentral()
}

dependencies {

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    testImplementation(group = "org.junit.jupiter", name = "junit-jupiter-api", version = "5.2.0")
    testImplementation(group = "org.junit.jupiter", name = "junit-jupiter-params", version = "5.2.0")
    testRuntime(group = "org.junit.jupiter", name = "junit-jupiter-engine", version = "5.2.0")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation(group = "io.rest-assured", name = "rest-assured", version = "3.3.0")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}

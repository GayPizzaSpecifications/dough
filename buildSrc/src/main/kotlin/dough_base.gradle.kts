import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  `java-base`

  kotlin("multiplatform")
  kotlin("plugin.serialization")
}

repositories {
  mavenCentral()
}

java {
  val javaVersion = JavaVersion.toVersion(17)
  sourceCompatibility = javaVersion
  targetCompatibility = javaVersion
}

tasks.withType<KotlinCompile> {
  kotlinOptions.jvmTarget = "17"
}

kotlin {
  jvm()

  sourceSets {
    commonMain {
      dependencies {
        api("org.jetbrains.kotlin:kotlin-bom")
        api("org.jetbrains.kotlin:kotlin-stdlib")
        api("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1")
      }
    }
  }
}

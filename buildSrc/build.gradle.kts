import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  `kotlin-dsl`
}

repositories {
  gradlePluginPortal()
}

dependencies {
  implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.10")
  implementation("org.jetbrains.kotlin:kotlin-serialization:1.9.10")
}

java {
  val javaVersion = JavaVersion.toVersion(17)
  sourceCompatibility = javaVersion
  targetCompatibility = javaVersion
}

tasks.withType<KotlinCompile> {
  kotlinOptions.jvmTarget = "17"
}

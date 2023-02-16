import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  `maven-publish`

  kotlin("multiplatform")
  kotlin("plugin.serialization")
}

repositories {
  mavenCentral()
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

java {
  val javaVersion = JavaVersion.toVersion(17)
  sourceCompatibility = javaVersion
  targetCompatibility = javaVersion
}

tasks.withType<KotlinCompile> {
  kotlinOptions.jvmTarget = "17"
}

publishing {
  repositories {
    mavenLocal()

    var githubPackagesToken = System.getenv("GITHUB_TOKEN")
    if (githubPackagesToken == null) {
      githubPackagesToken = project.findProperty("github.token") as String?
    }

    maven {
      name = "GitHubPackages"
      url = uri("https://maven.pkg.github.com/gaypizzaspecifications/dough")
      credentials {
        username = project.findProperty("github.username") as String? ?: "gaypizzaspecifications"
        password = githubPackagesToken
      }
    }
  }
}

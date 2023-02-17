plugins {
  dough_sample
}

kotlin {
  sourceSets {
    commonMain {
      dependencies {
        implementation(project(":dough-fs"))
      }
    }
  }
}
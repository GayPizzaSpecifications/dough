plugins {
  dough_component
}

kotlin {
  sourceSets {
    commonMain {
      dependencies {
        api(project(":dough-core"))
      }
    }
  }
}

plugins {
  dough_sample
}

kotlin {
  js(IR) {
    nodejs()
    browser()

    binaries.executable()
  }

  sourceSets {
    commonMain {
      dependencies {
        implementation(project(":dough-core"))
      }
    }
  }
}

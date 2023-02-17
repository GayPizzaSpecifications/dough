plugins {
  dough_component
}

kotlin {
  js(IR) {
    nodejs()
    browser()
  }
}

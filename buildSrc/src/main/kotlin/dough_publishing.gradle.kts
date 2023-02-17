plugins {
  id("dough_base")

  `maven-publish`
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

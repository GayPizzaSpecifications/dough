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

    var gitlabPackagesToken = System.getenv("GITLAB_TOKEN")
    if (gitlabPackagesToken == null) {
      gitlabPackagesToken = project.findProperty("gitlab.com.accessToken") as String?
    }

    maven {
      name = "GitHubPackages"
      url = uri("https://maven.pkg.github.com/gaypizzaspecifications/dough")
      credentials {
        username = project.findProperty("github.username") as String? ?: "gaypizzaspecifications"
        password = githubPackagesToken
      }
    }

    maven {
      name = "GitLab"
      url = uri("https://gitlab.com/api/v4/projects/49101454/packages/maven")
      credentials(HttpHeaderCredentials::class.java) {
        name = "Private-Token"
        value = gitlabPackagesToken
      }

      authentication {
        create<HttpHeaderAuthentication>("header")
      }
    }
  }
}

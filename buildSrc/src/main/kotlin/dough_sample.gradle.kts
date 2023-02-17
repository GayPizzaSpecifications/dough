import org.jetbrains.kotlin.gradle.targets.jvm.KotlinJvmTarget

plugins {
  id("dough_base")
}

val jvmMain = kotlin.targets.getByName<KotlinJvmTarget>("jvm").compilations.getByName("main")

tasks {
  val sampleJar = register<Jar>("sampleJar") {
    group = "application"

    manifest {
      attributes["Main-Class"] = "MainKt"
    }

    duplicatesStrategy = DuplicatesStrategy.EXCLUDE

    archiveBaseName.set("${project.name}-sample")
    from(jvmMain.output.classesDirs, jvmMain.compileDependencyFiles.map {
      if (it.isDirectory) it else zipTree(it)
    })
  }

  register<JavaExec>("runSample") {
    group = "application"

    mainClass.set("MainKt")
    classpath = jvmMain.output.classesDirs
    classpath += jvmMain.compileDependencyFiles
  }

  assemble.get().dependsOn(sampleJar)
}

import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinJvmCompilation
import org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsExec
import org.jetbrains.kotlin.gradle.targets.jvm.KotlinJvmTarget

plugins {
  id("dough_base")
}

val jvmMain: KotlinJvmCompilation =
  kotlin.targets.getByName<KotlinJvmTarget>("jvm").compilations.getByName("main")

kotlin {
  js {
    binaries.executable()
  }
}

tasks {
  val sampleJar = register<Jar>("jvmSampleJar") {
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

  register<JavaExec>("jvmSampleRun") {
    group = "application"

    mainClass.set("MainKt")
    classpath = jvmMain.output.classesDirs
    classpath += jvmMain.compileDependencyFiles
  }

  assemble.get().dependsOn(sampleJar)

  val jsNodeRun = tasks.getByName("jsNodeRun") as NodeJsExec
  jsNodeRun.workingDir(projectDir)
}

rootProject.name = "dough"

val topLevelModules = rootProject.projectDir.listFiles { item: File ->
  item.name.startsWith("dough-") &&
    item.isDirectory &&
    item.resolve("build.gradle.kts").exists()
}?.toList() ?: emptyList()

val samples = rootProject.projectDir.resolve("samples").listFiles { item: File ->
  item.isDirectory &&
    item.resolve("build.gradle.kts").exists()
}?.toList() ?: emptyList()

(topLevelModules + samples).map { file ->
  file.relativeTo(rootProject.projectDir)
}.forEach { file ->
  include(file.path.replace(File.separator, ":"))
}

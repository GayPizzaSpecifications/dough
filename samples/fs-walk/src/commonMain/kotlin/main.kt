import gay.pizza.dough.fs.PlatformFsProvider
import gay.pizza.dough.fs.walk

fun main() {
  val currentWorkingDirectory = PlatformFsProvider.currentWorkingDirectory
  for (item in currentWorkingDirectory.walk()) {
    val relative = item.relativeTo(currentWorkingDirectory)
    println(relative.fullPathString)
  }
}

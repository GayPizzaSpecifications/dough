import gay.pizza.dough.fs.PlatformFsProvider
import gay.pizza.dough.fs.readString

fun main() {
  val currentWorkingDirectory = PlatformFsProvider.currentWorkingDirectory
  val helloTextPath = currentWorkingDirectory.resolve("hello.txt")
  val content = helloTextPath.readString()
  println(content)
}

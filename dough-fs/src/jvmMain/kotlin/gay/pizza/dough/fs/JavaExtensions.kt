package gay.pizza.dough.fs

import java.nio.file.Path

fun Path.toFsPath(): FsPath = JavaPath(this)
fun FsPath.toJavaPath(): Path {
  return if (this is JavaPath) {
    javaPath
  } else {
    Path.of(fullPathString)
  }
}

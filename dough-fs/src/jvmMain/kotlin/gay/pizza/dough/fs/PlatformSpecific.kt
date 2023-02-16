package gay.pizza.dough.fs

import java.nio.file.Paths

actual fun FsPath(path: String): FsPath {
  return JavaPath(Paths.get(path))
}

package gay.pizza.dough.fs

import java.nio.file.FileSystem
import kotlin.io.path.absolute

class JavaFsProvider(val fileSystem: FileSystem) : FsProvider {
  override val currentWorkingDirectory: FsPath
    get() = fileSystem.getPath(".").absolute().toFsPath()
  override val separator: String
    get() = fileSystem.separator

  override val operations: FsOperations = JavaFsOperations

  override fun resolve(path: String): FsPath =
    fileSystem.getPath(path).toFsPath()
}

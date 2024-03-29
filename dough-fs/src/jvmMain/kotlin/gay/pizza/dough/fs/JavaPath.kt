package gay.pizza.dough.fs

import java.nio.file.Path
import java.util.*
import kotlin.io.path.relativeTo

class JavaPath(path: Path) : FsPath {
  val javaPath: Path = path.toAbsolutePath()

  override val fullPathString: String
    get() = javaPath.toString()

  override val entityNameString: String
    get() = javaPath.fileName.toString()

  override val parent: FsPath?
    get() = javaPath.parent?.toFsPath()

  override val operations: FsOperations = JavaFsOperations

  override fun resolve(part: String): FsPath = javaPath.resolve(part).toFsPath()
  override fun relativeTo(path: FsPath): FsPath = javaPath.relativeTo(path.toJavaPath()).toFsPath()

  override fun toString(): String = javaPath.toString()

  override fun equals(other: Any?): Boolean {
    if (other == null) {
      return false
    }

    if (other !is FsPath) {
      return false
    }

    return other.toJavaPath() == javaPath
  }

  override fun hashCode(): Int = Objects.hash(javaPath)
}

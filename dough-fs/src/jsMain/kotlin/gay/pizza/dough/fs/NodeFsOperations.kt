package gay.pizza.dough.fs

import gay.pizza.dough.core.time.UnixTime
import gay.pizza.dough.fs.nodefs.NodeFsModule
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.SerializationStrategy

object NodeFsOperations : FsOperations {
  override fun exists(path: FsPath): Boolean {
    TODO("Not yet implemented")
  }

  override fun isDirectory(path: FsPath): Boolean {
    TODO("Not yet implemented")
  }

  override fun isRegularFile(path: FsPath): Boolean {
    TODO("Not yet implemented")
  }

  override fun isSymbolicLink(path: FsPath): Boolean {
    TODO("Not yet implemented")
  }

  override fun isReadable(path: FsPath): Boolean {
    TODO("Not yet implemented")
  }

  override fun isWritable(path: FsPath): Boolean {
    TODO("Not yet implemented")
  }

  override fun isExecutable(path: FsPath): Boolean {
    TODO("Not yet implemented")
  }

  override fun lastModified(path: FsPath): UnixTime {
    TODO("Not yet implemented")
  }

  override fun list(path: FsPath): Sequence<FsPath> {
    TODO("Not yet implemented")
  }

  override fun walk(path: FsPath): Sequence<FsPath> {
    TODO("Not yet implemented")
  }

  override fun visit(path: FsPath, visitor: FsPathVisitor) {
    TODO("Not yet implemented")
  }

  override fun readString(path: FsPath): String =
    NodeFsModule.readFileSync(path.fullPathString, "utf-8")

  override fun readAllBytes(path: FsPath): ByteArray {
    TODO("Not yet implemented")
  }

  override fun readBytesChunked(path: FsPath, block: (ByteArray, Int) -> Unit) {
    TODO("Not yet implemented")
  }

  override fun <T> readJsonFile(
    path: FsPath,
    deserializer: DeserializationStrategy<T>
  ): T {
    TODO("Not yet implemented")
  }

  override fun readLines(path: FsPath): Sequence<String> {
    TODO("Not yet implemented")
  }

  override fun <T> readJsonLines(
    path: FsPath,
    deserializer: DeserializationStrategy<T>
  ): Sequence<T> {
    TODO("Not yet implemented")
  }

  override fun writeString(path: FsPath, content: String) {
    TODO("Not yet implemented")
  }

  override fun writeAllBytes(path: FsPath, bytes: ByteArray) {
    TODO("Not yet implemented")
  }

  override fun <T> writeJsonFile(
    path: FsPath,
    serializer: SerializationStrategy<T>,
    value: T
  ) {
    TODO("Not yet implemented")
  }

  override fun delete(path: FsPath) {
    TODO("Not yet implemented")
  }

  override fun deleteOnExit(path: FsPath) {
    TODO("Not yet implemented")
  }

  override fun deleteRecursively(path: FsPath) {
    TODO("Not yet implemented")
  }

  override fun createDirectories(path: FsPath) {
    TODO("Not yet implemented")
  }
}

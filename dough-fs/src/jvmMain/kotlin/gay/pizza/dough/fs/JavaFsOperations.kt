package gay.pizza.dough.fs

import gay.pizza.dough.core.time.UnixTime
import gay.pizza.dough.core.toUnixTime
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.SerializationStrategy
import kotlinx.serialization.json.Json
import java.nio.file.Files
import kotlin.io.path.bufferedReader
import kotlin.io.path.deleteExisting
import kotlin.io.path.inputStream
import kotlin.streams.asSequence

object JavaFsOperations : FsOperations {
  override fun exists(path: FsPath): Boolean = Files.exists(path.toJavaPath())

  override fun isDirectory(path: FsPath): Boolean = Files.isDirectory(path.toJavaPath())
  override fun isRegularFile(path: FsPath): Boolean = Files.isRegularFile(path.toJavaPath())
  override fun isSymbolicLink(path: FsPath): Boolean = Files.isSymbolicLink(path.toJavaPath())
  override fun isReadable(path: FsPath): Boolean = Files.isReadable(path.toJavaPath())
  override fun isWritable(path: FsPath): Boolean = Files.isWritable(path.toJavaPath())
  override fun isExecutable(path: FsPath): Boolean = Files.isExecutable(path.toJavaPath())

  override fun lastModified(path: FsPath): UnixTime = Files.getLastModifiedTime(path.toJavaPath()).toUnixTime()

  override fun list(path: FsPath): Sequence<FsPath> = Files.list(path.toJavaPath()).asSequence().map { it.toFsPath() }

  override fun walk(path: FsPath): Sequence<FsPath> = Files.walk(path.toJavaPath()).asSequence().map { it.toFsPath() }
  override fun visit(path: FsPath, visitor: FsPathVisitor): Unit =
    Files.walkFileTree(path.toJavaPath(), JavaFsPathVisitorAdapter(visitor)).run {}

  override fun readString(path: FsPath): String = Files.readString(path.toJavaPath())
  override fun readAllBytes(path: FsPath): ByteArray = Files.readAllBytes(path.toJavaPath())
  override fun readBytesChunked(path: FsPath, block: (ByteArray, Int) -> Unit) {
    val javaPath = path.toJavaPath()
    val stream = javaPath.inputStream()
    val buffer = ByteArray(1024 * 1024)
    var count: Int
    while ((stream.read(buffer).also { count = it }) > 0) {
      block(buffer, count)
    }
  }

  override fun <T> readJsonFile(path: FsPath, deserializer: DeserializationStrategy<T>): T =
    Json.decodeFromString(deserializer, readString(path))

  override fun readLines(path: FsPath): Sequence<String> {
    val stream = path.toJavaPath().bufferedReader()
    return stream.lineSequence()
  }

  override fun <T> readJsonLines(path: FsPath, deserializer: DeserializationStrategy<T>): Sequence<T> =
    readLines(path).map { line -> line.trim() }.map { line ->
      Json.decodeFromString(deserializer, line)
    }

  override fun writeString(path: FsPath, content: String): Unit = Files.writeString(path.toJavaPath(), content).run {}
  override fun writeAllBytes(path: FsPath, bytes: ByteArray): Unit = Files.write(path.toJavaPath(), bytes).run {}
  override fun <T> writeJsonFile(path: FsPath, serializer: SerializationStrategy<T>, value: T) =
    writeString(path, Json.encodeToString(serializer, value))

  override fun delete(path: FsPath) {
    path.toJavaPath().deleteExisting()
  }

  override fun deleteOnExit(path: FsPath) {
    path.toJavaPath().toFile().deleteOnExit()
  }

  override fun deleteRecursively(path: FsPath) {
    path.toJavaPath().toFile().deleteRecursively()
  }

  override fun createDirectories(path: FsPath) {
    Files.createDirectories(path.toJavaPath())
  }
}

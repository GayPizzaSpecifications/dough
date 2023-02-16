package gay.pizza.dough.fs

import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.SerializationStrategy

interface FsOperations {
  fun exists(path: FsPath): Boolean
  fun isDirectory(path: FsPath): Boolean
  fun isRegularFile(path: FsPath): Boolean
  fun isSymbolicLink(path: FsPath): Boolean
  fun isReadable(path: FsPath): Boolean
  fun isWritable(path: FsPath): Boolean
  fun isExecutable(path: FsPath): Boolean

  fun list(path: FsPath): Sequence<FsPath>

  fun walk(path: FsPath): Sequence<FsPath>
  fun visit(path: FsPath, visitor: FsPathVisitor)

  fun readString(path: FsPath): String
  fun readAllBytes(path: FsPath): ByteArray
  fun readBytesChunked(path: FsPath, block: (ByteArray, Int) -> Unit)
  fun <T> readJsonFile(path: FsPath, deserializer: DeserializationStrategy<T>): T

  fun readLines(path: FsPath, block: (String) -> Unit) {
    readLines(path).forEach(block)
  }

  fun readLines(path: FsPath): Sequence<String>

  fun readLinesToList(path: FsPath): List<String> {
    val lines = mutableListOf<String>()
    readLines(path) { line -> lines.add(line) }
    return lines
  }

  fun <T> readJsonLines(path: FsPath, deserializer: DeserializationStrategy<T>): Sequence<T>

  fun <T> readJsonLines(path: FsPath, deserializer: DeserializationStrategy<T>, block: (T) -> Unit) {
    readJsonLines(path, deserializer).forEach(block)
  }

  fun <T> readJsonLinesToList(path: FsPath, deserializer: DeserializationStrategy<T>): List<T> {
    val results = mutableListOf<T>()
    readJsonLines(path, deserializer) { item -> results.add(item) }
    return results
  }

  fun writeString(path: FsPath, content: String)
  fun writeAllBytes(path: FsPath, bytes: ByteArray)
  fun <T> writeJsonFile(path: FsPath, serializer: SerializationStrategy<T>, value: T)

  fun delete(path: FsPath)
  fun deleteOnExit(path: FsPath)
  fun deleteRecursively(path: FsPath)

  fun createDirectories(path: FsPath)
}

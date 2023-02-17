package gay.pizza.dough.fs

interface FsProvider {
  val currentWorkingDirectory: FsPath
  val operations: FsOperations

  fun resolve(path: String): FsPath
}

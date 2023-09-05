package gay.pizza.dough.fs

interface FsProvider : FsPathResolver {
  val currentWorkingDirectory: FsPath
  val separator: String
  val operations: FsOperations
}

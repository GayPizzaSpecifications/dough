package gay.pizza.dough.fs

interface FsProvider : FsPathResolver {
  val currentWorkingDirectory: FsPath
  val operations: FsOperations
}

package gay.pizza.dough.fs

object NodejsFsProvider : FsProvider {
  override val currentWorkingDirectory: FsPath
    get() = NodePath(".")

  override val operations: FsOperations = NodeFsOperations

  override fun resolve(path: String): FsPath = NodePath(path)
}

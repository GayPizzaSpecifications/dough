package gay.pizza.dough.fs

import gay.pizza.dough.fs.nodefs.NodePathModule

object NodejsFsProvider : FsProvider {
  override val currentWorkingDirectory: FsPath
    get() = NodePath(".")
  override val separator: String
    get() = NodePathModule.separator

  override val operations: FsOperations = NodeFsOperations

  override fun resolve(path: String): FsPath = NodePath(path)
}

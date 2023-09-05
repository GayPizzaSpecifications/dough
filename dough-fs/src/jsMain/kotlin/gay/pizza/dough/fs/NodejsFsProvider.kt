package gay.pizza.dough.fs

import gay.pizza.dough.fs.nodefs.NodePathModule

object NodejsFsProvider : FsProvider {
  override val currentWorkingDirectory: FsPath
    get() = NodePath(NodePathModule.resolve("."))

  override val operations: FsOperations
    get() = TODO()

  override fun resolve(path: String): FsPath = NodePath(NodePathModule.resolve(path))
}

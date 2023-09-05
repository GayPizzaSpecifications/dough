package gay.pizza.dough.fs

import gay.pizza.dough.fs.nodefs.NodePathModule

class NodePath(fullPathString: String) : FsPath {
  override val fullPathString: String = NodePathModule.resolve(fullPathString)

  override val entityNameString: String
  get() = NodePathModule.baseName(fullPathString)
  override val parent: FsPath
    get() = NodePath(fullPathString)
  override val operations: FsOperations
    get() = NodeFsOperations

  override fun resolve(part: String): FsPath =
    NodePath(NodePathModule.resolve(fullPathString, part))

  override fun relativeTo(path: FsPath): FsPath =
    NodePath(NodePathModule.relative(fullPathString, path.fullPathString))
}

package gay.pizza.dough.fs

object DefaultFsPathSerializer : FsPathSerializer({ FsPath(it) })

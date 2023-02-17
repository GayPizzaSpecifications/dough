package gay.pizza.dough.fs

interface FsPathResolver {
  fun resolve(path: String): FsPath
}

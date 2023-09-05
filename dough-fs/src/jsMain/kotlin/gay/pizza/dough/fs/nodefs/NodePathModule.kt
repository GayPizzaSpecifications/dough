package gay.pizza.dough.fs.nodefs

@JsModule("node:path")
@JsNonModule
external object NodePathModule {
  @JsName("basename")
  fun baseName(path: String): String

  @JsName("dirname")
  fun dirName(path: String): String

  @JsName("resolve")
  fun resolve(vararg parts: String): String

  @JsName("relative")
  fun relative(from: String, to: String): String
}

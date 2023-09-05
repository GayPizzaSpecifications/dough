package gay.pizza.dough.fs.nodefs

@JsModule("node:fs")
@JsNonModule
external object NodeFsModule {
  @JsName("statSync")
  fun statSync(path: String): NodeFsStats

  @JsName("readFileSync")
  fun readFileSync(path: String, encoding: String): String
}

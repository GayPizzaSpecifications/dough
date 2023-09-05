package gay.pizza.dough.core

enum class JsPlatformType {
  Nodejs,
  Browser,
  Unknown;

  companion object {
    val current: JsPlatformType
      get() {
        val isWindowAvailable = js("typeof window") != undefined
        val isProcessAvailable = js("typeof process") != undefined

        return when {
          isProcessAvailable -> Nodejs
          isWindowAvailable -> Browser
          else -> Unknown
        }
      }
  }
}

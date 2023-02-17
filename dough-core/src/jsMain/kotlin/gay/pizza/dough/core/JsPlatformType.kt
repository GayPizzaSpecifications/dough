package gay.pizza.dough.core

enum class JsPlatformType {
  Nodejs,
  Browser,
  Unknown;

  companion object {
    fun current(): JsPlatformType {
      val isWindowAvailable = js("typeof window") != undefined
      val isProcessAvailable = js("typeof process") != undefined

      if (isProcessAvailable) {
        return Nodejs
      }

      if (isWindowAvailable) {
        return Browser
      }
      return Unknown
    }
  }
}

package gay.pizza.dough.core.time

import gay.pizza.dough.core.PlatformClock

class StaticClockProvider(private val value: UnixTime) : ClockProvider {
  override fun now(): UnixTime = value

  companion object {
    fun snapshot(): StaticClockProvider = StaticClockProvider(PlatformClock.now())
  }
}

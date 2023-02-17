package gay.pizza.dough.core

import gay.pizza.dough.core.time.ClockProvider
import gay.pizza.dough.core.time.UnixTime

object JavaClockProvider : ClockProvider {
  override fun now(): UnixTime = UnixTime(System.currentTimeMillis())
}

package gay.pizza.dough.core

import gay.pizza.dough.core.time.ClockProvider
import gay.pizza.dough.core.time.UnixTime
import kotlin.js.Date

object StandardClockProvider : ClockProvider {
  override fun now(): UnixTime =
    UnixTime(Date().getTime().toLong())
}

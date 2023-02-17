package gay.pizza.dough.core

import gay.pizza.dough.core.time.ClockProvider
import gay.pizza.dough.core.time.UnixTime

object StandardClockProvider : ClockProvider {
  override fun now(): UnixTime =
    UnixTime(js("(new Date()).getTime()") as Long)
}

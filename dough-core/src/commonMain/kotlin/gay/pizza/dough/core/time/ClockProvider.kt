package gay.pizza.dough.core.time

interface ClockProvider {
  fun now(): UnixTime
}

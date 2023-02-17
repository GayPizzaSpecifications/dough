package gay.pizza.dough.core

import gay.pizza.dough.core.time.ClockProvider

actual val PlatformClock: ClockProvider = StandardClockProvider

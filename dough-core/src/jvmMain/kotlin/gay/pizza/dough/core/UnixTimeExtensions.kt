package gay.pizza.dough.core

import gay.pizza.dough.core.time.UnixTime
import java.nio.file.attribute.FileTime
import java.time.Instant

fun UnixTime.toInstant(): Instant = Instant.ofEpochMilli(millisecondsSinceEpoch)
fun Instant.toUnixTime(): UnixTime = UnixTime(toEpochMilli())
fun FileTime.toUnixTime(): UnixTime = toInstant().toUnixTime()

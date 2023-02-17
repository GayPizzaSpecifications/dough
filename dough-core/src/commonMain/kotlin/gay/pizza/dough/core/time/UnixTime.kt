package gay.pizza.dough.core.time

import kotlin.jvm.JvmInline
import kotlin.time.Duration
import kotlin.time.DurationUnit
import kotlin.time.toDuration

@JvmInline
value class UnixTime(val millisecondsSinceEpoch: Long) : Comparable<UnixTime> {
  operator fun plus(time: UnixTime): UnixTime =
    UnixTime(millisecondsSinceEpoch + time.millisecondsSinceEpoch)

  operator fun minus(time: UnixTime): UnixTime =
    UnixTime(millisecondsSinceEpoch - time.millisecondsSinceEpoch)

  operator fun times(time: UnixTime): UnixTime =
    UnixTime(millisecondsSinceEpoch * time.millisecondsSinceEpoch)

  operator fun div(duration: Duration): UnixTime =
    UnixTime(millisecondsSinceEpoch / duration.inWholeMilliseconds)

  operator fun rem(time: UnixTime): UnixTime =
    UnixTime(millisecondsSinceEpoch % time.millisecondsSinceEpoch)

    operator fun plus(duration: Duration): UnixTime =
    UnixTime(millisecondsSinceEpoch + duration.inWholeMilliseconds)

  operator fun minus(duration: Duration): UnixTime =
    UnixTime(millisecondsSinceEpoch - duration.inWholeMilliseconds)

  operator fun times(duration: Duration): UnixTime =
    UnixTime(millisecondsSinceEpoch * duration.inWholeMilliseconds)

  operator fun div(time: UnixTime): UnixTime =
    UnixTime(millisecondsSinceEpoch / time.millisecondsSinceEpoch)

  operator fun rem(duration: Duration): UnixTime =
    UnixTime(millisecondsSinceEpoch % duration.inWholeMilliseconds)

  fun toDuration(): Duration = millisecondsSinceEpoch.toDuration(DurationUnit.MILLISECONDS)

  override fun compareTo(other: UnixTime): Int =
    millisecondsSinceEpoch.compareTo(other.millisecondsSinceEpoch)
}

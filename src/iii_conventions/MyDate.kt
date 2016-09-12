package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int)

operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this, other)

operator fun MyDate.compareTo(other: MyDate): Int {
    val y = year - other.year
    if (y != 0) {
        return y
    }
    val m = month - other.month
    if (y != 0) {
        return m
    }
    return dayOfMonth - other.dayOfMonth
}

operator fun MyDate.plus(timeInterval: TimeInterval): MyDate {
    return this.addTimeIntervals(timeInterval, 1)
}

operator fun MyDate.plus(timeInterval: RepeatedTimeInterval): MyDate {
    return this.addTimeIntervals(timeInterval.timeInterval, timeInterval.times)
}

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

operator fun TimeInterval.times(times: Int): RepeatedTimeInterval {
    return RepeatedTimeInterval(this, times)
}

class RepeatedTimeInterval(val timeInterval: TimeInterval, val times: Int)

class DateRange(val start: MyDate, val endInclusive: MyDate) : Iterable<MyDate> {
    override fun iterator(): Iterator<MyDate> = DateIterator(this)
}

class DateIterator(val dateRange: DateRange) : Iterator<MyDate> {
    var current = dateRange.start

    override fun next(): MyDate {
        val now = current
        current = current.nextDay()
        return now
    }

    override fun hasNext(): Boolean {
        return current <= dateRange.endInclusive
    }
}

operator fun DateRange.contains(date: MyDate): Boolean {
    return start < date && date < endInclusive
}

package iv_properties

import util.TODO
import util.doc34
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class LazyPropertyUsingDelegates(initializer: () -> Int) {
    val lazyValue: Int by lazy(initializer)
}

fun todoTask34(): Lazy<Int> = TODO(
    """
        Task 34.
        Read about delegated properties and make the property lazy by using delegates.
    """,
    documentation = doc34()
)

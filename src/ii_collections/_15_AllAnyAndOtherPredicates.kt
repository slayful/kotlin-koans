package ii_collections

fun example2(list: List<Int>) {

    val isZero: (Int) -> Boolean = { it == 0 }

    val hasZero: Boolean = list.any(isZero)

    val allZeros: Boolean = list.all(isZero)

    val numberOfZeros: Int = list.count(isZero)

    val firstPositiveNumber: Int? = list.firstOrNull { it > 0 }
}

fun Customer.isFrom(city: City) = this.city.equals(city)

fun Shop.checkAllCustomersAreFrom(city: City) = this.customers.all { it.isFrom(city) }


fun Shop.hasCustomerFrom(city: City) = this.customers.any { it.isFrom(city) }

fun Shop.countCustomersFrom(city: City) = this.customers.count { it.isFrom(city) }

fun Shop.findAnyCustomerFrom(city: City): Customer? = this.customers.firstOrNull { it.isFrom(city) }

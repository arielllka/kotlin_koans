// Return the set of products that were ordered by all customers

fun Shop.getProductsOrderedByAll(): Set<Product> =
    customers
        .map { it.getOrderedProducts().toSet() }
        .reduce { result, products ->
            result intersect products
        }
fun Customer.getOrderedProducts(): Set<Product> =
    orders.flatMap { it.products }.toSet()
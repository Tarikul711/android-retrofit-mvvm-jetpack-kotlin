data class Results(

    val name: String,
    val slug: String,
    val image_urls: List<String>,
    val price_type: String,
    val max_price: Double,
    val min_price: Double,
    val min_discounted_price: Double
)
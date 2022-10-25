package com.shante.restaurantapp.utils

import android.net.Uri
import com.shante.restaurantapp.domain.models.AdvertisingBannerItem
import com.shante.restaurantapp.domain.models.MenuCategory

object TestData {
    val cities = listOf<String>(
        "Moscow",
        "Saint-Petersburg",
        "Novosibirsk",
        "Rostov",
        "Yaroslavl"
    )
    val menu_category_list = listOf(
        MenuCategory("Pizzas"),
        MenuCategory("Bbqs"),
        MenuCategory("Breads"),
        MenuCategory("Burgers"),
        MenuCategory("Chocolates"),
        MenuCategory("Deserts"),
        MenuCategory("Drinks"),
        MenuCategory("Fried-chicken"),
        MenuCategory("Ice-cream"),
        MenuCategory("Sandwiches"),
        MenuCategory("Sausages"),
        MenuCategory("Steaks")
    )
    val banners = listOf(
        AdvertisingBannerItem(Uri.parse("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS9Rn2SwZ581Ey1VYsMYrfg34_IXUD8yv_oiQ&usqp=CAU")),
        AdvertisingBannerItem(Uri.parse("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRstWhZFyNH3xi8vF1Ib927SMXTqm92F4gkNB-r_lnWctQ90w71hdxpNxaoVjk6GgMi0T8&usqp=CAU")),
        AdvertisingBannerItem(Uri.parse("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ3szzKTRSWTS888zQutJxadRxE42SCWcBDDA&usqp=CAU")),
    )
}
package org.d3if0020.assesment1mobpro.navigation

sealed class Screen(val route: String) {
    data object Home: Screen("mainScreen")
    data object About: Screen("aboutScreen")
    data object AddPizza: Screen("addPizzaScreen")
    data object Payment: Screen("paymentScreen")
}

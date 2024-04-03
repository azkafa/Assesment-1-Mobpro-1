package org.d3if0020.assesment1mobpro.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.d3if0020.assesment1mobpro.data.getPizzaById
import org.d3if0020.assesment1mobpro.screen.AboutScreen
import org.d3if0020.assesment1mobpro.screen.AddPizzaScreen
import org.d3if0020.assesment1mobpro.screen.MainScreen
import org.d3if0020.assesment1mobpro.screen.PaymentScreen


@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {
            MainScreen(navController)
        }
        composable(route = Screen.About.route) {
            AboutScreen(navController)
        }
        composable(route = Screen.AddPizza.route + "/{pizzaId}") { backStackEntry ->
            val pizzaId = backStackEntry.arguments?.getString("pizzaId")?.toIntOrNull()
            val selectedPizza = if (pizzaId != null) getPizzaById(pizzaId) else null
            AddPizzaScreen(navController, selectedPizza)
        }
        composable(route = Screen.Payment.route + "?totalHarga={totalHarga}&jumlahPesanan={jumlahPesanan}&topping={topping}&alamatPengiriman={alamatPengiriman}") { backStackEntry ->
            val totalHarga = backStackEntry.arguments?.getString("totalHarga")
            val jumlahPesanan = backStackEntry.arguments?.getString("jumlahPesanan")?.toIntOrNull()
            val topping = backStackEntry.arguments?.getString("topping")
            val alamatPengiriman = backStackEntry.arguments?.getString("alamatPengiriman")
            PaymentScreen(navController, totalHarga, jumlahPesanan, topping, alamatPengiriman)
        }
    }
}


package com.example.eweek07a.example01.navGraph

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.eweek07a.example01.model.Routes
import com.example.eweek07a.example01.uicomponents.HomeScreen
import com.example.eweek07a.example01.uicomponents.Screen_A
import com.example.eweek07a.example01.uicomponents.Screen_B
import com.example.eweek07a.example01.uicomponents.Screen_C

@Composable
fun NavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(navController = navController, startDestination = Routes.Home.route) {

        composable(route = Routes.Home.route) {
            HomeScreen(
                onNavigateA = { navController.navigate(Routes.ScreenA.route) },
                onNavigateB = { navController.navigate(Routes.ScreenB.route) }
            )
        }

//        composable(route = Routes.ScreenA.route) {
//            Screen_A(onNavigate = {navController.navigate(Routes.ScreenC.route)})
//        }
        composable(route = Routes.ScreenA.route) {
            Screen_A(
                onNavigateC = { navController.navigate(Routes.ScreenC.route) },
                onNavigateD = { navController.navigate(Routes.ScreenD.route) })
        }

        composable(route = Routes.ScreenB.route) {
            Screen_B()
        }

        composable(route = Routes.ScreenC.route) {
            Screen_C(onNavigate = {
                navController.navigate(Routes.Home.route){//뒤로 가기 했을 때 종료시키기
                    popUpTo(Routes.Home.route) {//원래는 인자 페이지 바로 아래까지만 비움
                        inclusive=true//인자 페이지 포함해서 지우기
                    }
                    launchSingleTop = true//탑과 중복되는 페이지면 올리지 말아라
                }
            })
        }
    }
}
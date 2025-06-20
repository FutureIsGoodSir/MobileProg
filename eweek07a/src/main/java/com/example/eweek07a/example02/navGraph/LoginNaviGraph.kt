package com.example.eweek07a.example02.navGraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.eweek07a.example02.model.Routes
import com.example.eweek07a.example02.uicomponents.LoginScreen
import com.example.eweek07a.example02.uicomponents.Register
import com.example.eweek07a.example02.uicomponents.WelcomeScreen


@Composable
fun LoginNavGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Routes.Login.route) {
        composable(route = Routes.Login.route) {
            LoginScreen(
                onWelcomeNavigate = { userId ->//웰컴 화면으로 이동하려고 할 때 해 주어야 하는 동작
                    navController.navigate(Routes.Welcome.route + "/$userId")//경로 파라미터

                },
                onRegisterNavigate = { userId, userPasswd ->
                    if(userId.isNotEmpty()||userPasswd.isNotEmpty())//사용자 아이디의 입력이 빈 값이 아닐 때
                        navController.navigate(Routes.Register.route + "?userID=$userId&passWD=$userPasswd")//쿼리 파라미터
                    else
                        navController.navigate(Routes.Register.route)
                }
            )
        }

        composable(
            route = Routes.Welcome.route + "/{userID}",//슬래시 앞의 문자열은 함수로 치면 이름인 셈
            arguments = listOf(
                navArgument(name = "userID") {//인자 정의
                    type = NavType.StringType
                }
            )
        ) {
            WelcomeScreen(
                it.arguments?.getString("userID")//it은 내비게이션 스택의 탑이고
                // .arguments는 이 탑이 가지고 있는 인자를 가져온다. 물음표는 널이 아닐 경우에만 가져오고 널이라면 널을 그대로 반환한 다는 뜻
                // userID라는 이름을 가진 변수를 가져온다. 여기서는 userID가 스트링이기 때문에 겟스트링 사용한 것
            )
        }

        composable(
            route = Routes.Register.route + "?userID={userID}&passWD={passWD}",//?은 파라미터 선언 시작을 뜻하는 방법. ? 뒤로 함수처럼 파라미터명이 나열됨. 쿼리 파라미터라고 함
            arguments = listOf(
                navArgument(name = "userID") {
                    type = NavType.StringType
                    defaultValue = "User"//인자 디폴트 값
                },
                navArgument(name = "passWD") {
                    type = NavType.StringType
                    defaultValue = ""
                }
            )
        ) {
            Register(
                it.arguments?.getString("userID"),
                it.arguments?.getString("passWD")
            )
        }
    }
}
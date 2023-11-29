package com.capstone.weddingplanner.ui

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Book
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import com.capstone.weddingplanner.ui.theme.Merah
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.capstone.weddingplanner.R
import com.capstone.weddingplanner.ui.theme.WeddingPlannerTheme
import com.capstone.weddingplanner.ui.navigation.NavigationItem
import com.capstone.weddingplanner.ui.navigation.Screen
import com.capstone.weddingplanner.ui.screen.cart.CartScreen
import com.capstone.weddingplanner.ui.screen.detail.DetailScreen
import com.capstone.weddingplanner.ui.screen.home.HomeScreen
import com.capstone.weddingplanner.ui.screen.profile.ProfileScreen
import com.capstone.weddingplanner.ui.screen.vendor.VendorScreen
import com.capstone.weddingplanner.ui.theme.Krem


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeddingPlannerApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    Scaffold(
        topBar = { AppBar()},
        bottomBar = {
            if (currentRoute != Screen.DetailReward.route) {
                BottomBar(navController)
            }
        },
        modifier = modifier
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen(
                    navigateToDetail = { rewardId ->
                        navController.navigate(Screen.DetailReward.createRoute(rewardId))
                    }
                )
            }
            composable(Screen.Vendor.route) {
                VendorScreen(navigateToDetail = { rewardId ->
                    navController.navigate(Screen.DetailReward.createRoute(rewardId))
                })
            }
            composable(Screen.Book.route) {
                val context = LocalContext.current
                CartScreen(
                    onOrderButtonClicked = { message ->
                        shareOrder(context, message)
                    }
                )
            }
            composable(Screen.Profile.route) {
                ProfileScreen()
            }
            composable(
                route = Screen.DetailReward.route,
                arguments = listOf(navArgument("rewardId") { type = NavType.LongType }),
            ) {
                val id = it.arguments?.getLong("rewardId") ?: -1L
                DetailScreen(
                    rewardId = id,
                    navigateBack = {
                        navController.navigateUp()
                    },
                    navigateToCart = {
                        navController.popBackStack()
                        navController.navigate(Screen.Book.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            restoreState = true
                            launchSingleTop = true
                        }
                    }
                )

            }
        }
    }

}

//bottom bar
@Composable
private fun BottomBar(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavigationBar(
        modifier = modifier,
        containerColor = Krem
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        val navigationItems = listOf(
            NavigationItem(
                title = stringResource(id = R.string.menu_home),
                icon = Icons.Outlined.Home,
                screen = Screen.Home
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_vendor),
                icon = Icons.Outlined.Search,
                screen = Screen.Vendor
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_booking),
                icon = Icons.Outlined.Book,
                screen = Screen.Book
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_profile),
                icon = Icons.Outlined.Person,
                screen = Screen.Profile
            ),
        )

        navigationItems.map { item ->
            NavigationBarItem(
                selected = currentRoute == item.screen.route,
                onClick = {
                    navController.navigate(item.screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title,
                        tint = Merah
                    )
                },
                label = { Text(text = item.title) }

            )

        }
    }
}

//topBar
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AppBar(
    modifier: Modifier = Modifier,
) {
    val provider = GoogleFont.Provider(
        "com.google.android.gms.fonts",
        "com.google.android.gms",
        certificates = R.array.com_google_android_gms_fonts_certs
    )
    val fontName = GoogleFont("Parisienne")
    val parisienneFont = FontFamily(
        Font(fontName, provider)
    )
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Krem,
            titleContentColor = Merah,
        ),
        title = {
//            Text("W", fontFamily = parisienneFont, fontSize = 40.sp,)
//            Text("P", fontFamily = parisienneFont, fontSize = 40.sp)

                Text("W",
                    fontFamily = parisienneFont,
                    fontSize = 40.sp,
                    softWrap = true,
                    modifier = Modifier
                        .padding(end = 30.dp,)
//                        .align(Alignment.Center)
                )
//                Spacer(modifier = Modifier.padding(2.dp))
                Text("P",
                    fontFamily = parisienneFont,
                    fontSize = 40.sp,
                    softWrap = true,
                    modifier = Modifier
                        .padding(start = 30.dp, top = 18.dp)
//                        .align(Alignment.Center)
                )



        },
        modifier = Modifier.clip(RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp))

    )

}

private fun shareOrder(context: Context, summary: String) {
    val intent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_SUBJECT, context.getString(R.string.dicoding_reward))
        putExtra(Intent.EXTRA_TEXT, summary)
    }
    context.startActivity(
        //createChooser jenis eksekusi Intent yang menampilkan pilihan aplikasi yang bisa membuka data yang bagikan.
        Intent.createChooser(
            intent,
            context.getString(R.string.dicoding_reward)
        )
    )
}

@Preview(showBackground = true)
@Composable
fun WeddingPlannerAppPreview() {
    WeddingPlannerTheme {
        WeddingPlannerApp()
    }
}
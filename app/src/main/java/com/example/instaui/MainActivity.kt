package com.example.instaui

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.instaui.ui.theme.InstaUITheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InstaUITheme {
                var top by remember {
                    mutableStateOf("home")
                }
                val navController = rememberNavController()
                Scaffold(bottomBar = {
                    BottomNavigationBar(navController = navController, items = listOf(
                        BottomNavItem(
                            name = "Home",
                            route = "home",
                            icon = painterResource(id = R.drawable.home_outline),
                            iconF = painterResource(id = R.drawable.home_filled)
                        ),
                        BottomNavItem(
                            name = "Search",
                            route = "search",
                            icon = painterResource(id = R.drawable.search_outline),
                            iconF = painterResource(id = R.drawable.search_filled)
                        ),
                        BottomNavItem(
                            name = "Post",
                            route = "post",
                            icon = painterResource(id = R.drawable.plus_outline),
                            iconF = painterResource(id = R.drawable.plus_filled)
                        ),
                        BottomNavItem(
                            name = "Reels",
                            route = "reels",
                            icon = painterResource(id = R.drawable.reels_outline),
                            iconF = painterResource(id = R.drawable.reels_filled)
                        ),
                        BottomNavItem(
                            name = "Profile",
                            route = "profile",
                            icon = painterResource(id = R.drawable.profile_outline),
                            iconF = painterResource(id = R.drawable.profile_filled)
                        ),
                    ), onItemClick = {
                        navController.navigate(it.route)
                        top=it.route

                    })
                }, topBar = {
                    if(top=="home")
                    {
                        TopBar2()
                    }
                    else if(top=="profile")
                    {
                        TopBar1()
                    }
                    else if(top=="search")
                    {
                        var searchText by remember { mutableStateOf(TextFieldValue("")) }
                        TopAppBar(
                            title = { Text(text = "App Name", color = Color.White) },
                            actions = {
                                SearchBar(searchText) { searchText = it }
                            }
                        )
                    }
                }
                )
                {innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding))
                    {
                        BottomNavigation(navController = navController)
                    }
                }
            }
        }
    }
}

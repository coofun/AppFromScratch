package com.coofun.appfromscratch.codelab.soothe

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.coofun.appfromscratch.R
import com.coofun.appfromscratch.codelab.soothe.component.AlignYourBodyRow
import com.coofun.appfromscratch.codelab.soothe.component.FavoriteCollectionsGrid
import com.coofun.appfromscratch.codelab.soothe.component.SearchBar
import com.coofun.appfromscratch.codelab.soothe.component.SootheBottomNavigation
import com.coofun.appfromscratch.codelab.soothe.component.SootheNavigationRail

@Composable
fun SootheApp(navController: NavController, windowSize: WindowSizeClass) {
    when (windowSize.widthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            SootheAppPortrait(navController = navController)
        }

        WindowWidthSizeClass.Expanded -> {
            SootheAppLandscape(navController = navController)
        }
    }
}

@Composable
fun SootheAppPortrait(navController: NavController) {
    Scaffold(
        bottomBar = { SootheBottomNavigation(navController = navController) }
    ) { padding ->
        HomeScreen(Modifier.padding(padding))
    }
}

@Composable
fun SootheAppLandscape(navController: NavController) {
    Surface(color = MaterialTheme.colorScheme.background) {
        Row {
            SootheNavigationRail()
            HomeScreen()
        }
    }
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.verticalScroll(rememberScrollState())
    ) {
        Spacer(Modifier.height(16.dp))
        SearchBar(Modifier.padding(horizontal = 16.dp))
        HomeSection(title = R.string.soothe_align_your_body) {
            AlignYourBodyRow()
        }
        HomeSection(title = R.string.soothe_favorite_collections) {
            FavoriteCollectionsGrid()
        }
        Spacer(Modifier.height(16.dp))
    }
}

@Composable
fun HomeSection(
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(modifier) {
        Text(
            text = stringResource(title),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .paddingFromBaseline(top = 40.dp, bottom = 16.dp)
        )
        content()
    }
}
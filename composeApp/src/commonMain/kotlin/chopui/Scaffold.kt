package chopui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import cafe.adriel.voyager.navigator.Navigator

@Composable
fun Scaffold(
    title: String = "Ahoy Scaffold!",
    navigator: Navigator? = null,
    modifier: Modifier = Modifier,
    floatingAction: (() -> Unit)? = null,
    fabIcon: ImageVector = Icons.Filled.Add,
    fabDescription: String = "Add",
    content: @Composable (PaddingValues) -> Unit,
) {
    val fab: @Composable () -> Unit = if (floatingAction != null) {
        {
            FloatingActionButton(onClick = floatingAction) {
                Icon(
                    fabIcon,
                    contentDescription = fabDescription
                )
            }
        }
    } else {
        { }
    }

    val navIcon: @Composable (() -> Unit)? = if (navigator != null) {
        {
            IconButton(onClick = { navigator.pop() }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "back"
                )
            }
        }
    } else {
        null
    }

    Scaffold(
        topBar = { TopAppBar(title = { Text(title) }, navigationIcon = navIcon) },
        floatingActionButton = fab,
        content = content,
        modifier = modifier
    )
}
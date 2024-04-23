import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import com.example.ExampleDb
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.kodein.di.DI
import org.kodein.di.bindProvider
import org.kodein.di.compose.withDI
import org.kodein.di.instance
import ui.HomeModel
import ui.HomeScreen

val di = DI {
    bindProvider {
        ExampleDb(
            driver = DatabaseDriverFactory().create()
        )
    }
    bindProvider { ExampleDataSource(instance()) }
    bindProvider { HomeModel(instance()) }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun App() = withDI(di) {
    MaterialTheme {
        // val db = YourDatabaseName.Schema.create(sqlDriver)
        Navigator(HomeScreen()) { navigator ->
            SlideTransition(navigator)
        }
    }
}
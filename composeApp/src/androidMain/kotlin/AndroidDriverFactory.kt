import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.bollwerks.sqldem.MainActivity
import com.example.ExampleDb

actual class DatabaseDriverFactory {
    actual fun create(): SqlDriver =
        AndroidSqliteDriver(
            ExampleDb.Schema,
            MainActivity.applicationContext(),
            "DATABASE_NAME"
        )
}
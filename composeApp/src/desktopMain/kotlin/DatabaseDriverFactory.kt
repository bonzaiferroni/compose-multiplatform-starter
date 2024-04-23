import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import com.example.ExampleDb
import java.io.File

actual class DatabaseDriverFactory {
    actual fun create(): SqlDriver {
        // "jdbc:sqlite:example.db"
        // val dbFile = File("example.db")
        // val driver: SqlDriver = JdbcSqliteDriver(dbFile.absolutePath)
        val driver: SqlDriver = JdbcSqliteDriver("jdbc:sqlite:../example.db")
        // val driver: SqlDriver = JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY)
        ExampleDb.Schema.create(driver)
        return driver
    }
}
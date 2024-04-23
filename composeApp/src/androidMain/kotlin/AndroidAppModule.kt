import android.content.Context
import com.example.ExampleDb

class AndroidAppModule(
    private val context: Context,
) : AppModule {
    private val db by lazy {
        ExampleDb(
            driver = DatabaseDriverFactory(context).create()
        )
    }

    override fun provideExampleDataSource() = ExampleDataSource(db)
}
import com.example.ExampleDb

class DesktopAppModule : AppModule {
    private val db by lazy {
        ExampleDb(
            driver = DatabaseDriverFactory().create()
        )
    }

    override fun provideExampleDataSource() = ExampleDataSource(db)
}
package ui

import ExampleDataSource
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.example.ExampleEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeModel(
    val exampleDataSource: ExampleDataSource
) : ScreenModel {
    private val _entities: MutableState<List<ExampleEntity>> = mutableStateOf(emptyList())
    val entities: MutableState<List<ExampleEntity>> = _entities

    private val _counter = mutableStateOf(0)
    val counter = _counter

    private val _entityName = mutableStateOf("")
    val entityName = _entityName

    init {
        screenModelScope.launch {
            exampleDataSource.getAll().collect {
                println("collecting ${it.count()}")
                _entities.value = it
            }
        }
    }

    fun growCounter() {
        _counter.value += 1
    }

    fun onEntityNameChange(value: String) {
        _entityName.value = value
    }

    fun addEntity() {
        screenModelScope.launch(Dispatchers.Main) {
            exampleDataSource.insert(id = null, name = entityName.value)
        }
    }
}
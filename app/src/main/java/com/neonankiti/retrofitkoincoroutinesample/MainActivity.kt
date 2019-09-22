package com.neonankiti.retrofitkoincoroutinesample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.android.scope.currentScope

class MainActivity : AppCompatActivity() {


    private val bisonUseCase by currentScope.inject<BisonUseCase>()

    private val placeView get() = findViewById<TextView>(R.id.place)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        placeView.text = bisonUseCase.move()
    }
}

interface AnimalRepository {
    fun getMovement(): String
}

class BisonRepositoryImpl : AnimalRepository {
    override fun getMovement() = "move to Yellow Stone National Park."
}

// not create interface for Usecase this time.
class BisonUseCase(private val repo: AnimalRepository) {
    fun move() = repo.getMovement()
}

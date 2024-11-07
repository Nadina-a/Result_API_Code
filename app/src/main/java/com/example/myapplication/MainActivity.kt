package com.example.myapplication

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    companion object{
        const val  AGE_KEY : String="AGE" //константа для передачи данных о возрасте во второе активити
        const val ACCESS_MESSAGE = "ACCESS_MESSAGE" // Константа для передачи сообщения из второго активити
    }
    var mStartForResult:ActivityResultLauncher<Intent?>?=  //Объявляет переменную mStartForResult типа ActivityResultLauncher<Intent?>?, которая будет использоваться для запуска второй активности и получения результата от нее.
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ //registerForActivityResult() - метод для создания ActivityResultLauncher. Он принимает два аргумента:
            result -> val textView=findViewById<TextView>(R.id.editText)  // лямбда-выражение, которое выполняется при получении результата из второй активности.

            if (result.resultCode== RESULT_OK) {
                val intent: Intent? = result.data //получает Intent, переданный из второй активности, в который были вложены данные.

                val accessMessage: String? =
                    intent!!.getStringExtra(ACCESS_MESSAGE) //извлекает сообщение об ошибке доступа из Intent, используя ключ ACCESS_MESSAGE
                textView.text=accessMessage
            }else{
                textView.text="Ошибка доступа"
            }
        }


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener(){
            var ageBox = findViewById<EditText>(R.id.editText)
            var age: String = ageBox.text.toString() // заносим в переменную данные из EditText
            var intent:Intent = Intent(this@MainActivity, MainActivity2::class.java)
            intent.putExtra(AGE_KEY, age) // добавляет в Intent данные о возрасте (age) с ключом AGE_KEY

            mStartForResult?.launch(intent)//запускает MainActivity2 с помощью mStartForResult и передает Intent с данными о возрасте.
        } } }







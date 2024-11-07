package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val grantClick = findViewById<Button>(R.id.button2)
        val denyClick = findViewById<Button>(R.id.button3)
        val notValidClick = findViewById<Button>(R.id.button4)
        val cancelClick = findViewById<Button>(R.id.button5)


        var extras:Bundle? = intent.extras //Объявляет переменную extras типа Bundle? для хранения данных, переданных через Intent.
        //intent.extras получает Bundle с дополнительными данными, которые были переданы из предыдущей активности.
        if(extras!=null){
            var textViewAge = findViewById<TextView>(R.id.textView)
            var age : String? = extras.getString(MainActivity.AGE_KEY)//Извлекает значение строки из Bundle по ключу MainActivity.AGE_KEY, который был определен в MainActivity.
            //Значение сохраняется в переменную age типа String?, что означает, что оно может быть null, если ключ не найден в Bundle.
            if(age!=null){
                textViewAge.text = age
            }

            fun sendMessage(message: String){
                var data: Intent=Intent() //создает Intent для возврата результата
                data.putExtra(MainActivity.ACCESS_MESSAGE, message)//добавляет в Intent сообщение с ключом MainActivity.ACCESS_MESSAGE.
                setResult(RESULT_OK,data)// устанавливает результат как RESULT_OK и передает Intent с сообщением.
                finish()// закрывает текущую Activity.
            }

            grantClick.setOnClickListener(){
                sendMessage("Разрешение на доступ")

            }
            denyClick.setOnClickListener(){
                sendMessage("Доступ запрещён")

            }
            notValidClick.setOnClickListener(){
                sendMessage("Возраст недействителен")
            }
            cancelClick.setOnClickListener(){
                setResult(RESULT_CANCELED)// результат операции отменен
                finish()
            } } } }

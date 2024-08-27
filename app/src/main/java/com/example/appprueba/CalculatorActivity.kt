package com.example.appprueba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class CalculatorActivity : AppCompatActivity() {
    var resultado = 0;
    var contador = 0;
    var cuenta = "";
    var cuenta2 = "";
    var all = "";
    var simbol = "";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calculator_main)
        findViewById<Button>(R.id.btnMas).setOnClickListener {
            var new = findViewById<TextView>(R.id.btnMas).text.toString();
            addAll(new);
        }
        findViewById<Button>(R.id.btnMenos).setOnClickListener {
            var new = findViewById<TextView>(R.id.btnMenos).text.toString();
            addAll(new);
        }
        findViewById<Button>(R.id.btnErase).setOnClickListener {
            removeLastAll();
        }
        findViewById<Button>(R.id.btnIgual).setOnClickListener {
            setResultado();
        }
        findViewById<Button>(R.id.btnMult).setOnClickListener {
            var new = findViewById<TextView>(R.id.btnMult).text.toString();
            addAll(new);
        }
        findViewById<Button>(R.id.btnDiv).setOnClickListener {
            var new = findViewById<TextView>(R.id.btnDiv).text.toString();
            addAll(new);
        }
        findViewById<Button>(R.id.btn1).setOnClickListener {
            var new = findViewById<TextView>(R.id.btn1).text.toString();
            addAll(new);
        }
        findViewById<Button>(R.id.btn2).setOnClickListener {
            var new = findViewById<TextView>(R.id.btn2).text.toString();
            addAll(new);
        }
        findViewById<Button>(R.id.btn3).setOnClickListener {
            var new = findViewById<TextView>(R.id.btn3).text.toString();
            addAll(new);
        }
        findViewById<Button>(R.id.btn4).setOnClickListener {
            var new = findViewById<TextView>(R.id.btn4).text.toString();
            addAll(new);
        }
        findViewById<Button>(R.id.btn5).setOnClickListener {
            var new = findViewById<TextView>(R.id.btn5).text.toString();
            addAll(new);
        }
        findViewById<Button>(R.id.btn6).setOnClickListener {
            var new = findViewById<TextView>(R.id.btn6).text.toString();
            addAll(new);
        }
        findViewById<Button>(R.id.btn7).setOnClickListener {
            var new = findViewById<TextView>(R.id.btn7).text.toString();
            addAll(new);
        }
        findViewById<Button>(R.id.btn8).setOnClickListener {
            var new = findViewById<TextView>(R.id.btn8).text.toString();
            addAll(new);
        }
        findViewById<Button>(R.id.btn9).setOnClickListener {
            var new = findViewById<TextView>(R.id.btn9).text.toString();
            addAll(new);
        }
    }

    fun addAll(newItem: String) {
        all += newItem.toString();
        setCuenta();
    }

    fun removeLastAll() {
        if (all.isNotEmpty()) {
            all = all.dropLast(1);
        }
        setCuenta();
    }

    fun addCuenta(newNumber: Int) {
        cuenta += newNumber.toString();
    }

    fun removeLast() {
        if (cuenta.isNotEmpty()) {
            cuenta = cuenta.dropLast(1);
        }
    }

    fun addCuenta2(newNumber: Int) {
        cuenta2 += newNumber.toString();
    }

    fun removeLast2() {
        if (cuenta2.isNotEmpty()) {
            cuenta2 = cuenta2.dropLast(1);
        }
    }

    fun setCuenta() {
        findViewById<TextView>(R.id.txtAll).setText(all);
    }

    fun setResultado() {
        findViewById<TextView>(R.id.txtResult).setText("Result: ${Total()}");
        findViewById<TextView>(R.id.txtAll).setText("");
    }

    fun Total(): Int {
        //val expression = "12+34-5"  // Ejemplo de cadena de operaciones
        return evaluateExpression(all)
    }

    fun evaluateExpression(expression: String): Int {
        var currentNumber = ""
        var currentOperator = '+'

        for (char in expression) {
            when {
                char.isDigit() -> currentNumber += char  // Agrega dígitos al número actual
                char in "+-*/" -> {
                    resultado = performOperation(resultado, currentNumber.toInt(), currentOperator)
                    currentOperator = char  // Actualiza el operador actual
                    currentNumber = ""  // Resetea el número actual
                }
            }
        }

        // Procesa el último número
        resultado = performOperation(resultado, currentNumber.toInt(), currentOperator)
        return resultado
    }

    fun performOperation(left: Int, right: Int, operator: Char): Int {
        return when (operator) {
            '+' -> left + right
            '-' -> left - right
            '*' -> left * right
            '/' -> left / right
            else -> left
        }
    }
}

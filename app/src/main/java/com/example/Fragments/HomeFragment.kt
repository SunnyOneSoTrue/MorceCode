package com.example.fragments.Fragments

import androidx.fragment.app.Fragment
import com.example.signsloginfinall.R
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText


class HomeFragment : Fragment(R.layout.fragment_home) {


    private lateinit var btndecode: Button
    private lateinit var outPutView : EditText
    private lateinit var etinput: EditText
    private lateinit var btnclear: Button


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btndecode = view.findViewById(R.id.btndecode)
        outPutView = view.findViewById(R.id.etoutput)
        etinput = view.findViewById(R.id.etinput)
        btnclear = view.findViewById(R.id.btnclear)

        translateButton()
        clearButton()

    }
    private fun translateButton(){
        btndecode.setOnClickListener {
            val output = textToMorse(etinput.text.toString())
            outPutView.setText(output).toString()

        }
    }
    private fun clearButton() {
        btnclear.setOnClickListener {
            etinput.setText(null)
            outPutView.setText(null)

        }

    }
    private fun textToMorse(s: String): String {
        val morseArr = s.map { value -> convertCharToMorse(value) }
        (morseArr.joinToString(" "))


        return (morseArr.joinToString(" "))
    }


    private fun convertCharToMorse(c: Char) = when (c.toLowerCase()) {
        'a' -> ".-"
        'b' -> "-..."
        'c' -> "-.-."
        'd' -> "-.."
        'e' -> "."
        'f' -> "..-."
        'g' -> "--."
        'h' -> "...."
        'i' -> ".."
        'j' -> ".---"
        'k' -> "-.-"
        'l' -> ".-.."
        'm' -> "--"
        'n' -> "-."
        'o' -> "---"
        'p' -> ".--."
        'q' -> "--.-"
        'r' -> ".-."
        's' -> "..."
        't' -> "-"
        'u' -> "..-"
        'v' -> "...-"
        'w' -> ".--"
        'x' -> "-..-"
        'y' -> "-.--"
        'z' -> "--.."
        '1' -> ".----"
        '2' -> "..---"
        '3' -> "...--"
        '4' -> "....-"
        '5' -> "....."
        '6' -> "-...."
        '7' -> "--..."
        '8' -> "---.."
        '9' -> "----."
        '0' -> "-----"
        else -> throw IllegalArgumentException("Not all characters are valid")
    }

}
package com.example.fragments.Fragments

import androidx.fragment.app.Fragment
import com.example.signsloginfinall.R
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class HomeFragment : Fragment(R.layout.fragment_home) {


    private lateinit var btndecode: Button
    private lateinit var outPutView : EditText
    private lateinit var etinput: EditText
    private lateinit var btnclear: Button
    private lateinit var changeButton: Button
    private var state:String = "T2S"


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btndecode = view.findViewById(R.id.btndecode)
        outPutView = view.findViewById(R.id.etoutput)
        etinput = view.findViewById(R.id.etinput)
        btnclear = view.findViewById(R.id.btnclear)
        changeButton = view.findViewById(R.id.changeButton)

        translateButton()
        clearButton()
        changeButton()
    }

    private fun translateButton(){
        btndecode.setOnClickListener {
            val output:String
            if(state=="T2S") {
                output = textToSypher(etinput.text.toString())
            }
            else{
                output = sypherToText((etinput.text.toString()))
            }
            outPutView.setText(output).toString()

        }
    }

    private fun clearButton() {
        btnclear.setOnClickListener {
            etinput.setText(null)
            outPutView.setText(null)
        }
    }

    private fun changeButton(){
        changeButton.setOnClickListener{
            if(state=="T2S") {
                state = "S2T"
                changeButton.setText("Sypher To Text")
            }
            else{
                state = "T2S"
                changeButton.setText("Text To Sypher")
            }
        }
    }

    private fun textToSypher(s: String): String {
        val morseArr = s.map { value -> convertCharToSypher(value) }
        morseArr.joinToString(" ")

        return morseArr.joinToString(" ")
    }

    private fun sypherToText(s:String): String{
        val strs = s.split(" ").toTypedArray()
        val letterArray= strs.map {value -> convertSypherToChar(value) }

        return letterArray.joinToString(" ")
    }

    private fun convertCharToSypher(c: Char) = when (c.toLowerCase()) {
        'ა' -> " არვეზ"
        'ბ' -> " ბაკმუნდ"
        'გ' -> " გერვაზ"
        'დ' -> " დაკმი"
        'ე' -> " ეხმუტ"
        'ვ' -> " ვარმა"
        'ზ' -> " ზორო"
        'თ' -> " თაკრო"
        'ი' -> " ირმაზ"
        'კ' -> " კოხრო"
        'ლ' -> " ლამლი"
        'მ' -> " მაშნი"
        'ნ' -> "  ნიშხო"
        'ო' -> "  ორლო"
        'პ' -> "  პახმად"
        'ჟ' -> " ჟემჟემ"
        'რ' -> " როხროხ"
        'ს' -> " სამპა"
        'ტ' -> " ტიხრიხ"
        'უ' -> " ულმოდ"
        'ფ' -> " ფაშრუ"
        'ქ' -> " ქაღლაშ"
        'ღ' -> " ღიშმიშ"
        'ყ' -> " ყალა"
        'შ' -> " შიჭა"
        'ც' -> " ცუპრუ"
        'ძ' -> " ძაწო"
        'წ' -> " წოღრა"
        'ჭ' -> " ჭილა"
        'ხ' -> " ხოხო"
        'ჯ' -> " ჯაყრუ"
        'ჰ' -> " ჰერი"
        '1' -> " თერი"
        '2' -> " რიო"
        '3' -> " ისმა"
        '4' -> " ხითო"
        '5' -> " თიხუ"
        '6' -> " ქვესი"
        '7' -> " ვიშიდ"
        '8' -> "არვ"
        '9' -> " არცხ"
        '0' -> " ილუნ"
        ' ' -> " "

        else -> Toast.makeText(requireContext(),"not all characters are valid", Toast.LENGTH_SHORT ).show()
    }

    private fun convertSypherToChar(c: String):Any = when (c.toLowerCase()){
        "არვეზ" -> 'ა'
        "ბაკმუნდ" ->  'ბ'
        "გერვაზ" -> 'გ'
        "დაკმი" ->'დ'
        "ეხმუტ" -> 'ე'
        "ვარმა" -> 'ვ'
        "ზორო"->  'ზ'
        "თაკრო"-> 'თ'
        "ირმაზ"-> 'ი'
        "კოხრო"-> 'კ'
        "ლამლი"-> 'ლ'
        "მაშნი"-> 'მ'
        "ნიშხო" -> 'ნ'
        "ორლო" ->'ო'
        "პახმად"->  'პ'
        "ჟემჟემ" -> 'ჟ'
        "როხროხ"-> 'რ'
        "სამპა" -> 'ს'
        "ტიხრიხ" ->  'ტ'
        "ულმოდ" -> 'უ'
        "ფაშრუ" ->'ფ'
        "ქაღლაშ"-> 'ქ'
        "ღიშმიშ" -> 'ღ'
        "ყალა"-> 'ყ'
        "შიჭა" -> 'შ'
        "ცუპრუ"-> 'ც'
        "ძაწო"-> 'ძ'
        "წოღრა"-> 'წ'
        "ჭილა" -> 'ჭ'
        "ხოხო" -> 'ხ'
        "ჯაყრუ"->  'ჯ'
        "ჰერი"-> 'ჰ'
        "თერი" -> '1'
        "რიო" -> '2'
        "ისმა" -> '3'
        "ხითო" -> '4'
        "თიხუ" -> '5'
        "ქვესი" ->'6'
        "ვიშიდ" -> '7'
        "არვ" -> '8'
        "არცხ"->  '9'
        "ილუნ" -> '0'

        else -> Toast.makeText(requireContext(), "incorrect input", Toast.LENGTH_SHORT).show()
    }

}
package com.example.signsloginfinall

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class ResetActivity : AppCompatActivity() {

    private lateinit var resetEmilInput: EditText
    private lateinit var resetSendEmailButton: Button

    private lateinit var mAth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset)

        mAth = FirebaseAuth.getInstance()

        resetEmilInput = findViewById(R.id.resetEmailEditText)
        resetSendEmailButton = findViewById(R.id.resetSendButton)

        resetSendEmailButton.setOnClickListener{
            val email = resetEmilInput.text.toString()
            if(email.isEmpty()){
                Toast.makeText(this, "ველი ცარიელია, სცადეთ ხელახლა.",Toast.LENGTH_LONG).show()
            } else{
                mAth.sendPasswordResetEmail(email).addOnCompleteListener { task ->
                    if (task.isSuccessful){
                        startActivity(Intent(this, MainActivity::class.java))
                        finish()
                    }
                }
            }
        }

    }
}
package com.example.fragments.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.signsloginfinall.MainActivity
import com.example.signsloginfinall.PasswordChangeActivity
import com.example.signsloginfinall.R
import com.google.firebase.auth.FirebaseAuth

class PersonFragment : Fragment(R.layout.fragment_person) {
    private lateinit var goToPasswordChangeButton: Button
    private lateinit var logoutButton: Button

    private lateinit var mAuth: FirebaseAuth
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        goToPasswordChangeButton = view.findViewById(R.id.goToPasswordChangeButton)
        logoutButton = view.findViewById(R.id.logOutButton)

        mAuth = FirebaseAuth.getInstance()


        goToPasswordChangeButton.setOnClickListener {
            val intent = Intent(getActivity(), PasswordChangeActivity::class.java)
            getActivity()?.startActivity(intent)
        }
        logoutButton.setOnClickListener {
            val intent = Intent(getActivity(), MainActivity::class.java)
            getActivity()?.startActivity(intent)
            mAuth.signOut()


        }
    }
}

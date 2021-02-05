package com.example.signsloginfinall

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.fragments.Fragments.HomeFragment
import com.example.fragments.Fragments.PersonFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class PersonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person)


        val firstFragments = HomeFragment()
        val secFragment = PersonFragment()

        setCurrentFragment(firstFragments)


        val nav_view: BottomNavigationView = findViewById(R.id.nav_view)
        nav_view.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home->setCurrentFragment(firstFragments)
                R.id.personRoom->setCurrentFragment(secFragment)

            }
            true
        }

    }

    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.nav_host_fragment,fragment)
            commit()




    }
}
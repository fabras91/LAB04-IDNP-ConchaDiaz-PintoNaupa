package com.example.fragmentsamplelab04

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {
    private lateinit var txtNombres:TextView;
    private lateinit var txtEmail:TextView;
    private lateinit var txtPhone:TextView;
    private lateinit var txtUser:TextView;
    private lateinit var txtPassword:TextView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        txtNombres = findViewById<TextView>(R.id.textName)
        txtEmail = findViewById<TextView>(R.id.textEmail)
        txtPhone= findViewById<TextView>(R.id.textPhone)
        txtUser= findViewById<TextView>(R.id.textUsuario)
        txtPassword= findViewById<TextView>(R.id.textPassword)

        val registerFragment=RegisterFragment.newInstance(response)
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.frameLayout, registerFragment)
        }

    }

    val response: (User) -> Unit = { user ->
        txtNombres.text=user.name
        txtEmail.text=user.email
        txtPhone.text=user.phone
        txtUser.text=user.username
        txtPassword.text=user.password

    }
}
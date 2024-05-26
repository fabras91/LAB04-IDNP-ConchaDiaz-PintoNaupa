package com.example.fragmentsamplelab04

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RegisterFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegisterFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_register, container, false)
        val btnAceptar= view.findViewById<Button>(R.id.btnAceptar)
        val edtNames=view.findViewById<TextView>(R.id.edtName)
        val edtEmail=view.findViewById<TextView>(R.id.edtEmail)
        val edtPhone=view.findViewById<TextView>(R.id.edtPhone)
        val edtUser= view.findViewById<TextView>(R.id.edtUser)
        val edtPassword= view.findViewById<TextView>(R.id.edtPassword)

        btnAceptar.setOnClickListener {
            val user = User(
                name = edtNames.text.toString(),
                email = edtEmail.text.toString(),
                phone = edtPhone.text.toString(),
                username = edtUser.text.toString(),
                password = edtPassword.text.toString()
            )
            clickBtnAceptar(user)
    }

        return view
    }

    companion object {
        private lateinit var clickBtnAceptar: (User) -> Unit

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(clickBtnAceptar: (User)->Unit): RegisterFragment{
            val registerFragment= RegisterFragment()
            this.clickBtnAceptar= clickBtnAceptar
            return registerFragment
        }
        /*
        fun newInstance(param1: String, param2: String) =
            RegisterFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
         */
    }
}

package com.example.latihanfirebase.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.latihanfirebase.R
import com.example.latihanfirebase.ShowActivity
import com.example.latihanfirebase.User
import com.example.latihanfirebase.databinding.FragmentHomeBinding
import com.example.latihanfirebase.databinding.FragmentUserBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class HomeFragment : Fragment() {

    private  var _binding : FragmentHomeBinding? = null
    private lateinit var database : DatabaseReference
    private val Binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return Binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Binding.buttonShow.setOnClickListener {
            val intent = Intent(context,ShowActivity::class.java)
            startActivity(intent)
        }

        Binding.buttonAdd.setOnClickListener {
            database= FirebaseDatabase.getInstance().getReference("Users")
            var nama = Binding.Nama.text.toString()
            var umur = Binding.Umur.text.toString()

            if (nama.isEmpty()){
                _binding?.Nama?.error ?:   "Email Harus Diisi"
                _binding?.Nama?.requestFocus()
                return@setOnClickListener
            }
            if (umur.isEmpty()){
                _binding?.Umur?.error ?:  "umur Harus Diisi"
                _binding?.Umur?.requestFocus()
                return@setOnClickListener
            }

            val db = database.push().key!!
            val user = User(nama,umur)
            database.child(nama).setValue(user)
                .addOnCompleteListener {
                    Toast.makeText(context,"success", Toast.LENGTH_SHORT).show()
                    Binding.Nama.text.clear()
                    Binding.Umur.text.clear()
                }.addOnFailureListener{ err ->
                    Toast.makeText(context,"fail", Toast.LENGTH_SHORT).show()
                }
        }
    }


}
package com.example.latihanfirebase

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.latihanfirebase.databinding.ActivityShowBinding
import com.example.latihanfirebase.rvAdapater
import com.google.firebase.database.*
import org.w3c.dom.Text

class ShowActivity : AppCompatActivity() {
    private lateinit var CardView : CardView
    private lateinit var userArrayList: ArrayList<User>
    private lateinit var database : DatabaseReference
    private lateinit var Binding : ActivityShowBinding
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Binding = ActivityShowBinding.inflate(layoutInflater)
        setContentView(Binding.root)

            Binding.rvlist.layoutManager = LinearLayoutManager(this)
            Binding.rvlist.setHasFixedSize(true)
            userArrayList = arrayListOf<User>()
            getUserData()

        // CardView = findViewById(R.id.cardviewitem)

//        CardView.setOnClickListener {
//
//            var nama : TextView
//            var umur : TextView
//
//            nama = findViewById(R.id.tvnama)
//            umur = findViewById(R.id.tvumur)
//
//            var put_nama : String
//            var put_umur : String
//
//            put_nama = nama.text.toString()
//            put_umur = umur.text.toString()
//
//            val intent = Intent(this,ListShowActivity::class.java).also {
//                intent.putExtra("nama",put_nama)
//                intent.putExtra("umur",put_umur)
//
//                startActivity(intent)
//            }
//
//        }


    }

    private fun getUserData() {
        database = FirebaseDatabase.getInstance().getReference("Users")
        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    for(userSnapshot in snapshot.children){
                        val user = userSnapshot.getValue(User::class.java)
                        userArrayList.add(user!!)

                    }
                    Binding.rvlist.adapter = rvAdapater(userArrayList)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

    }
}
package com.example.kotlinviewpager2andindicators

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.example.kotlinviewpager2andindicators.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding  : ActivityMainBinding
    private var personList = mutableListOf<Person>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Ocultar action bar
        supportActionBar?.hide()

        setList()
        binding.viewPager.adapter = ViewPagerAdapter(personList)
        binding.viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        //SET INDICATOR
        binding.indicator.setViewPager(binding.viewPager)


        //Hacer funcionar boton next para simular un SWIT falso
        binding.next.setOnClickListener {
            binding.viewPager.apply {
                beginFakeDrag()
                fakeDragBy(-10f)
                endFakeDrag()
            }
        }


    }


    fun setList(){
        personList.add(Person("Elon Musk", R.drawable.elon))
        personList.add(Person("Vladimir Putin", R.drawable.putin))
        personList.add(Person("Donald Trump", R.drawable.trump))
    }



}
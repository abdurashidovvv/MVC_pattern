package com.abdurashidov.mvc_pattern

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.abdurashidov.mvc_pattern.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity(), Observer, View.OnClickListener {

    var myModel:Model?=null
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myModel= Model()
        myModel?.addObserver(this)

        binding.apply {
            btn1.setOnClickListener(this@MainActivity)
            btn2.setOnClickListener(this@MainActivity)
            btn3.setOnClickListener(this@MainActivity)
        }
    }

    @SuppressLint("SetTextI18n")
    override fun update(o: Observable?, arg: Any?) {
        binding.apply {
            btn1.text="Count: "+myModel?.getValueAtIndex(0)
            btn2.text="Count: "+myModel?.getValueAtIndex(1)
            btn3.text="Count: "+myModel?.getValueAtIndex(2)
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_1->myModel?.setValueAtIndex(0)
            R.id.btn_2->myModel?.setValueAtIndex(1)
            R.id.btn_3->myModel?.setValueAtIndex(2)
        }
    }
}

//MVC patterniga kichik loyiha
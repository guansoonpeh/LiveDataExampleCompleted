package com.example.livedataexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.livedataexample.databinding.ActivityMainBinding
import com.example.livedataexample.models.AccountModel


class MainActivity : AppCompatActivity() {

    private val myAccout = AccountModel("A1234566","John", 500.00)
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //myAccout.balance.observe(this, Observer{newBalance -> binding.tvBalance.text = newBalance.toString()  })
        //myAccout.name.observe(this, Observer{newBalance -> binding.tvBalance.text = newBalance.toString()  })
        //myAccout.accNo.observe(this, Observer{newBalance -> binding.tvBalance.text = newBalance.toString()  })

        binding =  DataBindingUtil.setContentView(this, R.layout.activity_main)
        display()
        binding.myAccount = myAccout
        binding.lifecycleOwner = this

        binding.btnDeposit.setOnClickListener(){
            val amount:Double  = binding.tfAmount.text.toString().toDouble()

            myAccout.deposit(amount)

           // myAccout.balance.value = -1000.00

          //  binding.tvBalance.text  = myAccout.balance.toString()

        }

        binding.btnWitdraw.setOnClickListener(){
            val amount:Double  = binding.tfAmount.text.toString().toDouble()
            myAccout.withdraw(amount)

          //  binding.tvBalance.text  = myAccout.balance.toString()
        }
    }

    fun display(){

        binding.tvAccNo.text = myAccout.accNo
        binding.tvName.text = myAccout.owner
        binding.tvBalance.text = myAccout.balance.value.toString()

    }


}
package br.com.antoniocgrande.dslib

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initListeners()
    }

    private fun initListeners() {
//        buttonAdjustableRounded1.setOnClickListener {
//            toast(this, (it as DsButtonAdjustableRounded).text)
//        }
//
//        buttonAdjustableRounded2.setOnClickListener {
//            toast(this, (it as DsButtonAdjustableRounded).text)
//        }
//
//        buttonAdjustableRounded3.setOnClickListener {
//            toast(this, (it as DsButtonAdjustableRounded).text)
//        }
//
//        buttonAdjustableRounded4.setOnClickListener {
//            toast(this, (it as DsButtonAdjustableRounded).text)
//        }
//
//        buttonRounded1.setOnClickListener {
//            toast(this, (it as DsButtonRounded).text)
//        }
//
//        buttonRounded2.setOnClickListener {
//            toast(this, (it as DsButtonRounded).text)
//        }
//
//        buttonRounded3.setOnClickListener {
//            toast(this, (it as DsButtonRounded).text)
//        }
    }

    private fun toast(context: Context, text: CharSequence) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }
}
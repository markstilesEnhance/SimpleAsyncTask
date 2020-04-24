package com.example.simpleasynctask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var mTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mTextView = findViewById(R.id.textView1)
        if(savedInstanceState != null) {
            mTextView.text = savedInstanceState.getString("currentText")
        }
    }

    fun startTask(view: View) {
        mTextView.text = getText(R.string.napping)
        SimpleAsyncTask(mTextView).execute()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("currentText", mTextView.text as String?)
    }
}

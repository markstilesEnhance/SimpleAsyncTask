package com.example.simpleasynctask

import android.os.AsyncTask
import android.widget.TextView
import java.lang.ref.WeakReference
import java.util.*

open class SimpleAsyncTask(): AsyncTask<Void, Void, String>() {

    lateinit var mTextView: WeakReference<TextView>

    constructor(tView: TextView) : this() {
        mTextView = WeakReference(tView)
    }

    override fun doInBackground(vararg params: Void?): String {
        val r = Random()
        val s = 200 * r.nextInt(11)
        try{
            Thread.sleep(s.toLong())
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
        return "Awake at last after sleeping for $s milliseconds!"
    }

    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)
        mTextView.get()?.text = result
    }

}
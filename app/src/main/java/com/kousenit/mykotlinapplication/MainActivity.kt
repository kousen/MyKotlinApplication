package com.kousenit.mykotlinapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.net.URL

class MainActivity : AppCompatActivity() {
    companion object {
        const val BASE_URL = "http://api.icndb.com/jokes/random?limitTo=[nerdy]"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    @Suppress("UNUSED_PARAMETER")
    fun tellJoke(v: View) {
        getJoke()
    }

    private fun getJoke(first: String = "Brian", last: String = "Goetz") {
        val url = "$BASE_URL&firstName=$first&lastName=$last"
        val gson = Gson()
        doAsync {
            val jsonTxt = URL(url).readText()
            uiThread {
                val result = gson.fromJson(jsonTxt, IcndbResult::class.java)
                hello.text = result.value.joke
            }
        }
    }
}

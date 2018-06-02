package com.example.diploma.khaiid

import org.json.JSONArray
import org.json.JSONException
import okhttp3.OkHttpClient
import com.google.gson.Gson
import android.os.AsyncTask
import android.widget.AutoCompleteTextView
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import okhttp3.Request
import java.io.IOException

class SearchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.search_activity)


        var mAutoCompleteTextView = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)
        mAutoCompleteTextView.setThreshold(1)

        UserRequest().execute()
    }

     inner class UserRequest : AsyncTask<Void, Void, JSONArray>() {
        override fun doInBackground(vararg voids: Void): JSONArray? {
            val request = OkHttpJsonArrayRequest()
            try {
                return request["https://my-json-server.typicode.com/valeriypolezhay/DiplomaV2/users"]
            } catch (e: IOException) {
                e.printStackTrace()
            } catch (e: JSONException) {
                e.printStackTrace()
            }

            return null
        }

        override fun onPostExecute(jsonArray: JSONArray?) {
            super.onPostExecute(jsonArray)
            if (jsonArray != null && jsonArray.length() > 0) {
                val gson = Gson()
                val users = gson.fromJson<User>(jsonArray.toString(), User::class.java)
//               var mUserList = Arrays.asList(users)
               var mUserList = listOf(users)
               var mUserArrayAdapter = AutoCompleteAdapter(mContext, R.layout.search_activity, mUserList)
               mAutoCompleteTextView.setAdapter(mUserArrayAdapter)
            }
        }
    }

    private inner class OkHttpJsonArrayRequest {
        internal var client = OkHttpClient()
        // HTTP GET REQUEST
        @Throws(IOException::class, JSONException::class)
        internal operator fun get(url: String): JSONArray {
            val request = Request.Builder()
                    .url(url)
                    .build()
            val response = client.newCall(request).execute()
            return JSONArray(response.body()?.string())
        }
    }
}
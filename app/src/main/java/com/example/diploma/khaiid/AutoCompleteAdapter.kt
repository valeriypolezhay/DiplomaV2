package com.example.diploma.khaiid

import android.widget.TextView
import android.app.Activity
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Filter

class AutoCompleteAdapter( val mContext: Context, private val mLayoutResourceId: Int, users: List<User>) : ArrayAdapter<User>(mContext, mLayoutResourceId, users) {
    private val mUsers: MutableList<User>
    private val mUsersAll: List<User>

    init {
        this.mUsers = ArrayList(users)
        this.mUsersAll = ArrayList(users)
    }

    override fun getCount(): Int {
        return mUsers.size
    }

    override fun getItem(position: Int): User? {
        return mUsers[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        var convertView = convertView
        try {
            if (convertView == null) {
                val inflater = (mContext as Activity).layoutInflater
                convertView = inflater.inflate(mLayoutResourceId, parent, false)
            }
            val user = getItem(position)
            val name = convertView!!.findViewById<TextView>(R.id.autoCompleteTextView)
            name.setText(user.firstName.en)
            //TODO
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return convertView
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun convertResultToString(resultValue: Any): String {
                return (resultValue as User).firstName.en
            }

            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val filterResults = FilterResults()
                val UsersSuggestion = ArrayList()
                if (constraint != null) {
                    for (department in mUsersAll) {
                        if (department.firstName.en.toLowerCase().startsWith(constraint.toString().toLowerCase())) {
                            UsersSuggestion.add(department)
                        }
                    }
                    filterResults.values = UsersSuggestion
                    filterResults.count = UsersSuggestion.size
                }
                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                mUsers.clear()
                if (results != null && results!!.count > 0) {
                    // avoids unchecked cast warning when using mUsers.addAll((ArrayList<User>) results.values);
                    for (`object` in results!!.values) {

                        if (`object` is User) {
                            mUsers.add(`object` as User)
                        }
                    }
                    notifyDataSetChanged()
                } else if (constraint == null) {
                    // no filter, add entire original list back in
                    mUsers.addAll(mUsersAll)
                    notifyDataSetInvalidated()
                }
            }
        }
    }
}
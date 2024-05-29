//package com.example.satumeja.activity
//
//import android.content.Context
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.BaseAdapter
//import android.widget.TextView
//import com.example.satumeja.R
////import com.example.satumeja.database.UserData
//
//class UserAdapter(private val context: Context, private val users: List<UserData>) : BaseAdapter() {
//
//    override fun getCount(): Int {
//        return users.size
//    }
//
//    override fun getItem(position: Int): Any {
//        return users[position]
//    }
//
//    override fun getItemId(position: Int): Long {
//        return position.toLong()
//    }
//
//    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
//        val user = users[position]
//        val view: View
//
//        if (convertView == null) {
//            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
//            view = inflater.inflate(R.layout.user_item, parent, false)
//        } else {
//            view = convertView
//        }
//
//        val nameTextView = view.findViewById<TextView>(R.id.user_item_name)
//        val nisnTextView = view.findViewById<TextView>(R.id.user_item_nisn)
//
//        nameTextView.text = "Nama: " + user.name
//        nisnTextView.text = "NISN: " + user.nisn
//
//        return view
//    }
//}

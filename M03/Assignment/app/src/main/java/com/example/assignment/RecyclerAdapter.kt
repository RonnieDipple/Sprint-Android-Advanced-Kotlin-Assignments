package com.example.assignment

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recyclerview_item_row.view.*


class SongListAdapter(val songs: List<Song>): RecyclerView.Adapter<SongListAdapter.ViewHolder>(){



    class ViewHolder(view: View): RecyclerView.ViewHolder(view){

        val songTextView = view.tv_songs


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //Using an extension function
        val view = parent.inflate(R.layout.recyclerview_item_row, false)

        return ViewHolder(view)

    }

    override fun getItemCount(): Int {
        return songs.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.songTextView.text = songs[position].songName
}






}
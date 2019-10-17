package com.example.assignment

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.properties.Delegates


/*# Sprint-Android-Advanced-Kotlin-Assignments

## Build an app that switches between music genres and displays a set of songs from the genre in a RecyclerView

## Instructions:

1. Set a project that contains a RecyclerView in the main activity.
2. Store the RecyclerView in a property on your Activity. Do not use a nullable class;
instead think about what option to avoid using nullables makes the most sense for this property.
3. Come up with your own sealed class of songs with subclasses that represent different music genres.
Decide upon properties for the classes, and set up a layout for the items in your RecyclerView to display these properties.


4. Set up lists of objects that contain songs from the different genres.
You can do a search to find songs for each genre
(e.g., [billboard charts](https://en.wikipedia.org/wiki/Billboard_charts#Singles_and_tracks))

5. In your activity, set up a list that will contain the items in the RecyclerView.

6. Set up a menu (either options menu or `NavigationDrawer`) to switch between genres.

7. When the menu item is selected, display the appropriate genre in the list.
Use an `observable` or `vetoable` from `Delegates` to propagate the change to your list of songs.
Also think about how you can change the list and make sure the RecyclerView's adapter is updated whenever the list changes.

## Stretch goals
1. Polish the UI. Consider changing the title bar, updating the color, icons, etc. to make your project more interesting.
2. Find an API that you can use for the songs instead of setting up your own objects.*/
class MainActivity : AppCompatActivity() {


    private lateinit var songsList: List<Song>
    private lateinit var songListAdapter: SongListAdapter

    private val popSongs by lazy {
        listOf(
        Pop("Pop"),
        Pop("Pop Song 2")
        )
    }
    private val rockSongs by lazy {
        listOf(
        Rock("Rock"),
        Rock("Rock Song 2")
        )
    }
    private val hiphopSongs by lazy {
        listOf(
        HipHop("Hiphop"),
        HipHop("Hiphop Song 2")
        )
    }


    private var listType: Song by Delegates.observable(Rock("Testing Rock")) { _, _: Song, new: Song ->
        songsList = when (new) {
            is Pop -> popSongs
            is Rock -> rockSongs
            is HipHop -> hiphopSongs
        }

        recyclerView.adapter = SongListAdapter(songsList)


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        songsList = listOf(Pop("I am a Barbie Girl"))

        //test recycler
        // recyclerView.setBackgroundColor(Color.BLUE)
        ////////////////

        //This function takes a list and then passes it to the recyclerview adapter to be displayed
        initRecyclerView(songsList)
    }

    private fun initRecyclerView(songList: List<Song>){
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            songListAdapter = SongListAdapter(songList)
           adapter = songListAdapter

        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_genre, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        //The final boss
        when(item.itemId){
            R.id.menu_pop -> {listType = Pop("TestPop")}
            R.id.menu_rock -> {listType = Rock("TestRock")}
            R.id.menu_hiphop -> {listType = HipHop("TestHipHop")}
        }



        return super.onOptionsItemSelected(item)
    }
}

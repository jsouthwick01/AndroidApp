package com.example.assignment1

import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.room.Room
import com.example.assignment1.database.Stats
import com.example.assignment1.database.StatsDB
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.lang.reflect.Field

class MainActivity : AppCompatActivity() {
    //A fun collection of public variables so I can actually do some things outside of onCreate. I am lazy so I initialize here instead of onCreate.
    private val baseNum = 10
    var own = Array(baseNum) {'0'} //This is which values we own
    var rollNum = 15
    lateinit var rolltxt:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Gather references to all our things
        val rollButt: Button = findViewById(R.id.button1) //hehe rollbutt.
        val img: ImageView = findViewById(R.id.imageView)
        val txt: TextView = findViewById(R.id.textView)
        rolltxt = findViewById(R.id.textView2)
        val rollPage: FloatingActionButton = findViewById(R.id.floatingActionButton2) //Haven't added functionality to this yet
        val viewPage: FloatingActionButton = findViewById(R.id.floatingActionButton)

        val db = Room.databaseBuilder(
            applicationContext,
            StatsDB::class.java,
            "stat"
        ).allowMainThreadQueries().build()
        val statDao = db.statsDao()
        statDao.insert(Stats(0,rollNum,arrayToString(own)))
        //We will create a base value. For now, all our images will be the same rarity, so it will just be however many images I add
        //In the future I would like to create a mapping so that we can easily map a range of numbers to each image. For now I am just going to create a list for all 10 elements
        //This will save me time now, and since this is still supposed to be relatively basic I don't feel too bad.
        var ref = listOf(R.drawable.img_0,R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,R.drawable.img_4, R.drawable.img_5,R.drawable.img_6,R.drawable.img_7,R.drawable.img_8,R.drawable.img_9)
        //Set our click listener for our roll button
        rollButt.setOnClickListener{
            //When we click the roll button we want to find a random number
            //Then we want to update the image. If it is a new image that we don't have, add it to our collection.
            val num = (0 until baseNum).random()
            img.setImageResource(ref[num])
            //I don't care about screen readers so I am not going to add accessibility stuff, at least for now.
            //Now we will check if we have this one
            if(own[num] == '0')
            {
                txt.text = "Congrats! You got a new bunny!"
                own[num] = '1';

            }
            else
            {
                txt.text = "Bummer, you got a repeat"
            }
            rollNum--
            rolltxt.text = rollNum.toString()
        }

        viewPage.setOnClickListener()
        {
            switchActivities()
        }


    }

    override fun onStop() {
        super.onStop()

        val db = Room.databaseBuilder(
            applicationContext,
            StatsDB::class.java,
            "stat"
        ).allowMainThreadQueries().build()
        val statDao = db.statsDao()
        statDao.updateInfo(Stats(1,rollNum,arrayToString(own)))
    }

    override fun onStart() {
        super.onStart()

        val db = Room.databaseBuilder(
            applicationContext,
            StatsDB::class.java,
            "stat"
        ).allowMainThreadQueries().build()
        val statDao = db.statsDao()
        statDao.insert(Stats(0,rollNum,arrayToString(own)))
        var s: Stats = statDao.getAll()
        rollNum = s.rolls
        val hold = s.data
        stringToArray(hold,own)
        rolltxt.text = rollNum.toString()
        statDao.delete() //shhhhh don't worry about it. This isn't a stupid implementation at all.

    }
    private fun switchActivities() {
        val intent = Intent(this, ViewActivity::class.java)
        //I don't really understand passing data, and since I won't implement it yet I won't worry about it. But this is where that would go.
        startActivity(intent)
    }

    private fun stringToArray(s: String, a: Array<Char>) //currently just using array update by reference but who knows if that will work.
    {
        //Because of how weird for loops are I am just using a while loop
        var i = 0
        while(i < s.length)
        {
            a[i] = s[i]
            i++;
        }
    }

    private fun arrayToString(a:Array<Char>) : String{
        var i = 0;
        var s = ""
        while (i < a.size)
        {
            s+=a[i]
            i++;
        }
        return s
    }


}
package com.example.assignment1

import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.lang.reflect.Field

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Gather references to all our things
        val rollButt: Button = findViewById(R.id.button1) //hehe rollbutt.
        val img: ImageView = findViewById(R.id.imageView)
        val txt: TextView = findViewById(R.id.textView)
        val rollPage: FloatingActionButton = findViewById(R.id.floatingActionButton2) //Haven't added functionality to this yet
        val viewPage: FloatingActionButton = findViewById(R.id.floatingActionButton)
        //We will create a base value. For now, all our images will be the same rarity, so it will just be however many images I add
        val baseNum = 10
        //In the future I would like to create a mapping so that we can easily map a range of numbers to each image. For now I am just going to create a list for all 10 elements
        //This will save me time now, and since this is still supposed to be relatively basic I don't feel too bad.
        var ref = listOf(R.drawable.img_0,R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,R.drawable.img_4, R.drawable.img_5,R.drawable.img_6,R.drawable.img_7,R.drawable.img_8,R.drawable.img_9)
        var own = Array(baseNum) {false} //This is which values we own
        //Set our click listener for our roll button
        rollButt.setOnClickListener{
            //When we click the roll button we want to find a random number
            //Then we want to update the image. If it is a new image that we don't have, add it to our collection.
            val num = (0 until baseNum).random()
            img.setImageResource(ref[num])
            //I don't care about screen readers so I am not going to add accessibility stuff, at least for now.
            //Now we will check if we have this one
            if(own[num])
            {
                txt.text = "Bummer, you got a repeat"
            }
            else
            {
                txt.text = "Congrats! You got a new bunny!"
                own[num] = true;
            }
        }

        viewPage.setOnClickListener()
        {
            switchActivities()
        }


    }

    private fun switchActivities() {
        val intent = Intent(this, ViewActivity::class.java)
        //I don't really understand passing data, and since I won't implement it yet I won't worry about it. But this is where that would go.
        startActivity(intent)
    }


}
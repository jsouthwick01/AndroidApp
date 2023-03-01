package com.example.livelabdemo.data
import com.example.livelabdemo.R
import com.example.livelabdemo.model.Affirmation
class DataSource {
    fun loadAffirmations(): List<Affirmation>
    {
        return listOf<Affirmation>(
            Affirmation(R.string.affirmation1),
            Affirmation(R.string.affirmation2),
            Affirmation(R.string.affirmation3),
            Affirmation(R.string.affirmation4),
            Affirmation(R.string.affirmation5),
            Affirmation(R.string.affirmation6),
            Affirmation(R.string.affirmation7),

        )
    }
}
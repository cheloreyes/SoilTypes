package com.chelo.reyes.soiltypes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.chelo.reyes.soiltypes.ui.main.MainFragment
import com.chelo.reyes.soiltypes.ui.main.classification.ClassificationFragment

class MainActivity : AppCompatActivity(), ActivityCallback {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }

    override fun findClassification(profileType: String) {
        supportFragmentManager.beginTransaction()
            .add(R.id.container, ClassificationFragment.newInstance(profileType))
            .commitNow()
    }
}

interface ActivityCallback {
    fun findClassification(profileType: String)
}
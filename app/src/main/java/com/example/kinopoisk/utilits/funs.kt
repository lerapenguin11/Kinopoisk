package com.example.kinopoisk.utilits

import androidx.fragment.app.Fragment
import com.example.kinopoisk.APP_ACTIVITY
import com.example.kinopoisk.R

fun replaceFragment(fragment: Fragment, addStack: Boolean = true) {
    /* Функция расширения для AppCompatActivity, позволяет устанавливать фрагменты */
    if (addStack) {
        APP_ACTIVITY.supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(
                R.id.frame_layout,
                fragment
            ).commit()
    } else {
        APP_ACTIVITY.supportFragmentManager.beginTransaction()
            .replace(
                R.id.frame_layout,
                fragment
            ).commit()
    }
}
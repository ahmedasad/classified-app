package com.example.classifiedapp

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
@SmallTest
class ExampleInstrumentedTest {
    private lateinit var title:String

    @get:Rule
    var activityRule: ActivityScenarioRule<MainActivity> = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun initValidString() {
        title = "Product Details"
    }

    @Test
    fun setTextOnMainActivityTextView() {
        /*
        * Kindly uncomment text view from activity_main.xml
        * */


//        Espresso.onView(ViewMatchers.withId(R.id.testing_text))
//            .check(matches(withText(title)))
    }
}
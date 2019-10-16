package com.example.extensionexercises

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       val num: Int = 5

        println(num.isOdd())

        println(46.isOdd())

        println(10.isEven())


        println("palindrome")
        println("racercar".isPalindrome())

        println("name".capitalize())

        //adding alice to the person class list
        val people = listOf<Person>(
            Person("Jane", 25),
            Person("Joe", 54),
            Person("Jane", 35),
            Person("Billy", 15)
        )

        val cars = listOf<Car>(
            Car("Jane", "25")
        )

        val list = listOf<Int>(
            25,
            54,
            35,
            15
        )

        val points = listOf(Point(2.0, 5.0),
            Point(1.2, 4.6))

        /*val sortedBy = cars.sortedBy {
            it.name
        }*/

        val sorted = people.sorted()

        Car("Jane", "25") in cars

        "Jane" in cars


        //searching for alice
        println(people.isAliceThere())
        println(people.doesPersonExist("Billy"))

        people.doesNameExist("test")
        cars.doesNameExist("test")
        //infix demo
        24.toPowerOf(5.0)
        24.0.pow(5)

        24 toPowerOf 5.0 //Very like natural language


     /*   //vis fun demo
        text_view.visibility = View.VISIBLE
        text_view.visible()

        //infix demo connected to extensions
        text_view disappears  "Spooooky"


        this.showToast("Toasted")

        //alert dialog demo as extension function found in extensions
        this.showAlert("Test", "Hey alert worked")*/


        //
        val car = Car("Gallardo", "Lambo")
        val car2 = Car("Model 3", "Tesla")

        text_view.text = car - car2

        var pt1 = Point(2.0, 5.0)
        var pt2 = Point(1.2, 4.6)

        pt1 + pt2
        pt1 - pt2
        pt1 * pt2
        pt1 / pt2
        pt1++
        pt2--

        pt1 == pt2

        pt2 < pt1
















    }
}




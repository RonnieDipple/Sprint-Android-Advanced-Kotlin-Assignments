package com.example.extensionsassignment

import android.app.NotificationChannel
import android.app.NotificationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        val ANDROID_CHANNEL_ID = ""
        val ID = 0

    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button.setOnClickListener {
            showNotification(0, "")

        }


    }


}
    /*# Part - 2 Glide Extension Function
1. Following is a code snippet for downloading an image using Glide and listening to success and failure events.

```
private fun loadurl(url:String){
        Glide.with(this)
            .load(url)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    imageLoaded = false
                    return false
                }
​
                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    imageLoaded = true
                    return false
                }
            })
            .into(this)
    }
```
2. Now, re-write this using extension functions to achieve the same functionality with much more readability:
3. The resulting function should look like this:
```.load()
.onSuccess {
}
.onFailure {
}
```
4. Use this extension function in a sample app to load an image. */


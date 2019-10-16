package com.example.extensionsassignment

import android.app.NotificationChannel
import android.app.NotificationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
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

        button_pic.setOnClickListener {
            // TL said it was OK to just load a URL as may have issues with readme, LOOKING AT YOU BRANDON
            //BRANDON this is for you if you ever check this, English people eat this deliciousness for breakfast
            imageView.loadUrl("https://144f2a3a2f948f23fc61-ca525f0a2beaec3e91ca498facd51f15.ssl.cf3.rackcdn.com/uploads/food_portal_data/recipes/recipe/hero_article_image/1305/letterbox_resizeimage593x426xA6SozL86Xx.jpg")


        }


    }


}

// TL said it was OK to just load a URL as may have issues with readme, LOOKING AT YOU BRANDON
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


package africa.ngamia.swipebutton

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.marginLeft
import com.agik.AGIKSwipeButton.Controller.OnSwipeCompleteListener
import com.agik.AGIKSwipeButton.View.Swipe_Button_View

class MainActivity : AppCompatActivity() {

    private lateinit var startButton: Swipe_Button_View
    private lateinit var stopButton: Swipe_Button_View
    private lateinit var stopStartButton: Swipe_Button_View


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startButton = findViewById(R.id.start)
        stopButton = findViewById(R.id.stop)
        stopStartButton = findViewById(R.id.start_stop)

        // Initialise Start Button
        startButton.setTextColor(ContextCompat.getColor(this, R.color.white))
        startButton.setPadding(40,20,40,20)
        startButton.background = ContextCompat.getDrawable(this, R.drawable.shape_rounded)
        startButton.setThumbImage(ContextCompat.getDrawable(this, R.drawable.ic_baseline_arrow_forward_24))
        startButton.setThumbBackgroundColor(ContextCompat.getColor(this, R.color.white))


        // Initialise Stop Button
        stopButton.setTextColor(ContextCompat.getColor(this, R.color.white))
        stopButton.setPadding(40,20,40,20)
        stopButton.background = ContextCompat.getDrawable(this, R.drawable.shape_rounded)
        stopButton.setThumbImage(ContextCompat.getDrawable(this, R.drawable.ic_baseline_arrow_forward_24))
        stopButton.setThumbBackgroundColor(ContextCompat.getColor(this, R.color.white))


        // Initialise Start-Stop Button
        stopStartButton.setTextColor(ContextCompat.getColor(this, R.color.white))
        stopStartButton.setPadding(40,20,40,20)
        stopStartButton.background = ContextCompat.getDrawable(this, R.drawable.shape_rounded)
        stopStartButton.setThumbImage(ContextCompat.getDrawable(this, R.drawable.ic_baseline_arrow_forward_24))
        stopStartButton.setThumbBackgroundColor(ContextCompat.getColor(this, R.color.white))

        // Start Button Swipes
        startButton.setOnSwipeCompleteListener_forward_reverse(object : OnSwipeCompleteListener{
            override fun onSwipe_Forward(swipeView: Swipe_Button_View) {
                Toast.makeText(this@MainActivity, "Start Process", Toast.LENGTH_LONG).show()
            }
            override fun onSwipe_Reverse(swipeView: Swipe_Button_View) {
                Toast.makeText(this@MainActivity, "Finish Process", Toast.LENGTH_LONG).show()
            }
        })

        stopButton.setOnSwipeCompleteListener_forward_reverse(object : OnSwipeCompleteListener{
            override fun onSwipe_Forward(swipeView: Swipe_Button_View) {
                Toast.makeText(this@MainActivity, "Finish Process", Toast.LENGTH_LONG).show()
            }
            override fun onSwipe_Reverse(swipeView: Swipe_Button_View) {
                Toast.makeText(this@MainActivity, "Start Process", Toast.LENGTH_LONG).show()
            }
        })

        stopStartButton.setOnSwipeCompleteListener_forward_reverse(object : OnSwipeCompleteListener{
            override fun onSwipe_Forward(swipeView: Swipe_Button_View) {
                stopStartButton.setText("Swipe To Finish Service")
                stopStartButton.setPadding(40,20,40,20)
                stopStartButton.background = ContextCompat.getDrawable(this@MainActivity, R.drawable.shape_rounded)
                stopStartButton.setThumbImage(ContextCompat.getDrawable(this@MainActivity, R.drawable.ic_baseline_arrow_forward_24))
                stopStartButton.setThumbBackgroundColor(ContextCompat.getColor(this@MainActivity, R.color.white))
                Toast.makeText(this@MainActivity, "Start Service", Toast.LENGTH_LONG).show()
            }

            override fun onSwipe_Reverse(swipeView: Swipe_Button_View) {
                stopStartButton.setText("Swipe To Start Service")
                stopStartButton.setPadding(40,20,40,20)
                stopStartButton.background = ContextCompat.getDrawable(this@MainActivity, R.drawable.shape_rounded)
                stopStartButton.setThumbImage(ContextCompat.getDrawable(this@MainActivity, R.drawable.ic_baseline_arrow_forward_24))
                stopStartButton.setThumbBackgroundColor(ContextCompat.getColor(this@MainActivity, R.color.white))
                Toast.makeText(this@MainActivity, "Finish Service", Toast.LENGTH_LONG).show()
            }
        })
    }
}
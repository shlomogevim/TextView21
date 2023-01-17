package com.sg.textview21

import android.content.Context
import android.content.res.Resources
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import androidx.appcompat.widget.ThemedSpinnerAdapter
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.res.ResourcesCompat
import kotlin.math.min

const val TOP_MARGIN = "top_margin"
const val BUTTON_MARGIN = "button_margin"

class MainActivity : AppCompatActivity() {
    val helper=Helper()

    val initDistancePosition= TOP_MARGIN
//        var initDistancePosition= BUTTON_MARGIN



    var postText: ArrayList<String> =  arrayListOf(
        " אין בשבילך יופי בעולם ",
        " מלבד מה שאתה תופס כרגע ",
        " כיופי. ",
    )
    var initDistance = 100
    var spaceBetweenLines = 30
    val textViewNumber = postText.size
    val textSize = 27f
    var screenHeight =0
    var tvHeight =0
    var wholeLinesHeight=0
    val textColor="#F5D042"
    val backgroundColor="#0A174E"
    val radius=15
    var postPadding:ArrayList<Int> = arrayListOf(15,0,15,0)
    val lineSpacing = 1.2f
    val alpha = 10
    val font=103



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        supportActionBar?.hide()
        screenHeight = resources.displayMetrics.heightPixels
        val handler = Handler()
        val textViews = ArrayList<TextView>()
        val constraintLayout = ConstraintLayout(this)
        setContentView(constraintLayout)


        for (i in 1..textViewNumber) {
            val textView = addTextView(constraintLayout, "  מה קורה מלך $i")
            handler.postDelayed({

                if (i==1) {
                    tvHeight = textView.height
                   wholeLinesHeight=tvHeight*textViewNumber+spaceBetweenLines*textViewNumber
                  updateInitDistance(textViews)
                }

                setTextViewConstraints(constraintLayout, textView, textViews.lastOrNull())
                textViews.add(textView)
            }, (100 * i).toLong())
        }
    }
    private fun updateInitDistance(textViews: ArrayList<TextView>) {
        val screenHeight = resources.displayMetrics.heightPixels
        if (initDistancePosition== TOP_MARGIN){
             if (wholeLinesHeight+initDistance>screenHeight){
                 initDistance=screenHeight-wholeLinesHeight
             }
        }
        if (initDistancePosition== BUTTON_MARGIN){
            initDistance=screenHeight-wholeLinesHeight-initDistance
        }
    }
    private fun addTextView(constraintLayout: ConstraintLayout, text: String): TextView {
        val textView = TextView(this)
        textView.id = View.generateViewId()
        textView.gravity=Gravity.CENTER
        textView.text = text
        textView.textSize = textSize
        textView.setTextColor(Color.parseColor(updateColor(textColor)))
        val shape = GradientDrawable()
        shape.cornerRadius =radius.toFloat()
        shape.setColor(Color.parseColor(updateColor(backgroundColor)))
        textView.background = shape
       // textView.setPadding(leftPadding, topPadding, rightPadding, bottomPadding)
        textView.setPadding(postPadding[0].toPx(),postPadding[1].toPx(),postPadding[2].toPx(),postPadding[3].toPx())
        textView.setLineSpacing(0f, lineSpacing)
/*The first parameter is the extra space that will be added to the height of each line of text,
 and the second parameter is the multiplication factor that will be applied to the default line spacing.*/
        textView.alpha = alpha/10f

        val typeface=helper.getFamilyFont(font)
        textView.typeface= ResourcesCompat.getFont(this, typeface)

        val layoutParams = ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.WRAP_CONTENT,
            ConstraintLayout.LayoutParams.WRAP_CONTENT
        )
        textView.layoutParams = layoutParams
        constraintLayout.addView(textView)
        return textView
    }

    fun updateColor(str: String): String {
        return "#" + str.replace("[^A-Za-z0-9]".toRegex(), "")
    }
    fun dpToPx(dp: Int, context: Context): Float {
        return dp.toFloat() * context.resources.displayMetrics.density
    }



    private fun marginFromTheButtom(): Int {
        var diser1=0
        val interval=tvHeight*textViewNumber-spaceBetweenLines*(textViewNumber-1)
        val maxMargin1 = screenHeight - interval
        val interval1=tvHeight*(textViewNumber*3)-spaceBetweenLines*(textViewNumber-1)
        diser1=screenHeight-interval1
//        Log.d("gg","screenHeight=$screenHeight  tvHeight=$tvHeight  spaceBetweenLines=$spaceBetweenLines  initDistance=$initDistance")
//        Log.d("gg","interval=$interval  interval1=$interval1    ")



     return diser1
    }




    private fun setTextViewConstraints(
        constraintLayout: ConstraintLayout,
        textView: TextView,
        aboveTextView: TextView?
    ) {
        val constraints = ConstraintSet()
        constraints.clone(constraintLayout)

        constraints.connect(
            textView.id,
            ConstraintSet.LEFT,
            ConstraintSet.PARENT_ID,
            ConstraintSet.LEFT
        )
        constraints.connect(
            textView.id,
            ConstraintSet.RIGHT,
            ConstraintSet.PARENT_ID,
            ConstraintSet.RIGHT
        )
        if (aboveTextView != null)
            constraints.connect(
                textView.id,
                ConstraintSet.TOP,
                aboveTextView.id,
                ConstraintSet.BOTTOM,
                spaceBetweenLines
            )
        else

            constraints.connect(
                textView.id,
                ConstraintSet.TOP,
                ConstraintSet.PARENT_ID,
                ConstraintSet.TOP,
                initDistance

            )
        constraints.applyTo(constraintLayout)
    }

    fun Int.toPx(): Int = (this * Resources.getSystem().displayMetrics.density).toInt()






}














/*
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        supportActionBar?.hide()

        val constraintLayout = ConstraintLayout(this)
        setContentView(constraintLayout)
        val handler = Handler()
        val textViews = ArrayList<TextView>()
        for (i in 1..3) {
            val textView = addTextView(constraintLayout, "text view $i")
            handler.postDelayed({
                setTextViewConstraints(constraintLayout, textView, textViews.lastOrNull())
                textViews.add(textView)
            }, (100 * i).toLong())
        }
    }

    private fun addTextView(constraintLayout: ConstraintLayout, text: String): TextView {
        val textView = TextView(this)
        textView.id = View.generateViewId()
        textView.text = text
        textView.textSize = 20f

        val layoutParams = ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.WRAP_CONTENT,
            ConstraintLayout.LayoutParams.WRAP_CONTENT
        )
        textView.layoutParams = layoutParams
        constraintLayout.addView(textView)
        return textView
    }

    private fun setTextViewConstraints(
        constraintLayout: ConstraintLayout,
        textView: TextView,
        aboveTextView: TextView?
    ) {
        val constraints = ConstraintSet()
        constraints.clone(constraintLayout)

        constraints.connect(
            textView.id,
            ConstraintSet.LEFT,
            ConstraintSet.PARENT_ID,
            ConstraintSet.LEFT
        )
        constraints.connect(
            textView.id,
            ConstraintSet.RIGHT,
            ConstraintSet.PARENT_ID,
            ConstraintSet.RIGHT
        )
        if (aboveTextView != null)
            constraints.connect(
                textView.id,
                ConstraintSet.TOP,
                aboveTextView.id,
                ConstraintSet.BOTTOM,
                40
            )
        else
            constraints.connect(
                textView.id,
                ConstraintSet.TOP,
                ConstraintSet.PARENT_ID,
                ConstraintSet.TOP,
                100
            )
        constraints.applyTo(constraintLayout)
    }
}

*/




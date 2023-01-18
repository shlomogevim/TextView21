package com.sg.textview21

import android.content.Context
import android.content.res.Resources
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.res.ResourcesCompat
import com.bumptech.glide.Glide
import com.sg.textview21.model.Post
import com.sg.textview21.tools.CONSTANT
import com.sg.textview21.tools.NO_BOTTOM
import com.sg.textview21.tools.NO_TOP

const val TOP_MARGIN = "top_margin"
const val BUTTON_MARGIN = "button_margin"

class MainActivity : AppCompatActivity() {
    val helper=Helper()
    val handler=Handler()
    lateinit var post:Post
    var constraintSet = ConstraintSet()

//    val initDistancePosition= TOP_MARGIN
    //    var initDistancePosition= BUTTON_MARGIN
        var initDistancePosition= ""

  /*  var postText: ArrayList<String> =  arrayListOf(
        " אין בשבילך יופי בעולם ",
        " מלבד מה שאתה תופס כרגע ",
        " כיופי. ",
    )*/
    var initDistance = 0
    var spaceBetweenLines = 0
 //   val textViewNumber = postText.size
   // val textSize = 16f
    var screenHeight =0
    var tvHeight =0
    var wholeLinesHeight=0
    //val textColor="#F5D042"
   // val backgroundColor="#0A174E"
  //  val radius=15
   // var postPadding:ArrayList<Int> = arrayListOf(15,0,15,0)
   // val lineSpacing = 1.2f
   // val alpha = 10
    //val font=103
  //  val imageUrl = "https://cdn.pixabay.com/photo/2023/01/10/00/17/italy-7708552_960_720.jpg"
  //  var textLocation:ArrayList<Int> = arrayListOf<Int>(100,0,0,0,0)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        supportActionBar?.hide()
        screenHeight = resources.displayMetrics.heightPixels


        val constraintLayout = ConstraintLayout(this)
        constraintSet.clone(constraintLayout)
        setContentView(constraintLayout)
        post=createPost()
        set_data(post)
        loadImage(constraintLayout,post)
        setText(constraintLayout,post)
        constraintSet.applyTo(constraintLayout)
    }

    private fun set_data(post: Post) {
        //    textLocation = arrayListOf(10,-1, 33,10,0,0, 0, 0)
        var dataAr=post.textLocation
        spaceBetweenLines=dataAr[2]
        if (dataAr[1]==-1){
            initDistancePosition= BUTTON_MARGIN
            initDistance=dataAr[3]
        }else{
            initDistancePosition=TOP_MARGIN
            initDistance=dataAr[1]
        }
//Log.d("gg"," 89   initDistancePosition=$initDistancePosition   initDistance=$initDistance  spaceBetweenLines=$spaceBetweenLines")


    }

    private fun createPost():Post {

            val post = Post()
            with(post) {
                postNum = 4999071
                lineNum = 4
                imageUri ="https://cdn.pixabay.com/photo/2023/01/10/00/17/italy-7708552_960_720.jpg"
                postText = arrayListOf(
                    " זכרון העבר ",
                    " זה מה שקרה לך בעבר, ",
                    "  טעות היא  ",
                    " להכפיף את ההווה שלך לזה. "
                )
                postId = 87

//                textLocation = arrayListOf(10,100,0,-1,0,0, 0, 0)  //  Top  o.k.
                textLocation = arrayListOf(10,0,0,-1,0,0, 0, 0)  //  Button   n.o.k.
                postPadding = arrayListOf(0, 0, 10,0)
                postTransparency =10
                postTextSize = arrayListOf(0, 16)
                val backgroundColor = "#0A174E"
                val textColor = "#F5D042"
                postFontFamily = 103

                postBackground = backgroundColor
                postTextColor = arrayListOf(CONSTANT, textColor)
                videoUrl = "9UVjjcOUJLE"
                //   videoText = util1.getPostExplanation(postNum, postText)
            }
            //  drawPost.drawPostFire(post, layout)
            //  util.sendPostToStringFirestore(post)

         return post
    }




    private fun setText(constraintLayout: ConstraintLayout,post: Post) {
        val textViews = ArrayList<TextView>()
        val size=post.postText.size
        for (index in 1..size) {
            val textView = addTextView(post,constraintLayout, post.postText[index-1])
            handler.postDelayed({
                if (index==1) {
                    tvHeight = textView.height
                  wholeLinesHeight=tvHeight*size+spaceBetweenLines*size
                  Log.d("gg"," 140  tvHeight=$tvHeight    spaceBetweenLines=$spaceBetweenLines  wholeLinesHeight=$wholeLinesHeight")
                    updateInitDistance(textViews)
                }
              setTextViewConstraints(constraintLayout, textView, textViews.lastOrNull())
             //   arrangeText10(index,textView, post )
                textViews.add(textView)
            }, (100 * index).toLong())
        }
        constraintSet.applyTo(constraintLayout)
    }

    private fun arrangeText10(index: Int, currentTV: TextView, post: Post) {
        constraintSet.clear(currentTV.id, ConstraintSet.TOP)
        constraintSet.clear(currentTV.id, ConstraintSet.BOTTOM)
        val line = index - 1
        val ind1 = post.lineNum - line - 1
        var top = post.textLocation[1]
        if (top != NO_TOP) {
            top = top.toPx()
        }
        val dis = post.textLocation[2].toPx()
        var bottom = post.textLocation[3]
        if (bottom != NO_BOTTOM) {
            bottom = bottom.toPx()
        }
        val line1 = post.textLocation[4]                                   // from this line
        val dis1 = post.textLocation[5].toPx()
        val line2 = post.textLocation[6]                                // from this line
        val dis2 = post.textLocation[7].toPx()
        var distanceBotton = bottom + dis * ind1
        var distanceTop = top + dis * line

        if (top == NO_TOP) {                                                                            //locate in the bottom
            if (line <= line1) {
                distanceBotton += dis1
            }
            if (line <= line2) {
                //    util.logi("DrawGeneral 290 line=$line   line2=$line2 ")
                distanceBotton += dis2
            }

            constraintSet.connect(
                currentTV.id,
                ConstraintSet.BOTTOM,
                ConstraintSet.PARENT_ID,
                ConstraintSet.BOTTOM, distanceBotton
            )
        }

        if (bottom == NO_BOTTOM) {                                                                            //locate in the top
//            var distance = (top + (dis * line)).toPx()                                                //10, 0,              35,   NO_BOTTOM,     0,       500,         0,          0
//              util.logi("DrawGeneral 303  line=$line   line1=$line1 ")
            if (line >= line1) {
//                util.logi("DrawGeneral 305  line=$line   line1=$line1 ")
                distanceTop += dis1
            }
            if (line >= line2) {
                distanceTop += dis2
            }
            constraintSet.connect(
                currentTV.id,
                ConstraintSet.TOP,
                ConstraintSet.PARENT_ID,
                ConstraintSet.TOP, distanceTop
            )
        }

    }


  /*
   private fun arangeText10(index: Int, currentTV: TextView, post: Post) {
        util.logi("DrawGeneralPost/arangeText10/ 315==>index=$index  currentTV=$currentTV   postText=${post.postText}")

        val line = index - 1
        val ind1 = post.lineNum - line - 1
        var top = post.textLocation[1]
        if (top != NO_TOP) {
            top = top.toPx()
        }
        val dis = post.textLocation[2].toPx()
        var bottom = post.textLocation[3]
        if (bottom != NO_BOTTOM) {
            bottom = bottom.toPx()
        }
        val line1 = post.textLocation[4]                                   // from this line
        val dis1 = post.textLocation[5].toPx()
        val line2 = post.textLocation[6]                                // from this line
        val dis2 = post.textLocation[7].toPx()
        var distanceBotton = bottom + dis * ind1
        var distanceTop = top + dis * line

        if (top == NO_TOP) {                                                                            //locate in the bottom
            if (line <= line1) {
                distanceBotton += dis1
            }
            if (line <= line2) {
                //    util.logi("DrawGeneral 290 line=$line   line2=$line2 ")
                distanceBotton += dis2
            }

            constraintSet.connect(
                currentTV.id,
                ConstraintSet.BOTTOM,
                ConstraintSet.PARENT_ID,
                ConstraintSet.BOTTOM, distanceBotton
            )
        }

        if (bottom == NO_BOTTOM) {                                                                            //locate in the top
//            var distance = (top + (dis * line)).toPx()                                                //10, 0,              35,   NO_BOTTOM,     0,       500,         0,          0
//              util.logi("DrawGeneral 303  line=$line   line1=$line1 ")
            if (line >= line1) {
//                util.logi("DrawGeneral 305  line=$line   line1=$line1 ")
                distanceTop += dis1
            }
            if (line >= line2) {
                distanceTop += dis2
            }
            constraintSet.connect(
                currentTV.id,
                ConstraintSet.TOP,
                ConstraintSet.PARENT_ID,
                ConstraintSet.TOP, distanceTop
            )
        }
    }*/

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
    private fun addTextView(post: Post,constraintLayout: ConstraintLayout, text: String): TextView {
        val textView = TextView(this)
        textView.id = View.generateViewId()
        textView.gravity=Gravity.CENTER
        textView.text = text
        textView.textSize = post.postTextSize[1].toFloat()
        textView.setTextColor(Color.parseColor(updateColor(post.postTextColor[1])))
        val shape = GradientDrawable()
        shape.cornerRadius =post.postRadiuas.toFloat()
        shape.setColor(Color.parseColor(updateColor(post.postBackground)))
        textView.background = shape
       // textView.setPadding(leftPadding, topPadding, rightPadding, bottomPadding)
        val pad=post.postPadding
        textView.setPadding(pad[0].toPx(),pad[1].toPx(),pad[2].toPx(),pad[3].toPx())
        textView.setLineSpacing(0f, post.lineSpacing)
/*The first parameter is the extra space that will be added to the height of each line of text,
 and the second parameter is the multiplication factor that will be applied to the default line spacing.*/
        textView.alpha = post.postTransparency/10f

        val typeface=helper.getFamilyFont(post.postFontFamily)
        textView.typeface= ResourcesCompat.getFont(this, typeface)

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

    private fun loadImage(layout: ConstraintLayout, post:Post) {
        val imageView = ImageView(layout.context)
        imageView.id = View.generateViewId()
        val params = ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.MATCH_PARENT,
            ConstraintLayout.LayoutParams.MATCH_PARENT
        )
//        params.dimensionRatio = "H,1:1"
        params.topToTop = ConstraintLayout.LayoutParams.PARENT_ID
        params.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
        params.startToStart = ConstraintLayout.LayoutParams.PARENT_ID
        params.endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
        imageView.layoutParams = params
        imageView.scaleType = ImageView.ScaleType.CENTER_CROP
        layout.addView(imageView)

        Glide.with(layout.context)
            .load(post.imageUri)
            .into(imageView)
    }



    fun Int.toPx(): Int = (this * Resources.getSystem().displayMetrics.density).toInt()
}
fun updateColor(str: String): String {
    return "#" + str.replace("[^A-Za-z0-9]".toRegex(), "")
}


fun dpToPx(dp: Int, context: Context): Float {
    return dp.toFloat() * context.resources.displayMetrics.density
}




/* private fun marginFromTheButtom(): Int {
        var diser1=0
        val interval=tvHeight*textViewNumber-spaceBetweenLines*(textViewNumber-1)
        val maxMargin1 = screenHeight - interval
        val interval1=tvHeight*(textViewNumber*3)-spaceBetweenLines*(textViewNumber-1)
        diser1=screenHeight-interval1
     return diser1
    }*/

/* fun setBackgroundPicture(constraintLayout: ConstraintLayout){
      val imageView = ImageView(this)
      val layoutParams = ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.MATCH_PARENT)
      imageView.layoutParams = layoutParams

      val imageUrl = "https://cdn.pixabay.com/photo/2023/01/03/10/35/butterfly-7694101_960_720.jpg"
      Glide.with(this)
          .load(imageUrl)
          .into(imageView)

      constraintLayout.addView(imageView)
  }*/












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




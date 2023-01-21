package com.sg.textview21.demi

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.util.TypedValue
import android.view.WindowManager
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import com.google.api.Context
import com.sg.textview21.BUTTON_MARGIN
import com.sg.textview21.Helper
import com.sg.textview21.TOP_MARGIN
import com.sg.textview21.model.Post
import com.sg.textview21.tools.CONSTANT
import com.sg.textview21.tools.NO_BOTTOM
import com.sg.textview21.tools.NO_TOP

class Demi30(val context: Context) {


        /*fun positionTextViews(constraintLayout: ConstraintLayout, textViews: ArrayList<TextView>, margin: Int, location: String) {
    val constraintSet = ConstraintSet()
    constraintSet.clone(constraintLayout)
    val marginPixel = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, margin.toFloat(), resources.displayMetrics).toInt()
    textViews.forEachIndexed { index, textView ->
        if (index == 0) {
            if (location == "Top") {
                constraintSet.connect(textView.id, ConstraintSet.TOP, constraintLayout.id, ConstraintSet.TOP, marginPixel)
            } else if (location == "Bottom") {
                constraintSet.connect(textView.id, ConstraintSet.BOTTOM, constraintLayout.id, ConstraintSet.BOTTOM, marginPixel)
            }
        } else {
            if (location == "Top") {
                constraintSet.connect(textView.id, ConstraintSet.TOP, textViews[index - 1].id, ConstraintSet.BOTTOM, marginPixel)
            } else if (location == "Bottom") {
                constraintSet.connect(textView.id, ConstraintSet.BOTTOM, textViews[index - 1].id, ConstraintSet.TOP, marginPixel)
            }
        }
    }
    constraintSet.applyTo(constraintLayout)
}
*/


















/*

        fun setFirstTextViewConstraints(constraintSet: ConstraintSet, constraintLayout: ConstraintLayout, textView: TextView, location: String, margin: Int) {
                val marginPixel = margin.toFloat().toPx(context)
                if (location == "Top") {
                        constraintSet.connect(textView.id, ConstraintSet.TOP, constraintLayout.id, ConstraintSet.TOP, marginPixel)
                } else if (location == "Bottom") {
                        constraintSet.connect(textView.id, ConstraintSet.BOTTOM, constraintLayout.id, ConstraintSet.BOTTOM, marginPixel)
                }
        }

        fun setTextViewConstraints(constraintSet: ConstraintSet, textView: TextView, previousTextView: TextView?, location: String, margin: Int) {
                val marginPixel = margin.toFloat().toPx(context)
                if (location == "Top") {
                        constraintSet.connect(textView.id, ConstraintSet.TOP, previousTextView!!.id, ConstraintSet.BOTTOM, marginPixel)
                } else if (location == "Bottom") {
                        constraintSet.connect(textView.id, ConstraintSet.BOTTOM, previousTextView!!.id, ConstraintSet.TOP, marginPixel)
                }
        }


*/





























































        /*

          class MainActivity : AppCompatActivity() {
              val helper= Helper()
              val handler= Handler()
              lateinit var post: Post
              var constraintSet = ConstraintSet()

              //    val initDistancePosition= TOP_MARGIN
              //    var initDistancePosition= BUTTON_MARGIN
              var initDistancePosition= ""

              *//*  var postText: ArrayList<String> =  arrayListOf(
              " אין בשבילך יופי בעולם ",
              " מלבד מה שאתה תופס כרגע ",
              " כיופי. ",
          )*//*
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
            }else{
                TOP_MARGIN
            }

            if (initDistancePosition== BUTTON_MARGIN){
                initDistance=dataAr[3]
            }










        }

        private fun createPost(): Post {

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
                textLocation = arrayListOf(10,100, 0,-1,0,0, 0, 0)
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
            // drawPost(post)
            //  drawPost.drawPostFire(post, layout)
            //  util.sendPostToStringFirestore(post)

            return post
        }




        private fun setText(constraintLayout: ConstraintLayout, post: Post) {
            val textViews = ArrayList<TextView>()
            val size=post.postText.size
            for (index in 1..size) {
                val textView = addTextView(post,constraintLayout, post.postText[index-1])
                tvHeight = textView.height
                handler.postDelayed({

                    if (index==1) {

                        wholeLinesHeight=tvHeight*size+spaceBetweenLines*size
                        Log.d("gg"," 150  tvHeight=$tvHeight    spaceBetweenLines=$spaceBetweenLines  wholeLinesHeight=$wholeLinesHeight")
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

            */

        }













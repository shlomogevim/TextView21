package com.sg.textview21.demi

class SaveIt10 {


    /*  private fun setDataToPost() {
        val post = Post()
        with(post) {
            postNum = 4999071
            lineNum = 4
            imageUri = "https://cdn.pixabay.com/photo/2017/01/30/15/23/memory-2021124_960_720.jpg"
            postText = arrayListOf(
                " זכרון העבר ",
                " זה מה שקרה לך בעבר, ",
                "  טעות היא  ",
                " להכפיף את ההווה שלך לזה. "
            )
            postId = 87
            textLocation = arrayListOf(10,-1, 33,10,0,0, 0, 0)
            postPadding = arrayListOf(10, 0, 10, 0)
            postTransparency =5
            postTextSize = arrayListOf(0, 15)
            val backgroundColor = "#0A174E"
            val textColor = "#F5D042"
            postFontFamily = 103
         //   postBackground = util.improveColorString(backgroundColor)
        //    val textcolo = util.improveColorString(textColor)
         //   val col = "#$textcolo"
        //    postTextColor = arrayListOf(CONSTANT, col)
            videoUrl = "9UVjjcOUJLE"
         //   videoText = util1.getPostExplanation(postNum, postText)
        }
      //  drawPost.drawPostFire(post, layout)
      //  util.sendPostToStringFirestore(post)
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











}
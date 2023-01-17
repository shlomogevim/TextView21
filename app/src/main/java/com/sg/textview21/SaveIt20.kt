package com.sg.textview21

class SaveIt20 {

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

        val margin = 40
        for (i in 3 downTo 1) {
            val textView = addTextView(constraintLayout, "text view $i")
            handler.postDelayed({
                if (i == 3) {
                    setTextViewConstraints(
                        constraintLayout,
                        textView,
                        null,
                        "BOTTOM",
                        100,
                        textViews
                    )
                } else {
                    setTextViewConstraints(
                        constraintLayout,
                        textView,
                        textViews[textViews.size-1],
                        "TOP",
                        margin,
                        textViews
                    )
                }
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
        aboveTextView: TextView?,
        position: String,
        margin: Int,
        textViews: ArrayList<TextView>
    ) {
        if (position == "TOP") {
            setTextViewConstraintsForTop(constraintLayout, textView, aboveTextView, margin)
        } else if (position == "BOTTOM") {
            setTextViewConstraintsForBottom(constraintLayout, textView, aboveTextView, margin, textViews)

        /*   constraintLayout: ConstraintLayout,
        textView: TextView,
        aboveTextView: TextView?,
        margin: Int,
        textViews: ArrayList<TextView>  */
        }
    }
    private fun setTextViewConstraintsForTop(
        constraintLayout: ConstraintLayout,
        textView: TextView,
        aboveTextView: TextView?,
        margin: Int
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
                margin
            )
        else
            constraints.connect(
                textView.id,
                ConstraintSet.TOP,
                ConstraintSet.PARENT_ID,
                ConstraintSet.TOP,
                margin
            )
        constraints.applyTo(constraintLayout)
    }

    private fun setTextViewConstraintsForBottom(
        constraintLayout: ConstraintLayout,
        textView: TextView,
        aboveTextView: TextView?,
        margin: Int,
        textViews: ArrayList<TextView>
    ){
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
                ConstraintSet.BOTTOM,
                aboveTextView.id,
                ConstraintSet.TOP,
                margin
            )
        else if (textViews.isNotEmpty())
            constraints.connect(
                textView.id,
                ConstraintSet.TOP,
                textViews[textViews.size-1].id,
                ConstraintSet.BOTTOM,
                margin
            )
        else
            constraints.connect(
                textView.id,
                ConstraintSet.BOTTOM,
                ConstraintSet.PARENT_ID,
                ConstraintSet.BOTTOM,
                -margin
            )
        constraints.applyTo(constraintLayout)
    }

}




*/











}
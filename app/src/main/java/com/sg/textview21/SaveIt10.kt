package com.sg.textview21

class SaveIt10 {

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
package au.sjowl.lib.view.telegramchart.names

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import au.sjowl.lib.view.telegramchart.R
import au.sjowl.lib.view.telegramchart.ThemedView
import au.sjowl.lib.view.telegramchart.params.ChartColors
import kotlinx.android.synthetic.main.rv_item_chart_title.view.*
import org.jetbrains.anko.textColor

class ChartNameView : LinearLayout, ThemedView {

    override fun updateTheme(colors: ChartColors) {
        title.textColor = colors.colorText
    }

    fun bind(item: ChartItem, listener: ChartItemHolderListener) {
        setOnClickListener {
            checkbox.check()
            listener.onChecked(item, checkbox.checked)
        }
        checkbox.onCheckedChangedListener { checked ->
            listener.onChecked(item, checked)
        }
        title.text = item.name
        checkbox.color = item.color
        checkbox.checked = item.enabled
    }

    private fun init() {
        LayoutInflater.from(context).inflate(R.layout.rv_item_chart_title, this)
    }

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }
}
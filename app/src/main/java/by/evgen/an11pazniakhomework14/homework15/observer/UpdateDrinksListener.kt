package by.evgen.an11pazniakhomework14.homework15.observer

import android.widget.TextView

class UpdateDrinksListener(private val textView: TextView): Listener {
    override fun update(eventType: String, text: String) {
        val localText = textView.text.toString() + text + "\n"
        textView.text = localText
    }
}
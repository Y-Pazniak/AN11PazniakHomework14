package by.evgen.an11pazniakhomework14.homework15.observer

class Editor() {
    val eventManager: EventManager = EventManager("update")

    fun updateTextView(text: String){
        eventManager.notify("update", text)
    }
}
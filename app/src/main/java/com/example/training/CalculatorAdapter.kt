import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.training.CalculatorButton
import com.example.training.R

class CalculatorAdapter(private val buttons: List<CalculatorButton>, private val clickListener: (String) -> Unit) :
    RecyclerView.Adapter<CalculatorAdapter.ButtonViewHolder>() {

    inner class ButtonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val buttonTextView: TextView = itemView.findViewById(R.id.buttonTextView)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ButtonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_button, parent, false)
        return ButtonViewHolder(view)
    }

    override fun onBindViewHolder(holder: ButtonViewHolder, position: Int) {
        val button = buttons[position]
        holder.buttonTextView.text=button.label
        holder.buttonTextView.setBackgroundColor(button.bgColor)
        holder.buttonTextView.setTextColor(button.textColor)
        holder.itemView.setOnClickListener { clickListener(button.label) }
    }


    override fun getItemCount(): Int {
        return buttons.size
    }
}

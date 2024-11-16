package com.example.training

import android.content.res.ColorStateList
import android.net.Uri
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.suke.widget.SwitchButton

class AddInventoryActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private lateinit var attachmentTextView: TextView
    private lateinit var browseButton: Button
    private lateinit var switch: SwitchButton
    private lateinit var category: AutoCompleteTextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_inventory)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        imageView = findViewById(R.id.imageView2)
        attachmentTextView = findViewById(R.id.attachmentTextView)
        browseButton = findViewById(R.id.browseButton)
        switch = findViewById(R.id.toggle)
        category = findViewById(R.id.categoryDropdown)

        val dropdownitems = listOf ("Option 1", "Option 2", "option 3", "option 4")
        val adapter= ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line,dropdownitems)
        category.setAdapter(adapter)


        browseButton.setOnClickListener {
            openFilePicker()
        }
        imageView.setOnClickListener {
            openFilePicker()
        }
    }
    // File Picker Activity Result
    private val filePickerLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        if (uri != null) {
            previewSelectedFile(uri)
        } else {
            Snackbar.make(
                findViewById(R.id.main),
                "No file selected.",
                Snackbar.LENGTH_SHORT
            ).show()
        }
    }

    // Open File Picker
    private fun openFilePicker() {
        filePickerLauncher.launch("image/*")     }

    // Display Selected File
    private fun previewSelectedFile(uri: Uri) {
        try {
            // Set image to ImageView
            imageView.setImageURI(uri)

            // Update attachment text
            attachmentTextView.text = "File selected: ${uri.path}"
        } catch (e: Exception) {
            e.printStackTrace()
            Snackbar.make(
                findViewById(R.id.main),
                "Failed to load file.",
                Snackbar.LENGTH_SHORT
            ).show()
        }
    }
}

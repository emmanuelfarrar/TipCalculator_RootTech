package com.example.tipcalculator_roottech;

//Youtube: https://youtu.be/NWzbIIZ2Tno

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //variables for elements in the app
    private EditText billEditText;
    private EditText peopleEditText;
    private ImageView iconImageView;
    private TextView mainTextTextView;
    private Button calculateButton;
    private Spinner tipSpinner;
    private ArrayList<String> tipList;
    private ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //instantiating elements
        billEditText = findViewById(R.id.bill_edittext);
        peopleEditText = findViewById(R.id.people_edittext);
        iconImageView = findViewById(R.id.icon_ImageView);
        mainTextTextView = findViewById(R.id.maintext_textView);
        calculateButton = findViewById(R.id.button);

        tipSpinner = findViewById(R.id.spinner);


        tipList = new ArrayList<>();

        //passing the activity, layout, and the array into the adapter
        adapter = new ArrayAdapter<>(this, R.layout.spinner_layout, tipList);
        //setting the dropdown resource
        adapter.setDropDownViewResource(R.layout.spinner_dropdown);
        tipSpinner.setAdapter(adapter);

    }
}

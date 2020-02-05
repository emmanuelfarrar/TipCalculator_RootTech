package com.example.tipcalculator_roottech;

//Youtube: https://youtu.be/NWzbIIZ2Tno

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //variables for elements in the app
    private EditText billEditText;
    private EditText peopleEditText;
    private ImageView iconImageView;
    private TextView mainTextTextView;
    private Button calculateButton;
    private Spinner tipSpinner;
    private ArrayList<String> tipList;
    private TextView outputTextView;
    private ArrayAdapter<String> adapter;
    private int tip;
    private static final String TIP_SPINNER = "Tip";
    private static final int TIP_MAX = 20;


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
        outputTextView = findViewById(R.id.output);

        tipSpinner = findViewById(R.id.spinner);


        tipList = new ArrayList<>();

        //Calling addToSpinner() before building the spinner
        addToSpinner();

        //passing the activity, layout, and the array into the adapter
        adapter = new ArrayAdapter<>(this, R.layout.spinner_layout, tipList);
        //setting the dropdown resource
        adapter.setDropDownViewResource(R.layout.spinner_dropdown);
        tipSpinner.setAdapter(adapter);     //setting the spinner to adapter
        //This requires that we implement AdapterView.OnItemSelectedListener
        tipSpinner.setOnItemSelectedListener(this);

        //creating the setOnClickListener for calculateButton
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTotal();
            }
        });

    }

    /*
    * calculates total bill, tip, and divide each consumer
    * */
    public void calculateTotal(){
        //get input from user
        String billString = billEditText.getText().toString();
        if (billString == null || billString.length() == 0) {
            Toast.makeText(this, "Enter bill amount", Toast.LENGTH_SHORT).show();
        }
        double bill = Double.parseDouble(billString);
        int numOfPeople = Integer.parseInt(peopleEditText.getText().toString());
        DecimalFormat df2 = new DecimalFormat("0.00");  //decimal format for currency
        double tipDollar = bill * (tip/100.00);
        double totalBill = bill + tipDollar;

        String output = "Total Bill: " + df2.format(totalBill) + "\n" +
                        "Tips: " + df2.format(tipDollar) + "\n" +
                        "Each Pay: " + df2.format(totalBill/numOfPeople);

        outputTextView.setText(output);

    }



        /*
        adding elements to spinner
*       */

    public void addToSpinner(){
        tipList.add(TIP_SPINNER);
        for(int i = 1; i < TIP_MAX; i++){
            tipList.add(i +"");
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            tip = position;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

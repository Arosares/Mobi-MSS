package com.example.aro.cowcounter;

import android.content.Context;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Cow> cowList = new LinkedList<>();
    private int rowCounter = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        final EditText textFieldBreed = (EditText) findViewById(R.id.editText);
        final EditText textFieldID = (EditText) findViewById(R.id.editText2);

        final TextView cowCounter = (TextView) findViewById(R.id.textView5);
        cowCounter.setText("Cows: " + cowList.size());

        final TableLayout tableLayout = (TableLayout) findViewById(R.id.tableLayout1);





        Button addButton = (Button) findViewById(R.id.button);
        addButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String breedString = textFieldBreed.getText().toString();
                String cowIDString = textFieldID.getText().toString();

                if(breedString.matches("") || cowIDString.matches("")){
                    //Do nothing
                } else {
                    int breed = Integer.parseInt(breedString);
                    int cowID = Integer.parseInt(cowIDString);


                    Cow cow = new Cow(breed, cowID);
                    cowList.add(cow);

                    //Edit Table

                    TableRow newRow = new TableRow(tableLayout.getContext());
                    newRow.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT));

                    TextView cowBreedTable = new TextView(newRow.getContext());

                    cowBreedTable.setText(Integer.toString(cow.getBreed()));
                    cowBreedTable.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT));

                    TextView cowIDTable = new TextView(newRow.getContext());
                    cowIDTable.setText(Integer.toString(cow.getCowID()));
                    cowIDTable.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT));

                    newRow.addView(cowBreedTable);
                    newRow.addView(cowIDTable);
                    newRow.setId(rowCounter);

                    tableLayout.addView(newRow, new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT));



                    //Update counter
                    cowCounter.setText("Cows: " + cowList.size());
                    System.out.println("Created Cow:");
                    System.out.println("Breed: " + cow.getBreed() + " ID: " + cow.getCowID());
                    System.out.println("CowList: "+ cowList);

                }

            }
        });

        Button rejButton = (Button) findViewById(R.id.button2);
        rejButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String breedString = textFieldBreed.getText().toString();
                String cowIDString = textFieldID.getText().toString();

                if(breedString.matches("") || cowIDString.matches("")){
                    //Do nothing
                } else {
                    int breed = Integer.parseInt(breedString);
                    int cowID = Integer.parseInt(cowIDString);

                    Cow toDelete = new Cow(breed, cowID);
                    System.out.println("toDelete: " + toDelete);
                    List<Cow> found = new LinkedList<Cow>();

                    //Deletes multiple occurences of a cow in the List. Not sure if desired
                    //For only one occurence add break; in if-block
                    for (Cow cow : cowList) {
                        if (cow.compareTo(toDelete) == 0) {
                            found.add(cow);
                            System.out.println(cow);
                        }
                    }
                    cowList.removeAll(found);
                    cowCounter.setText("Cows: " + cowList.size());
                    System.out.println("Removed Cow(s)\n" + cowList);
                }
            }
        });

        Button clearButton = (Button) findViewById(R.id.button3);
        clearButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                List<Cow> deleteHelper = cowList;
                cowList.removeAll(deleteHelper);

                cowCounter.setText("Cows: " + cowList.size());
            }
        });

    }


}

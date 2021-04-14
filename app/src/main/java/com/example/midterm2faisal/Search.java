package com.example.midterm2faisal;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;


public class Search extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Button Search=findViewById(R.id.Search);
        TextView View=findViewById(R.id.textView2);
        EditText SearchID =findViewById(R.id.editTextTextPersonName);
        DBHelper dbHelper=new DBHelper(this);
        Button go1=findViewById(R.id.btn2act111);
    }
    go1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(Search.this,Database2.class));
        }
    });
    // I did the select part here for the search but it seems there is an error but it worked in the First Activity (database2).
    Search.setOnClickListener(new View.OnClickListener()

    {
        @Override
        public void onClick(View v) {
            Cursor c2=dbHelper.getResult(inp_fname.getText()+"");

            if (c2==null){
                Toast.makeText(Search.this,"No Record.",Toast.LENGTH_SHORT).show();
                return;
            }
            String message= c2.getInt(0)+" "+
                    c2.getString(1)+" "+
                    c2.getString(2)+" "+
                    c2.getString(3)+" "+
                    c2.getString(4)+" ";

            Toast.makeText(Search.this,"Record found: "+message,Toast.LENGTH_LONG).show();
        }
    });

}
package com.example.midterm2faisal;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

public class Database2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DBHelper dbHelper=new DBHelper(this);
        setContentView(R.layout.activity_database2);
        setTitle("You are in Activity 1");
        Button select=findViewById(R.id.btn_select);
        Button add=findViewById(R.id.AddinList);
        Button delete=findViewById(R.id.DeleteButton);
        EditText inp_fname=findViewById(R.id.inputFirstName);
        EditText inp_email=findViewById(R.id.inputemail);
        EditText inp_pid=findViewById(R.id.inputPersonalId);
        EditText inp_id=findViewById(R.id.inputID);
        EditText inp_phone=findViewById(R.id.inputPhone);

        Button go2=findViewById(R.id.b3act2);
        Button go1=findViewById(R.id.b3act1);

//  The select is working in this Activity
        //And delete by ID

        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c2=dbHelper.getResult(inp_fname.getText()+"");

                if (c2==null){
                    Toast.makeText(Database2.this,"No Record.",Toast.LENGTH_SHORT).show();
                    return;
                }
                String message= c2.getInt(0)+" "+
                        c2.getString(1)+" "+
                        c2.getString(2)+" "+
                        c2.getString(3)+" "+
                        c2.getString(4)+" ";

                Toast.makeText(Database2.this,"Record found: "+message,Toast.LENGTH_LONG).show();
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.delete(inp_pid.getText()+"");
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.insert(inp_id.getText().toString(), inp_fname.getText().toString(), inp_email.getText().toString(),inp_phone.getText().toString(),inp_pid.getText().toString());
            }
        });
        go1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Database2.this,Database2.class));
            }
        });

    }
}
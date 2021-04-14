package com.example.midterm2faisal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;

public class Database1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database1);
        setTitle("You are in Activity 2");
        Button go1=findViewById(R.id.btn2act1);

        go1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Database1.this,Database2.class));
            }
        });



        Button select_1=findViewById(R.id.Read_all_raws);
        Button d_1=findViewById(R.id.deleteR);
        TextView r_1=findViewById(R.id.outputfirstR);

        DBHelper dbHelper=new DBHelper(this);

        select_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c1=dbHelper.getAllRow();
                if (c1==null){
                    Toast.makeText(Database1.this,"Empty Table",Toast.LENGTH_SHORT).show();
                    return;
                }
                r_1.setText(c1.getInt(0)+" "+
                            c1.getString(1)+" "+
                            c1.getString(2)+" "+
                            c1.getString(3)+" "+
                            c1.getString(4)+" ");

            }
        });
        d_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.deleteAllRow();
                Toast.makeText(Database1.this,"XX records deleted.",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
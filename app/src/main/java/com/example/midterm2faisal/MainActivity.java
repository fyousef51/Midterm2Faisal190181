package com.example.midterm2faisal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity extends AppCompatActivity {



    AtomicInteger timer=new AtomicInteger(6);
    TextView timerText;
    final Timer t=new Timer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timerText=findViewById(R.id.timer1);
        TimerTask task =new Task();
        t.schedule(task,1000);

    }

    class Task extends TimerTask{

        @Override
        public void run() {
            if (timer.get()!= 1){
                timer.decrementAndGet();
                MainActivity.this.runOnUiThread(new Runnable() {
                    public void run() {
                        timerText.setText(timer.get()+" seconds");
                    }
                });
                t.schedule(new Task(),1000);
            }else{
                finish();
                startActivity(new Intent(MainActivity.this,Database2.class));
            }
        }
    };
}
package com.example.i7_4770k.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class ChangeActivity extends AppCompatActivity {

    private TextView tvInfo;
    private TimePicker timepicker;
    private Button butGetTime;
    private String doublePoint;  // :0 else :

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvInfo = (TextView) findViewById(R.id.textView1);
        timepicker = (TimePicker) findViewById(R.id.timePicker1);

        Calendar now = Calendar.getInstance();

        timepicker.setCurrentHour(now.get(Calendar.HOUR_OF_DAY));
        timepicker.setCurrentMinute(now.get(Calendar.MINUTE));
        timepicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {

            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                /*Toast.makeText(getApplicationContext(), "onTimeChanged",
                        Toast.LENGTH_SHORT).show();*/

                if (minute < 10) doublePoint = ":0";
                else doublePoint = ":";
                tvInfo.setText("Время: " + hourOfDay + doublePoint + minute);
            }
        });

        butGetTime = (Button) findViewById(R.id.button1);

        butGetTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (timepicker.getCurrentMinute() < 10) doublePoint = ":0";
                else doublePoint = ":";
                tvInfo.setText(new StringBuilder()
                        .append(timepicker.getCurrentHour()).append(doublePoint)
                        .append(timepicker.getCurrentMinute()));

                //передача интента в предыдущее активити
                Intent intent = new Intent();
                intent.putExtra("cloc", tvInfo.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}

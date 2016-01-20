package com.example.i7.analogclock;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private TextView tvInfo;
    private TimePicker timepicker;
    private Button butGetTime;
    private String doublePoint;  // :0 else :


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Убираем заголовок
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        // Убираем панель уведомлений
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvInfo = (TextView) findViewById(R.id.textView1);
        timepicker = (TimePicker) findViewById(R.id.timePicker1);

        Calendar now = Calendar.getInstance();



        timepicker.setCurrentHour(now.get(Calendar.HOUR_OF_DAY));
        timepicker.setCurrentMinute(now.get(Calendar.MINUTE));
        timepicker.setOnTimeChangedListener(new OnTimeChangedListener() {

            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                /*Toast.makeText(getApplicationContext(), "onTimeChanged",
                        Toast.LENGTH_SHORT).show();*/

                if (minute<10) doublePoint = ":0"; else doublePoint = ":";
                    tvInfo.setText("Время: " + hourOfDay + doublePoint + minute);
            }
        });

        butGetTime = (Button) findViewById(R.id.button1);

        butGetTime.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                tvInfo.setText(new StringBuilder()
                        .append(timepicker.getCurrentHour()).append(":")
                        .append(timepicker.getCurrentMinute()));
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

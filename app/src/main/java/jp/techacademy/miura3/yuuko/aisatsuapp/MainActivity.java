package jp.techacademy.miura3.yuuko.aisatsuapp;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        mTextView = (TextView) findViewById(R.id.textView);
     }
    @Override
    public void onClick(View v) {
        showTimePickerDialog();
    }

    private void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        int totalMinute = hourOfDay * 60 + minute;
                        //2:00-9:59
                        if( totalMinute >= (2 * 60) &&  totalMinute <= (9 * 60 + 59)) {
                            mTextView.setText("おはよう");
                        }
                        //10:00-17:59
                        else if( totalMinute >= (10 * 60) && totalMinute <= (17 * 60 + 59)) {
                            mTextView.setText("こんにちは");
                        }
                        //その他（18:00-1:59）
                        else {
                            mTextView.setText("こんばんは");
                        }
                    }
                },
                13, // 初期値（時間）
                0,  // 初期値（分）
                true);

        timePickerDialog.show();
    }
}

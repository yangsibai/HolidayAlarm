package me.sibo.HolidayAlarm.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import me.sibo.HolidayAlarm.R;

/**
 * Created by massimo on 14-10-7.
 */
public class AddAlarmActivity extends Activity {
    private ImageButton backBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_alarm);

        backBtn = (ImageButton)this.findViewById(R.id.ib_back);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AddAlarmActivity.this, HomeActivity.class);
                AddAlarmActivity.this.startActivity(intent);
            }
        });
    }
}
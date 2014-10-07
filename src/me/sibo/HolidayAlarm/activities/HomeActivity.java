package me.sibo.HolidayAlarm.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import me.sibo.HolidayAlarm.R;
import me.sibo.HolidayAlarm.adapters.SeparatedListAdapter;

public class HomeActivity extends Activity {

    private final static String[] days = new String[]{"今天", "明天", "后天", "以后"};

    private final static String[] notes =new String[]{"08:00", "08:10", "08:20"};

    private SeparatedListAdapter adapter;

    private ListView alarmListView;
    private ImageButton addAlarmBtn;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //create the list view adapter
        adapter = new SeparatedListAdapter(this);
        ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this, R.layout.list_item, notes);

        for(int i = 0; i < days.length; i++){
            adapter.addSection(days[i], listAdapter);
        }

        alarmListView = (ListView)this.findViewById(R.id.list_alarms);
        alarmListView.setAdapter(adapter);

        alarmListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = (String) adapter.getItem(position);
                Toast.makeText(getApplicationContext(), item, Toast.LENGTH_SHORT).show();
            }
        });
        addAlarmBtn = (ImageButton)this.findViewById(R.id.ib_add_alarm);
        addAlarmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, AddAlarmActivity.class);
                HomeActivity.this.startActivity(intent);
            }
        });
    }
}

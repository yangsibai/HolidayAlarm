package me.sibo.HolidayAlarm.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import me.sibo.HolidayAlarm.R;
import me.sibo.HolidayAlarm.adapters.SeparatedListAdapter;

public class HomeActivity extends Activity {

    private final static String[] days = new String[]{"今天", "明天", "后天", "以后"};

    private final static String[] notes =new String[]{"08:00", "08:10", "08:20"};

    private SeparatedListAdapter adapter;

    private ListView alarmListView;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //create the listview adapter
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
    }
}

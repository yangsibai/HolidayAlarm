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

import java.util.HashMap;
import java.util.Map;

public class HomeActivity extends Activity {

    public final static String ITEM_TITLE = "title";
    public final static String ITEM_CAPTION = "caption";

    private final static String[] days = new String[]{"Mon", "Tue", "Web", "Thur", "Fri"};

    private final static String[] notes =new String[]{"Ate Breakfast", "Ran a Marathan ...yah really", "Slept all day"};

    private ListView addAlarmEntryItem;
    private SeparatedListAdapter adapter;

    private ListView alarmListView;

    public Map<String, ?> createItem(String title, String caption){
        Map<String, String> item = new HashMap<String, String>();
        item.put(ITEM_TITLE, title);
        item.put(ITEM_CAPTION, caption);
        return item;
    }

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

       final ArrayAdapter<String> alarmEntryAdapter = new ArrayAdapter<String>(this, R.layout.add_alarm, new String[]{"Add alarm"});

        addAlarmEntryItem = (ListView)this.findViewById(R.id.add_alarm);
        addAlarmEntryItem.setAdapter(alarmEntryAdapter);
        addAlarmEntryItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = alarmEntryAdapter.getItem(position);
                Toast.makeText(getApplicationContext(), item, Toast.LENGTH_SHORT).show();
            }
        });

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

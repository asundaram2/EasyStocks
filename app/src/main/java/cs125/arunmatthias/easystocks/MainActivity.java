package cs125.arunmatthias.easystocks;

import android.content.ClipData;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String[] items;
    String[] prices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        listView = findViewById(R.id.listView);
        items = res.getStringArray(R.array.stocks);
        prices = res.getStringArray(R.array.prices);

        ItemAdapter itemadapter = new ItemAdapter(this, items, prices);
        listView.setAdapter(itemadapter);

        //used when you click a list item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent showStockActivity = new Intent(getApplicationContext(), DisplayStockInfo.class);
                showStockActivity.putExtra("ITEM_INDEX", items[position]); // displays stock name if I have not added the api call for it
                String toast = items[position];
                Toast.makeText(getApplicationContext(),toast,Toast.LENGTH_LONG).show();
                startActivity(showStockActivity);
            }
        });
    }
}

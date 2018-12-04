package cs125.arunmatthias.easystocks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * displays the name of the stock when you click on the list item
 */
public class DisplayStockInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_stock_info);

        // displays the name of the stock using the position and key from ThirdActivity.class
        if (getIntent().hasExtra("ITEM_INDEX")) {
            TextView secondTV = (TextView) findViewById(R.id.stockNameTextView);
            String text = getIntent().getExtras().getString("ITEM_INDEX");
            secondTV.setText(text);
        }
    }

}

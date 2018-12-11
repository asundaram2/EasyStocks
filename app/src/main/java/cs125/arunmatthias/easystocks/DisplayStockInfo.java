package cs125.arunmatthias.easystocks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


import java.net.MalformedURLException;
import java.net.URL;

/**
 * displays the name of the stock when you click on the list item
 */
public class DisplayStockInfo extends AppCompatActivity {

    public static TextView displayAPIText;
    public URL url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_stock_info);

        // displays the json from the API of the stock
        if (getIntent().hasExtra("ITEM_INDEX")) {
            displayAPIText = findViewById(R.id.displayAPI);
            String text = getIntent().getExtras().getString("ITEM_INDEX");
            if (text.equals("AAPL")) {
                fetchData process = null;
                try {
                    process = new fetchData(new URL("https://api.iextrading.com/1.0/stock/aapl/earnings"));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                process.execute();
            } else if (text.equals("GOOGL")) {
                fetchData process = null;
                try {
                    process = new fetchData(new URL("https://api.iextrading.com/1.0/stock/googl/earnings"));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                process.execute();
            } else if(text.equals("FB")) {
                fetchData process = null;
                try {
                    process = new fetchData(new URL("https://api.iextrading.com/1.0/stock/fb/earnings"));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                process.execute();
            }  else if(text.equals("NFLX")) {
                fetchData process = null;
                try {
                    process = new fetchData(new URL("https://api.iextrading.com/1.0/stock/nflx/earnings"));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                process.execute();
            } else if(text.equals("AMZN")) {
                fetchData process = null;
                try {
                    process = new fetchData(new URL("https://api.iextrading.com/1.0/stock/amzn/earnings"));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                process.execute();
            }else {
                displayAPIText.setText(text);
            }
        }
    }

    public URL getURL() {
        return url;
    }
}

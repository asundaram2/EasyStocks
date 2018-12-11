package cs125.arunmatthias.easystocks;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

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

        // displays the name of the stock using the position and key from ThirdActivity.class
        if (getIntent().hasExtra("ITEM_INDEX")) {
            displayAPIText = (TextView) findViewById(R.id.displayAPI);
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
            } else {
                displayAPIText.setText(text);
            }
        }
    }

    public URL getURL() {
        return url;
    }
}

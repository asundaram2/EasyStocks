package cs125.arunmatthias.easystocks;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * displays the name of the stock when you click on the list item
 */
public class DisplayStockInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_stock_info);

        // displays the graph of the stock using the position and key from ThirdActivity.class
        //TODO stock info API here

        Intent intent = getIntent();
        int index = intent.getIntExtra("ITEM_INDEX", -1);

        if (index > -1) {
            int graph = getGraph(index);
            ImageView imageview = (ImageView) findViewById(R.id.imageView);
            scaleGraph(imageview, graph);
        }
    }

    private int getGraph(int index) {
        switch (index) {
            case 0:
                return R.drawable.apple;
            case 1:
                return R.drawable.google;
            case 2:
                return R.drawable.tyson;
            default:
                return -1;
        }
    }

    private void scaleGraph(ImageView graph, int picture) {

        Display screen = getWindowManager().getDefaultDisplay();
        BitmapFactory.Options options = new BitmapFactory.Options();

        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), picture, options);

        int width = options.outWidth;
        int screenWidth = screen.getWidth();
        if (width > screenWidth) {
            int ratio = Math.round((float)width / (float)screenWidth);
            options.inSampleSize = ratio;
        }

        options.inJustDecodeBounds = false;
        Bitmap scaledGraph = BitmapFactory.decodeResource(getResources(), picture, options);
        graph.setImageBitmap(scaledGraph);
    }

}

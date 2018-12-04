package cs125.arunmatthias.easystocks;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import cs125.arunmatthias.easystocks.R;

/**
 * sets the name and price in the respective label
 */
public class ItemAdapter extends BaseAdapter {

    LayoutInflater mInflater;
    ListView listView;
    String[] items;
    String[] prices;

    public ItemAdapter(Context c, String[] setItems, String[] setPrices) {
        items = setItems;
        prices = setPrices;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int position) {
        return items[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //puts the items and prices in the list text views
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = mInflater.inflate(R.layout.my_listview_data, null);
        TextView nameTextView = (TextView) v.findViewById(R.id.nameTextView);
        TextView priceTextView = (TextView) v.findViewById(R.id.priceTextView);

        String name = items[position];
        String price = prices[position];

        nameTextView.setText(name);
        priceTextView.setText(price);

        return v;
    }
}

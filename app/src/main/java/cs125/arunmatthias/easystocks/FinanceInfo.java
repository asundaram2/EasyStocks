package cs125.arunmatthias.easystocks;

import android.util.Log;

import java.net.URL;

public class FinanceInfo {
    final static String price = "l1";

    public static Stock getStockData(String ticket) {
        String[] companyData;

        Stock stock = new Stock();

        try {
            URL url = new URL("http://chart.finance.yahoo.com/z" );
        } catch (Exception e) {
            Log.d("Error", e.toString());
        }

        return stock;
    }
}

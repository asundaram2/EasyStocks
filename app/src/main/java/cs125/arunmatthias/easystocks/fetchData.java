package cs125.arunmatthias.easystocks;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class fetchData extends AsyncTask<Void, Void, Void> {

    URL url;
    fetchData(URL setURL) {
        url = setURL;
    }
    String data ="";
    String singleParsed ="";
    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = this.url;

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while(line != null){
                line = bufferedReader.readLine();
                data = data + line;
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            Log.d("TAG" , "IO");
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        try {
            JSONObject jObject = new JSONObject(data);
            String priceOpen = jObject.getJSONObject("ohlc").getJSONObject("open").getString("price");
            String priceClose = jObject.getJSONObject("ohlc").getJSONObject("close").getString("price");
            String maxPrice = jObject.getJSONObject("ohlc").getString("high");
            String lowPrice = jObject.getJSONObject("ohlc").getString("low");

            singleParsed =
                    "Price @ Open:   " + priceOpen + "\n" +
                    "Price @ Close:   " + priceClose + "\n" +
                    "Daily High:   " + maxPrice + "\n" +
                    "Daily Low:   " + lowPrice + "\n";
            DisplayStockInfo.displayAPIText.setText(singleParsed);
        } catch (JSONException e) {
            e.printStackTrace();
            Log.d("TAG" , "JSON");
        }


    }

}

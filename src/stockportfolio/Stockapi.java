package stockportfolio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Stockapi {
    private static final String API_KEY = "Q287J9DLK1X91P92";
    private static final String API_URL = "https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=%s&apikey=%s";

    public static double getLiveStockPrice(String symbol) {
        try {
            String requestUrl = String.format(API_URL, symbol, API_KEY);
            URL url = new URL(requestUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();


            return extractLivePrice(response.toString());

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    private static double extractLivePrice(String response) {

        String searchKey = "\"05. price\": \"";
        int startIndex = response.indexOf(searchKey);
        if (startIndex == -1) {
            return -1;
        }
        startIndex += searchKey.length();
        int endIndex = response.indexOf("\"", startIndex);
        String priceStr = response.substring(startIndex, endIndex);

        try {
            return Double.parseDouble(priceStr);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}

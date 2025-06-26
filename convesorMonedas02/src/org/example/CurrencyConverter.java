package org.example;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class CurrencyConverter {
    private static final String API_KEY = "dde562d9934f3885af310b2a"; // Reemplaza con tu API Key
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/USD";

    public static JsonObject getRates() throws Exception {
        URL url = new URL(API_URL);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        InputStreamReader reader = new InputStreamReader(request.getInputStream());
        JsonObject json = JsonParser.parseReader(reader).getAsJsonObject();
        return json.getAsJsonObject("conversion_rates");
    }

    public static double convertToUSD(double amount, double rate) {
        return amount / rate;
    }

    public static double convertFromUSD(double amount, double rate) {
        return amount * rate;
    }
}
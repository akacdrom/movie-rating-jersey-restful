package org.client;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetRequest {
    public String getMoviePoster(String movieName) throws IOException {
        movieName = movieName.replace(" ","+");
        URL url = new URL("https://api.themoviedb.org/3/search/movie?api_key=15d2ea6d0dc1d476efbca3eba2b9bbfb&query="+movieName+"&callback=?");

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + conn.getResponseCode());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
        String jsonObj = br.readLine();
        int i = jsonObj.indexOf("{");
        jsonObj = jsonObj.substring(i);
        JSONObject jsonObject = new JSONObject(jsonObj);
        String pageName = jsonObject.getJSONArray("results").getJSONObject(0).getString("poster_path");

        conn.disconnect();
        return "https://image.tmdb.org/t/p/w500"+pageName;
    }
}

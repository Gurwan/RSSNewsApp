package studio.okaria.fluxrss.Common;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Allows to connect the app to the feed
 */
public class HTTPDataHandler {

    static String ret = null;

    public String getData(String urlS) {
        try {
            URL url = new URL(urlS);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {

                InputStream inputStream = new BufferedInputStream(urlConnection.getInputStream());

                BufferedReader bufferedReader = new BufferedReader((new InputStreamReader(inputStream)));
                StringBuilder sb = new StringBuilder();
                String line;

                while ((line = bufferedReader.readLine()) != null) {
                    sb.append(line);
                }

                ret = sb.toString();
                urlConnection.disconnect();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ret;
    }
}

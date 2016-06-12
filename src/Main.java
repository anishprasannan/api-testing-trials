import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    public static void main(String[] args) {

        try {
            URL url =new URL("http://maps.googleapis.com/maps/api/geocode/json?address=chicago&sensor=false&#8221");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept","application/json");
            System.out.println(connection.getResponseCode());
            InputStream inputStream = connection.getInputStream();
            String fullString = IOUtils.toString(inputStream, connection.getContentEncoding());
            JSONObject jsonObject = new JSONObject(fullString);
            InputStream inputStream1 = Main.class.getResourceAsStream("\\sample.json");
            System.out.println(inputStream1);
            /*String fullString1 = IOUtils.toString(inputStream1, "UTF-8");
            JSONObject jsonObject1 = new JSONObject(fullString1);
            System.out.println(jsonObject.equals(jsonObject1));*/
            //jsonObject.equals
            //System.out.println(fullString);
            connection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package downloader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import org.json.JSONException;

/**
 *
 * @author zacky
 */
public class asdwe {
     public static void main(String args[]) throws JSONException, MalformedURLException, IOException {
    URL url = new URL("http://www.mangahere.co/manga/narakarana/c000/");
    URLConnection spoof = url.openConnection();

    //Spoof the connection so we look like a web browser
    spoof.setRequestProperty( "User-Agent", "Mozilla/4.0 (compatible; MSIE 5.5; Windows NT 5.0;    H010818)" );
    BufferedReader in = new BufferedReader(new InputStreamReader(spoof.getInputStream()));
    String strLine = "";
    String finalHTML = "";
    //Loop through every line in the source
    while ((strLine = in.readLine()) != null){
       finalHTML += strLine;
    }
         System.out.println(finalHTML);
         }
}

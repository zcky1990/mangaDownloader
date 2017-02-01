/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author soeltan_z
 */
public class Util {
    public void generateConfig() throws JSONException{
        String path = System.getProperty("user.dir").toString();
        String config = "[\n" +
                        "  {\n" +
                        "    \"manga_site\": \"MangaHere\",\n" +
                        "    \"manga_url\":\"http://www.mangahere.co/mangalist/\",\n" +
                        "    \"config\": {\n" +
                        "      \"manga_list\": \"manga_info\",\n" +
                        "      \"description\": \"manga_detail_top\",\n" +
                        "      \"chapter\": \"detail_list\",\n" +
                        "      \"pages\": \"wid60\",\n" +
                        "      \"image\": \"viewer\"\n" +
                        "    }\n" +
                        "  }\n" +
                        "]";
        JSONArray array = new JSONArray(config);

         try{
            PrintWriter writer = new PrintWriter("config_manga", "UTF-8");
            writer.println(array);
            writer.close();
         } catch (IOException e) {

        }
    }
    
    public void generateSystemSetting() throws JSONException{
        String path = System.getProperty("user.dir").toString();
        JSONArray mangaList = new JSONArray();
        mangaList.put("Manga Here");
        
        JSONObject obj = new JSONObject();
            obj.put("destinationPath", path);
            obj.put("mangaList", mangaList);
        
        JSONArray mangaSiteSelected = new JSONArray();
        
        JSONObject mangaHereSiteselected = new JSONObject();
        mangaHereSiteselected.put("mangaSite", "Manga Here");
        mangaHereSiteselected.put("isSelected", true);
        
        mangaSiteSelected.put(mangaHereSiteselected);
        
        obj.put("selectedMangaSite", mangaSiteSelected);
        
         try{
            PrintWriter writer = new PrintWriter("configDownload", "UTF-8");
            writer.println(obj);
            writer.close();
         } catch (IOException e) {

        }
    }
    
    public String requestFile(String fileName){
		File file = new File(fileName);
		FileInputStream fis = null;
                try {
                    fis = new FileInputStream(file);
                } catch (FileNotFoundException ex) {
                    return "fileNotFound";
                }
	
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		String line;
		String textStr = "";
		try {
			while ((line = br.readLine()) != null) {
				textStr = textStr + line;
			} 
		
			br.close();
		} catch (IOException e) {

		}
		try {
			br.close();
			fis.close();
		} catch (IOException e) {

		}
		return textStr;
	}
}

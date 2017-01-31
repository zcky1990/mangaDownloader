/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import static downloader.MangaDownloader.util;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author soeltan_z
 */
public class DownloaderConfig {
    private String mangaSite;
    private String manga_list;
    private String manga_url;
    private String description;
    private String chapter;
    private String pages;
    private String image;
    private JSONArray mangaConfiguration;
    private JSONObject downloaderConfiguration;
    private String path;
    private String [] mangaList;
    
    public void setMangaConfig(String defaultMangaSite) throws JSONException, IOException{
        String test = util.requestFile("config_manga");
        if(test.equalsIgnoreCase("fileNotFound")){
            util.generateConfig();
            test = util.requestFile("config_manga");
        }
        
        String downloadConfig = util.requestFile("configDownload");
        if(downloadConfig.equalsIgnoreCase("fileNotFound")){
            util.generateSystemSetting();
            downloadConfig = util.requestFile("configDownload");
        }
               
        if(!test.equalsIgnoreCase("fileNotFound")){
            mangaConfiguration = new JSONArray(test);
        }else {
            mangaConfiguration = new JSONArray();
        }
        for(int i = 0 ; i < mangaConfiguration.length(); i++){
            JSONObject mangaConfig = mangaConfiguration.getJSONObject(i);
            String siteManga = mangaConfig.getString("manga_site");
            String url = mangaConfig.getString("manga_url");
            JSONObject siteConfig = mangaConfig.getJSONObject("config");
            if(siteManga.equalsIgnoreCase(defaultMangaSite)){
                this.mangaSite = siteManga;
                this.manga_url = url;
                this.manga_list = siteConfig.getString("manga_list");
                this.description = siteConfig.getString("description");
                this.chapter = siteConfig.getString("chapter");
                this.pages = siteConfig.getString("pages");
                this.image = siteConfig.getString("image");
                break;
            }
        }
        
        if(!downloadConfig.equalsIgnoreCase("fileNotFound")){
            downloaderConfiguration = new JSONObject(downloadConfig);
        }else {
            downloaderConfiguration = new JSONObject();
        }
        
        if(downloaderConfiguration.has("destinationPath")){
            path = downloaderConfiguration.getString("destinationPath");
        }else {
            path = System.getProperty("user.dir").toString();
        }
        
        if(downloaderConfiguration.has("mangaList")){
            JSONArray mangaListArray =  downloaderConfiguration.getJSONArray("mangaList");
            System.out.println(mangaListArray.get(0));
            mangaList = new String [mangaListArray.length()];
            for(int i= 0 ;i < mangaListArray.length(); i++){
                mangaList[i] = mangaListArray.get(i).toString();
            }
        }
        
    }

    public String getMangaSite() {
        return mangaSite;
    }

    public void setMangaSite(String mangaSite) {
        this.mangaSite = mangaSite;
    }

    public String getManga_list() {
        return manga_list;
    }

    public void setManga_list(String manga_list) {
        this.manga_list = manga_list;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getManga_url() {
        return manga_url;
    }

    public void setManga_url(String manga_url) {
        this.manga_url = manga_url;
    }

    public JSONArray getMangaConfiguration() {
        return mangaConfiguration;
    }

    public void setMangaConfiguration(JSONArray mangaConfiguration) {
        this.mangaConfiguration = mangaConfiguration;
    }

    public JSONObject getDownloaderConfiguration() {
        return downloaderConfiguration;
    }

    public void setDownloaderConfiguration(JSONObject downloaderConfiguration) {
        this.downloaderConfiguration = downloaderConfiguration;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String[] getMangaList() {
        return mangaList;
    }

    public void setMangaList(String[] mangaList) {
        this.mangaList = mangaList;
    }
    
    
}

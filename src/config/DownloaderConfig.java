/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import static downloader.MangaDownloader.util;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import model.SelectedMangaOption;
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
    private ArrayList<SelectedMangaOption > selectedmangaList;
    private String defaultMangaSite;
    
    public void setMangaConfig() throws JSONException, IOException{
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
        
               
        if(!downloadConfig.equalsIgnoreCase("fileNotFound")){
            downloaderConfiguration = new JSONObject(downloadConfig);
        }else {
            downloaderConfiguration = new JSONObject();
        }
        
        //get active mangaSite
        if(downloaderConfiguration.has("defaultMangaSite")){
            defaultMangaSite = downloaderConfiguration.getString("defaultMangaSite");
        }else {
            defaultMangaSite = "Manga Here";
        }
        if(downloaderConfiguration.has("destinationPath")){
            path = downloaderConfiguration.getString("destinationPath");
        }else {
            path = System.getProperty("user.dir").toString();
        }
        
        System.out.println(""+mangaConfiguration);
        //setActiveMangaSite and set all  jsoup parsing config
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
                
        selectedmangaList = new ArrayList<SelectedMangaOption >();
        
        ArrayList<String> selectedMangaSiteArray = new ArrayList<String>();
        if(downloaderConfiguration.has("selectedMangaSite")){
         JSONArray selectedSite =  downloaderConfiguration.getJSONArray("selectedMangaSite");
         for(int i= 0 ;i < selectedSite.length(); i++){
               JSONObject selectedMangaSite = selectedSite.getJSONObject(i);
               boolean isSelected = selectedMangaSite.getBoolean("isSelected");
               if(isSelected){
                    selectedMangaSiteArray.add(selectedMangaSite.getString("mangaSite"));
               }
               selectedmangaList.add(new SelectedMangaOption(selectedMangaSite.getBoolean("isSelected"),selectedMangaSite.getString("mangaSite")));
            }
        }
        
        //add selected manga site as list of site manga available
        mangaList = new String [selectedMangaSiteArray.size()];
            for(int i= 0 ;i < selectedMangaSiteArray.size(); i++){
                mangaList[i] = selectedMangaSiteArray.get(i).toString();
            }
        
    }
    
    public void saveConfig() throws JSONException{
        JSONObject obj = new JSONObject();
        obj.put("destinationPath", this.path);
        
        JSONArray mangaSiteSelected = new JSONArray();
        for(int i = 0; i < selectedmangaList.size();i++){
            SelectedMangaOption mngOptSel = selectedmangaList.get(i);          
            JSONObject mangaHereSiteselected = new JSONObject();
            mangaHereSiteselected.put("mangaSite", mngOptSel.getMangaSite());
            mangaHereSiteselected.put("isSelected", mngOptSel.isIsSelected());
            mangaSiteSelected.put(mangaHereSiteselected);
        }
         obj.put("selectedMangaSite", mangaSiteSelected);
         
         try{
            PrintWriter writer = new PrintWriter("configDownload", "UTF-8");
            writer.println(obj);
            writer.close();
         } catch (IOException e) {

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

    public ArrayList<SelectedMangaOption > getSelectedmangaList() {
        return selectedmangaList;
    }

    public void setSelectedmangaList(ArrayList<SelectedMangaOption > selectedmangaList) {
        this.selectedmangaList = selectedmangaList;
    }

    public String getDefaultMangaSite() {
        return defaultMangaSite;
    }

    public void setDefaultMangaSite(String defaultMangaSite) {
        this.defaultMangaSite = defaultMangaSite;
    }
    
    
}

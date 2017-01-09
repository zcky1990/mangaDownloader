/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package option;

import config.DownloaderConfig;
import static downloader.MangaDownloader.util;
import java.util.ArrayList;
import model.Manga;
import org.json.JSONException;
import Util.MangaUtility;
import java.io.IOException;

/**
 *
 * @author soeltan_z
 */
public class option {
    private String defaultMangaSite;
    private String []listManga;
    private String PATH;
    private DownloaderConfig config;
    private boolean isSuccesSetConfig;
    private ArrayList<Manga> mangaList;
    MangaUtility utility = new MangaUtility();

    public String[] getListManga() {
        return listManga;
    }

    public void setListManga(String[] listManga) {
        this.listManga = listManga;
    }

    public boolean isIsSuccesSetConfig() {
        return isSuccesSetConfig;
    }

    public void setIsSuccesSetConfig(boolean isSuccesSetConfig) {
        this.isSuccesSetConfig = isSuccesSetConfig;
    }

    public ArrayList<Manga> getMangaList() {
        return mangaList;
    }

    public void setMangaList(ArrayList<Manga> mangaList) {
        this.mangaList = mangaList;
    }
    
    public option(DownloaderConfig config) throws JSONException, IOException{
      this.config = config;
    }
    
    public void getmangaList() throws JSONException, IOException{
        this.mangaList = utility.readMangaList(this.config.getMangaSite());
            if(!(this.mangaList.size()> 0)){   
                utility.generateMangaList(this.config.getMangaSite(), this.config.getManga_url(), this.config.getManga_list());
                this.mangaList = utility.readMangaList(this.config.getMangaSite());
            }
    }
    
    public void generateListItem(){
        String[] toppings = new String[this.mangaList.size()];
        for(int i = 0 ; i < this.mangaList.size(); i++){
           toppings[i] = this.mangaList.get(i).getTitle();
        }
        this.listManga = toppings;
    }

    public String getDefaultMangaSite() {
        return defaultMangaSite;
    }

    public void setDefaultMangaSite(String defaultMangaSite) {
        this.defaultMangaSite = defaultMangaSite;
    }

    public String getPATH() {
        return PATH;
    }

    public void setPATH(String PATH) {
        this.PATH = PATH;
    }

    public DownloaderConfig getConfig() {
        return config;
    }

    public void setConfig(DownloaderConfig config) {
        this.config = config;
    }

    public MangaUtility getUtility() {
        return utility;
    }

    public void setUtility(MangaUtility utility) {
        this.utility = utility;
    }
    
}

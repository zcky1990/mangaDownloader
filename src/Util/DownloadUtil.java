/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import config.DownloaderConfig;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JTable;
import model.Chapter;
import model.Download;
import model.Manga;
import model.Pages;

/**
 *
 * @author soeltan_z
 */
public class DownloadUtil {
    
    DownloaderConfig config;
    JTable downloadTabel;
    MangaDownloaderAPI controller;
    
    
    public DownloadUtil() {

    }
    
    public DownloadUtil(DownloaderConfig config, JTable downloadTabel , MangaDownloaderAPI controller) {
        this.downloadTabel =downloadTabel;
        this.config = config;
        this.controller = controller;
    }
    
    public void download(javax.swing.JTable table, Download download){
        Manga manga = download.getManga();
        String title = manga.getTitle();
        ArrayList<Chapter> chapter = manga.getMangaDetails().getChapters();
        MangaDownloaderAPI api = new MangaDownloaderAPI();
        String destinationPath = this.config.getPath();
        for(int i = 0 ; i < chapter.size(); i++){
            Chapter mangaChapter = chapter.get(i);
            String chapterName = mangaChapter.getChapterTitle();
            String urlChapter = mangaChapter.getUrlChapter();
            Pages mangaPages = api.getChapterPageList(urlChapter, this.config.getPages());
            mangaChapter.setPage(mangaPages);
            ArrayList<String> pageURL = mangaPages.getPageMangaUrl();
            for(int j = 0 ; j < pageURL.size(); j++){
                String urlImage = pageURL.get(j);
                String url = this.controller.getImage(urlImage, this.config.getImage());
                String imageName = ""+(j+1);
                
                downLoadImage(url,title, chapterName ,imageName,destinationPath);
            }
        }
    
    }
    
    public String downLoadImage(String url, String title, String chapterName, String imageName, String destinationPath){
     BufferedImage image = null;
     String status="";
      if(destinationPath.equalsIgnoreCase("")){
                destinationPath = System.getProperty("user.dir").toString();
            }
            
            String output = destinationPath+"/"+title+"/"+chapterName+"/"+imageName+".png";  
            File theDir = new File( destinationPath+"/"+title+"/"+chapterName);

           if (!theDir.exists()) {
               System.out.println("status create "+theDir.canWrite());
            if (theDir.mkdirs()) {
                System.out.println("Directory is created!");
            } else {
                System.out.println("Failed to create directory!");
                 status = "failed to create folder";
            }
        }
          if(!status.equalsIgnoreCase("failed to create folder")){
                try {

                    URL imageUrl = new URL(url);
                    image = ImageIO.read(imageUrl);
                    ImageIO.write(image, "png",new File(output));
                    status = "success";
                } catch (IOException e) {
                        e.printStackTrace();
                    status = e.getMessage();
                }
          }
          return status;
    }
   
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author soeltan_z
 */
public class Download {
    private Manga manga;

    public Download(Manga manga) {
        this.manga = manga;
    }
    
    public void setManga(Manga manga){
        this.manga = manga;
    }
    
    public Manga getManga(){
        return this.manga;
    }
    
}

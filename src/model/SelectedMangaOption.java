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
public class SelectedMangaOption {
    
    private boolean isSelected;
    private String mangaSite;

    public SelectedMangaOption( boolean isSelected,String mangaSite){
        this.isSelected = isSelected;
        this.mangaSite = mangaSite;
    }

    public boolean isIsSelected() {
        return isSelected;
    }

    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    public String getMangaSite() {
        return mangaSite;
    }

    public void setMangaSite(String mangaSite) {
        this.mangaSite = mangaSite;
    }
    
    

    
}

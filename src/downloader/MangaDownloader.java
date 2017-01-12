/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package downloader;

import Util.MangaDownloaderAPI;
import Util.MangaDownloaderController;
import Util.Util;
import config.DownloaderConfig;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import model.Chapter;
import model.Manga;
import model.MangaDetails;
import model.Pages;
import option.option;
import org.json.JSONException;

/**
 *
 * @author soeltan_z
 */
public class MangaDownloader extends javax.swing.JFrame {
     public static Util util = new Util();
     public MangaDownloaderAPI controller = new MangaDownloaderAPI();
     public option opt;
     private String[] strings;
     private ArrayList<Integer>searchIndex;
     private String searchVal ="";
     private int searchIndexitr = 0;
     private DownloaderConfig config;
    /**
     * Creates new form MangaDownloader
     */
     
    public boolean getConfig() throws JSONException, IOException{
        boolean isSuccesSetConfig = false;
        
        //get option configuration to get selected mangaSite
        String optionConfig = util.requestFile("option");
        String defaultMangaSite = null;
        if(optionConfig.equalsIgnoreCase("fileNotFound")){
            defaultMangaSite = "MangaHere";
        }else {
         
        }
     
        //set mangasite to config
        this.config.setMangaConfig(defaultMangaSite);
        System.out.println("getMangaSite "+ this.config.getMangaSite());
        this.opt.setDefaultMangaSite(defaultMangaSite);
        
        //
        String mangaList = util.requestFile(this.config.getMangaSite());
        System.out.println("mangaList.length()" + mangaList.length());
        
        if(!this.config.getMangaSite().isEmpty() && mangaList.length() > 12){
            isSuccesSetConfig = true;
        }
     
        if(isSuccesSetConfig){
            this.opt.getmangaList();
            this.opt.generateListItem();
        }
      
     return isSuccesSetConfig;
    }
     
    public MangaDownloader() throws JSONException, IOException {
         this.config = new DownloaderConfig();
         this.opt = new option(this.config);
         boolean isSuccesGetConfig = this.getConfig();
          
         System.out.println("isSuccesGetConfig " + isSuccesGetConfig);
         if(!isSuccesGetConfig){
            Init initialize = new Init();
            initialize.setVisible(true);
            initialize.setLabelText("Generating Manga List....");
            this.opt.getmangaList();
            this.opt.generateListItem();
            initialize.setLabelText("Generating Manga List Completed.");
            initialize.setVisible(false);
         }
         
        strings = this.opt.getListManga();
        searchIndex = new ArrayList<Integer>();
        initComponents();
        listOfManga.setModel(new javax.swing.AbstractListModel<String>() {      
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listOfManga.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jScrollPane1.setViewportView(listOfManga);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        top = new javax.swing.JPanel();
        bottom = new javax.swing.JPanel();
        left = new javax.swing.JPanel();
        listPane = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        searchPane = new javax.swing.JPanel();
        searchField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        mangaListPane = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listOfManga = new javax.swing.JList<>();
        right = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout topLayout = new javax.swing.GroupLayout(top);
        top.setLayout(topLayout);
        topLayout.setHorizontalGroup(
            topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        topLayout.setVerticalGroup(
            topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
        );

        listPane.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Manga List", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));
        listPane.setLayout(new java.awt.GridLayout(1, 0));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        listPane.add(jComboBox1);

        searchPane.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));
        searchPane.setLayout(new javax.swing.BoxLayout(searchPane, javax.swing.BoxLayout.LINE_AXIS));

        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchFieldKeyPressed(evt);
            }
        });
        searchPane.add(searchField);

        ImageIcon imageIcon = new javax.swing.ImageIcon(getClass().getResource("/downloader/Search-button.png")); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        imageIcon = new ImageIcon(newimg);
        jButton1.setIcon(imageIcon);
        jButton1.setToolTipText("");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        searchPane.add(jButton1);

        listOfManga.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        listOfManga.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listOfManga.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        listOfManga.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listOfMangaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listOfManga);

        javax.swing.GroupLayout mangaListPaneLayout = new javax.swing.GroupLayout(mangaListPane);
        mangaListPane.setLayout(mangaListPaneLayout);
        mangaListPaneLayout.setHorizontalGroup(
            mangaListPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mangaListPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                .addContainerGap())
        );
        mangaListPaneLayout.setVerticalGroup(
            mangaListPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout leftLayout = new javax.swing.GroupLayout(left);
        left.setLayout(leftLayout);
        leftLayout.setHorizontalGroup(
            leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mangaListPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(leftLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(listPane, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                    .addComponent(searchPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        leftLayout.setVerticalGroup(
            leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(listPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mangaListPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout rightLayout = new javax.swing.GroupLayout(right);
        right.setLayout(rightLayout);
        rightLayout.setHorizontalGroup(
            rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 466, Short.MAX_VALUE)
            .addGroup(rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(rightLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        rightLayout.setVerticalGroup(
            rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 448, Short.MAX_VALUE)
            .addGroup(rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(rightLayout.createSequentialGroup()
                    .addGap(9, 9, 9)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(19, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout bottomLayout = new javax.swing.GroupLayout(bottom);
        bottom.setLayout(bottomLayout);
        bottomLayout.setHorizontalGroup(
            bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bottomLayout.createSequentialGroup()
                .addGap(254, 254, 254)
                .addComponent(right, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(bottomLayout.createSequentialGroup()
                    .addComponent(left, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 466, Short.MAX_VALUE)))
        );
        bottomLayout.setVerticalGroup(
            bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(right, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(bottomLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(left, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(22, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(top, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(bottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(top, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bottom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void searchFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyPressed
        if (evt.getKeyCode() == 10){
            searchMangaList();
        }
    }//GEN-LAST:event_searchFieldKeyPressed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        searchMangaList();
    }//GEN-LAST:event_jButton1MouseClicked

    private void listOfMangaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listOfMangaMouseClicked
             //TODO add your handling code here:
             int index =  listOfManga.getSelectedIndex();
             this.getSelectedMangaDescription(index);

    }//GEN-LAST:event_listOfMangaMouseClicked

    public void getSelectedMangaDescription(int index){
        try {
             //TODO add your handling code here:
             System.out.println("index " + index);
             ArrayList<Manga> mangaList = this.opt.getMangaList();
             Manga manga = mangaList.get(index);
             System.out.println("url " + manga.getUrlManga());
             System.out.println("title Manga " + manga.getTitle());
             
             //get Manga Description
             MangaDetails detailsManga = this.controller.getMangaDescription( manga.getUrlManga(),this.config.getDescription());
             
             //get Manga Chapters
            ArrayList<Chapter> chapterlist = this.controller.getMangaChapter(manga.getUrlManga(), this.config.getChapter());
            
            detailsManga.setChapters(chapterlist);
            manga.setMangaDetails(detailsManga);
           
            MangaDetailsFrame descFrame = new MangaDetailsFrame(manga.getTitle(),  manga.getMangaDetails());
            descFrame.setVisible(true);
         } catch (JSONException ex) {
             Logger.getLogger(MangaDownloader.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    public void searchMangaList(){
    if(searchVal.contentEquals("") || !(searchVal.equalsIgnoreCase(searchField.getText().toString().toLowerCase()))){
                searchIndex.clear();
                searchIndexitr = 0;
                String value = searchField.getText().toString().toLowerCase();
                searchVal = value;
                for(int i = 0 ; i < strings.length; i++){
                String title = strings[i].toLowerCase();
                    if(title.contains(value)){
                       searchIndex.add(i);
                    }
                }
                if(searchIndex.size() > 0){
                    listOfManga.setSelectedIndex(searchIndex.get(searchIndexitr));
                    listOfManga.ensureIndexIsVisible(listOfManga.getSelectedIndex());
                }
                
            }else if(searchVal.equalsIgnoreCase(searchField.getText().toString().toLowerCase())){
                searchIndexitr++;
                if(searchIndexitr == (searchIndex.size()-1) ){
                    searchIndexitr--;
                }
               if(searchIndex.size() > 0){
                    listOfManga.setSelectedIndex(searchIndex.get(searchIndexitr));
                    listOfManga.ensureIndexIsVisible(listOfManga.getSelectedIndex());
                }
            }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MangaDownloader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MangaDownloader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MangaDownloader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MangaDownloader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MangaDownloader().setVisible(true);
                } catch (JSONException ex) {
                    Logger.getLogger(MangaDownloader.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(MangaDownloader.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bottom;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel left;
    private javax.swing.JList<String> listOfManga;
    private javax.swing.JPanel listPane;
    private javax.swing.JPanel mangaListPane;
    private javax.swing.JPanel right;
    private javax.swing.JTextField searchField;
    private javax.swing.JPanel searchPane;
    private javax.swing.JPanel top;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package downloader;

import Util.DownloadUtil;
import Util.MangaDownloaderAPI;
import Util.MangaDownloaderController;
import Util.Util;
import clickedMenu.ClickedMenu;
import config.DownloaderConfig;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import model.Chapter;
import model.Download;
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
     private static DownloaderConfig config;
     private static DownloadUtil utilDownload;
     private static ArrayList<Download> downloadedManga;

    /**
     * Creates new form MangaDownloader
     */
     
    public boolean getConfig() throws JSONException, IOException{
        boolean isSuccesSetConfig = false;
             
        //set mangasite to config
        this.config.setMangaConfig();
        this.opt.setDefaultMangaSite(this.config.getDefaultMangaSite());
        
        System.out.println(this.config.getMangaSite());
        
        //used to chek if mangaList file exits or not
        String mangaList = util.requestFile(this.config.getMangaSite());
        
        if(!this.config.getMangaSite().isEmpty() && !mangaList.equalsIgnoreCase("fileNotFound")){
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
         this.downloadedManga = new ArrayList<Download>();
         boolean isSuccesGetConfig = this.getConfig();
         utilDownload = new DownloadUtil (this.config, downloadTabel, controller);
         
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

        //set set mangalist
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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        bottom = new javax.swing.JPanel();
        left = new javax.swing.JPanel();
        searchPane = new javax.swing.JPanel();
        searchField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        mangaListPane = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listOfManga = new javax.swing.JList<>();
        updtList = new javax.swing.JButton();
        settingBtn = new javax.swing.JButton();
        right = new javax.swing.JPanel();
        updateStatusTxt = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        downloadTabel = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Manga Here Downloader");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/downloader/Sfh9SQ5 2.jpg"))); // NOI18N
        jLabel2.setInheritsPopupMenu(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1129, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1129, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 626, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE))
        );

        bottom.setOpaque(false);

        left.setOpaque(false);

        searchPane.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Lucida Grande", 0, 13), new java.awt.Color(255, 255, 255))); // NOI18N
        searchPane.setForeground(new java.awt.Color(255, 255, 255));
        searchPane.setOpaque(false);
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

        mangaListPane.setOpaque(false);

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                .addContainerGap())
        );
        mangaListPaneLayout.setVerticalGroup(
            mangaListPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mangaListPaneLayout.createSequentialGroup()
                .addGap(0, 16, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        updtList.setText("Update");
        updtList.setToolTipText("Update Manga List");
        updtList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updtListActionPerformed(evt);
            }
        });

        settingBtn.setText("Setting");
        settingBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout leftLayout = new javax.swing.GroupLayout(left);
        left.setLayout(leftLayout);
        leftLayout.setHorizontalGroup(
            leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mangaListPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(leftLayout.createSequentialGroup()
                .addGroup(leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(leftLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(updtList, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(settingBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(searchPane, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE))
                .addContainerGap())
        );
        leftLayout.setVerticalGroup(
            leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(settingBtn)
                    .addComponent(updtList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(searchPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mangaListPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        right.setOpaque(false);

        updateStatusTxt.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        downloadTabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title", "Manga Resource", "Status", "Download Date", "Chapter List", "Chapter Download", "Progress", "Downloaded Chapter"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        downloadTabel.setOpaque(false);
        downloadTabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                downloadTabelMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                downloadTabelMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(downloadTabel);

        javax.swing.GroupLayout rightLayout = new javax.swing.GroupLayout(right);
        right.setLayout(rightLayout);
        rightLayout.setHorizontalGroup(
            rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rightLayout.createSequentialGroup()
                .addContainerGap(597, Short.MAX_VALUE)
                .addComponent(updateStatusTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rightLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 817, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        rightLayout.setVerticalGroup(
            rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rightLayout.createSequentialGroup()
                .addContainerGap(428, Short.MAX_VALUE)
                .addComponent(updateStatusTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(rightLayout.createSequentialGroup()
                    .addGap(9, 9, 9)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(29, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout bottomLayout = new javax.swing.GroupLayout(bottom);
        bottom.setLayout(bottomLayout);
        bottomLayout.setHorizontalGroup(
            bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bottomLayout.createSequentialGroup()
                .addContainerGap(294, Short.MAX_VALUE)
                .addComponent(right, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(bottomLayout.createSequentialGroup()
                    .addComponent(left, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 764, Short.MAX_VALUE)))
        );
        bottomLayout.setVerticalGroup(
            bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(right, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(bottomLayout.createSequentialGroup()
                    .addComponent(left, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 14, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(162, Short.MAX_VALUE)
                .addComponent(bottom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void settingBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingBtnActionPerformed
         Option option = new Option(this.config);
         option.setVisible(true);
    }//GEN-LAST:event_settingBtnActionPerformed

    private void updtListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updtListActionPerformed
        updateStatusTxt.setText("Updating manga list...");
        
        new Thread(new Runnable() {
            public void run() {
               updateMangaListBox();
            }
        }).start();
         
    }//GEN-LAST:event_updtListActionPerformed

    private void downloadTabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_downloadTabelMouseClicked
        
   
    
            
    }//GEN-LAST:event_downloadTabelMouseClicked

    private void downloadTabelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_downloadTabelMouseReleased
        boolean isRightClick = SwingUtilities.isRightMouseButton(evt);
        if(isRightClick){
            int row = downloadTabel.rowAtPoint( evt.getPoint() );
            int column = downloadTabel.columnAtPoint( evt.getPoint() );
            Object asdw = downloadTabel.getValueAt(row, 2);
            String status = "";
            
            if(asdw != null){
                status = asdw.toString();
            }else {
                status = "column empty";
            }

            int[] numbOfRowSelected = downloadTabel.getSelectedRows();

            boolean multipleSelection = false;
            if(numbOfRowSelected.length > 1){
                multipleSelection = true;
            }

            ClickedMenu menu = new ClickedMenu(row,downloadTabel, status, multipleSelection , numbOfRowSelected, downloadedManga , utilDownload);
            menu.show(evt.getComponent(), evt.getX(), evt.getY());
        }
   
        
    }//GEN-LAST:event_downloadTabelMouseReleased

    public void updateMangaListBox (){
     try {
           this.opt.updateMangaList();
         } catch (JSONException ex) {
             Logger.getLogger(MangaDownloader.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
             Logger.getLogger(MangaDownloader.class.getName()).log(Level.SEVERE, null, ex);
         }
       
        this.opt.generateListItem();
        strings = this.opt.getListManga();
         //set set mangalist
        listOfManga.setModel(new javax.swing.AbstractListModel<String>() {      
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listOfManga.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jScrollPane1.setViewportView(listOfManga);
        updateStatusTxt.setText("Done Updating Manga List.");
         try {
             Thread.sleep(10000);
             updateStatusTxt.setVisible(false);
         } catch (InterruptedException ex) {
             Logger.getLogger(MangaDownloader.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    public void getSelectedMangaDescription(int index){
        try {
             ArrayList<Manga> mangaList = this.opt.getMangaList();
             Manga manga = mangaList.get(index);

             //get Manga Description
             MangaDetails detailsManga = this.controller.getMangaDescription( manga.getUrlManga(),this.config.getDescription());
             
             //get Manga Chapters
            ArrayList<Chapter> chapterlist = this.controller.getMangaChapter(manga.getUrlManga(), this.config.getChapter());
            
            detailsManga.setChapters(chapterlist);
            manga.setMangaDetails(detailsManga);
           
            MangaDetailsFrame descFrame = new MangaDetailsFrame(manga.getTitle(), manga);
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
    private static javax.swing.JTable downloadTabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel left;
    private javax.swing.JList<String> listOfManga;
    private javax.swing.JPanel mangaListPane;
    private javax.swing.JPanel right;
    private javax.swing.JTextField searchField;
    private javax.swing.JPanel searchPane;
    private javax.swing.JButton settingBtn;
    private javax.swing.JLabel updateStatusTxt;
    private javax.swing.JButton updtList;
    // End of variables declaration//GEN-END:variables

    
    public interface downloadListener{
        javax.swing.JTable jTableDownload = downloadTabel;
        ArrayList<Download> download = downloadedManga;
        DownloaderConfig dataConfig = config;
        DownloadUtil utilDownloadImage =  utilDownload;
        
        public ArrayList<Download> getDownload();
        public javax.swing.JTable getjTableDownload();
        public DownloaderConfig getConfig();
        public DownloadUtil getUtilDowload();

    }
}



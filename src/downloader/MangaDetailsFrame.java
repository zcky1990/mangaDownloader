/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package downloader;

import Util.DownloadUtil;
import config.DownloaderConfig;
import downloader.MangaDownloader.downloadListener;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Chapter;
import model.Download;
import model.Manga;
import model.MangaDetails;

/**
 *
 * @author soeltan_z
 */
public class MangaDetailsFrame extends javax.swing.JFrame implements downloadListener{
    private String title;
    private String artistTextStr;
    private String authorsTextStr;
    private String descFieldStr;
    private String genreTextStr;
    private String rankTextStr;
    private String ratingTextStr;
    private String statusTextStr;
    private String titleTextStr;
    private String imageUrl;
    private String[] chapterListMangaTitle;
    private ArrayList<Chapter> chapterListManga;
    private ArrayList<Chapter> selectedChapterDownload;
    private String[] selectedChapterListMangaTitle;
    private MangaDetails detailsManga;
    private Manga manga;
    
    /**
     * Creates new form MangaDetailsFrame
     * @param titleManga
     * @param manga
     * @param Download
     */ 
    public MangaDetailsFrame(String title, Manga manga) {
        this.manga = manga;
        this.detailsManga = this.manga.getMangaDetails();
        this.title = title;
        this.artistTextStr = detailsManga.getArtist();
        this.authorsTextStr = detailsManga.getAuthor();
        this.descFieldStr = detailsManga.getSummary();
        this.genreTextStr = detailsManga.getGenre();
        this.rankTextStr = detailsManga.getRank();
        this.ratingTextStr = detailsManga.getRating();
        this.statusTextStr = detailsManga.getStatus();
        this.titleTextStr = detailsManga.getAltName();
        this.imageUrl = detailsManga.getUrlImageCover();
        this.setChapterList(detailsManga);
        System.out.println("this.imageUrl " + this.imageUrl);
        initComponents();
        this.setMangaChapter(this.chapterListMangaTitle);
        this.setTextDesciption(this.artistTextStr, this.authorsTextStr, this.descFieldStr, this.genreTextStr, this.rankTextStr, this.ratingTextStr,this.statusTextStr, this.titleTextStr);
        this.setImageCover(this.imageUrl);
        this.setTitle(title);
        
    }
    
    public void setChapterList(MangaDetails detailsManga){
        chapterListManga = detailsManga.getChapters();
        chapterListMangaTitle = new String[chapterListManga.size()];
        int Index = 0;
        for(int i = 0 ; i < chapterListManga.size(); i++ ){
            Chapter mangachapter = chapterListManga.get(i);
            chapterListMangaTitle[Index] = mangachapter.getChapterTitle();
            Index++;
        }
    
    }
      public MangaDetailsFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        coverImage = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        qwe = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        titleText = new javax.swing.JLabel();
        authorsText = new javax.swing.JLabel();
        artistText = new javax.swing.JLabel();
        genreText = new javax.swing.JLabel();
        statusText = new javax.swing.JLabel();
        rankText = new javax.swing.JLabel();
        ratingText = new javax.swing.JLabel();
        descField = new javax.swing.JTextField();
        botomPanel = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        removeBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        chapterList = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        downloadChapter = new javax.swing.JList<>();
        jPanel5 = new javax.swing.JPanel();
        downloadButton = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        coverImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        coverImage.setText("Image Preview");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 289, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(coverImage, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(coverImage, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(20, 20, 20)))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 9, -1, 299));

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel4.setLayout(new java.awt.GridBagLayout());

        qwe.setText("Alternative Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.ipadx = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(19, 6, 0, 20);
        jPanel4.add(qwe, gridBagConstraints);

        jLabel3.setText("Authors                ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 6, 0, 20);
        jPanel4.add(jLabel3, gridBagConstraints);

        jLabel4.setText("Artist");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 6, 0, 0);
        jPanel4.add(jLabel4, gridBagConstraints);

        jLabel5.setText("Genre(s)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 6, 0, 0);
        jPanel4.add(jLabel5, gridBagConstraints);

        jLabel6.setText("Status");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 6, 0, 0);
        jPanel4.add(jLabel6, gridBagConstraints);

        jLabel7.setText("Rank");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 6, 0, 0);
        jPanel4.add(jLabel7, gridBagConstraints);

        jLabel8.setText("Rating");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 6, 0, 0);
        jPanel4.add(jLabel8, gridBagConstraints);

        jLabel9.setText("Desciption");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 6, 22, 0);
        jPanel4.add(jLabel9, gridBagConstraints);

        jLabel10.setText(":");

        jLabel11.setText(":                ");

        jLabel12.setText(":");

        jLabel13.setText(":");

        jLabel14.setText(":");

        jLabel15.setText(":");

        jLabel16.setText(":");

        jLabel17.setText(":");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel14)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13)
                .addGap(46, 46, 46)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addComponent(jLabel17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(134, 134, 134)
                    .addComponent(jLabel14)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        titleText.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        titleText.setText("title");
        titleText.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        authorsText.setText("Authors                ");

        artistText.setText("Artist");

        genreText.setText("Genre(s)");

        statusText.setText("Status");

        rankText.setText("Rank");

        ratingText.setText("Rating");

        descField.setEditable(false);
        descField.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        descField.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titleText, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(authorsText)
            .addComponent(artistText, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(genreText, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(statusText, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(rankText, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(ratingText, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(descField, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(titleText, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(authorsText, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(artistText, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(genreText, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(statusText, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(rankText, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(ratingText, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(descField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(130, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 25, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 9, 480, 300));

        botomPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        removeBtn.setText("Remove");
        removeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeBtnMouseClicked(evt);
            }
        });

        addBtn.setText("Add");
        addBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addBtnMouseClicked(evt);
            }
        });

        jScrollPane1.setViewportView(chapterList);

        jScrollPane2.setViewportView(downloadChapter);

        javax.swing.GroupLayout botomPanelLayout = new javax.swing.GroupLayout(botomPanel);
        botomPanel.setLayout(botomPanelLayout);
        botomPanelLayout.setHorizontalGroup(
            botomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botomPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(botomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );
        botomPanelLayout.setVerticalGroup(
            botomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, botomPanelLayout.createSequentialGroup()
                .addContainerGap(107, Short.MAX_VALUE)
                .addComponent(addBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removeBtn)
                .addGap(131, 131, 131))
            .addGroup(botomPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(botomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        jPanel1.add(botomPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 314, 781, -1));

        downloadButton.setText("Download");
        downloadButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                downloadButtonMouseClicked(evt);
            }
        });

        cancelBtn.setText("Cancel");
        cancelBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(582, Short.MAX_VALUE)
                .addComponent(cancelBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(downloadButton)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(downloadButton)
                .addComponent(cancelBtn))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 630, -1, -1));

        getContentPane().add(jPanel1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBtnMouseClicked
        int[] selectedChapter = chapterList.getSelectedIndices();
        this.generateSelectedChapterModel(selectedChapter);
        this.setSelectedMangaChapter(selectedChapterListMangaTitle);
    }//GEN-LAST:event_addBtnMouseClicked

    private void removeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeBtnMouseClicked
        // TODO add your handling code here:
        int[] selectedChapter = downloadChapter.getSelectedIndices();
        this.removeSelectedChapter(selectedChapter);
        this.setSelectedMangaChapter(selectedChapterListMangaTitle);
    }//GEN-LAST:event_removeBtnMouseClicked

    private void downloadButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_downloadButtonMouseClicked
        this.detailsManga.setChapters(selectedChapterDownload);
        ArrayList<Download> download =  this.getDownload();
        Download downloadManga = new Download(manga);
        download.add(downloadManga);
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        String currDate = dateFormat.format(date); 
        
        String chapterList = "";
        ArrayList<Chapter> chap = manga.getMangaDetails().getChapters();
        for(int i = 0 ; i < chap.size(); i++){
            if(i != chap.size()-1){
                chapterList = chapterList + chap.get(i).getChapterTitle()+",";
            }else {
                chapterList = chapterList + chap.get(i).getChapterTitle();
            }
        }
        JTable tableDownload = getjTableDownload();
        String titleManga = manga.getTitle();
        String mangaSite = this.getConfig().getMangaSite();
        String statusDownload = "Not started";
        
        String currentChapter = manga.getMangaDetails().getChapters().get(0).getChapterTitle();
 
        Object[] row = { titleManga, mangaSite, statusDownload,currDate, chapterList, currentChapter,"",""};

        DefaultTableModel model = (DefaultTableModel) tableDownload.getModel();
        int numbOfRow = model.getRowCount();
        boolean isRowAvailable = false;
        for(int i = 0 ; i < numbOfRow;i++){
            Object value = model.getValueAt(i, 0);
            if(value == null){
                model.setValueAt(titleManga, i, 0);
                model.setValueAt(mangaSite, i, 1);
                model.setValueAt(statusDownload, i, 2);
                model.setValueAt(currDate, i, 3);
                model.setValueAt(chapterList, i, 4);
                model.setValueAt(currentChapter, i, 5);
                model.setValueAt("", i, 6);
                model.setValueAt("", i, 7);
                isRowAvailable = true;
                break;
            }
        }
        if(!isRowAvailable){
        model.addRow(row);
        }
        this.dispose();
        
    }//GEN-LAST:event_downloadButtonMouseClicked

    private void cancelBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelBtnMouseClicked
        this.dispose();
    }//GEN-LAST:event_cancelBtnMouseClicked

    
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
            java.util.logging.Logger.getLogger(MangaDetailsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MangaDetailsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MangaDetailsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MangaDetailsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MangaDetailsFrame().setVisible(true);
            }
        });
    }

    
    public void setTextDesciption(String artistText, String authorsText, String descField, String genreText, String rankText, String ratingText,
            String statusText, String titleText){
        this.artistText.setText(artistText);
        this.authorsText.setText(authorsText);
        this.descField.setText(descField);
        this.genreText.setText(genreText);
        this.rankText.setText(rankText);
        this.ratingText.setText(ratingText);
        this.statusText.setText(statusText);
        this.titleText.setText(titleText);
        this.coverImage.setText("");
    }
    
    public void setImageCover(String urlImage){
         try { 
                    System.out.println("Get Image from " + urlImage);
                    URL url = new URL(urlImage);
                    BufferedImage image = ImageIO.read(url);
                    System.out.println("Load image into frame...");
                    coverImage.setIcon(new ImageIcon(image));
                } catch (Exception exp) {
                    exp.printStackTrace();
                }

    }
    
    public void setMangaChapter(String [] strings){
       chapterList.setModel(new javax.swing.AbstractListModel<String>() {      
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        chapterList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jScrollPane1.setViewportView(chapterList);
    }
    
     public void setSelectedMangaChapter(String [] strings){
       downloadChapter.setModel(new javax.swing.AbstractListModel<String>() {      
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        downloadChapter.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jScrollPane1.setViewportView(chapterList);
    }
     
    public void generateSelectedChapterModel (int [] listChapter){
        selectedChapterListMangaTitle = new String [listChapter.length];
        selectedChapterDownload = new ArrayList<Chapter>();
        for(int i = 0 ; i < listChapter.length; i++){
            int index = listChapter[i];
            
            selectedChapterListMangaTitle[i] = chapterListMangaTitle[index];
            //selected chapter
            selectedChapterDownload.add(chapterListManga.get(index));
        }
    }
    
    public void removeSelectedChapter(int []listChapter){
     selectedChapterDownload = new ArrayList<Chapter>(); 
     ArrayList<String> temp = new ArrayList<String>();
      for(int j = 0 ; j < listChapter.length; j++){
          int index = listChapter[j];
          selectedChapterListMangaTitle[index]="";
      }
            for(int i = 0 ; i < selectedChapterListMangaTitle.length; i++){
              String chapterTitle = selectedChapterListMangaTitle[i];
              if(!chapterTitle.equalsIgnoreCase("")){
                  temp.add(chapterTitle);
              }
            }
            String [] list = new String [temp.size()];
            for(int i = 0; i < temp.size(); i++){
                list[i] = temp.get(i);
                
                //selected chapter
                for(int j = 0 ; j < chapterListManga.size(); j++){
                    Chapter chpt = chapterListManga.get(j);
                    String title = chpt.getChapterTitle();
                    if(title.equalsIgnoreCase(temp.get(i))){
                        selectedChapterDownload.add(chpt);
                        break;
                    }
                }
             
            }
           selectedChapterListMangaTitle = list;
           
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JLabel artistText;
    private javax.swing.JLabel authorsText;
    private javax.swing.JPanel botomPanel;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JList<String> chapterList;
    private javax.swing.JLabel coverImage;
    private javax.swing.JTextField descField;
    private javax.swing.JButton downloadButton;
    private javax.swing.JList<String> downloadChapter;
    private javax.swing.JLabel genreText;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel qwe;
    private javax.swing.JLabel rankText;
    private javax.swing.JLabel ratingText;
    private javax.swing.JButton removeBtn;
    private javax.swing.JLabel statusText;
    private javax.swing.JLabel titleText;
    // End of variables declaration//GEN-END:variables

    @Override
    public ArrayList<Download> getDownload() {
       return download;
    }

    @Override
    public JTable getjTableDownload() {
        return jTableDownload;
    }

    @Override
    public DownloaderConfig getConfig() {
        return dataConfig;
    }

    @Override
    public DownloadUtil getUtilDowload() {
       return utilDownloadImage;
    }

   
}

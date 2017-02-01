/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package downloader;

import config.DownloaderConfig;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JFileChooser;
import model.SelectedMangaOption;

/**
 *
 * @author soeltan_z
 */
public final class Option extends javax.swing.JFrame {
   private static DownloaderConfig config;
   private ArrayList<SelectedMangaOption > mangaList; 
    /**
     * Creates new form Option
     */
    public Option(DownloaderConfig Config) {
        config = Config;
        initComponents();
        mangaList = config.getSelectedmangaList();
        this.selectedMangaListOption();
        destinationField.setText(config.getPath());
    }
    
    public Option() {
        initComponents();
    }

    public void selectedMangaListOption(){
        for(int i = 0 ; i < mangaList.size(); i++){
            SelectedMangaOption mangaSite = mangaList.get(i);
            boolean isSelected = mangaSite.isIsSelected();
            String site = mangaSite.getMangaSite();
            this.setChekBox(isSelected, site);
        }
                      
    }
    
    public void setChekBox (boolean isSelected , String site){
        if(site.equalsIgnoreCase("Manga Here")){
           mangaHere.setSelected(isSelected);
        }
        if(site.equalsIgnoreCase("Manga Fox")){
           mangaFox.setSelected(isSelected);
        }
        if(site.equalsIgnoreCase("Manga Reader")){
           mangaReader.setSelected(isSelected);
        }
    
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        mangaHere = new javax.swing.JCheckBox();
        mangaFox = new javax.swing.JCheckBox();
        mangaReader = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        destinationField = new javax.swing.JTextField();
        browseBtn = new javax.swing.JButton();
        svBtnOpt = new javax.swing.JButton();
        cnlBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Setting");

        mangaHere.setText("Manga Here");
        mangaHere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mangaHereActionPerformed(evt);
            }
        });

        mangaFox.setText("Manga Fox");

        mangaReader.setText("Manga Reader");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mangaHere)
                    .addComponent(mangaFox)
                    .addComponent(mangaReader))
                .addContainerGap(263, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(mangaHere)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mangaFox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mangaReader)
                .addContainerGap(96, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Manga List", jPanel1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 388, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 211, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab2", jPanel2);

        jLabel1.setText("Destination Path :");

        destinationField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                destinationFieldActionPerformed(evt);
            }
        });

        browseBtn.setText("Browse");
        browseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(destinationField, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(browseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(destinationField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(browseBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        svBtnOpt.setText("Save");
        svBtnOpt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                svBtnOptActionPerformed(evt);
            }
        });

        cnlBtn.setText("Cancel");
        cnlBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cnlBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cnlBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(svBtnOpt)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(svBtnOpt)
                    .addComponent(cnlBtn))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void destinationFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_destinationFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_destinationFieldActionPerformed

    private void browseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseBtnActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        String path = config.getPath();
        fileChooser.setCurrentDirectory(new java.io.File(path));
        fileChooser.setDialogTitle("Select Destination Folder");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);    
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) { 
            String newPath = fileChooser.getSelectedFile().toString();
            destinationField.setText(newPath);
          }
        else {
            System.out.println("No Selection ");
          }
       
    }//GEN-LAST:event_browseBtnActionPerformed

    private void svBtnOptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_svBtnOptActionPerformed
        String newPath = destinationField.getText();
        config.setPath(newPath);
        
    }//GEN-LAST:event_svBtnOptActionPerformed

    private void mangaHereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mangaHereActionPerformed
        boolean isSelected = mangaHere.isSelected();
        SelectedMangaOption mangalistSelected = null;
        for(int i = 0 ; i < this.mangaList.size(); i++){
          SelectedMangaOption listSelected = this.mangaList.get(i);
          String mangaSite = mangalistSelected.getMangaSite();
          if(mangaSite.equalsIgnoreCase("Manga Here")){
            mangalistSelected = listSelected;
            break;
          }
        }
        if(isSelected){
            mangaHere.setSelected(false);
            mangalistSelected.setIsSelected(false);
        }else {
            mangaHere.setSelected(true);
            mangalistSelected.setIsSelected(true);
        }
    }//GEN-LAST:event_mangaHereActionPerformed

    private void cnlBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cnlBtnActionPerformed
          this.dispose();
    }//GEN-LAST:event_cnlBtnActionPerformed

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
            java.util.logging.Logger.getLogger(Option.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Option.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Option.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Option.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Option().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browseBtn;
    private javax.swing.JButton cnlBtn;
    private javax.swing.JTextField destinationField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JCheckBox mangaFox;
    private javax.swing.JCheckBox mangaHere;
    private javax.swing.JCheckBox mangaReader;
    private javax.swing.JButton svBtnOpt;
    // End of variables declaration//GEN-END:variables

}

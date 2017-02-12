/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clickedMenu;

import Util.DownloadUtil;
import downloadTask.DownloadTask;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;
import model.Download;

/**
 *
 * @author zacky
 */
   
public class ClickedMenu extends JPopupMenu {
    private int MIN_ROW_TABLE = 25;
     JMenuItem start;
     JMenuItem stop;
     JMenuItem  remove;
     int [] numbOfRowSelected;
    javax.swing.JTable jTableDownload;
    DownloadUtil utilDownload;
     
    public ClickedMenu(int row, javax.swing.JTable jTableDownload, String status, boolean multipleSelection, int[] numbOfRowSelected, ArrayList<Download> downloadedManga, DownloadUtil utilDownload){
        start = new JMenuItem("Start Download");
       // stop = new JMenuItem("Stop Download");
        remove = new JMenuItem("Remove");
        this.numbOfRowSelected = numbOfRowSelected;
        this.jTableDownload = jTableDownload;
        
        add(start);
       // add(stop);
        add(remove);
        
        this.utilDownload = utilDownload;
        
        setEnableDisableStartStopMenu(status ,multipleSelection);
        setEnableDisableRemoveMenu(status ,multipleSelection);
        
       remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) jTableDownload.getModel();
                String []emptyRow = {null, null, null, null, null, null, null, null};
                int rowCount = jTableDownload.getRowCount();
                for(int i = 0; i < numbOfRowSelected.length;i++ ){
                    Object asdw = jTableDownload.getValueAt(numbOfRowSelected[i], 2);
                    String status = "";
            
                    if(asdw != null){
                        status = asdw.toString();
                    }else {
                        status = "column empty";
                    }
                    
                    if(!status.equalsIgnoreCase("downloading")){
                        if(rowCount > MIN_ROW_TABLE){
                            model.removeRow(numbOfRowSelected[i]);
                        }else {
                            model.removeRow(numbOfRowSelected[i]);
                            model.addRow(emptyRow);
                        }
                    }
                }  
            }
        });
       
       start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) jTableDownload.getModel();
                for(int i = 0; i < numbOfRowSelected.length;i++ ){
                    model.setValueAt("Downloading", numbOfRowSelected[i], 2);
                    Download download = downloadedManga.get(row);
                         new Thread(new Runnable() {
                        public void run() {
                        DownloadTask downloadTask = new DownloadTask(row, utilDownload, download , model);
                        downloadTask.run();
                        }
                }).start();
                    
                }  
                
            }
        });
    }
    
    public void setEnableDisableStartStopMenu(String status ,boolean multipleSelection ){
      if(status.equalsIgnoreCase("empty")|| multipleSelection){
           start.setEnabled(false);
         //   stop.setEnabled(false);
      }else {
        if(status.equalsIgnoreCase("downloading")){
            start.setEnabled(false);
       //     stop.setEnabled(true);
        }else {
             start.setEnabled(true);
           //  stop.setEnabled(false);
        }
      }
    
    }
    
    public void setEnableDisableRemoveMenu(String status , boolean multipleSelection){
        if(status.equalsIgnoreCase("empty")|| multipleSelection){
            remove.setEnabled(false);
        }else {
             remove.setEnabled(true);
        }
    
    }
}
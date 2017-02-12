/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package downloadTask;

import Util.DownloadUtil;
import javax.swing.table.DefaultTableModel;
import model.Download;

/**
 *
 * @author zacky
 */
public class DownloadTask implements Runnable {

    private DownloadUtil util;
    private Download download;
    private int row ;
    private DefaultTableModel model;
            
    public DownloadTask(int row, DownloadUtil util, Download download , DefaultTableModel model) {
        this.row = row;
        this.util = util;
        this.download = download;
        this.model = model;
    }

    @Override
    public void run() {
      this.util.download(row, model, download);
    }
}

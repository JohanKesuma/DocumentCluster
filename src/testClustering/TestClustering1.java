/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testClustering;

import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import model.Cluster;
import model.Document;
import model.InvertedIndex;
import model.Posting;

/**
 *
 * @author johan
 */
public class TestClustering1 {

    public static void main(String[] args) {
        // seting dokumen
        Document doc1 = new Document(1, "Fahri Hamzah Usul Ibu Kota Pindah ke Kepulauan Seribu");
        Document doc2 = new Document(2, "Gaya Nyentrik Menteri Susi Saat Pimpin Penenggelaman 13 Kapal Vietnam di Kalbar");
        Document doc3 = new Document(3, "TNI AL: KRI Tjiptadi-381 Diprovokasi Kapal Pengawas Ikan Vietnam ");

        // buat object invertedIndex
        InvertedIndex index = new InvertedIndex();
        File file = new File("/home/johan/Documents/50 Text Lagu");
        index.readDirectory(file);
        JOptionPane.showMessageDialog(null, "Documents Opened");
        // bikin dictionary
        index.makeDictionaryWithTermNumber();
        // bikin preclustering
        index.preClustering();
        for (int i = 0; i < index.getDocuments().size(); i++) {
            ArrayList<Posting> listPosting = 
                    index.getDocuments().get(i).getListOfClusteringPosting();
            System.out.println("IdDoc = "+index.getDocuments().get(i).getId());
            for (int j = 0; j < listPosting.size(); j++) {
                System.out.println(listPosting.get(j));
            }
        
        }
        index.clustering();
        for (int i = 0; i < index.getListOfCluster().size(); i++) {
            Cluster cluster = index.getListOfCluster().get(i);
            System.out.println("cluster : " + cluster.getIdCluster());
            System.out.println("Member : ");
            for (int j = 0; j < cluster.getMember().size(); j++) {
                System.out.println(cluster.getMember().get(j).getId());
            }
            System.out.println("");
        }
    }
}

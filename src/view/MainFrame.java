package view;

import javax.swing.*;
import java.io.IOException;

public class MainFrame extends JFrame {
    public MainFrame() throws IOException {
        initComponents();
    }


    private void initComponents() throws IOException {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));
        setSize(new java.awt.Dimension(800, 600));


        jMenuBar1.setBorder(null);
        jMenuBar1.setMinimumSize(new java.awt.Dimension(64, 30));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(64, 30));

        jMenu1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jMenu1.setText("Open file");
        jMenu1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jMenuBar1.add(jMenu1);

        jMenu2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jMenu2.setText("Create file");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);
        Article[] articles = new Article[100];
        for (int i =0; i<100; i++){
            articles[i] = new Article("Grechka", 40, "Usual grechka", new ArticleCategory().getCategory(), "C:/Users/Lenovo/Desktop/grechka.jpg");
        }

        kk1 = new ObjectsPannel(articles);
        this.setContentPane(kk1);
        pack();
    }

    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    JPanel kk1;
}

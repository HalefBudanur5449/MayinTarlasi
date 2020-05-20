package mayinoyunu;

import javax.swing.JToggleButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class oyun extends javax.swing.JFrame {

    final int genislik = 9, yukseklik = 9, bomba = 10;
    JToggleButton[][] bloklar = new JToggleButton[yukseklik][genislik];
    int[][] blok = new int[yukseklik][genislik];
    boolean baslangic, oynayabilme;
    ActionListener acListen = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            int i = 0, j = 0;
            boolean bulunanHucre = false;
            for (i = 0; i < yukseklik; i++) {
                for (j = 0; j < genislik; j++) {
                    if (e.getSource() == bloklar[i][j]) {
                        bulunanHucre = true;
                        break;
                    }
                }
                if (bulunanHucre) {
                    break;
                };
            }
            if (oynayabilme) {
                bloklar[i][j].setSelected(true);
                if (!baslangic) {
                    bombaYeri(i, j);
                    baslangic = true;
                }
                if (blok[i][j] != -1) {
                    ac(i, j);
                    atama();
                } else {
                    kaybetmek();
                }
                kazandınız();
            } else {
                atama();
            }
        }

    };

    private void kazandınız() {
        boolean birinci=true;
        for (int i = 0; i < yukseklik; i++) {
            for (int j = 0; j < genislik; j++) {
                if(blok[i][j]==0){
                    birinci=false;
                    break;
                }
            }
            if(!birinci) break;
        }
        if(birinci) {
            javax.swing.JOptionPane.showMessageDialog(null, "Oyunu kazandınız...");
            oynayabilme=false;
        }
     }

    private void kaybetmek() {
        oynayabilme = false;
        for (int i = 0; i < yukseklik; i++) {
            for (int j = 0; j < genislik; j++) {
                if (blok[i][j] == -1) {
                    bloklar[i][j].setText("Bomba");
                    bloklar[i][j].setSelected(true);
                }

            }
        }
    }

    private void ac(int a, int b) {
        if (a < 0 || b < 0 || b > genislik - 1 || a > yukseklik - 1 || blok[a][b] != 0) {
            return;
        }
        int bombalar = 0;
        for (int i = a - 1; i <= a + 1; i++) {
            for (int j = b - 1; j < b + 1; j++) {
                if (!(j < 0 || i < 0 || j > genislik - 1 || i > yukseklik - 1) && blok[i][j] == -1) {
                    bombalar++;
                }
            }
        }
        if (bombalar == 0) {
            blok[a][b] = -2;
            for (int i = a - 1; i <= a + 1; i++) {
                for (int j = b - 1; j < b + 1; j++) {
                    if (!(j < 0 || i < 0 || j > genislik - 1 || i > yukseklik - 1)) {
                        if (i != a || j != b) {
                            ac(i, j);
                        }
                    }
                }
            }
        } else {
            blok[a][b] = bombalar;
        }
    }

    private void atama() {
        for (int i = 0; i < yukseklik; i++) {
            for (int j = 0; j < genislik; j++) {
                if (blok[i][j] == 0) {
                    bloklar[i][j].setText("");
                    bloklar[i][j].setSelected(false);
                }
                if (blok[i][j] == -2) {
                    bloklar[i][j].setText("");
                    bloklar[i][j].setSelected(true);
                }
                if (blok[i][j] > 0) {
                    bloklar[i][j].setText("" + blok[i][j]);
                    bloklar[i][j].setSelected(true);
                }
                if (!oynayabilme && blok[i][j] == -1) {
                    bloklar[i][j].setSelected(true);
                }
            }
            panel1.repaint();
        }
    }

    private void bombaYeri(int a, int b) {
        for (int i = 0; i < bomba; i++) {
            int k, l;
            do {
                k = (int) (Math.random() * (genislik - .01));
                l = (int) (Math.random() * (yukseklik - .01));

            } while (blok[k][l] == -1 || (k == b && l == a));
            blok[k][l] = -1;
        }
    }

    public oyun() {
        initComponents();
        for (int i = 0; i < yukseklik; i++) {
            for (int j = 0; j < genislik; j++) {
                bloklar[i][j] = new JToggleButton();
                bloklar[i][j].setSize(panel1.getWidth() / genislik, panel1.getHeight() / yukseklik);
                panel1.add(bloklar[i][j]);
                bloklar[i][j].setLocation(j * panel1.getWidth() / genislik, i * panel1.getHeight() / yukseklik);
                bloklar[i][j].addActionListener(acListen);

            }
        }
        baslangic = false;
        oynayabilme = true;
    }

    private void boyut() {
        for (int i = 0; i < yukseklik; i++) {
            for (int j = 0; j < genislik; j++) {
                bloklar[i][j].setSize(panel1.getWidth() / genislik, panel1.getHeight() / yukseklik);
                panel1.add(bloklar[i][j]);
                bloklar[i][j].setLocation(j * panel1.getWidth() / genislik, i * panel1.getHeight() / yukseklik);

            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        panel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                panel1ComponentResized(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 628, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 357, Short.MAX_VALUE)
        );

        jMenu1.setText("Seçenekler");

        jMenuItem1.setText("Yeni oyun");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   //kullanıcı tarafındaki herhangi boyut bozulmalarını engeller
    private void panel1ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_panel1ComponentResized
        boyut();
    }//GEN-LAST:event_panel1ComponentResized

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        blok =new int[yukseklik][genislik];
        atama();
        oynayabilme=true;
        baslangic=false;
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(oyun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(oyun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(oyun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(oyun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new oyun().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel panel1;
    // End of variables declaration//GEN-END:variables
}


 import javax.swing.JOptionPane;
 import java.sql.Connection;
import java.sql.*;
import javax.swing.*;
   import java.sql.DriverManager;
 import java.sql.ResultSet;
import java.text.SimpleDateFormat;
 import javax.swing.DefaultComboBoxModel;

 
public class penilaian extends javax.swing.JFrame {

    private ResultSet rs;

    /**
     */
    public penilaian() {
        initComponents();
        isikelas();
        isiblok();
         isimapel();
          isitahunajaran();
           isisemester();
           isisiswamapeljurusan();
         
        
        
    }
    private void kosong(){
      
       
    }
    
private void isitahunajaran() {
    try {
        // Query to get year id and name
        String sql = "SELECT id_tahun_ajaran, tahun_ajaran FROM tahun_ajaran"; 

        java.sql.Connection conn = (Connection) koneksi.configDB();
        java.sql.PreparedStatement pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        
        // Clear combo box before adding new items
        tahun_ajaran.removeAllItems();

        // Loop through results and add items to combo box
        while(rs.next()) {
            String idTahunAjaran = rs.getString("id_tahun_ajaran"); // Get id_tahun_ajaran from result
            String namaTahunAjaran = rs.getString("tahun_ajaran");
            tahun_ajaran.addItem(idTahunAjaran + ":" + namaTahunAjaran); // Store id_tahun_ajaran with name
        }
    } catch(Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
}


     private void isikelas() {
    try {
        String sql = "SELECT * FROM kelas";
        java.sql.Connection conn = (Connection) koneksi.configDB();
        java.sql.PreparedStatement pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        
        // Bersihkan combo box kelas sebelum menambahkan item baru
        siswa.removeAllItems();
        
        // Loop melalui hasil query dan tambahkan nama kelas ke combo box
        while(rs.next()) {
            siswa.addItem(rs.getString("nama_kelas"));
        }
    } catch(Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
}
 private void isisemester() {
    try {
        // Query to get semester id and name
        String sql = "SELECT id_semester, semester FROM semester"; 

        java.sql.Connection conn = (Connection) koneksi.configDB();
        java.sql.PreparedStatement pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        
        // Clear combo box before adding new items
        semester.removeAllItems();

        // Loop through results and add items to combo box
        while(rs.next()) {
            String idSemester = rs.getString("id_semester"); // Get id_semester from result
            String namaSemester = rs.getString("semester");
            semester.addItem(idSemester + ":" + namaSemester); // Store id_semester with name
        }
    } catch(Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
}

    
    



 private void isiblok(){
      
       try{
        String sql = "SELECT * from blok";
        java.sql.Connection conn=(Connection)koneksi.configDB();
        java.sql.PreparedStatement pst=conn.prepareStatement(sql);
        rs = pst.executeQuery();
        
        while(rs.next()){
            blok.addItem(rs.getString("id_blok"));
        }
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
       }
   }
private void isimapel() {
    try {
        // Query to get subject id and name
        String sql = "SELECT id_mapel, nama_mapel FROM mapel"; 

        java.sql.Connection conn = (Connection) koneksi.configDB();
        java.sql.PreparedStatement pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        
        // Clear combo box before adding new items
        mapel.removeAllItems();

        // Loop through results and add items to combo box
        while(rs.next()) {
            String idMapel = rs.getString("id_mapel"); // Get id_mapel from result
            String namaMapel = rs.getString("nama_mapel");
            mapel.addItem(idMapel + ":" + namaMapel); // Store id_mapel with name
        }
    } catch(Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
}


private void isisiswamapeljurusan() {
    try {
        // Query to get student id, name, department, and class name
        String sql = "SELECT s.id_siswa, s.nama_siswa, s.nama_jurusan, k.nama_kelas " +
                     "FROM siswa s " +
                     "JOIN kelas k ON s.id_kelas = k.id_kelas"; 

        java.sql.Connection conn = (Connection) koneksi.configDB();
        java.sql.PreparedStatement pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        
        // Clear combo box before adding new items
        siswa.removeAllItems();

        // Loop through results and add items to combo box
        while(rs.next()) {
            String idSiswa = rs.getString("id_siswa"); // Get id_siswa from result
            String namaSiswa = rs.getString("nama_siswa");
            String namaJurusan = rs.getString("nama_jurusan");
            String namaKelas = rs.getString("nama_kelas");
            String combinedName = namaSiswa + " -- " + namaJurusan + " -- " + namaKelas; 
            siswa.addItem(idSiswa + ":" + combinedName); // Store id_siswa with combined string
        }
    } catch(Exception e) {
        JOptionPane.showMessageDialog(null, e);
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

        jammulai = new com.raven.swing.TimePicker();
        jamselesai = new com.raven.swing.TimePicker();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        siswa = new javax.swing.JComboBox<>();
        blok = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tahun_ajaran = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        semester = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        mapel = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        nilaitugas = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        nilaimid = new javax.swing.JTextField();
        nilaifinal = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        jMenu2.setText("Menu");
        jMenu2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jMenuItem1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jMenuItem1.setText("Dashboard");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Siswa            :");

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton1.setText("Simpan");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton2.setText("Reset");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        siswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siswaActionPerformed(evt);
            }
        });

        blok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blokActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setText("Blok              : ");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("Tahun ajaran:");

        tahun_ajaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tahun_ajaranActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel9.setText("Semester       : ");

        semester.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semesterActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel10.setText("Mapel            : ");

        mapel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mapelActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel11.setText("Nilai tugas    : ");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel12.setText("Nilai Midblok: ");

        nilaimid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nilaimidActionPerformed(evt);
            }
        });

        nilaifinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nilaifinalActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel13.setText("Nilai Finalblok: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nilaimid))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nilaitugas))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mapel, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tahun_ajaran, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(blok, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(siswa, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(semester, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nilaifinal)))
                .addGap(113, 113, 113)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tahun_ajaran, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(siswa, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(blok, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(semester, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mapel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nilaitugas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nilaimid))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nilaifinal, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(75, Short.MAX_VALUE))
        );

        jMenu3.setText("Menu");
        jMenu3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jMenuItem2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jMenuItem2.setText("Dashboard");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.getAccessibleContext().setAccessibleName("rewdf");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
  try {
    // SQL insert statement including mapel
    String sql = "INSERT INTO penilaian (id_siswa, id_blok, id_mapel, nilai_tugas, nilai_midblok, nilai_finalblok, total_nilai, id_semester, id_tahun_ajaran, predikat) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    
    // Establish connection
    java.sql.Connection conn = (Connection) koneksi.configDB();
    java.sql.PreparedStatement pst = conn.prepareStatement(sql);
    
    // Split selected items to get IDs
    String selectedSiswa = (String) siswa.getSelectedItem();
    String[] partsSiswa = selectedSiswa.split(":");
    String idSiswa = partsSiswa[0]; // This is now the id_siswa

    String selectedMapel = (String) mapel.getSelectedItem(); // Assuming mapel is a combo box
    String[] partsMapel = selectedMapel.split(":");
    String idMapel = partsMapel[0]; // This is now the id_mapel

    String selectedSemester = (String) semester.getSelectedItem();
    String[] partsSemester = selectedSemester.split(":");
    String idSemester = partsSemester[0]; // This is now the id_semester
    
    String selectedTahunAjaran = (String) tahun_ajaran.getSelectedItem();
    String[] partsTahunAjaran = selectedTahunAjaran.split(":");
    String idTahunAjaran = partsTahunAjaran[0]; // This is now the id_tahun_ajaran
    
    // Get and parse input values
    double nilaiTugas = Double.parseDouble(nilaitugas.getText());
    double nilaiMidblok = Double.parseDouble(nilaimid.getText());
    double nilaiFinalblok = Double.parseDouble(nilaifinal.getText());

    // Calculate total and average
    double totalNilai = nilaiTugas + nilaiMidblok + nilaiFinalblok;
    double averageNilai = totalNilai / 3; // Average calculation

    // Determine predikat based on average
    String predikat;
    if (averageNilai > 92) {
        predikat = "A";
    } else if (averageNilai > 83) {
        predikat = "B";
    } else if (averageNilai >= 75) {
        predikat = "C";
    } else {
        predikat = "D";
    }

    // Set parameters for the prepared statement
    pst.setString(1, idSiswa); // Use id_siswa
    pst.setString(2, (String) blok.getSelectedItem()); // Assuming this is id_blok
    pst.setString(3, idMapel); // Use id_mapel
    pst.setDouble(4, nilaiTugas); // nilai_tugas
    pst.setDouble(5, nilaiMidblok); // nilai_midblok
    pst.setDouble(6, nilaiFinalblok); // nilai_finalblok
    pst.setDouble(7, totalNilai); // total_nilai
    pst.setString(8, idSemester); // Use id_semester
    pst.setString(9, idTahunAjaran); // Use id_tahun_ajaran
    pst.setString(10, predikat); // predikat

    // Execute the update
    pst.executeUpdate();
    
    // Show success message
    JOptionPane.showMessageDialog(null, "Penyimpanan Data Berhasil.\nTotal Nilai: " + totalNilai + "\nRata-rata: " + averageNilai);

} catch (Exception e) {
    JOptionPane.showMessageDialog(this, e.getMessage());
}

// After saving, clear the form
kosong();









    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        


    }//GEN-LAST:event_jButton2ActionPerformed

    private void siswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siswaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_siswaActionPerformed

    private void blokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_blokActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new dashboard().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new dashboard().setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void tahun_ajaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tahun_ajaranActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tahun_ajaranActionPerformed

    private void semesterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semesterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_semesterActionPerformed

    private void mapelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mapelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mapelActionPerformed

    private void nilaimidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nilaimidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nilaimidActionPerformed

    private void nilaifinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nilaifinalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nilaifinalActionPerformed

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
            java.util.logging.Logger.getLogger(tambah_guru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tambah_guru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tambah_guru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tambah_guru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new penilaian().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> blok;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private com.raven.swing.TimePicker jammulai;
    private com.raven.swing.TimePicker jamselesai;
    private javax.swing.JComboBox<String> mapel;
    private javax.swing.JTextField nilaifinal;
    private javax.swing.JTextField nilaimid;
    private javax.swing.JTextField nilaitugas;
    private javax.swing.JComboBox<String> semester;
    private javax.swing.JComboBox<String> siswa;
    private javax.swing.JComboBox<String> tahun_ajaran;
    // End of variables declaration//GEN-END:variables
}


import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author LEGION
 */
public class raport extends javax.swing.JFrame {

     private ResultSet rs;
     
    public raport() {
        initComponents();
        isisiswakelas();
        isitahunajaran();
         isisemester();
          isiblok();
//         
        
        
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
    private void getPenilaianData(String idSiswa, String idTahunAjaran, String idSemester, String idBlok) {
    try {
        // Query SQL yang telah diperbarui (tanpa NIS)
        String sql = "SELECT p.id_penilaian, p.nilai_tugas, p.nilai_midblok, p.nilai_finalblok, p.total_nilai, p.predikat, " +
                     "s.nama_siswa, k.nama_kelas, se.semester, m.nama_mapel " +
                     "FROM penilaian p " +
                     "JOIN siswa s ON s.id_siswa = p.id_siswa " +
                     "JOIN kelas k ON k.id_kelas = s.id_kelas " +
                     "JOIN semester se ON se.id_semester = p.id_semester " +
                     "JOIN mapel m ON m.id_mapel = p.id_mapel " +
                     "WHERE p.id_siswa = ? AND p.id_tahun_ajaran = ? AND p.id_semester = ? AND p.id_blok = ?";

        // Koneksi ke database
        Connection conn = koneksi.configDB();
        java.sql.PreparedStatement pst = conn.prepareStatement(sql);
        
        // Set nilai parameter query
        pst.setString(1, idSiswa);
        pst.setString(2, idTahunAjaran);
        pst.setString(3, idSemester);
        pst.setString(4, idBlok);

        // Eksekusi query
        rs = pst.executeQuery();
        
        // Proses hasil query
        while (rs.next()) {
            String namaSiswa = rs.getString("nama_siswa");
            String namaKelas = rs.getString("nama_kelas");
            String namaMapel = rs.getString("nama_mapel");
            int nilaiTugas = rs.getInt("nilai_tugas");
            int nilaiMidBlok = rs.getInt("nilai_midblok");
            int nilaiFinalBlok = rs.getInt("nilai_finalblok");
            int totalNilai = rs.getInt("total_nilai");
            String predikat = rs.getString("predikat");
            
            // Menampilkan data
            System.out.println("Nama Siswa: " + namaSiswa + ", Kelas: " + namaKelas);
            System.out.println("Mapel: " + namaMapel + ", Nilai Tugas: " + nilaiTugas + 
                               ", Midblok: " + nilaiMidBlok + ", Finalblok: " + nilaiFinalBlok + 
                               ", Total: " + totalNilai + ", Predikat: " + predikat);
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Gagal mengambil data: " + e.getMessage());
    }
}

    
    private void isisiswakelas() {
    try {
        // Query to get student id, name, department, and class name
        String sql = "SELECT s.id_siswa, s.nama_siswa, k.nama_kelas " +
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
            String namaKelas = rs.getString("nama_kelas");
            String combinedName = namaSiswa +  " -- " + namaKelas; 
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        blok = new javax.swing.JComboBox<>();
        siswa = new javax.swing.JComboBox<>();
        tahun_ajaran = new javax.swing.JComboBox<>();
        semester = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Semester                  :");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("Nama Siswa            :");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setText("Tahun Ajaran         :");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setText("Blok                          :");

        blok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blokActionPerformed(evt);
            }
        });

        siswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siswaActionPerformed(evt);
            }
        });

        tahun_ajaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tahun_ajaranActionPerformed(evt);
            }
        });

        semester.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semesterActionPerformed(evt);
            }
        });

        jButton1.setText("PRINT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel2)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(siswa, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(semester, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tahun_ajaran, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(blok, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(299, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(siswa, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(tahun_ajaran, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(semester, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(blok, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(78, 78, 78)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(104, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(298, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void blokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_blokActionPerformed

    private void siswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siswaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_siswaActionPerformed

    private void tahun_ajaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tahun_ajaranActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tahun_ajaranActionPerformed

    private void semesterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semesterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_semesterActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    // Ambil nilai dari combobox
    String selectedSiswa = siswa.getSelectedItem().toString().split(":")[0]; // Dapatkan id siswa dari combo box
    String selectedTahunAjaran = tahun_ajaran.getSelectedItem().toString().split(":")[0]; // Dapatkan id tahun ajaran
    String selectedSemester = semester.getSelectedItem().toString().split(":")[0]; // Dapatkan id semester
    String selectedBlok = blok.getSelectedItem().toString(); // Dapatkan id blok

    RaportPDFPrinter pdfPrinter = new RaportPDFPrinter();
    pdfPrinter.printPDF(selectedSiswa, selectedTahunAjaran, selectedSemester, selectedBlok);



        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(raport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(raport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(raport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(raport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new raport().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> blok;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> semester;
    private javax.swing.JComboBox<String> siswa;
    private javax.swing.JComboBox<String> tahun_ajaran;
    // End of variables declaration//GEN-END:variables
}

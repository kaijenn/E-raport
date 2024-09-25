import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Cell;
import java.sql.Connection;
import java.sql.ResultSet;

public class RaportPDFPrinter {

    public void printPDF(String idSiswa, String idTahunAjaran, String idSemester, String idBlok) {
        try {
            // Koneksi dan query ke database
            Connection conn = koneksi.configDB();
            String sql = "SELECT p.id_penilaian, p.nilai_tugas, p.nilai_midblok, p.nilai_finalblok, p.total_nilai, p.predikat, " +
                         "s.nama_siswa, k.nama_kelas, se.semester, m.nama_mapel " +
                         "FROM penilaian p " +
                         "JOIN siswa s ON s.id_siswa = p.id_siswa " +
                         "JOIN kelas k ON k.id_kelas = s.id_kelas " +
                         "JOIN semester se ON se.id_semester = p.id_semester " +
                         "JOIN mapel m ON m.id_mapel = p.id_mapel " +
                         "WHERE p.id_siswa = ? AND p.id_tahun_ajaran = ? AND p.id_semester = ? AND p.id_blok = ?";
            
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, idSiswa);
            pst.setString(2, idTahunAjaran);
            pst.setString(3, idSemester);
            pst.setString(4, idBlok);

            ResultSet rs = pst.executeQuery();

            // Membuat tabel dengan 5 kolom
            float[] columnWidths = {100, 100, 100, 100, 100};
            Table table = new Table(columnWidths);
            table.addCell(new Cell().add(new Paragraph("Nama Siswa")));
            table.addCell(new Cell().add(new Paragraph("Kelas")));
            table.addCell(new Cell().add(new Paragraph("Mapel")));
            table.addCell(new Cell().add(new Paragraph("Nilai Tugas")));
            table.addCell(new Cell().add(new Paragraph("Total Nilai")));

            String namaSiswa = ""; // Variabel untuk menyimpan nama siswa

            // Menambahkan data ke tabel dari result set
            while (rs.next()) {
                namaSiswa = rs.getString("nama_siswa"); // Ambil nama siswa
                String namaKelas = rs.getString("nama_kelas");
                String namaMapel = rs.getString("nama_mapel");
                int nilaiTugas = rs.getInt("nilai_tugas");
                int totalNilai = rs.getInt("total_nilai");

                table.addCell(new Cell().add(new Paragraph(namaSiswa)));
                table.addCell(new Cell().add(new Paragraph(namaKelas)));
                table.addCell(new Cell().add(new Paragraph(namaMapel)));
                table.addCell(new Cell().add(new Paragraph(String.valueOf(nilaiTugas))));
                table.addCell(new Cell().add(new Paragraph(String.valueOf(totalNilai))));
            }

            // Buat nama file PDF dengan nama siswa
            String dest = namaSiswa.replaceAll(" ", "_") + "_raport.pdf"; // Ganti spasi dengan underscore untuk nama file
            
            // Membuat PDF writer
            PdfWriter writer = new PdfWriter(dest);
            PdfDocument pdfDoc = new PdfDocument(writer);
            Document document = new Document(pdfDoc);
            
            // Tambahkan judul pada PDF
            document.add(new Paragraph("Laporan Nilai Siswa"));

            // Menambahkan tabel ke dokumen PDF
            document.add(table);
            document.close();

            System.out.println("PDF berhasil dibuat dengan nama: " + dest);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Gagal membuat PDF: " + e.getMessage());
        }
    }
}

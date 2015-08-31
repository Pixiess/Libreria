package controlador;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class CrearPdf {

    private static final Font font1 = new Font(Font.FontFamily.TIMES_ROMAN, 21, Font.BOLD, BaseColor.BLACK);
    private static final Font font2 = new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.BOLD, BaseColor.BLACK);

    private  String titulo;
    private File destino;

    public CrearPdf(String titulo, File destino) {
        this.titulo = titulo;
        this.destino = destino;
    }

    public void anadirTitulo(Document documento) throws DocumentException {
        Paragraph preface = new Paragraph();
        anadirLineaVacia(preface, 1);
        preface.add(new Paragraph(titulo, font1));
        anadirLineaVacia(preface, 1);
        documento.add(preface);
    }

    public void anadirDatos(Document documento) {
        documento.addTitle("PDF");
        documento.addAuthor(System.getProperty("user.name"));
        documento.addCreator(System.getProperty("user.name"));
    }

    public void crearTabla(Document documento, Object[][] tabla, int filas, int columnas, String[] tituloT) throws BadElementException, DocumentException {
        PdfPTable table = new PdfPTable(columnas);
        for (int i = 0; i < tituloT.length; i++) {
            PdfPCell c1 = new PdfPCell(new Phrase(tituloT[i]));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);

        }
        table.setHeaderRows(1);
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                table.addCell("" + tabla[i][j]);
            }
        }

        Paragraph contenido = new Paragraph();
        anadirLineaVacia(contenido, 1);
        contenido.add(table);
        anadirLineaVacia(contenido, 1);
        documento.add(contenido);

    }

    public void anadirLineaVacia(Paragraph parrafo, int numero) {
        for (int i = 0; i < numero; i++) {
            parrafo.add(new Paragraph(" "));
        }
    }

    public File destino() {
        File rutaDestino = null;
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo PDF", "pdf", "PDF");

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(filter);

        int r = fileChooser.showSaveDialog(null);
        if (r == JFileChooser.APPROVE_OPTION) {
            rutaDestino = fileChooser.getSelectedFile().getAbsoluteFile();
        }
        return rutaDestino;
    }

    public void mostrarPdf() {
        try {
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + destino.getPath()+".pdf");
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null, "Error");
        }

    }

    public void setDestino(File destino) {
        this.destino = destino;
    }
}

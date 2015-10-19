package controlador;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;

public class CrearFactura {

    private final CrearPdf crearPdf;
    private static final Font font1 = new Font(Font.FontFamily.TIMES_ROMAN, 21, Font.BOLD, BaseColor.BLACK);
    private static final Font font2 = new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.BOLD, BaseColor.BLACK);

    private File destino;

    public CrearFactura(String titulo, File destino) {
        this.destino = destino;
        crearPdf = new CrearPdf(titulo, destino);
    }

    public void generarFactura(String fecha, String cliente, String nit, String vendedor, Object[][] tabla, String total, int filas, int columnas, String[] tablaTitulo) {
        try {
            Document documento = new Document(PageSize.LETTER);
            Paragraph contenido = new Paragraph();
            PdfWriter.getInstance(documento, new FileOutputStream(destino + ".pdf"));

            documento.open();
            crearPdf.anadirDatos(documento);

            anadirContenido(documento, fecha, cliente, nit, vendedor);
            crearPdf.crearTabla(documento, tabla, filas, columnas, tablaTitulo);
            crearPdf.anadirLineaVacia(contenido, 1);
            contenido.add(new Paragraph("                                                                                                     TOTAL : " + total, font2));
            documento.add(contenido);
            documento.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void anadirContenido(Document documento, String fecha, String cliente, String nit, String vendedor) throws DocumentException {

        Paragraph contenido = new Paragraph();
        crearPdf.anadirLineaVacia(contenido, 1);
        contenido.add(new Paragraph("                                         FACTURA ", font1));
        crearPdf.anadirLineaVacia(contenido, 1);
        contenido.add(new Paragraph("  ----------------------------------------------------------------------------------------------------------------------- "));
        crearPdf.anadirLineaVacia(contenido, 1);
        contenido.add(new Paragraph(" FECHA :  " + fecha, font2));
        contenido.add(new Paragraph(" SEÑOR(A)  : " + cliente, font2));
        //crearPdf.anadirLineaVacia(contenido, 1);
        contenido.add(new Paragraph(" ATENDIDO POR : " + vendedor, font2));
        contenido.add(new Paragraph(" NIT/CI :  " + nit, font2));
        crearPdf.anadirLineaVacia(contenido, 1);
        documento.add(contenido);
    }

    public void mostrarFactura() {
        crearPdf.mostrarPdf();
    }

    public File destino() {
        return crearPdf.destino();
    }

    public void setDestino(File rutaDestino) {
        destino = rutaDestino;
        crearPdf.setDestino(destino);
    }
}

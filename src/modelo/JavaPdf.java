/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.FileOutputStream;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author A
 */
public class JavaPdf {

    private static final Font font1 = new Font(Font.FontFamily.TIMES_ROMAN, 21, Font.BOLD, BaseColor.BLACK);
    private static final Font font2 = new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.BOLD, BaseColor.BLACK);
    private static final Font font3 = new Font(Font.FontFamily.TIMES_ROMAN, 13);

    private static String file, title;

    public JavaPdf(String name, String title, int u) {
        //file = "C:/Users/" + System.getProperty("user.name") + "/Documents/" + name + "_" + u + ".pdf";
        file = System.getProperty("user.dir")+"/Facturas/" + name + "_" + u + ".pdf";
        this.title = title;
    }

    public void generarFactura(String fecha, String cliente, String nit, Object[][] tabla, String total, int rows, int columns, String[] tablaTitulo) {  //fecha, cliente, ci, tabla, total, rows, columns
        try {
            Document document = new Document(PageSize.LETTER);
            PdfWriter.getInstance(document, new FileOutputStream(file));
            document.open();
            addMetaData(document);
            //addTittle(document);
            addContent(document, fecha, cliente, nit);
            createTable(document, tabla, rows, columns, total, tablaTitulo);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addContent(Document document, String fecha, String cliente, String nit) throws DocumentException {

        Paragraph content = new Paragraph();
        addEmptyLine(content, 1);
        content.add(new Paragraph("                                         FACTURA ", font1));
        addEmptyLine(content, 1);
        content.add(new Paragraph("  -------------------------------------------------------------------------------------------------------------------- "));
        addEmptyLine(content, 1);
        content.add(new Paragraph(" FECHA : " + fecha, font2));
        content.add(new Paragraph(" SEÑOR(A) : " + cliente, font2));
        addEmptyLine(content, 1);
        content.add(new Paragraph(" NIT/CI : " + nit, font2));
        addEmptyLine(content, 1);
        document.add(content);
    }

    private static void createTable(Document document, Object[][] tabla, int rows, int columns, String total, String[] tituloT) throws BadElementException, DocumentException {
        PdfPTable table = new PdfPTable(columns);
        for (int i = 0; i < tituloT.length; i++) {
            PdfPCell c1 = new PdfPCell(new Phrase(tituloT[i]));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);

        }
        table.setHeaderRows(1);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                table.addCell("" + tabla[i][j]);
            }
        }

        Paragraph content = new Paragraph();
        addEmptyLine(content, 1);
        content.add(table);
        addEmptyLine(content, 1);
        content.add(new Paragraph("                                                                                                     TOTAL : " + total, font2));
        document.add(content);

    }

    public void shownPdf() {
        try {
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + file);
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null, "Error");
        }

    }

    private static void addMetaData(Document document) {
        document.addTitle("PDF");
        document.addAuthor(System.getProperty("user.name"));
        document.addCreator(System.getProperty("user.name"));
    }

    private static void addTittle(Document document) throws DocumentException {
        Paragraph preface = new Paragraph();
        addEmptyLine(preface, 1);
        preface.add(new Paragraph(title, font1));
        addEmptyLine(preface, 1);
        document.add(preface);
    }

    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
}

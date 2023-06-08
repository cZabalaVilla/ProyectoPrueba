package edu.fpdual.webapplication.utilities.reportpdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Stream;

public class Pdftext {

    public void createPDF(String fileName, String text) throws IOException, DocumentException, URISyntaxException {

        Document document = new Document();
        //PdfWriter pdfWriter =
        PdfWriter.getInstance(document, new FileOutputStream(fileName + ".pdf"));
        //Forma de encriptacion de fichero previo a su creacion
        // pdfWriter.setEncryption("user".getBytes(), "1234".getBytes(), PdfWriter.ALLOW_PRINTING, PdfWriter.ENCRYPTION_AES_256);

        document.open();

        Paragraph paragraph = createParagraph(text);

        PdfPTable pdfPTable = new PdfPTable(4);
        pdfPTable.setSpacingBefore(10f);
        addTableHeaders(pdfPTable);
        addTableCustomRows(pdfPTable);

        document.add(paragraph);
        document.add(Chunk.NEWLINE);
        document.add(pdfPTable);
        document.close();

        //Forma de encriptacion de fichero posterior a su creacion
        PdfReader pdfReader = new PdfReader(fileName + ".pdf");
        PdfStamper pdfStamper = new PdfStamper(pdfReader, new FileOutputStream(fileName + "_encrypted.pdf"));
        pdfStamper.setEncryption("user".getBytes(), "1234".getBytes(), PdfWriter.ALLOW_PRINTING, PdfWriter.ENCRYPTION_AES_256);
        pdfStamper.close();

    }
    private Paragraph createParagraph(String text) {
        Font font = FontFactory.getFont(FontFactory.COURIER_BOLD, 16, BaseColor.BLACK);
        Paragraph paragraph = new Paragraph(text, font);
        paragraph.setAlignment(Element.ALIGN_CENTER);
        paragraph.setSpacingAfter(10f);
        return paragraph;
    }

    private void addTableHeaders(PdfPTable pdfPTable) {
        Stream.of("Fecha", "Gasto o Ingreso", "Cantidad", "Categoria").forEach(nombreColumna -> {
            PdfPCell header = new PdfPCell();
            header.setBackgroundColor(BaseColor.GRAY);
            header.setBorderWidth(2);
            header.setPhrase(new Phrase(nombreColumna));
            header.setHorizontalAlignment(Element.ALIGN_CENTER);
            header.setVerticalAlignment(Element.ALIGN_CENTER);
            pdfPTable.addCell(header);
        });
    }

    private void addTableCustomRows(PdfPTable pdfPTable) throws URISyntaxException, BadElementException, IOException {

        PdfPCell columnNombre = new PdfPCell(new Phrase("Natalia"));
        columnNombre.setBackgroundColor(BaseColor.MAGENTA);
        columnNombre.setBorderWidth(1);
        columnNombre.setHorizontalAlignment(Element.ALIGN_CENTER);
        columnNombre.setVerticalAlignment(Element.ALIGN_MIDDLE);
        pdfPTable.addCell(columnNombre);

        PdfPCell columnApellido = new PdfPCell(new Phrase("Castillo"));
        columnApellido.setBackgroundColor(BaseColor.MAGENTA);
        columnApellido.setBorderWidth(1);
        columnApellido.setHorizontalAlignment(Element.ALIGN_CENTER);
        columnApellido.setVerticalAlignment(Element.ALIGN_MIDDLE);
        pdfPTable.addCell(columnApellido);

        PdfPCell columnEdad = new PdfPCell(new Phrase("45"));
        columnEdad.setBackgroundColor(BaseColor.MAGENTA);
        columnEdad.setBorderWidth(1);
        columnEdad.setHorizontalAlignment(Element.ALIGN_CENTER);
        columnEdad.setVerticalAlignment(Element.ALIGN_MIDDLE);
        pdfPTable.addCell(columnEdad);

        PdfPCell columnE = new PdfPCell(new Phrase("45"));
        columnEdad.setBackgroundColor(BaseColor.MAGENTA);
        columnEdad.setBorderWidth(1);
        columnEdad.setHorizontalAlignment(Element.ALIGN_CENTER);
        columnEdad.setVerticalAlignment(Element.ALIGN_MIDDLE);
        pdfPTable.addCell(columnE);

        PdfPCell columnEs = new PdfPCell(new Phrase("45"));
        columnEdad.setBackgroundColor(BaseColor.MAGENTA);
        columnEdad.setBorderWidth(1);
        columnEdad.setHorizontalAlignment(Element.ALIGN_CENTER);
        columnEdad.setVerticalAlignment(Element.ALIGN_MIDDLE);
        pdfPTable.addCell(columnEs);
    }

    public static void main(String[] args) throws DocumentException, IOException, URISyntaxException {
        ArrayList<String> lista = new ArrayList<>();
        lista.add("01-06-2023");
        lista.add("Gasto");
        lista.add("20 €");
        lista.add("Restaurante");

        lista.add("02-06-2023");
        lista.add("Ingreso");
        lista.add("120 €");
        lista.add("Trabajo");

        lista.add("05-06-2023");
        lista.add("Gasto");
        lista.add("12 €");
        lista.add("Supermercado");
        new Pdftext().createPDF("Reporte" + LocalDate.now(), "Reporte sobre...");
    }

}

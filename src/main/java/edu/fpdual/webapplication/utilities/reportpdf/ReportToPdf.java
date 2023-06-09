package edu.fpdual.webapplication.utilities.reportpdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.stream.Stream;

public class ReportToPdf {

    public static void main(String[] args) throws DocumentException, IOException {
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

        new ReportToPdf().createPDF(lista);
    }

    /**
     * Create a new pdf file based on the report selected
     *
     * @param list the list of all incomes and expenses.
     * @return a {@link String}
     */
    public String createPDF(ArrayList<String> list) throws IOException, DocumentException {
        String desktopPath = System.getProperty("user.home") + "/Desktop/";
        String filePath = desktopPath + pdfName() + ".pdf";

        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(filePath + ".pdf"));
        document.open();

        Paragraph paragraph = createParagraph();
        PdfPTable pdfPTable = createTable();
        addTableHeaders(pdfPTable);
        addTableCustomRows(pdfPTable, list);

        document.add(paragraph);
        document.add(Chunk.NEWLINE);
        document.add(pdfPTable);
        document.close();

        return "Se ha creado un reporte en un escritorio.";
    }

    private String pdfName() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        String timestampString = now.format(formatter);
        return "Reporte_" + timestampString;
    }

    private Paragraph createParagraph() {
        String text = "Fit-Pocket Report";

        Font font = FontFactory.getFont(FontFactory.COURIER_BOLD, 16, BaseColor.BLACK);
        Paragraph paragraph = new Paragraph(text, font);
        paragraph.setAlignment(Element.ALIGN_CENTER);
        paragraph.setSpacingAfter(10f);
        return paragraph;
    }

    private PdfPTable createTable() {
        PdfPTable pdfPTable = new PdfPTable(4);
        pdfPTable.setSpacingBefore(10f);
        return pdfPTable;
    }

    private void addTableHeaders(PdfPTable pdfPTable) {
        Stream.of("Fecha", "Gasto o Ingreso", "Cantidad", "Categoria").forEach(nombreColumna -> {
            PdfPCell header = new PdfPCell();
            header.setBackgroundColor(BaseColor.LIGHT_GRAY);
            header.setBorderWidth(2);
            header.setPhrase(new Phrase(nombreColumna));
            header.setHorizontalAlignment(Element.ALIGN_CENTER);
            header.setVerticalAlignment(Element.ALIGN_MIDDLE);
            pdfPTable.addCell(header);
        });
    }

    private void addTableCustomRows(PdfPTable pdfPTable, ArrayList<String> list) {
        for (String str : list) {
            PdfPCell column = new PdfPCell(new Phrase(str));
            column.setBackgroundColor(BaseColor.WHITE);
            column.setBorderWidth(1);
            column.setHorizontalAlignment(Element.ALIGN_CENTER);
            column.setVerticalAlignment(Element.ALIGN_MIDDLE);
            pdfPTable.addCell(column);
        }
    }
}

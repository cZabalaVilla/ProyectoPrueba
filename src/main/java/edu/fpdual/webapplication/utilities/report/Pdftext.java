package edu.fpdual.webapplication.utilities.report;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Stream;

public class Pdftext {

    public void createPDF(String fileName, String text,ArrayList<String> list) throws IOException, DocumentException, URISyntaxException {
        Document document = new Document();
        document.open();
        PdfWriter.getInstance(document, new FileOutputStream(fileName + ".pdf"));
        PdfPTable pdfPTable = new PdfPTable(4);

        /* Bloque para añadir una foto
            Path path = Paths.get(ClassLoader.getSystemResource("Check.png").toURI());
            Image image = createImage(path, 50);
        */
        Paragraph paragraph = createParagraph(text);
        addTableHeaders(pdfPTable);
        addTableCustomRows(pdfPTable,list);

        document.add(paragraph);
        document.add(Chunk.NEWLINE);
        //document.add(image);
        document.add(pdfPTable);
        document.close();

        /* Para encriptar
        PdfReader pdfReader = new PdfReader(fileName + ".pdf");
        PdfStamper pdfStamper = new PdfStamper(pdfReader, new FileOutputStream(fileName + "_encrypted.pdf"));
        pdfStamper.setEncryption("user".getBytes(), "1234".getBytes(), PdfWriter.ALLOW_PRINTING, PdfWriter.ENCRYPTION_AES_256);
        pdfStamper.close();
        */

    }

    private Image createImage(Path path, float scale) throws BadElementException, IOException {
        Image image = Image.getInstance(path.toAbsolutePath().toString());
        image.scalePercent(scale);
        return image;
    }

    private Paragraph createParagraph(String text) {
        Font font = FontFactory.getFont(FontFactory.COURIER_BOLD, 16, BaseColor.BLACK);
        Paragraph paragraph = new Paragraph(text, font);
        paragraph.setAlignment(Element.ALIGN_CENTER);
        paragraph.setSpacingAfter(10f);
        return paragraph;
    }

    private void addTableHeaders(PdfPTable pdfPTable) {
        Stream.of("Fecha", "Gasto o Ahorro", "Cantidad", "Categoria").forEach(nombreColumna -> {
            PdfPCell header = new PdfPCell();
            header.setBackgroundColor(BaseColor.GRAY);
            header.setBorderWidth(2);
            header.setPhrase(new Phrase(nombreColumna));
            header.setHorizontalAlignment(Element.ALIGN_CENTER);
            header.setVerticalAlignment(Element.ALIGN_CENTER);
            pdfPTable.addCell(header);
        });
    }


    private void addTableSimpleRows(PdfPTable pdfPTable) throws URISyntaxException, BadElementException, IOException {
        /*Path path = Paths.get(ClassLoader.getSystemResource("default-avatar.png").toURI());
        pdfPTable.addCell(createImage(path, 20));
        */
        pdfPTable.addCell("Ismael");
        pdfPTable.addCell("Orellana");
        pdfPTable.addCell("19");
    }

    private void addTableCustomRows(PdfPTable pdfPTable, ArrayList<String> list) throws URISyntaxException, BadElementException, IOException {

        /*
        Path path = Paths.get(ClassLoader.getSystemResource("default-avatar.png").toURI());
        PdfPCell columnFoto = new PdfPCell(createImage(path, 20));
        columnFoto.setBackgroundColor(BaseColor.MAGENTA);
        columnFoto.setBorderWidth(1);
        columnFoto.setHorizontalAlignment(Element.ALIGN_CENTER);
        columnFoto.setVerticalAlignment(Element.ALIGN_MIDDLE);
        pdfPTable.addCell(columnFoto);
        */
        /*
         * Lista de gastos simula un array bidimensional que se le pasa por parametro con la fecha, si es ingreso o gasto,
         * la cantidad y la categoría. Se pueden pasar directamente los gastos/ingresos en dos Arraylist también.
         * */
        String[][] listaDeGastos = new String[4][10];

        /*
        listaDeGastos[0][0] = "01-06-2023";
        listaDeGastos[1][0] = "Gasto";
        listaDeGastos[2][0] = "20 €";
        listaDeGastos[3][0] = "Restaurante";

        listaDeGastos[0][1] = "02-06-2023";
        listaDeGastos[1][1] = "Ingreso";
        listaDeGastos[2][1] = "120 €";
        listaDeGastos[3][1] = "Trabajo";

        listaDeGastos[0][2] = "05-06-2023";
        listaDeGastos[1][2] = "Gasto";
        listaDeGastos[2][2] = "12 €";
        listaDeGastos[3][2] = "Supermercado";
        */

        /*for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {*/
        for (String str : list) {
            PdfPCell column = new PdfPCell(new Phrase(str));
            column.setBackgroundColor(BaseColor.WHITE);
            column.setBorderWidth(1);
            column.setHorizontalAlignment(Element.ALIGN_CENTER);
            column.setVerticalAlignment(Element.ALIGN_MIDDLE);
            pdfPTable.addCell(column);
        }
        pdfPTable.completeRow();
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
        new Pdftext().createPDF("Reporte" + LocalDate.now(), "Reporte sobre...",lista);
    }

}

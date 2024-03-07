package com.employeePortal.pdfConverter;

import java.awt.Color;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.employeePortal.entity.ProfileInformation;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.Image;
@Service
public class PdfService {

    public static ByteArrayInputStream employeePDFReport(List<ProfileInformation> employees) throws IOException {
        Document document = new Document();
        document.setPageSize(com.lowagie.text.PageSize.A4.rotate());
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();
            Image logo = Image.getInstance("https://lh3.googleusercontent.com/proxy/p0j7GEke2nQF6mvDl6hrNj-94iv0lo2O-d9LX783XbCn_QyB_1erbcYOBGxUJUgF5CSx-WyG8yiCfLAKzgUnjK1cuxOGZCz2V9nicw7-yexgVDs6atUr2zam4ChE2bvm66mdhw"); 
            logo.scaleAbsolute(100, 100);

            Font fontHeader = FontFactory.getFont(FontFactory.TIMES_BOLD, 25);
            Paragraph paraLogo = new Paragraph();
            paraLogo.add(logo);
            paraLogo.setAlignment(Element.ALIGN_CENTER);

            Paragraph paraHeading = new Paragraph("Employee Structure", fontHeader);
            paraHeading.setAlignment(Element.ALIGN_CENTER);
            paraHeading.setSpacingBefore(-85);
            document.add(paraLogo);
            document.add(paraHeading);
            document.add(Chunk.NEWLINE); 

            PdfPTable table = new PdfPTable(9);
            table.setWidthPercentage(100);
            float[] columnWidths = {15, 20, 20, 20, 20, 15, 20, 15, 20};
            table.setWidths(columnWidths);

            // Add PDF Table Header
            Stream.of("Employee Id", "Employee Name", "Email ID", "Designation", "Mobile Number",
                    "Date Of Joining", "Reporting Manager", "Work Location", "Shift timings")
                    .forEach(headerTitle -> {
                        PdfPCell header = new PdfPCell();
                        Font headFont = FontFactory.getFont(FontFactory.TIMES_BOLD, 12, Color.WHITE);
                        header.setBackgroundColor(new Color(20, 73, 130));
                        header.setHorizontalAlignment(Element.ALIGN_CENTER);
                        header.setBorderWidth(2);
                        header.setPhrase(new Phrase(headerTitle, headFont));
                        table.addCell(header);
                    });

            for (ProfileInformation employee : employees) {
                addCell(table, employee.getEmployeeID().toString());
                addCell(table, employee.getEmployeeName());
                addCell(table, String.valueOf(employee.getEmailId()));
                addCell(table, String.valueOf(employee.getDesignation()));
                addCell(table, String.valueOf(employee.getMobileNumber()));
                addCell(table, String.valueOf(employee.getDateOfJoining()));
                addCell(table, String.valueOf(employee.getReportingManager()));
                addCell(table, String.valueOf(employee.getWorkFrom()));
                addCell(table, String.valueOf(employee.getShiftTimes()));
            }

            document.add(table);
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());
    }

    private static void addCell(PdfPTable table, String data) {
        String value = (data == null || data=="") ?  "" :data;
        PdfPCell cell = new PdfPCell(new Phrase(value));
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPadding(4);
        table.addCell(cell);
    }

}

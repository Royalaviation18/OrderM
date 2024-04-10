package com.royalaviation.OrderM;


import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.royalaviation.OrderM.entity.Order;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;

public class OrderReport {
    private List<Order> orderList;
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    public OrderReport(List<Order> orderList) {
        this.orderList = orderList;
        workbook = new XSSFWorkbook();
    }

    private void writeHeader() {
        sheet = workbook.createSheet("Order");
        Row row = sheet.createRow(0);
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
        createCell(row, 0, "ID", style);
        createCell(row, 1, "Total Amount", style);
        createCell(row, 2, "Total Quantity", style);
        createCell(row, 3, "Company Id", style);
        createCell(row, 4, "Company Name", style);
        createCell(row, 5, "Company Address", style);
        createCell(row, 6, "Company Email", style);
        createCell(row, 8, "Customer Name", style);
        createCell(row, 9, "Customer Phone", style);
        createCell(row, 10, "Item Id", style);
        createCell(row, 11, "Item Name", style);
    }

    private void createCell(Row row, int columnCount, Object valueOfCell, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (valueOfCell instanceof Integer) {
            cell.setCellValue((Integer) valueOfCell);
        } else if (valueOfCell instanceof Long) {
            cell.setCellValue((Long) valueOfCell);
        } else if (valueOfCell instanceof String) {
            cell.setCellValue((String) valueOfCell);
        } else {
            cell.setCellValue((Boolean) valueOfCell);
        }
        cell.setCellStyle(style);
    }

    private void write() {
        int rowCount = 1;
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);
        for (Order record : orderList) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            createCell(row, columnCount++, record.getId(), style);
            createCell(row, columnCount++, record.getTotalAmount(), style);
            createCell(row, columnCount++, record.getTotalQuantity(), style);
            createCell(row, columnCount++, record.getCompanyEntity().getId(), style);
            createCell(row, columnCount++, record.getCompanyEntity().getCompanyName(), style);
            createCell(row, columnCount++, record.getCompanyEntity().getCompanyAddress(), style);
            createCell(row, columnCount++, record.getCompanyEntity().getCompanyEmail(), style);
            createCell(row, columnCount++, record.getCustomerEntity().getCustomerName(), style);
            createCell(row, columnCount++, record.getCustomerEntity().getCustomerPhone(), style);
            createCell(row, columnCount++, record.getCustomerEntity().getCustomerEmail(), style);
            createCell(row, columnCount++, record.getItemEntity().getId(), style);
            createCell(row, columnCount++, record.getItemEntity().getItemName(), style);
        }
    }

    public void generateExcelFile(HttpServletResponse response) throws IOException {
        writeHeader();
        write();
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}

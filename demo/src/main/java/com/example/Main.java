package com.example;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRXmlDataSource;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;

import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        try {
            // Cargar XML desde resources
            InputStream xmlInput = Main.class.getResourceAsStream("/personas.xml");
            if (xmlInput == null) throw new RuntimeException("No se encontró personas.xml");

            // Convertir a ByteArrayInputStream para evitar ClassCastException
            byte[] xmlBytes = xmlInput.readAllBytes();
            JRXmlDataSource xmlDataSource = new JRXmlDataSource(new ByteArrayInputStream(xmlBytes), "/personas/persona");

            // Compilar reporte
            InputStream jrxmlInput = Main.class.getResourceAsStream("/reporte.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(jrxmlInput);

            // Llenar reporte
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap<>(), xmlDataSource);

            // Exportar PDF
            JasperExportManager.exportReportToPdfFile(jasperPrint, "reporte_personas.pdf");

            // Exportar HTML
            JasperExportManager.exportReportToHtmlFile(jasperPrint, "reporte_personas.html");

            // Exportar XLSX
            JRXlsxExporter exporter = new JRXlsxExporter();
            exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
            exporter.setExporterOutput(new SimpleOutputStreamExporterOutput("reporte_personas.xlsx"));
            SimpleXlsxReportConfiguration configuration = new SimpleXlsxReportConfiguration();
            configuration.setOnePagePerSheet(false);
            exporter.setConfiguration(configuration);
            exporter.exportReport();

            System.out.println("Reportes generados correctamente!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

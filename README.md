# Generación de reportes con JasperReports y XML (Java + Maven)

Este proyecto demuestra cómo generar reportes **PDF**, **HTML** y **XLSX** a partir de un archivo **XML** usando **JasperReports** en un proyecto Maven.

---

## Estructura del proyecto

```
UD1XMLtoReportJasper/
│
├── pom.xml
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/Main.java
│   │   └── resources/
│   │       ├── personas.xml
│   │       └── reporte.jrxml
│   └── test/
│
└── target/
```

---

## Dependencias Maven

Agrega las siguientes dependencias en tu `pom.xml`:

```xml
<dependencies>
        <!-- JasperReports Core -->  
        <dependency>
            <groupId>net.sf.jasperreports</groupId>
            <artifactId>jasperreports</artifactId>
            <version>6.20.6</version>
        </dependency>

        <!-- Export PDF -->
        <dependency>
            <groupId>com.lowagie</groupId>
            <artifactId>itext</artifactId>
            <version>2.1.7</version>
        </dependency>

        <!-- Export XLS -->
        <dependency>
            <groupId>org.apache.poi</groupId>
            <artifactId>poi</artifactId>
            <version>5.2.3</version>
        </dependency>
        <dependency>
            <groupId>org.apache.poi</groupId>
            <artifactId>poi-ooxml</artifactId>
            <version>5.2.3</version>
        </dependency>
        <dependency>
            <groupId>jaxen</groupId>
            <artifactId>jaxen</artifactId>
            <version>1.2.0</version>
        </dependency>
    </dependencies>
```
---
## Resultados

Se generarán los siguientes archivos en la carpeta raíz del proyecto:

- `reporte_personas.pdf`
- `reporte_personas.html`
- `reporte_personas.xlsx`

---

## Notas

- Todos los archivos (`.jrxml` y `.xml`) deben estar en **`src/main/resources`**.
- Si empaquetas tu proyecto como `.jar`, el uso de `getResourceAsStream` asegura que siga funcionando correctamente.

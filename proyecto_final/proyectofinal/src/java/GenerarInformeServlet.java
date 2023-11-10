import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@WebServlet("/GenerarInformeServlet")
public class GenerarInformeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection connection = null;
        try {
            // Establecer la conexión a tu base de datos
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdproductos", "root", "");

            // Ruta al archivo JasperReport compilado (.jasper)
            String jasperFilePath = getServletContext().getRealPath("/Productos.jasper");

            // Compilar el archivo JasperReport si no está compilado
            JasperCompileManager.compileReportToFile(jasperFilePath, "UTF-8");

            // Parámetros del informe (si los necesitas)
            Map<String, Object> parameters = new HashMap<>();

            // Llenar el informe con datos (puedes obtener datos de la base de datos aquí)

            // Crear el informe JasperPrint
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperFilePath, parameters, connection);

            // Exportar el informe a PDF y enviarlo como respuesta al navegador
            response.setContentType("application/pdf");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Content-Disposition", "inline; filename=Productos.pdf");

            try (OutputStream out = response.getOutputStream()) {
                JasperExportManager.exportReportToPdfStream(jasperPrint, out);
            }

        } catch (Exception e) {
            // Imprimir el error en la consola
            e.printStackTrace();

            // Enviar un mensaje de error como respuesta al navegador
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.println("<html><body><h2>Error al generar el informe: " + e.getMessage() + "</h2></body></html>");
            }
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

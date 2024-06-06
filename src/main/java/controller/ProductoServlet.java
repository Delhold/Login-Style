package controller;
//  Created by IntelliJ IDEA.
//  Estudiante: Dario Verdezoto
//  Descripcion: Estilos
//  To change this template use File | Settings | File Templates.

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Producto;
import services.LoginService;
import services.ProductoService;
import services.ProductoServiceImplement;
import services.loginServiceImplement;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

//Creamos nuestros path
@WebServlet({"/productoServlet", "/productos"})
public class ProductoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductoService service = new ProductoServiceImplement();
        List<Producto> productos = service.listar();
        LoginService auth = new loginServiceImplement();
        Optional<String> usernameOptional = auth.getUserName(req);

        resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Carrito</title>");
            out.println("<style>");
            out.println("body {");
            out.println("    font-family: Arial, sans-serif;");
            out.println("    background-color: #f2f2f2;");
            out.println("    margin: 0;");
            out.println("    padding: 0;");
            out.println("}");
            out.println(".navbar {");
            out.println("    background-color: #333;");
            out.println("    overflow: hidden;");
            out.println("    position: fixed;");
            out.println("    top: 0;");
            out.println("    width: 100%;");
            out.println("    z-index: 1000;");
            out.println("}");
            out.println(".navbar ul {");
            out.println("    display: flex;");
            out.println("    justify-content: right;");
            out.println("    padding: 0;");
            out.println("    margin: 0;");
            out.println("}");
            out.println(".navbar li {");
            out.println("    margin: 0 15px;");
            out.println("}");
            out.println(".navbar a {");
            out.println("    color: white;");
            out.println("    padding: 14px 20px;");
            out.println("    text-decoration: none;");
            out.println("    display: block;");
            out.println("    transition: background-color 0.3s ease;");
            out.println("}");
            out.println(".navbar a:hover {");
            out.println("    background-color: #979797;");
            out.println("}");
            out.println(".navbar .icon {");
            out.println("    display: flex;");
            out.println("    align-items: center;");
            out.println("    padding: 14px 20px;");
            out.println("}");
            out.println(".navbar img {");
            out.println("    height: 24px;");
            out.println("    vertical-align: middle;");
            out.println("}");
            out.println("h2 {");
            out.println("    text-align: center;");
            out.println("}");
            out.println("table {");
            out.println("    width: 80%;");
            out.println("    margin: 20px auto;");
            out.println("    border-collapse: collapse;");
            out.println("}");
            out.println("th, td {");
            out.println("    padding: 10px;");
            out.println("    border-bottom: 2px solid #ccc;");
            out.println("}");
            out.println("tr:last-child td {");
            out.println("    border-bottom: none;");
            out.println("}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='navbar'>");
            out.println("    <ul>");
            out.println("        <li class='icon'>");
            out.println("            <!-- Espacio para el icono principal -->");
            out.println("            <li><a href='index.html'> <img src='imagenes/store.png' alt='Icono principal' style='height: 24px;'></a></li>");
            out.println("        </li>");
            out.println("        </li>");
            out.println("        <li><a href='/login_war/productos'><img src='imagenes/cart.png' alt='Carrito'></a></li>");
            out.println("        <li><a href='/login_war/ServletLogin'><img src='imagenes/user.png' alt='Login'></a></li>");
            out.println("        <li><a href='/login_war/logout'><img src='imagenes/logout.png' alt='Logout'></a></li>");
            out.println("    </ul>");
            out.println("</div>");
            out.println("<br>");
            out.println("<br>");
            out.println("<h2>Listado de productos</h2>");
            if (usernameOptional.isPresent()) {
                out.println("<div>Hola " + usernameOptional.get() + " Bienvenido!</div>");
            }
            out.println("<table>");
            out.println("<tr>");
            out.println("<th>id</th>");
            out.println("<th>Nombre</th>");
            out.println("<th>Categoria</th>");
            out.println("<th>Descripcion</th>");
            if (usernameOptional.isPresent()) {
                out.println("<th>Precio</th>");
            }
            out.println("</tr>");
            productos.forEach(producto -> {
                out.println("<tr>");
                out.println("<td>" + producto.getId() + "</td>");
                out.println("<td>" + producto.getNombre() + "</td>");
                out.println("<td>" + producto.getCategoria() + "</td>");
                out.println("<td>" + producto.getDescripcion() + "</td>");
                if (usernameOptional.isPresent()) {
                    out.println("<td>" + producto.getPrecio() + "</td>");
                }
                out.println("</tr>");

            });
            out.println("</table>");
            out.println("<br>");
            out.println("<ul>");
            out.println("</body>");
            out.println("</html>");
        }
    }

}
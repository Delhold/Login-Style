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
import jakarta.servlet.http.HttpSession;
import services.LoginService;
import services.loginServiceImplement;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

//CREAMOS EL PATH PARA LA CONEXION AL (SERVLET)
@WebServlet({"/Login", "/ServletLogin"})
public class ServletLogin extends HttpServlet {
    final static String USERNAME = "admin";
    final static String PASSWORD = "1234";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        LoginService auth = new loginServiceImplement();
        Optional<String> usernameOptional = auth.getUserName(request);
        if (usernameOptional.isPresent()) {
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>ServletLogin</title>");
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
                out.println("h1, p {");
                out.println("    text-align: center;");
                out.println("    margin-top: 20px;");
                out.println("}");
                out.println("p a {");
                out.println("    color: #007bff;");
                out.println("    text-decoration: none;");
                out.println("}");
                out.println("p a:hover {");
                out.println("    text-decoration: underline;");
                out.println("}");
                out.println("</style>");
                out.println("</head>");
                out.println("<body>");
                out.println("<div class='navbar'>");
                out.println("    <ul>");
                out.println("        <li class='icon'>");
                out.println("            <!-- Espacio para el icono principal -->");
                out.println("            <li> <img src='imagenes/store.png' alt='Icono principal' style='height: 24px;'></li>");
                out.println("        </li>");
                out.println("        <li><a href='/login_war/productos'><img src='imagenes/cart.png' alt='Carrito'></a></li>");
                out.println("        <li><a href='/login_war/ServletLogin'><img src='imagenes/user.png' alt='Login'></a></li>");
                out.println("        <li><a href='/login_war/logout'><img src='imagenes/logout.png' alt='Logout'></a></li>");
                out.println("    </ul>");
                out.println("</div>");
                out.println("<h1>Iniciado la sesión correctamente " + usernameOptional.get() + "</h1>");
                out.println("<p><a href='" + request.getContextPath() + "/index.html'>Volver</a></p>");
                out.println("<p><a href='" + request.getContextPath() + "/logout'>Cerrar sesión</a></p>");
                out.println("</body>");
                out.println("</html>");


            }

        }else{
            getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
    //SOBRESCRIBIMOS EL METODO "DO POST"
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (USERNAME.equals(username) && PASSWORD.equals(password)) {
            HttpSession session = request.getSession();
            //Seteamos los datos
            session.setAttribute("username", username);
            //REDIRECCIONA AL HTML
            response.sendRedirect(request.getContextPath() + "/ServletLogin");
        }else {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "no esta autorizado para ingresar al sistema0");
        }
    }
}

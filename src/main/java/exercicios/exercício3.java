package exercicios;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/calculadora")
public class exercício3 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String n1 = req.getParameter("n1");
        String n2 = req.getParameter("n2");
        String operacao = req.getParameter("operacao");

        resp.setContentType("text/html");
        switch (operacao) {
            case "mult":
                //fazer multiplicação
                double resultado = Double.parseDouble(n1) * Double.parseDouble(n2);
                resp.getWriter().println("<h1>" + resultado + "</h1>");
                break;

            case "div":
                //fazer divisão
                double divisor = Double.parseDouble(n2);
                if (divisor == 0) {
                    resp.getWriter().println("<h1>Não pode dividir por 0 bobão!!!</h1>");
                } else {
                    resultado = Double.parseDouble(n1) / divisor;
                    resp.getWriter().println("<h1>" + resultado + "</h1>");
                }
                break;

            case "soma":
                //fazer soma
                resultado = Double.parseDouble(n1) + Double.parseDouble(n2);
                resp.getWriter().println("<h1>" + resultado + "</h1>");
                break;

            case "sub":
                //fazer menos
                resultado = Double.parseDouble(n1) - Double.parseDouble(n2);
                resp.getWriter().println("<h1>" + resultado + "</h1>");
                break;

            default:
                //exibir erro
                resp.getWriter().println("<h1>Operação desconhecida </h1>");
        }
    }
}

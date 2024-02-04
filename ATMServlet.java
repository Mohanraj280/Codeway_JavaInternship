package ser;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ATMServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final BankAccount userAccount = new BankAccount(1000); // Initial balance

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double amount = Double.parseDouble(request.getParameter("amount"));
        String action = request.getParameter("action");

        ATM atm = new ATM(userAccount);

        // Set response content type
        response.setContentType("text/html");

        // Get PrintWriter object to write HTML response
        PrintWriter out = response.getWriter();

        // Start writing HTML response
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>ATM Response</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; background-color: #f0f0f0; }");
        out.println(".container { width: 400px; margin: 50px auto; background-color: #fff; padding: 20px; border-radius: 8px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); }");
        out.println(".message { margin-bottom: 20px; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class=\"container\">");

        switch (action) {
            case "withdraw":
                atm.withdraw(amount);
                break;
            case "deposit":
                atm.deposit(amount);
                break;
            case "checkBalance":
                double balance = atm.checkBalance();
                out.println("<div class=\"message\">Current balance: " + balance + "</div>");
                break;
            default:
                out.println("<div class=\"message\">Invalid action.</div>");
        }

        // End writing HTML response
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoanServlet")
public class LoanServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        double loanAmount = Double.parseDouble(request.getParameter("amount"));
        double interestRate = Double.parseDouble(request.getParameter("interest")) / 100;
        int years = Integer.parseInt(request.getParameter("years"));

        Loan loan = new Loan(loanAmount, interestRate, years);
        double monthlyPayment = loan.calculateMonthlyPayment();
        double totalPayment = loan.calculateTotalPayment();

        request.setAttribute("monthlyPayment", monthlyPayment);
        request.setAttribute("totalPayment", totalPayment);
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }
}
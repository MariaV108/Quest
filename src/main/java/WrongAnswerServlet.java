import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@WebServlet("/wrongAnswer")
public class WrongAnswerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (InputStream inputStream = new FileInputStream("/Users/mariavorobeva/Downloads/Quest/src/main/resources/game.properties")) {
            Properties properties = new Properties();
            properties.load(inputStream);
            String id = req.getParameter("id");

            String questionNumber = properties.getProperty("question." + id);
            String wrongAnswer = properties.getProperty("wrongAnswer" + id);

            req.setAttribute("questionNumber", questionNumber);
            req.setAttribute("wrongAnswer", wrongAnswer);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("wrongAnswer.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}

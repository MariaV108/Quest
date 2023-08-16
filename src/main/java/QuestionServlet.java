import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@WebServlet("/question")
public class QuestionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (InputStream input = new FileInputStream("/Users/mariavorobeva/Downloads/Quest/src/main/resources/game.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            String id = req.getParameter("id");

            HttpSession session = req.getSession();
            session.setAttribute("name", "Maria");
            session.setAttribute("playerAge", "43");
            String sessionId = session.getId();
            session.setAttribute("id", sessionId);

            String questionText = prop.getProperty("question." + id);
            String answer1 = prop.getProperty("answer" + id + "." + 1);
            String answer2 = prop.getProperty("answer" + id + "." + 2);
            String isRight1 = prop.getProperty("isRight" + id + "." + 1);
            String isRight2 = prop.getProperty("isRight" + id + "." + 2);

            if (questionText == null) {
                RequestDispatcher requestDispatcher1 = req.getRequestDispatcher("final.jsp");
                requestDispatcher1.forward(req, resp);
            }

            req.setAttribute("questionNumber", questionText);
            req.setAttribute("answer1", answer1);
            req.setAttribute("answer2", answer2);
            req.setAttribute("nextQuestionId", Integer.parseInt(id) + 1);
            req.setAttribute("currentQuestionId", id);
            req.setAttribute("isRight1", isRight1);
            req.setAttribute("isRight2", isRight2);

        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("question.jsp");
        requestDispatcher.forward(req, resp);
    }
}

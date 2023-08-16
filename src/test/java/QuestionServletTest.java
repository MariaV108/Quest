import org.junit.jupiter.api.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static org.mockito.Mockito.*;

class QuestionServletTest {

    private final static String path = "question.jsp";


    @Test
    void doGetTest() throws ServletException, IOException {
        final QuestionServlet servlet = new QuestionServlet();

        final HttpServletRequest request = mock(HttpServletRequest.class);
        final HttpServletResponse response = mock(HttpServletResponse.class);
        final RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        final HttpSession session = mock(HttpSession.class);

        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher(path)).thenReturn(dispatcher);
        when(request.getParameter("id")).thenReturn("2");

        servlet.doGet(request, response);

        verify(request, times(1)).getRequestDispatcher(path);
        verify(dispatcher).forward(request, response);
    }
}
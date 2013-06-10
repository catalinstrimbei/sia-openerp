package org.app.forms;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class ClientiComenziGAEServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Bine ati venit in aplicatia Cloud!");
	}
}

package controller;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import compiler.DynamicCompiler;

import model.Exercise;
import model.User;

@WebServlet("/CompilerServlet")
public class CompilerServlet extends HttpServlet {

	private static final long serialVersionUID = 9166992002212699252L;
	
	public CompilerServlet() {
		super();
	}
	
	public void destroy() {
		super.destroy();
	}
	
	// Servlet Service
	public void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// get user, exo and code
		User u = (User) req.getSession().getAttribute("User");
		Exercise exo = (Exercise) req.getSession().getAttribute("exo");
		String code = req.getParameter("code");
		
		// compile
		String result = DynamicCompiler.dynamicCompile(exo, code, u);
		
		// check result
		System.out.println(result);
	}

}

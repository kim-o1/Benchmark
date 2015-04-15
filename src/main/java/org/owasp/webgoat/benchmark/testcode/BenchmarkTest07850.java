package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest07850")
public class BenchmarkTest07850 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = new Test().doSomething(param);
		
		new java.io.File(bar, "/Test.txt");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map16816 = new java.util.HashMap<String,Object>();
		map16816.put("keyA-16816", "a Value"); // put some stuff in the collection
		map16816.put("keyB-16816", param.toString()); // put it in a collection
		map16816.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map16816.get("keyB-16816"); // get it back out

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
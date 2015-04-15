package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13594")
public class BenchmarkTest13594 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheValue("foo");

		String bar = new Test().doSomething(param);
		
		Object[] obj = { "a", bar };
		
		response.getWriter().format(java.util.Locale.US,"notfoo",obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map92732 = new java.util.HashMap<String,Object>();
		map92732.put("keyA-92732", "a_Value"); // put some stuff in the collection
		map92732.put("keyB-92732", param.toString()); // put it in a collection
		map92732.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map92732.get("keyB-92732"); // get it back out
		bar = (String)map92732.get("keyA-92732"); // get safe value back out

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
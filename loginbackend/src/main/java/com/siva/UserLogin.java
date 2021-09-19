package com.siva;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/login")
public class UserLogin extends HttpServlet {
    private String pass;
    private String uname;
    private User validated;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        uname = request.getParameter("uname");
		pass = request.getParameter("pass");

        System.out.println("uname : " + uname + "\npass : " + pass);

//      Changing the password to the encoded value so that it can be compared with the encrypted value in database
		pass = SecureUtil.encode(pass);

        System.out.println("uname : " + uname + "\npass : " + pass);
		
		
//		Verifying the username and password and initializing a session

		if (Logindao.validate(uname, pass)) {
            System.out.println("came if validated");
			validated = new User(uname, true);
		} else {
            validated = new User(uname, false);
		}

        
        String validatedUserJsonString = new Gson().toJson(validated);
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(validatedUserJsonString);
        out.flush();

    }
}

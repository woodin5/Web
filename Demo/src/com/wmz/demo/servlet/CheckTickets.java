package com.wmz.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wmz.demo.helper.JsonTools;

/**
 * Servlet implementation class CheckTickets
 */
@WebServlet("/CheckTickets")
public class CheckTickets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckTickets() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter(); 
		String ticketNum = request.getParameter("num");
		if(ticketNum!=null&&!"".equals(ticketNum)){
			if("1".equals(ticketNum)){
				pw.println(JsonTools.checkTickets("true"));
			}else{
				pw.println(JsonTools.checkTickets("false"));
			}
		}else{
			pw.println(JsonTools.checkTickets("false"));
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

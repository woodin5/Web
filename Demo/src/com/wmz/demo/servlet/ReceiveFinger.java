package com.wmz.demo.servlet;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.swing.internal.plaf.synth.resources.synth_it;
import com.wmz.demo.helper.FileUtils;

/**
 * Servlet implementation class ReceiveFinger
 */
@WebServlet("/ReceiveFinger")
public class ReceiveFinger extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReceiveFinger() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		String finger = request.getParameter("finger");
		if (finger != null && finger.length() > 0) {
			String path = "e:" + File.separator + "wmz" + File.separator + "upload" + File.separator + "finger.txt";
			boolean writeOk = FileUtils.writeFile(path, finger);
			if (writeOk) {
				response.getWriter().println("OK");
			} else {
				response.getWriter().println("NO");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

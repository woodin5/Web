package com.wmz.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Welcome
 */
@WebServlet("/Welcome")
public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Welcome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html;charset=gbk");
		 
	      PrintWriter out = response.getWriter();
		  String title = "HTTP Header ����ʵ��";
	      String docType =
	      "<!doctype html public \"-//w3c//dtd html 4.0 " +
	      "transitional//en\">\n";
	      out.println(docType +
	        "<html>\n" +
	        "<head><title>" + title + "</title></head>\n"+
	        "<body bgcolor=\"#f0f0f0\">\n" +
	        "<h1 align=\"center\">" + title + "</h1>\n" +
	        "<table width=\"100%\" border=\"1\" align=\"center\">\n" +
	        "<tr bgcolor=\"#949494\">\n" +
	        "<th>Header ����</th><th>Header ֵ</th>\n"+
	        "</tr>\n");
	 
	      Enumeration headerNames = request.getHeaderNames();
	      
	      while(headerNames.hasMoreElements()) {
	         String paramName = (String)headerNames.nextElement();
	         out.print("<tr><td>" + paramName + "</td>\n");
	         String paramValue = request.getHeader(paramName);
	         out.println("<td> " + paramValue + "</td></tr>\n");
	      }
	      out.println("</table>\n</body></html>");
	      
	      
	      
	      
	      
	      
	      // ����ˢ���Զ�����ʱ��Ϊ 5 ��
	      response.setIntHeader("Refresh", 5);
	 
	      // Get current time
	      Calendar calendar = new GregorianCalendar();
	      String am_pm;
	      int hour = calendar.get(Calendar.HOUR);
	      int minute = calendar.get(Calendar.MINUTE);
	      int second = calendar.get(Calendar.SECOND);
	      if(calendar.get(Calendar.AM_PM) == 0)
	        am_pm = "AM";
	      else
	        am_pm = "PM";
	 
	      String CT = hour+":"+ minute +":"+ second +" "+ am_pm;
	    
	      
	       title = "�Զ�ˢ�� Header ����";
	       docType =
	      "<!doctype html public \"-//w3c//dtd html 4.0 " +
	      "transitional//en\">\n";
	      out.println(docType +
	        "<html>\n" +
	        "<head><title>" + title + "</title></head>\n"+
	        "<body bgcolor=\"#f0f0f0\">\n" +
	        "<h1 align=\"center\">" + title + "</h1>\n" +
	        "<p>��ǰʱ���ǣ�" + CT + "</p>\n");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
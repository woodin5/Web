package com.wmz.demo.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadApk
 */
@WebServlet("/DownloadApk")
public class DownloadApk extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadApk() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 File f = new File("E:"+File.separator+"wmz"+File.separator+"apk"+File.separator+"Test.apk");  
	        if(f.exists()){  
	            FileInputStream  fis = new FileInputStream(f);  
	            String filename=URLEncoder.encode(f.getName(),"utf-8"); //��������ļ������غ����������  
	            byte[] b = new byte[fis.available()];  
	            fis.read(b);  
	            response.setCharacterEncoding("utf-8");  
	            response.setHeader("Content-Disposition","attachment; filename="+filename+"");  
	            //��ȡ��Ӧ�������������  
	            ServletOutputStream  out =response.getOutputStream();  
	            //���  
	            out.write(b);  
	            out.flush();  
	            out.close();  
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

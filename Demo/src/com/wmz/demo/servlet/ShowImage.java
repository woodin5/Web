package com.wmz.demo.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowImage
 */
@WebServlet("/ShowImage")
public class ShowImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowImage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		showImage(request, response);
		downlodeImage(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	 public void showImage(HttpServletRequest request,
	            HttpServletResponse response) throws ServletException, IOException {
	        // ��ȡ��ʽ
	        // response.setContentType("application/zip");
	        response.setContentType("image/jpeg");
	        // ��ȡͼƬ����·��
	        String path = this.getServletContext().getRealPath("/");
	        File file = new File(path + "/images/ad_1.jpg");
	        System.out.println("file="+file.getAbsolutePath());
	        // �����ļ�������
	        FileInputStream is = new FileInputStream(file);
	        // ��Ӧ�����
	        ServletOutputStream out = response.getOutputStream();
	        // ����������
	        byte[] buffer = new byte[1024];
	        int len = 0;
	        while ((len = is.read(buffer)) != -1) {
	            out.write(buffer, 0, len);
	        }
	        is.close();
	        out.flush();
	        out.close();
	 
	    }
	 
	    public void downlodeImage(HttpServletRequest request,
	            HttpServletResponse response) throws ServletException, IOException {
	         
	        // ��ȡͼƬ����·��
	        String path = this.getServletContext().getRealPath("/");
	        File file = new File(path + "/images/ad_1.jpg");
	        //����ͷ��Ϣ,���ݴ���ķ�ʽ,attachment�Ը�������ʽ��,���ǽ�������,�����������ļ�������
	        response.setHeader("Content-Disposition","attachment;filename="+file.getName());
	        // �����ļ�������
	        FileInputStream is = new FileInputStream(file);
	        // ��Ӧ�����
	        ServletOutputStream out = response.getOutputStream();
	        // ����������
	        byte[] buffer = new byte[1024];
	        int len = 0;
	        while ((len = is.read(buffer)) != -1) {
	            out.write(buffer, 0, len);
	        }
	        is.close();
	        out.flush();
	        out.close();
	 
	    }
}

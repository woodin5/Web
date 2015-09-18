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
	        // 读取方式
	        // response.setContentType("application/zip");
	        response.setContentType("image/jpeg");
	        // 获取图片绝对路径
	        String path = this.getServletContext().getRealPath("/");
	        File file = new File(path + "/images/ad_1.jpg");
	        System.out.println("file="+file.getAbsolutePath());
	        // 创建文件输入流
	        FileInputStream is = new FileInputStream(file);
	        // 响应输出流
	        ServletOutputStream out = response.getOutputStream();
	        // 创建缓冲区
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
	         
	        // 获取图片绝对路径
	        String path = this.getServletContext().getRealPath("/");
	        File file = new File(path + "/images/ad_1.jpg");
	        //设置头信息,内容处理的方式,attachment以附件的形式打开,就是进行下载,并设置下载文件的命名
	        response.setHeader("Content-Disposition","attachment;filename="+file.getName());
	        // 创建文件输入流
	        FileInputStream is = new FileInputStream(file);
	        // 响应输出流
	        ServletOutputStream out = response.getOutputStream();
	        // 创建缓冲区
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

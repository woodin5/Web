package com.wmz.demo.helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FileUtils {

	public static boolean existsFile(File file) {
		return file.exists();
	}

	public static boolean existsFile(String filePath) {
		File file = new File(filePath);
		return existsFile(file);
	}

	public static List<String> listPath(String root) {
		List<String> allDir = new ArrayList<String>();
		SecurityManager checker = new SecurityManager();
		File path = new File(root);
		checker.checkRead(root);
		if (path.isDirectory()) {
			for (File f : path.listFiles()) {
				if (f.isDirectory() && !f.getName().startsWith(".")) {
					allDir.add(f.getAbsolutePath());
				}
			}
		}
		return allDir;
	}

	public static List<File> listPathFiles(String root) {
		List<File> allDir = new ArrayList<File>();
		SecurityManager checker = new SecurityManager();
		File path = new File(root);
		checker.checkRead(root);
		File[] files = path.listFiles();
		for (File f : files) {
			if (f.isFile())
				allDir.add(f);
			else
				listPath(f.getAbsolutePath());
		}
		return allDir;
	}

	public static void RecursionDeleteFile(File file) {
		if (file.isFile()) {
			file.delete();
			return;
		}
		if (file.isDirectory()) {
			File[] childFile = file.listFiles();
			if (childFile == null || childFile.length == 0) {
				file.delete();
				return;
			}
			for (File f : childFile) {
				RecursionDeleteFile(f);
			}
			file.delete();
		}
	}

	public static boolean writeFile(String filePath, InputStream inputStream) {
		if (inputStream == null)
			return false;
		byte[] bytes = new byte[1024];
		int len = 0;
		try {
			FileOutputStream fs = new FileOutputStream(filePath);
			while ((len = inputStream.read(bytes)) != -1) {
				fs.write(bytes, 0, len);
			}
			fs.close();
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean writeFile(String filePath, String data) {
		if (data == null || "".equals("data") || data.length() == 0)
			return false;
		byte[] bytes = new byte[1024];
		int len = 0;
		try {
			FileOutputStream fs = new FileOutputStream(filePath);
			fs.write(data.getBytes("utf-8"));
			fs.close();
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
}

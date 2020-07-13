package com.sample.download;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import com.sample.dao.SampleFileDao;
import com.sample.util.NumberUtil;
import com.sample.vo.SampleFile;

// FileDownloadServlet�� HttpServlet�� ��ӹ��� ���� Ŭ������.
// HttpServlet�� ��ӹ��� Ŭ������ HTTP��û�� ó���� �� �ִ� ������ �ȴ�.
// FileDownloadServlet�� Ŭ���̾�Ʈ�� ��û�� ó���� �� �ִ� Ŭ������.
// Tomcat�� /download URL ��û�� ���� FileDownloadServlet�� ���� ��û�̶�� �Ǵ��Ѵ�.
// Tomcat�� /download URL ��û�� ���� ��û��ü�� ���䰴ü�� �����ϰ�,
// FileDownloadServlet�� service(HttpServletRequest request, HttpServletResponse response)
// �޼ҵ带 �����ؼ� Ŭ���̾�Ʈ�� ��û�� ó���Ѵ�.
// @WebServlet�� ������ ���� ���������� ������ �� ���Ǵ� ������̼��̴�.
// urlPatterns�� ��û URL�� ���� �� ������� ����ؾ� �Ǵ����� �����Ѵ�.
@WebServlet(urlPatterns = "/download")
public class FileDownloadServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
		int fileNo = NumberUtil.stringToInt(req.getParameter("no"));
		
		SampleFileDao sampleFileDao = new SampleFileDao();
		SampleFile sampleFile = sampleFileDao.getFileByNo(fileNo);
		
		ServletContext application = this.getServletContext();
		String saveDirectory = application.getInitParameter("saveDirectory");
		String filename = sampleFile.getName();
		File file = new File(saveDirectory, filename);
		long fileSize = file.length();
		
		String encodedFilename = URLEncoder.encode(filename, "utf-8");
		// ������������ Ÿ���� �����Ѵ�.
		// ������ �̸��� ����޼����� �����Ѵ�.
		resp.setContentType("application/octet-stream");
		resp.setContentLengthLong(fileSize);
		resp.setHeader("Content-Disposition", "attachment; filename=" + encodedFilename);
		// ������ ��ο��� �����̸��� �شٝ۴� ������ �о���� ��Ʈ�� ȹ��
		FileInputStream input = new FileInputStream(file);
		// ���䰴ü���� �������� �����͸� �����ϴ� ��Ʈ�� ȹ��
		OutputStream output = resp.getOutputStream();
		IOUtils.copy(input, output);
		
		} catch(Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}

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

// FileDownloadServlet은 HttpServlet을 상속받은 서블릿 클래스다.
// HttpServlet을 상속받은 클래스는 HTTP요청을 처리할 수 있는 서블릿이 된다.
// FileDownloadServlet은 클라이언트의 요청을 처리할 수 있는 클래스다.
// Tomcat은 /download URL 요청이 오면 FileDownloadServlet에 대한 요청이라고 판단한다.
// Tomcat은 /download URL 요청이 오면 요청객체와 응답객체를 생성하고,
// FileDownloadServlet의 service(HttpServletRequest request, HttpServletResponse response)
// 메소드를 실행해서 클라이언트의 요청을 처리한다.
// @WebServlet은 서블릿에 대한 설정정보를 지정할 때 사용되는 어노테이션이다.
// urlPatterns는 요청 URL이 왔을 때 어떤서블릿을 사용해야 되는지를 지정한다.
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
		// 응답컨텐츠의 타입을 지정한다.
		// 파일의 이름을 응답메세지에 설정한다.
		resp.setContentType("application/octet-stream");
		resp.setContentLengthLong(fileSize);
		resp.setHeader("Content-Disposition", "attachment; filename=" + encodedFilename);
		// 지정된 경로에서 파일이름에 해다앟는 파일을 읽어오는 스트림 획득
		FileInputStream input = new FileInputStream(file);
		// 응답객체에서 브라우저로 데이터를 전송하는 스트림 획득
		OutputStream output = resp.getOutputStream();
		IOUtils.copy(input, output);
		
		} catch(Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}

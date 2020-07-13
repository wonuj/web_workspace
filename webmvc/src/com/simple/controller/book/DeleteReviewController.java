package com.simple.controller.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.simple.controller.Controller;
import com.simple.dao.ReviewDao;
import com.simple.util.NumberUtil;
import com.simple.vo.Review;
import com.simple.vo.User;

public class DeleteReviewController implements Controller {
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("loginUser");
		// �α��ε��� ���� ����ڴ� �α��� ������ �����̷��ǽ�Ų��.
		if(user == null) {
			return "redirect:../login/form/hta?error=deny";
		}
		
		// ��û �Ķ���Ͱ� ��ȸ
		int reviewNo = NumberUtil.stringToInt(req.getParameter("reviewno"));
		
		// �����ȣ�� �ش��ϴ� ���� ���� ����
		ReviewDao reviewDao = new ReviewDao();
		Review review = reviewDao.getReviewByNo(reviewNo);
		
		// ���� ������ �������� �ʴ� ��� å ����������� �����̷��� ��Ų��.
		if(review == null) {
			return "redirect:list.hta";
		}
		// �α��� ����ڰ� �ۼ��� ���䰡 �ƴ� ��� �����޼����� �Բ� å ���������� �����̷��� ��Ų��.
		if(!review.getUserId().equals(user.getId())) {
			return "redirect:detail.hta?error=deny&bookno=" + review.getBookNo();
		}
		
		// ��������ϱ�
		reviewDao.deleteReview(reviewNo);;
		
		// å ���������� ��û�ϴ� URI�� ���û�ϰ� �ϱ�
		return "redirect:detail.hta?bookno=" + review.getBookNo();
	}
}

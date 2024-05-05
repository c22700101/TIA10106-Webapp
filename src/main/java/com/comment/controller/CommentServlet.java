package com.comment.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.comment.model.CommentService;
import com.comment.model.CommentVO;

public class CommentServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			Integer str = Integer.valueOf(req.getParameter("commentId"));
			if (str == null) {
				errorMsgs.add("請輸入評價編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/comment/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			Integer commentId = null;
			try {
				commentId = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.add("評價編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/comment/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 2.開始查詢資料 *****************************************/
			CommentService commentSvc = new CommentService();
			CommentVO commentVO = commentSvc.getOneComment(commentId);
			if (commentVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/comment/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			req.setAttribute("commentVO", commentVO); // 資料庫取出的empVO物件,存入req
			String url = "/comment/listOneComment.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
			successView.forward(req, res);
		}

		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ****************************************/
			Integer commentId = Integer.valueOf(req.getParameter("commentId"));

			/*************************** 2.開始查詢資料 ****************************************/
			CommentService commentSvc = new CommentService();
			CommentVO commentVO = commentSvc.getOneComment(commentId);

			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
			req.setAttribute("commentVO", commentVO); // 資料庫取出的empVO物件,存入req
			String url = "/comment/update_comment_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
			successView.forward(req, res);
		}

		if ("update".equals(action)) { // 來自update_comment_input.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			Integer commentId = Integer.valueOf(req.getParameter("commentId").trim());

			Integer commentProductId = Integer.valueOf(req.getParameter("commentProductId"));
			if (commentProductId == null) {
				errorMsgs.add("產品編號: 請勿空白");
			}

			CommentVO commentVO = new CommentVO();
			commentVO.setCommentId(commentId);
			commentVO.setCommentProductId(commentProductId);
			commentVO.setCommentText(req.getParameter("commentText"));
			commentVO.setCommentImg(req.getParameter("commentImg"));
			commentVO.setCommentTimestamp(Timestamp.from(Instant.now()));
			commentVO.setCommentRateStars(req.getParameter("commentRateStars"));

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("commentVO", commentVO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/comment/update_comment_input.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}

			/*************************** 2.開始修改資料 *****************************************/
			CommentService commentSvc = new CommentService();
			commentSvc.update(commentVO);

			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			req.setAttribute("commentVO", commentVO); // 資料庫update成功後,正確的的empVO物件,存入req
			String url = "/comment/listOneComment.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneComment.jsp
			successView.forward(req, res);
		}

		if ("insert".equals(action)) { // 來自addComment.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			Integer commentProductId = Integer.valueOf(req.getParameter("commentProductId"));
			if (commentProductId == null) {
				errorMsgs.add("產品編號: 請勿空白");
			}

			CommentVO commentVO = new CommentVO();
			commentVO.setCommentProductId(commentProductId);
			commentVO.setCommentText(req.getParameter("commentText"));
			commentVO.setCommentImg(req.getParameter("commentImg"));
			commentVO.setCommentTimestamp(Timestamp.from(Instant.now()));
			commentVO.setCommentRateStars(req.getParameter("commentRateStars"));

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("commentVO", commentVO); // 含有輸入格式錯誤的commetVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/comment/addComment.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}

			/*************************** 2.開始修改資料 *****************************************/
			CommentService commentSvc = new CommentService();
			commentSvc.insert(commentVO);

			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			String url = "/comment/listAllComment.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllComment.jsp
			successView.forward(req, res);
		}
		if ("delete".equals(action)) { // 來自listAllEmp.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ***************************************/
			Integer commentId = Integer.valueOf(req.getParameter("commentId"));

			/*************************** 2.開始刪除資料 ***************************************/
			CommentService commentSvc = new CommentService();
			commentSvc.delete(commentId);

			/*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
			String url = "/comment/listAllComment.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
			successView.forward(req, res);
		}
	}
}

package jp.co.alpha.servlet.cleaning;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.alpha.bean.CleanPrace;
import jp.co.alpha.dao.CleanPraceDao;

/**
 * Servlet implementation class CleaingView
 */
@WebServlet("/to_clean")
public class ToClean extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<CleanPrace> CleanPraceList = CleanPraceDao.findAll();
		request.setAttribute("CleanPraceList", CleanPraceList);
		request.getRequestDispatcher("/jsp/clean.jsp").forward(request, response);

	}

}
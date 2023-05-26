package jp.co.alpha.servlet.group;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.alpha.bean.Team;
import jp.co.alpha.bean.UserTeam;
import jp.co.alpha.dao.TeamDao;
import jp.co.alpha.dao.UsersDao;

/**
 * Servlet implementation class GroupCreate
 */
@WebServlet("/group_create")
public class GroupCreate extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			String splitValue = request.getParameter("split");
			String useValue = request.getParameter("use");
			int useNum = -1;
			switch (useValue) {
			case "s":
				useNum = 1;
				break;
			case "o":
				useNum = 0;
				break;
			}
			int groupNumber = Integer.parseInt(request.getParameter("gNumber"));
			List<Team> teamList = new ArrayList<>();
			for (int i = 1; i < groupNumber + 1; i++) {
				Team t = new Team();
				t.setId(i);
				t.setFlag(useNum);
				t.setDeleteFlag(0);
				teamList.add(t);
			}
			List<UserTeam> utList = utList = TeamDao.createTeams(teamList, groupNumber);;
			switch (splitValue) {
			case "n":
				// 名前の順
				
				break;
			case "r":
				// ランダム
				int userNum = UsersDao.allUsers().size();
				int[] intArray = new Random().ints(userNum, 1, userNum).toArray();
				utList = TeamDao.createTeams(teamList, groupNumber, intArray);
				break;
			}
			request.setAttribute("utList", utList);
			request.setAttribute("gNum", groupNumber);
			request.getRequestDispatcher("/jsp/group_confirm.jsp").forward(request, response);
		} catch (NullPointerException e) {
			session.setAttribute("failure", "failure");
			response.sendRedirect(request.getContextPath() + "/jsp/group.jsp");
		}
	}
}

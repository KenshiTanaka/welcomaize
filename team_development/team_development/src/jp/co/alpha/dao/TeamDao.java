package jp.co.alpha.dao;

import java.util.ArrayList;
import java.util.List;

import jp.co.alpha.bean.Team;
import jp.co.alpha.bean.UserTeam;
import jp.co.alpha.bean.Users;

public class TeamDao {
	public static List<UserTeam> createTeams(List<Team> teamList, int groupNum) {
		List<UserTeam> utList = new ArrayList<>();
		List<Users> userList = UsersDao.allUsers();
		int count = userList.size();
		int time = 0;
		int idSetting = 1;
		if (count % groupNum == 0) {
			for (int i = 0; i < groupNum; i++) {
				for (int j = 0; j < count / groupNum; j++) {
					UserTeam ut = new UserTeam();
					ut.setId(idSetting++);
					ut.setUsers(userList.get(time++));
					ut.setTeam(teamList.get(i));
					utList.add(ut);
				}
			}
		} else {
			int oneG = count / groupNum + 1;
			int key = count % groupNum;
			for (int i = 0; i < groupNum; i++) {
				if (i > key - 1) {
					oneG -= 1;
				}
				for (int j = 0; j < oneG; j++) {
					UserTeam ut = new UserTeam();
					ut.setId(idSetting++);
					ut.setUsers(userList.get(time++));
					ut.setTeam(teamList.get(i));
					utList.add(ut);
				}
			}
		}
		return utList;
	}

	public static List<UserTeam> createTeams(List<Team> teamList, int groupNum, int[] ranArr) {
		List<UserTeam> utList = new ArrayList<>();
		List<Users> userList = UsersDao.allUsers();
		int count = userList.size();
		int time = 0;
		int idSetting = 1;
		if (count % groupNum == 0) {
			for (int i = 0; i < groupNum; i++) {
				for (int j = 0; j < count / groupNum; j++) {
					UserTeam ut = new UserTeam();
					ut.setId(idSetting++);
					ut.setUsers(userList.get(ranArr[time++]));
					ut.setTeam(teamList.get(i));
					utList.add(ut);
				}
			}
		} else {
			int oneG = count / groupNum + 1;
			int key = count % groupNum;
			for (int i = 0; i < groupNum; i++) {
				if (i > key - 1) {
					oneG -= 1;
				}
				for (int j = 0; j < oneG; j++) {
					UserTeam ut = new UserTeam();
					ut.setId(idSetting++);
					ut.setUsers(userList.get(ranArr[time++]));
					ut.setTeam(teamList.get(i));
					utList.add(ut);
				}
			}
		}
		return utList;
	}
}

package ezen.mvcframework.web.member.controller;

import java.util.List;
import java.util.Map;

import ezen.mvcframework.core.web.controller.WebController;
import ezen.mvcframework.domain.common.database.DaoFactory;
import ezen.mvcframework.domain.member.dao.MemberDao;
import ezen.mvcframework.domain.member.dto.Member;

public class MemberListRestController implements WebController{

	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model) {
		String viewName = "member/member";
		MemberDao memberDao = DaoFactory.getInstance().getMemberDao();
		List<Member> members = memberDao.findByAll();
		model.put("members", members);
		return viewName;
	}

}














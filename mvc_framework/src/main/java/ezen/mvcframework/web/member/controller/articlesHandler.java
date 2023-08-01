package ezen.mvcframework.web.member.controller;

import java.util.List;
import java.util.Map;

import ezen.mvcframework.core.web.controller.ControllerV3;
import ezen.mvcframework.core.web.controller.ModelAndView;
import ezen.mvcproject.domain.common.database.DaoFactory;
import ezen.mvcproject.domain.member.dao.MemberDao;
import ezen.mvcproject.domain.member.dto.Member;

public class articlesHandler implements ControllerV3{
	@Override
	public ModelAndView process(Map<String, String> paramMap) {
		String viewName = "member/article";
		MemberDao memberDao =DaoFactory.getInstance().getMemberDao();
		List<Member> members =memberDao.findByAll();
		ModelAndView mav = new ModelAndView(viewName);
		mav.getModel().put("members", members);
		return mav;
	}
}
	
	

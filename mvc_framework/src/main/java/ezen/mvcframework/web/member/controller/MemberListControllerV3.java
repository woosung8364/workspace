package ezen.mvcframework.web.member.controller;

import java.util.List;
import java.util.Map;

import ezen.mvcframework.core.web.controller.ControllerV3;
import ezen.mvcframework.core.web.controller.ModelAndView;
import ezen.mvcproject.domain.common.database.DaoFactory;
import ezen.mvcproject.domain.member.dao.MemberDao;
import ezen.mvcproject.domain.member.dto.Member;

/**
 * 회원 목록 요청에 대한 처리
 * @author i7C-송우성
 *
 */
public class MemberListControllerV3 implements ControllerV3 {

	
//	Map 에는 파라미터가 들어가있음
	@Override
	public ModelAndView process(Map<String, String> paramMap) {
			String viewName = "member/members";
			MemberDao memberDao =DaoFactory.getInstance().getMemberDao();
			List<Member> members =memberDao.findByAll();
			ModelAndView mav = new ModelAndView(viewName);
			mav.getModel().put("members", members);
			return mav;
	}

}

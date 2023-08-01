package ezen.mvcframework.web.member.controller;

import java.util.Map;
import ezen.mvcframework.core.web.controller.ControllerV3;
import ezen.mvcframework.core.web.controller.ModelAndView;
import ezen.mvcproject.domain.common.database.DaoFactory;
import ezen.mvcproject.domain.member.dao.MemberDao;
import ezen.mvcproject.domain.member.dto.Member;

/**
 * 회원 가입 요청 처리 세부 컨트롤러
 * 5
 */
public class MemberSignupActionControllerV3 implements ControllerV3 {
	
	@Override
	public ModelAndView process(Map<String, String> paramMap) {
		String viewName = "member/signup-result";
		
//		맵에서 해당요소들을 뺌
		String name = paramMap.get("name"); 
		String id = paramMap.get("id");
		String passwd = paramMap.get("passwd");
		String email = paramMap.get("email");

		Member member = new Member(id, passwd, name, email, null);
		MemberDao memberDao = DaoFactory.getInstance().getMemberDao();
		memberDao.create(member);
		
		// 모델에 회원정보 저장
		ModelAndView mav = new ModelAndView(viewName);
		mav.getModel().put("member", member); 
//		프론트 컨트롤러에 반환
		return mav;
	}
	
	public static void main(String[] args) {
		
	}

}

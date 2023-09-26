package com.ezen.springmvc.domain.article.controller;
import java.util.List;

import com.ezen.springmvc.domain.article.ArticleService;
import com.ezen.springmvc.domain.article.page.PageParams;
import com.ezen.springmvc.domain.article.page.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ezen.springmvc.domain.article.dto.ArticleDTO;
import com.ezen.springmvc.domain.article.mapper.ArticleMapper;
import com.ezen.springmvc.domain.member.dto.Member;
import com.ezen.springmvc.domain.member.mapper.MemberMapper;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@RequestMapping("/article")
@Controller
@Slf4j
public class ArticleController {

	// 한 페이지에 보여지는 목록 갯수 설정
	private static final int ELEMENT_SIZE = 3;
	// 한페이지에 보여지는 페이지 갯수 설정
	private static final int PAGE_SIZE = 3;

	@Autowired
	private ArticleMapper articleMapper;

	@Autowired
	private MemberMapper memberMapper;

	@Autowired
	private ArticleService articleService;

//	게시글 메인 경로설정
	@GetMapping("/main")
	public String Article(Model model) {

		log.info("Article 홈페이지 실행됨");
		return "articles/index";
	}

//  게시글 목록 경로설정
  @GetMapping("/list")
  public String list(@ModelAttribute Member member, HttpSession session ,Model model, @RequestParam(defaultValue = "1") int requestPage) {
     log.info("게시글 목록 페이지 실행됨");
     int selectPage = requestPage;
     int rowCount = articleService.getCountAll();
     PageParams pageParams = new PageParams(ELEMENT_SIZE, PAGE_SIZE, selectPage, rowCount);
     Pagination pagination = new Pagination(pageParams);
     List<ArticleDTO> list;
  if(requestPage !=0){
     list = articleService.findByAll(pageParams);
  } else {
     list = articleService.findAll();
}

//     로그인 성공했다고 가정 / id명은 임의로 주었음
     member = memberMapper.findById("song8364");
     session.setAttribute("member", member);

	//	 모델에 list 배열 저장
     model.addAttribute("list" , list);

     // 모델에 페이징 정보 설정
     model.addAttribute("pagination", pagination);

     // 모델에 현재 요청 페이지 정보 저장
     model.addAttribute("requestPage", requestPage);
     log.info("수신받은 list 객체에 대해서 알려드립니다 : {}" , list);
     log.info("수신 받은 member 객체에 대해서 알려드립니다 : {}" , member);
     return "articles/list";
  }

	@GetMapping("/list/search")
	public String searchList(@RequestParam String value, Model model) {

		return "";
	}

//	게시글 등록
	@GetMapping("/register")
	public String registerForm(Model model) {
		log.info("게시글 등록 페이지 실행됨");
		// 빈 게시글 객체 생성 (없는값은 수동으로 넣고 나중에 groupNum을 update로 articleId로 바꾸자)
		ArticleDTO articleDTO = ArticleDTO.builder().build();

		model.addAttribute("article", articleDTO);
		model.addAttribute("boolean", "register");
		return "articles/register";
	}

	@PostMapping("/register")
	public String register(@ModelAttribute ArticleDTO articleDTO, Model model) {
		log.info("게시글 등록 정보 : {}", articleDTO.toString());
		// member 객체를 가져와야해 passwd를 어떻게 가져오냐

		articleDTO.setBoardId(10);
		articleDTO.setGroupNum(1);
		articleDTO.setWriter("song8364");
		articleDTO.setHitcount(1);
		articleDTO.setLevelNum(0);
		articleDTO.setOrderNum(0);
		articleDTO.setPasswd("1111");

		articleService.create(articleDTO);

		log.info("게시글 등록 정보 : {}", articleDTO.toString());
		return "redirect:/article/list";
	}

	// 게시글 댓글 등록
	@GetMapping("/reply")
	public String replyForm(HttpSession session,Model model, @RequestParam int articleId) {
		log.info("댓글 등록 페이지 실행됨");
		ArticleDTO getSessionArticle = (ArticleDTO) session.getAttribute("article");
		getSessionArticle.setSubject("");
		getSessionArticle.setContent("");
		getSessionArticle.setWriter("");

		model.addAttribute("article", getSessionArticle);
		model.addAttribute("boolean", "reply");
		return "articles/register";
	}

	@PostMapping("/reply")
	public String reply(HttpSession session,@RequestParam String writer , @RequestParam String subject, @RequestParam String content,
			RedirectAttributes redirectAttributes) {
		log.info("게시글 등록 DB 작업 실행됨");

		ArticleDTO getSessionArticle = (ArticleDTO) session.getAttribute("article");
		getSessionArticle.setSubject(subject);
		getSessionArticle.setContent(content);
		getSessionArticle.setGroupNum(getSessionArticle.getArticleId());
		getSessionArticle.setWriter(writer);
		log.info("게시글 등록 정보 : {}", getSessionArticle);

		articleService.createArticle(getSessionArticle);
		redirectAttributes.addFlashAttribute(getSessionArticle);

		return "redirect:/article/list";
	}

//	게시글  상세보기 경로설정

	@GetMapping("/read")
	public String read(HttpSession session, @ModelAttribute ArticleDTO articleDTO, @RequestParam int articleId,
			Model model) {
		log.info("상세보기 페이지 실행됨");

//		수신받은 게시글 번호로 클릭한 게시판의 객체를 리턴받음
		articleDTO = articleMapper.searchArticle(articleId);
		log.info("상세보기 페이지로 수신받은 객체 {} : " ,articleDTO);
//		model에 article이라는 이름으로 전달받은 객체저장
		session.setAttribute("article", articleDTO);
		ArticleDTO getArticle = (ArticleDTO) session.getAttribute("article");
		model.addAttribute("readArticle" , getArticle);
		
		log.info("getArticle 테스트 {} : " ,getArticle);
		return "articles/read";
	}

//	게시글  상세보기 경로설정

	@PostMapping("/read/update")
	public String readUpdate(@ModelAttribute ArticleDTO articleDTO, Model model) {
		log.info("게시글 수정 페이지 실행됨");
		articleDTO = articleMapper.updateArticle(articleDTO);
		return "articles/read";
	}

}

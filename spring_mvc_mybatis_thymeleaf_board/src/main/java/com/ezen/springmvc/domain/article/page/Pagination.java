package com.ezen.springmvc.domain.article.page;

/**
 * 페이징 처리 계산
 * @author 김기정
 */
public class Pagination {
	
	// 페이징 계산에 필요한 필드
	private PageParams params;        /** 여러개의 파라메터 포장 */
//	private int totalElements;        /** 테이블로부터 조회된 행의 수 */
	
	// 계산 결과 저장을 위한 필드
	private int totalPages;           /** 전체 페이지 수 */
	private int listNo;               /** 목록별 식별번호 */
	private int startPage;            /** 현재 페이지가 소속된 목록의 시작 번호 */
	private int endPage;              /** 현재 페이지가 소속된 목록의 마지막 번호 */
	private int previousStartPage;    /** 이전 페이지가 소속된 목록의 시작 번호 */
	private int nextStartPage;        /** 다음 페이지가 소속된 목록의 마지막 번호 */
	
	public Pagination(PageParams params) {
		this.params = params;
		compute();
	}
	
	public PageParams getParams() {
		return params;
	}

	public void setParams(PageParams params) {
		this.params = params;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getListNo() {
		return listNo;
	}

	public void setListNo(int listNo) {
		this.listNo = listNo;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getPreviousStartPage() {
		return previousStartPage;
	}

	public void setPreviousStartPage(int previousStartPage) {
		this.previousStartPage = previousStartPage;
	}

	public int getNextStartPage() {
		return nextStartPage;
	}

	public void setNextStartPage(int nextStartPage) {
		this.nextStartPage = nextStartPage;
	}
	
	

	@Override
	public String toString() {
		return "Pagination [params=" + params + ", totalPages=" + totalPages + ", listNo=" + listNo + ", startPage="
				+ startPage + ", endPage=" + endPage + ", previousStartPage=" + previousStartPage + ", nextStartPage="
				+ nextStartPage + "]";
	}

	/** 페이징 계산 */
	public void compute(){
		// 테이블로부터 검색된 행의 수에 따른 전체페이지수 계산
		totalPages = (int)Math.ceil((double)params.getRowCount() / params.getElementSize());
		
		// 목록별 번호(1~10):0, (11~20):1, (21~30):2, .....
		listNo = (params.getRequestPage() - 1) / params.getPageSize();
			
		// 현재 페이지의 시작페이지번호와 마지막페이지번호 계산
		startPage = (listNo * params.getPageSize()) + 1;
		endPage = (listNo * params.getPageSize()) + params.getPageSize();
		if (endPage > totalPages){
			endPage = totalPages;
		}
		
		// 이전 그룹의 시작페이지 번호 계산
		previousStartPage = startPage - params.getPageSize();
		// 첫번째 목록인 경우 1페이지로 설정
		if (previousStartPage < 0)  previousStartPage = 1;
		
		// 다음 목록의 시작페이지 번호 계산
		nextStartPage = startPage + params.getPageSize();
	}
	
	/** 현재 목록에서 [처음으로] 출력 여부 반환 */
	public boolean isShowFirst() {
		return listNo > 0;
	}
	
	/** 현재 목록에서 [끝으로] 출력 여부 반환 */
	public boolean isShowLast() {
		return endPage < totalPages;
	}
	
	/** 현재 목록에서 [이전목록] 출력 여부 반환 */
	public boolean isShowPrevious() {
		return listNo > 0;
	}
	
	/** 현재 목록에서 [다음목록] 출력 여부 반환 */
	public boolean isShowNext() {
		return endPage < totalPages;
	}
	
}

package kr.kh.spring.pagination;

import lombok.Data;

@Data
public class PageMaker {
	private int totalCount; //��ü ������ ���� => ������ ���������̼��� ������ �������� ����ϱ� ����
	private int startPage;//���������̼� ���� ��������ȣ
	private int endPage;//���������̼� ������ ��������ȣ
	private boolean prev;//������ư Ȱ��ȭ
	private boolean next;//������ư Ȱ��ȭ
	private int displayPageNum;//�� ���������̼ǿ��� ������ �������� �ִ� ���� ����
	private Criteria cri;
	
	//totalCount, diplayPageNum, perPageNum(cri)�� �̿��Ͽ� 
	//endPage, startPage, prev, next�� ����ϴ� �޼���
	//���� : ��ü �Խñ��� : 131��, ���������� �Խñ��� 10, 14������
	public void calculate() {
		//���� �������� ���� �ִ� ��������ȣ
		//���� ������ : 4, ���������� ������ ������ 10, �� ���������̼��� ������ ���� : 10
		//endPage = (int)(Math.ceilt(0.4) * 10);
		endPage = (int)(Math.ceil(cri.getPage()/(double)displayPageNum)*displayPageNum);
		
		startPage = endPage - displayPageNum + 1;
		//������ ������ �̿��Ͽ� ����� �ִ� ������ ��ȣ : 14
		int tmpEndPage = (int)(Math.ceil(totalCount/(double)cri.getPerPageNum()));
		//endPage�� tmpEndPage �� ���� ���� endPage�� ����
		if(endPage > tmpEndPage) {
			endPage = tmpEndPage;
		}
		//ù��° ���������̼��̸� false �ƴϸ� true
		prev = startPage == 1 ? false : true;
		//������ ���������̼��̸� false �ƴϸ� true
		next = endPage == tmpEndPage ? false : true;
	}
	public PageMaker(int displayPageNum, Criteria cri, int totalCount) {
		this.displayPageNum = displayPageNum;
		this.cri = cri;
		this.totalCount = totalCount;
		calculate();
	}
}
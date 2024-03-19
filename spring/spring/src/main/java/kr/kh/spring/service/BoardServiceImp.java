package kr.kh.spring.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.kh.spring.dao.BoardDAO;
import kr.kh.spring.model.vo.BoardVO;
import kr.kh.spring.model.vo.CommunityVO;
import kr.kh.spring.model.vo.FileVO;
import kr.kh.spring.model.vo.MemberVO;
import kr.kh.spring.model.vo.RecommendVO;
import kr.kh.spring.pagination.Criteria;
import kr.kh.spring.utils.UploadFileUtils;

@Service
public class BoardServiceImp implements BoardService {

	@Autowired
	private BoardDAO boardDao;

	@Resource
	private String uploadPath;
	
	private boolean checkString(String str) {
		return str != null && str.length() != 0;
	}
	
	private void uploadFile(int bo_num, MultipartFile file) {
		
		try {
			String originalFileName = file.getOriginalFilename();
			//���ϸ��� ������
			if(originalFileName.length() == 0) {
				return;
			}
			//������ ���ε� �� ���ε��� ���ϸ��� ������
			String fileName = 
				UploadFileUtils.uploadFile(uploadPath, originalFileName,file.getBytes());
			//FileVO ��ü�� ����
			FileVO fileVo = new FileVO(bo_num, fileName, originalFileName);
			//DB�� �߰�
			boardDao.insertFile(fileVo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void deleteFile(FileVO file) {
		if(file == null) {
			return;
		}
		//�������� ����
		UploadFileUtils.delteFile(uploadPath, file.getFi_name());
		//DB���� ����
		boardDao.deleteFile(file.getFi_num());
	}
	
	@Override
	public ArrayList<BoardVO> getBoardList(Criteria cri) {
		if(cri == null) {
			cri = new Criteria(1,5);
		}
		return boardDao.selectBoardList(cri);
	}

	@Override
	public int getBoardTotalCount(Criteria cri) {
		if(cri == null) {
			cri = new Criteria(1,5);
		}
		return boardDao.selectBoardTotalCount(cri);
	}

	@Override
	public ArrayList<CommunityVO> getCommunityList() {
		return boardDao.selectCommunityList();
	}

	@Override
	public boolean insertBoard(BoardVO board, MemberVO user, MultipartFile[] files) {
		if(user == null || board == null) {
			return false;
		}
		if( !checkString(board.getBo_title()) || 
			!checkString(board.getBo_content())) {
			return false;
		}
		board.setBo_me_id(user.getMe_id());
		boolean res = boardDao.insertBoard(board);
		//�Խñ� ��� ���� => ÷������ �ø� �ʿ� ����
		if(!res) {
			return false;
		}
		//÷������ ���ε� �۾�
		//÷������ ���� ���
		if(files == null || files.length == 0) {
			return true;
		}
		for(MultipartFile file : files) {
			//÷�������� ������ ���ε��ϰ�, DB�� �߰�
			uploadFile(board.getBo_num(), file);
		}
		
		return true;
	}

	@Override
	public BoardVO getBoard(int boNum) {
		return boardDao.selectBoard(boNum);
	}

	@Override
	public void updateView(int boNum) {
		boardDao.updateView(boNum);
	}

	@Override
	public ArrayList<FileVO> getFileList(int boNum) {
		return boardDao.selectFileList(boNum);
	}

	@Override
	public boolean deleteBoard(int num, MemberVO user) {
		if(user == null) {
			return false;
		}
		//�Խñ� ��ȣ�� �´� �Խñ��� ������
		BoardVO board = boardDao.selectBoard(num);
		//�Խñ��� ���ų� �ۼ��ڰ� �ƴϸ� false�� ����
		if( board == null || 
			!board.getBo_me_id().equals(user.getMe_id())) {
			return false;
		}
		//������ ���� �� ����� ����
		//������ ÷������ ���� �� DB���� ����
		//�Խñ� ��ȣ�� �´� ÷������ ����Ʈ�� ������
		ArrayList<FileVO> fileList = boardDao.selectFileList(num);
		//÷������ ����Ʈ�� ������ �ݺ������� ÷�������� ����
		if(fileList != null) {
			for(FileVO file : fileList) {
				deleteFile(file);
			}
		}
		//�Խñ� ����
		
		return boardDao.deleteBoard(num);
	}

	@Override
	public boolean updateBoard(BoardVO board, MemberVO user, MultipartFile[] file, int[] delNums) {
		if( board == null || 
			!checkString(board.getBo_title()) || 
			!checkString(board.getBo_content())) {
			return false;
		}
		if(user == null) {
			return false;
		}
		//�ۼ��ڰ� �´���
		BoardVO dbBoard = boardDao.selectBoard(board.getBo_num());
		if( dbBoard == null || 
			!dbBoard.getBo_me_id().equals(user.getMe_id())) {
			return false;
		}
		//�Խñ� ����
		boolean res = boardDao.updateBoard(board);
		
		if(!res) {
			return false;
		}
		//÷������ ����
		
		//�� ÷������ �߰�
		if(file != null) {
			for(MultipartFile tmp : file) {
				uploadFile(board.getBo_num(), tmp);
			}
		}
		//������ ÷������ ����
		if(delNums == null) {
			return true;
		}
		for(int tmp : delNums) {
			FileVO fileVo = boardDao.selectFile(tmp);
			deleteFile(fileVo);
		}
		return true;
	}

	@Override
	public boolean recommend(RecommendVO recommend, MemberVO user) {
		if(recommend == null) {
			return false;
		}
		if(user == null) {
			return false;
		}
		//기존 추천 정보가 있는지 확인
		recommend.setRe_me_id(user.getMe_id());
		RecommendVO dbRecommend = boardDao.selectRecommend(recommend);
		//없으면 추가
		if(dbRecommend == null) {
			boardDao.insertRecommend(recommend);
		}
		//있으면 수정
		else {
			if(recommend.getRe_state() == dbRecommend.getRe_state()) {
				recommend.setRe_state(0);
			}
			boardDao.updateRecommend(recommend);
		}
		return true;
	}

	
}
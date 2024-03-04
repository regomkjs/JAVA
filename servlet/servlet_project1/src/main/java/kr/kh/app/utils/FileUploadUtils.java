package kr.kh.app.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.http.Part;

public class FileUploadUtils {
	
	public static String getFileName(Part part) {
		String contentDisposition = part.getHeader("content-disposition");
		String [] items = contentDisposition.split(";");
		for(String item: items) {
			if(item.trim().startsWith("filename")) {
				return item.substring(item.indexOf("=") + 2,item.length() - 1);
			}
		}
		return null;
	}
	
	public static String upload(String uploadPath, Part part) {
		String fileName = getFileName(part);
		UUID uid = UUID.randomUUID();
		String filePath = calculatePath(uploadPath) + File.separator + uid + "_" + fileName;
		try(InputStream is = part.getInputStream();
			OutputStream os = new FileOutputStream(uploadPath + filePath)){
			byte [] buffer = new byte[1024*4]; //4kb씩 읽어와서 덮어쓰기
			int readCount; // 읽어온 개수
			//InputStream.read(byte[])은 읽어와서 배열에 저장 후 읽어온 개수를 반환
			// 읽어온 개수가 없으면 -1을 리턴
			while((readCount = is.read(buffer)) != -1) {
				os.write(buffer, 0, readCount);
			}
			return filePath.replace(File.separatorChar, '/');
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private static String calculatePath(String uploadPath) {
		Calendar cal = Calendar.getInstance();
		String yearPath = File.separator + cal.get(Calendar.YEAR);
		String monthPath = yearPath + File.separator 
				+ new DecimalFormat("00").format(cal.get(Calendar.MONTH)+1);
		String datePath = monthPath + File.separator 
				+ new DecimalFormat("00").format(cal.get(Calendar.DATE));
		makeDir(uploadPath, yearPath, monthPath, datePath);
		return datePath;
	}
	
	// uploadPath를 기준으로 paths들 폴더가 없으면 폴더를 생성해주는 메서드
	private static void makeDir(String uploadPath, String ...paths) {
		int lastIndex = paths.length - 1;
		//마지막 경로에 해당하는 폴더가 있으면 종료
		if(new File(uploadPath + paths[lastIndex]).exists()) {
			return;
		}
		for(String path : paths) {
			File dir = new File(uploadPath + path);
			if(!dir.exists()) {
				dir.mkdir();
			}
		}
	}
	
}

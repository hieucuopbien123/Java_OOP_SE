package FIleHandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

// FileHandling

public class UnzipFile {
	public static File newFile(File destinationDir, ZipEntry zipEntry) throws IOException {
        //tạo file ở: destinationDir/zipEntry.getName() => cái zipEntry.getName là url từ dir đổi ra
	    File destFile = new File(destinationDir, zipEntry.getName());

        //nếu lấy đường dẫn file và thư mục
	    String destDirPath = destinationDir.getCanonicalPath();
	    String destFilePath = destFile.getCanonicalPath();

        //check là cái đường dẫn file nó phải thực sự bắt đầu bằng đường dẫn dir.
        if (!destFilePath.startsWith(destDirPath + File.separator)) {
	        throw new IOException("Entry is outside of the target dir: " + zipEntry.getName());
	    }

	    return destFile;
	}
	
	public static void main(String[] args) throws IOException {
        //xác định file cần giải nén ra và ra thư mục nào
        String fileZip = "./testthu.zip";
        File destDir = new File("./UnzipDir");
        byte[] buffer = new byte[1024];

        //lấy file zip làm input và lấy từng entry của nó là từng thư mục và file theo thứ tự ta nén vào
        ZipInputStream zis = new ZipInputStream(new FileInputStream(fileZip));
        ZipEntry zipEntry = zis.getNextEntry();
        while (zipEntry != null) {
            //nếu entry tồn tại thì tạo ra file có đường dẫn như trong entry
            File newFile = newFile(destDir, zipEntry);

            //nếu là thư mục thì tạo ra 
            if (zipEntry.isDirectory()) {
                if (!newFile.isDirectory() && !newFile.mkdirs()) {
                    throw new IOException("Failed to create directory " + newFile);
                }
            } else {
                // fix for Windows-created archives => éo hiểu window bị lỗi nên nó check parent của file này
                //phải là 1 thư mục, nếu k thì phải tạo ra
                File parent = newFile.getParentFile();
                if (!parent.isDirectory() && !parent.mkdirs()) {
                    throw new IOException("Failed to create directory " + parent);
                }
                
                //nếu là file thì đọc từng byte và lưu vào buffer và check chưa hết thì write vào newFile
                FileOutputStream fos = new FileOutputStream(newFile);
                int len;
                while ((len = zis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }
                fos.close();
            }
            zipEntry = zis.getNextEntry();
        }
        zis.closeEntry();
        zis.close();
    }
}
package FIleHandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

// FileHandling

public class ZipDirectory {
	public static void main(String[] args) throws IOException {
        String sourceFile = "./FileHandling";
        FileOutputStream fos = new FileOutputStream("./dirCompressed.zip");
        ZipOutputStream zipOut = new ZipOutputStream(fos);
        File fileToZip = new File(sourceFile);

        zipFile(fileToZip, fileToZip.getName(), zipOut);
        zipOut.close();
        fos.close();
    }

    private static void zipFile(File fileToZip, String fileName, ZipOutputStream zipOut) throws IOException {
        if (fileToZip.isHidden()) {
            return;
        }
        if (fileToZip.isDirectory()) {
            if (fileName.endsWith("/")) {
                //vì mỗi thư mục or file đều phải là 1 entry, như này mới giữ nguyên phân cấp thư mục
                zipOut.putNextEntry(new ZipEntry(fileName));
                zipOut.closeEntry();//khi dùng xong 1 entry thì phải đóng nếu cần dùng tiếp entry tiếp theo
            } else {//nếu k kết thúc bằng / thì tự thêm vào
                zipOut.putNextEntry(new ZipEntry(fileName + "/"));//thư mục truyền vào zipEntry phải có /
                zipOut.closeEntry();
            }
            //lấy các file và directory bên trong nó và tiếp tục đệ quy
            File[] children = fileToZip.listFiles();
            for (File childFile : children) {
                zipFile(childFile, fileName + "/" + childFile.getName(), zipOut);
            }
            return;
        }
        FileInputStream fis = new FileInputStream(fileToZip);
        ZipEntry zipEntry = new ZipEntry(fileName);
        zipOut.putNextEntry(zipEntry);
        byte[] bytes = new byte[1024];
        int length;
        while ((length = fis.read(bytes)) >= 0) {
            zipOut.write(bytes, 0, length);
        }
        fis.close();
    }
}
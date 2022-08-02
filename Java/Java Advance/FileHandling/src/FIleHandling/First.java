package FIleHandling;

import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import java.io.*;

public class First {
    // FileHandling
    
    public static void copyAll(File f1, File f2) {
		try {
			// Copy ban than no
			Files.copy(f1.toPath(), f2.toPath(), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(f1.isDirectory()){
			// Copy cac tap tin va thu muc con
			File[] mangCon = f1.listFiles();
			for (File file : mangCon) {
				File file_new = new File(f2.getAbsoluteFile()+"/"+file.getName());
				copyAll(file, file_new);
			}
		}
        //copy xong gọi đệ quy các file bên trong. Thư muc thì đệ quy, file thì copy là xong
	}
    public static void main(String[] args) {
        //nch là đọc ghi file thì có vô số cách
        //VD đọc file bằng StringBuffer và Stream
		Path path = Paths.get("./testest.txt");
		StringBuilder sb = new StringBuilder();
		try (Stream<String> stream = Files.lines(path)) {
			stream.forEach(s -> sb.append(s).append("\n"));
		} catch (IOException ex) {
			// Handle exception
		}
		String contents = sb.toString();
		System.out.println(contents);

        //VD đọc file với operator + của String như này sẽ tốn heap có thể tràn nếu file quá lớn
        String data = "";
		try (BufferedReader br = new BufferedReader(new FileReader("./testest.txt"))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		        data += line;
		        data += "\n";
		    }
		}
		System.out.println(data);

        //đọc file vào string code gọn nhất
        Path filePath = Path.of("./testest.txt");
		String content = Files.readString(filePath);
		System.out.println(content);

        //mở và ghi
        FileOutputStream fos = null;
        File file = new File("./file.txt");
        String mycontent = "This is my Data which needs to be written into the file";
        try {
            file = new File("./file.txt");
            fos = new FileOutputStream(file);
            if (!file.exists()) {
                //file đc tạo ra bởi createnewFile thì return true, ngược lại file có sẵn sẽ trả ra false
                boolean fvar = file.createNewFile();
                if (fvar)
                    System.out.println("File has been created successfully");
                else{
                    System.out.println("File already present at the specified location");
                    return;
                }
            }
            //phải convert sang byte để gọi write của FileOutputStream
            byte[] bytesArray = mycontent.getBytes();
            fos.write(bytesArray);//xóa mọi thứ và ghi lại từ đầu
            fos.flush();
            System.out.println("File Written Successfully");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if(fos != null) 
                    fos.close();
            } catch (IOException ioe) {
                System.out.println("Error in closing the Stream");//cái éo gì với file cũng check
            }
        }
        //createNewFile trả ra IOException nếu có lỗi input/output trong quá trình tạo file
        //trả SecurityException nếu 1 trình bảo mật nào đó tồn tại và method SecurityManager.checkWrite(java.lang.String)
        //của nó từ chối quyền truy cập ghi vào file của chương trình này

        //ghi thêm
        try{
            String content = "This is my content which would be appended at the end of the specified file";
            FileWriter fw = new FileWriter(file, true);//tham số 2 là boolean append true thì append
            BufferedWriter bw = new BufferedWriter(fw);//dùng thêm BufferedWriter để ghi file tốc độ nhanh hơn
            bw.write(content);
            bw.close();//Closing BufferedWriter Stream
            System.out.println("Data successfully appended at the end of file");
        }catch(IOException ioe){
            System.out.println("Exception occurred:");
            ioe.printStackTrace();
        }

        //cách tốt nhất để ghi thêm
        try{
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);//mọi thứ ghi vào PrintWriter sẽ ghi vào file
            pw.println("");//ghi 1 lần xuống dòng vào PrintWriter
            pw.println("This is first line");//ghi thêm 3 dòng
            pw.println("This is the second line");
            pw.println("This is third line");
            pw.close(); 
            System.out.println("Data successfully appended at the end of file");
        }catch(IOException ioe){
            System.out.println("Exception occurred:");
            ioe.printStackTrace();
        }

        //đọc file chuẩn với BufferedInputStream
        BufferedInputStream bis = null;
        FileInputStream fis = null;
        try
        {
            fis = new FileInputStream(file);//FileInputStream to read the file

            //truyền FileInputStream vào BufferedInputStream để đọc nhanh bằng buffer array
            bis = new BufferedInputStream(fis);
            
            //available trả ra 0 nếu k còn byte nào trong file để đọc tiếp
            while( bis.available() > 0 ){             	
                System.out.print((char)bis.read());
            }
        }catch(FileNotFoundException fnfe){
            System.out.println("The specified file not found " + fnfe);
        }
        catch(IOException ioe){
            System.out.println("I/O Exception: " + ioe); 
        }finally{
            try{
                if(bis != null && fis!=null){
                    fis.close();
                    bis.close();
                }      
            }catch(IOException ioe){
                System.out.println("Error in InputStream close(): " + ioe);
            }
        }

        //xóa
        try{
            //xóa thành công return true, thất bại return false
            if(file.delete()){
                System.out.println(file.getName() + " is deleted!");
            }else{
                System.out.println("Delete failed: File didn't delete");
            }
        }catch(Exception e){
            System.out.println("Exception occurred");
            e.printStackTrace();
        }

        File f0 = new File("./test.txt");//tạo file này để nó thực hiện đổi, nếu k sẽ lỗi đường dẫn k tồn tại
        File f1 = new File("./testRename.txt");
        File f2 = new File("./testest.txt");
        System.out.println(f0.renameTo(f1));
        //dùng move để đổi tên từ testRename sang testest. Thực chất hàm move là đổi vị trí file nhưng ta làm 
        //kiểu cùng thư mục thì nó thành đổi tên thôi
        try {
            Files.move(f1.toPath(), f2.toPath(), StandardCopyOption.REPLACE_EXISTING);//cái cuối là enum
        }catch(IOException e) {
            e.printStackTrace();//tránh đường dẫn file k tồn tại
        }
        //Tương tự lệnh copy với syntax giống hệt move nhưng sẽ chỉ copy cái vỏ, muốn copy tất
        //cả ta phải tự viết hàm VD hàm copyAll bên trên

        //lưu object ra file. Có thể dùng bất cứ object nào
        try{
            File f4 = new File("./objectSave.data");
            OutputStream os = new FileOutputStream(f4);
            ObjectOutputStream oos = new ObjectOutputStream(os);

            String st = new String("Long String");
            oos.writeObject(st);
            oos.flush();
            oos.close();
        }catch(Exception e){ }

        try {
            File f4 = new File("./objectSave.data");
            InputStream is = new FileInputStream(f4);
            ObjectInputStream ois = new ObjectInputStream(is);
            String st = null;
            while(true) {
                st = (String) ois.readObject();
                if(st != null) {
                    System.out.println(st);
                }else break;
            }
            ois.close();
        }catch(Exception e){
            e.printStackTrace();
        }

        //nén file
        String source = "./testThu.txt";
        try {
            FileOutputStream fileOS = new FileOutputStream("testThu.zip");
            ZipOutputStream zipOut = new ZipOutputStream(fileOS);
            File fileToZip = new File(source);
            FileInputStream fileIS = new FileInputStream(fileToZip);
            //file cần nén cho vào inputstream, file cần xuất cho ra outputstream

            //Trong Zip out put có nhiều tập tin con gọi là zipentry, ta sẽ cho file này như 1 zipentry
            ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
            zipOut.putNextEntry(zipEntry);

            //đọc từng bytes và viết vào zip output stream
            byte[] bytes = new byte[1024];
            int length;
            while((length = fileIS.read(bytes)) >= 0){
                zipOut.write(bytes, 0, length);
            }
            zipOut.close();
            fileIS.close();
            fileOS.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //muốn nén nhiều file => cho vào mảng duyệt từng file 1 và tạo ra input stream cũng như zipentry từng file
    }
}

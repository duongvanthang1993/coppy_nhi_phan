import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Filecopy {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("nhap duong dan tep nguon (source file): ");
        String sourcePath = scanner.nextLine();

        System.out.println("nhap duong dan tep dich (targe file): ");
        String targetPath = scanner.nextLine();

        File sourceFile = new File(sourcePath);
        File targetFile = new File(targetPath);

        if (!sourceFile.exists()) {
            System.out.println("loi: tep nguon khong ton tai!");
            scanner.close();
            return;
        }
        if (!sourceFile.isFile()) {
            System.out.println("loi:  duong dan nguon phai la mot tep(khong phai thu muc)");
            scanner.close();
            return;

        }
        if (targetFile.exists()) {
            System.out.print("canh bao: tep dich da ton tai, ban co muon ghi khong? (Y/N)");
            String choice = scanner.nextLine();
            if (!choice.equalsFoldCase("Y")) {
                System.out.println("huy thao tac sao chep");
                scanner.close();
                return;
            }
        }
        long byteCount = 0;
        try (FileInputStream fis = new FileInputStream(sourceFile);
                FileOutputStream fos = new FileOutputStream(targetFile)) {
            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
                byteCount += bytesRead;
            }
            System.out.println("sao chep thanh cong! ");
            System.out.println("tong so byte trong tep: " + byteCount + "bytes");
        } catch (IOException e) {
            System.out.println("da xay ra loi trong qua tring sao chep" + e.getMessage());
        } finally {
            scanner.close();
        }

    }
}
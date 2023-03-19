package exception;

import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

class FileManagerTest {

    /**
     * ファイルロック時にIOExceptionがthrowされること
     */
    @Test
    public void ファイルがロックされている時にIOException() {

        String filePath = ".//test//resources//test.txt";
        File file = new File(filePath);
        try(RandomAccessFile fos = new RandomAccessFile(file,"rw")){

            // 例外をスローさせるため、ファイルをロックする
            FileChannel channel = fos.getChannel();
            FileLock tryLock = channel.lock();

            FileManager manager = new FileManager();
            assertThrows(IOException.class,() -> manager.readFile(filePath));

            // ロックをリリース
            tryLock.release();

        }catch(IOException ex) {
            ex.printStackTrace();

            // 失敗
            fail();
        }
    }

    /**
     * 読み込み内容が正しいこと
     */
    @Test
    public void ファイルを2行読み込み() {

        try {
            String filePath = ".//test//resources//test.txt";

            FileManager fileManager = new FileManager();
            List<String> fileDataList = fileManager.readFile(filePath);
            assertEquals(2, fileDataList.size());
            assertEquals("テスト1", fileDataList.get(0));
            assertEquals("テスト2", fileDataList.get(1));

        } catch (IOException ex) {
            ex.printStackTrace();

            // 失敗
            fail();
        }
    }
}
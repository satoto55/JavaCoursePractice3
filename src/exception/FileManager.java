package exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * 第3回課題 例外処理の実装
 *
 * @author sato
 * @version 1.0.0
 */
public class FileManager {
    /**
     * ファイルを読みこみ、Listに格納して返します。
     *
     * @return fileContentList
     * @throws IOException
     */
    public List<String> readFile(String filePathText) throws IOException {

        Path filePath = Path.of(filePathText);

        List<String> fileContentList = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)) {

            // 読み込み行
            String line;

            // ファイル読み込み
            while ((line = br.readLine()) != null) {
                fileContentList.add(line);
            }
            return fileContentList;
        } catch (IOException e) {

            throw new IOException("ファイルの処理中に例外が発生しました", e);
        }
    }
}

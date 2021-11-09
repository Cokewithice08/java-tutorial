package io.github.jast90.fs;



import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class FileSystems {

    private static StorageClient storageClient;

    private static TrackerServer trackerServer;

    static{
        try {
            ClientGlobal.initByProperties("fastdfs-client.properties");
            TrackerClient trackerClient = new TrackerClient();
            trackerServer = trackerClient.getTrackerServer();
            storageClient = new StorageClient(trackerServer,null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    public static String[] upload(InputStream inputStream, String fileName, String fileExtName) throws IOException, MyException {
        NameValuePair[] metaList = new NameValuePair[1];
        metaList[0] = new NameValuePair("fileName",fileName);
        int length = inputStream.available();
        byte[] bytes = new byte[length];
        inputStream.read(bytes);
        String[] result = storageClient.upload_file(bytes, fileExtName, metaList);
        return  result;
    }

    public static void download(Path path,String[] uploadResult) throws MyException, IOException {
        byte[] result = storageClient.download_file(uploadResult[0], uploadResult[1]);
        Files.write(path,result);
    }

    public static void main(String[] args) throws IOException, MyException {
        String fileName = "download.sql";
        String fileExtName = "sql";
        File file = Paths.get("C:", "Users/Administrator/Downloads", fileName).toFile();
        FileInputStream fileInputStream = new FileInputStream(file);
        String[] uploadResult = FileSystems.upload(fileInputStream, fileName,fileExtName);
        System.out.println(Arrays.asList(uploadResult));

        Path downloadFile = Paths.get("D:", "Downloads", fileName);
        FileSystems.download(downloadFile,uploadResult);

    }
}

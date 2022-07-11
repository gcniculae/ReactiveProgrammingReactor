package reactiveprogramming.assignment1;

import reactor.core.publisher.Mono;

import java.io.*;

public class FileService {

    private static final String PATH = "src/main/resources/assignment1";

    public Mono<Runnable> readFileContent() {
        return Mono.fromRunnable(this::readFromFile);
    }

    public Mono<Runnable> writeFileContent() {
        return Mono.fromRunnable(() -> {
            String inputData = "Test1 \n" +
                    "Test2 \n" +
                    "Test3";

            writeInFile(inputData, 2);
        });
    }

    public Mono<Runnable> deleteFileCreated() {
        return Mono.fromRunnable(this::deleteFile);
    }

    private void readFromFile() {
        FileReader fileReader = getFileReader();

        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String element;
        try {
            while ((element = bufferedReader.readLine()) != null) {
                System.out.println(element);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeInFile(String inputData, int numberOfLines) {
        File file = createFile("write-file");

        FileWriter fileWriter = getFileWriter(file);

        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        String dataToWrite = inputData + System.getProperty("line.separator");

        try {
            for (int index = numberOfLines - 1; index >= 0; index--) {
                bufferedWriter.write(dataToWrite);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                bufferedWriter.close();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void deleteFile() {
        File file = createFile("delete-file");

        file.delete();
    }

    private FileReader getFileReader() {
        File file = new File(PATH + "/read-file.txt");

        FileReader fileReader;
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return fileReader;
    }

    private FileWriter getFileWriter(File file) {
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fileWriter;
    }

    private File createFile(String fileName) {
        File file = new File(PATH + fileName + ".txt");

        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return file;
    }
}

package File;

import Model.PhoneBook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManagement {
    public List<PhoneBook> readCSV(String pathname) {
        List<PhoneBook> list = new ArrayList<>();
        PhoneBook product;
        String[] strProduct;
        try {
            FileReader fileReader = new FileReader(pathname);
            BufferedReader bufferedReader = new BufferedReader((fileReader));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                strProduct = line.split(",");
                product = new PhoneBook(strProduct[0], strProduct[1], strProduct[2], strProduct[3], strProduct[4], strProduct[5], strProduct[6]);
                list.add(product);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void writeCSV(String pathname,String strProduct) throws IOException {
;
        FileWriter fileWriter = new FileWriter(pathname);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(strProduct + "\n");
        bufferedWriter.close();
        fileWriter.close();
    }
}

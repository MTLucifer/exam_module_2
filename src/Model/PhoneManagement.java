package Model;

import Model.PhoneBook;
import File.FileManagement;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PhoneManagement {
    FileManagement fileManagement = new FileManagement();
    List<PhoneBook> list = new ArrayList<>();

    public void add(String pathname,String contact)  {
        try {
            fileManagement.writeCSV(pathname, contact);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isPhoneExisted(String pathname, String phoneNumber) {
        list = fileManagement.readCSV(pathname);
        boolean result = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPhoneNumber().equals(phoneNumber)) {
                result = true;
            }
        }
        return result;
    }

    public void delete(String pathname, String phoneNumber) {
        if (isPhoneExisted(pathname, phoneNumber)) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getPhoneNumber().equals(phoneNumber)) {
                    list.remove(i);
                }
            }
        }
    }

    public PhoneBook findBYPhone(String pathname, String phoneNumber) {
        PhoneBook contact =null;
        if (isPhoneExisted(pathname, phoneNumber)) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getPhoneNumber().equals(phoneNumber)) {
                    contact = list.get(i);
                }
            }
        }
        return contact;
    }

//    public void update(String pathname, String phoneNumber, String update) throws IOException {
//        if (isPhoneExisted(pathname, phoneNumber)) {
//            delete(pathname, phoneNumber);
//            add(pathname,update);
//        }
//    }
}

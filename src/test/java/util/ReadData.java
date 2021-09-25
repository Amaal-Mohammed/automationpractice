package util;

import java.io.IOException;
import java.util.ArrayList;

public class ReadData {

    public static String Customerfirstname;
    public static String Customerlastname;
    public static String Password;
    public static String FirstName;
    public static String LastName;
    public static String Company;
    public static String Address;
    public static String City;
    public static String State;
    public static String Postal;
    public static String Phone;
    public static String Mobile;
    public static String AddressAlias;
    public static String BadEmail;

    public static void setData(String filepath) throws IOException {
        String path = filepath + "\\" + Constants.filename;
        ArrayList<String> data = ExcelRead.readFromExcel(path, Constants.Sheet);
        Customerfirstname = data.get(0);
        Customerlastname = data.get(1);
        Password = data.get(2);
        FirstName = data.get(3);
        LastName = data.get(4);
        Company = data.get(5);
        Address = data.get(6);
        City = data.get(7);
        State = data.get(8);
        Postal = data.get(9);
        Phone = data.get(10);
        Mobile = data.get(11);
        AddressAlias = data.get(12);
        BadEmail = data.get(13);


    }

}

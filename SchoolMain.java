package SqliteDB332JAR;
import javax.xml.transform.Result;
import java.sql.*;
import java.sql.Connection;
import java.util.ResourceBundle;
import java.util.Scanner;

public class SchoolMain {
    public static void main(String[] args) {
        int Id, TC, Math, Physics, Database, Mobile, Average, Gender;
        String Name;

        String url = "jdbc:sqlite:C:\\Users\\akyz6\\OneDrive\\Masaüstü\\DOSYALAR\\Kodlamalar\\JavaGUI\\kaldiGectiDB\\src\\SqliteDB332JAR\\eokul.db";
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url);
            System.out.print("Sisteme bağlanıldı.");

            Scanner scanner = new Scanner(System.in);
            System.out.print("<---------SİSTEME HOŞGELDİNİZ--------->\n1-Kayıt ol\n2-Giriş yap\n3-Sınıf listesi\nLütfen seçim yapınız:");
            int selection = scanner.nextInt();
            if(selection == 1){
                System.out.print("TC Kimlik numaranız:");
                TC = scanner.nextInt();
                System.out.print("İsim:");
                Name = scanner.next();
                System.out.print("Matematik notunuz:");
                Math = scanner.nextInt();
                System.out.print("Fizik notunuz:");
                Physics = scanner.nextInt();
                System.out.print("Veritabanı notunuz:");
                Database = scanner.nextInt();
                System.out.print("Mobil Uygulama notunuz:");
                Mobile = scanner.nextInt();
                System.out.print("Cisiyet(0-K - 1-E):");
                Gender = scanner.nextInt();
                Average = (Math+Physics+Database+Mobile)/4;
                String insert = "insert into Student(TC_No, Name, Math, Physics, Database, Mobile, Average, Gender) values('"+ TC +"','"+ Name +"','"+ Math +"','"+ Physics +"','"+ Database +"','"+ Mobile +"', '"+Average+"','"+Gender+"')";
                Statement statementInsert = connection.createStatement();
                statementInsert.executeUpdate(insert);
                System.out.print("Notlar kayıt edildi.\n \n");
                String select = "select * from Student where TC_No='"+TC+"'";
                Statement statementSelect = connection.createStatement();
                ResultSet resultSet = statementSelect.executeQuery(select);
                while (resultSet.next())
                {
                    String cinsiyet = "";
                    if(resultSet.getInt("Gender")==1){
                        cinsiyet = "Erkek";
                    }
                    else{
                        cinsiyet = "Kadın";
                    }
                    System.out.println("TC Kimlik Numarası:"+resultSet.getInt("TC_no")+"\nİsim:"+resultSet.getString("Name")+"\nMatematik Notu:"+resultSet.getString("Math")+"\nFizik Notu:"+resultSet.getString("Physics")+"\nVeritabanı Notu:"+resultSet.getString("Database")+"\nMobil Uygulama Notu:"+resultSet.getString("Mobile")+"\nOrtalama:"+Average+"\nCinsiyeti:"+cinsiyet);
                }

            }
            if(selection == 2){
                System.out.print("TC Kimlik Numaranızı giriniz:");
                TC = scanner.nextInt();
                String select = "select * from Student where TC_No='"+TC+"'";
                Statement statementSelect = connection.createStatement();
                ResultSet resultSet = statementSelect.executeQuery(select);
                while (resultSet.next())
                {
                    String cinsiyet = "";
                    if(resultSet.getInt("Gender")==1){
                        cinsiyet = "Erkek";
                    }
                    else{
                        cinsiyet = "Kadın";
                    }
                    System.out.println("TC Kimlik Numarası:"+resultSet.getInt("TC_no")+"\nİsim:"+resultSet.getString("Name")+"\nMatematik Notu:"+resultSet.getInt("Math")+"\nFizik Notu:"+resultSet.getInt("Physics")+"\nVeritabanı Notu:"+resultSet.getInt("Database")+"\nMobil Uygulama Notu:"+resultSet.getInt("Mobile")+"\nOrtalama:"+resultSet.getInt("Average")+"\nCinsiyeti:"+cinsiyet);
                }
            }
            if(selection == 3){
                String sql = "select Student.Name, Class.Class_Name from Student_List inner join Student on Student.Id==Student_List.Student_Id inner join Class on Student_List.Class_Id==Class.Id";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next())
                {
                    System.out.println(resultSet.getString(1)+" - "+resultSet.getString(2));
                }
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

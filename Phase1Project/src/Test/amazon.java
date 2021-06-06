package Test;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import com.mysql.cj.jdbc.CallableStatement;

public class amazon {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.in/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "root");

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Amazon");

			while (rs.next()) {

				System.out.println(rs.getString(2) + "  " + rs.getString(3));
				
				String Category = rs.getString(2);
				
				String SearchVal = rs.getString(3);

			}

			// stmt.executeUpdate("insert into eproduct (name, price, date_added) values
			// ('HardDrive', 2000.00, now())");
			// stmt.executeUpdate("insert into eproduct (name, price, date_added) values
			// ('Laptop', 2000.00, now())");
			// stmt.executeUpdate("update eproduct set price=20000 where name = 'Laptop'");
			// stmt.executeUpdate("delete from eproduct where name = 'HardDrive'");

			// stmt.executeUpdate("drop database db2");

//			CallableStatement stmt1 = (CallableStatement) con.prepareCall("{call add_product(?, ?)}");
//			stmt1.setString(1, "IPhone");
//
//			BigDecimal obj = new BigDecimal(1900.50);
//
//			stmt1.setBigDecimal(2, obj);
//			stmt1.executeUpdate();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Class not found");
		} catch (SQLException e) {
			System.out.println("SQL Exception");
		}
	}


	}

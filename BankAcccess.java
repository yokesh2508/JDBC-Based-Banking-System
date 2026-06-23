package Repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import com.demo.BankDetails.*;
import java.util.Scanner;

public class BankAcccess {
		  private String url="jdbc:postgresql://localhost:5432/Bank_server";
          private String user="postgres";
          private String password="root";
          private Connection connection; 
          {
          try {
			Class.forName("org.postgresql.Driver");
			connection =DriverManager.getConnection(url,user,password);
			//System.out.println("Connected");
		  } catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  }
          }
          //Add bank details in database
          public int addAccount(BankDetails b)throws SQLException {
        	  String sql="insert into account_info values(?,?,?,nextval('acc_id'),?,?,?)";
        	  PreparedStatement ps=connection.prepareStatement(sql);
        	  ps.setString(1,b.getName());
        	  ps.setString(2,b.getAcc_type());
        	  ps.setDouble(3,b.getBalance());
        	  ps.setString(4,b.getPhone());
        	  Timestamp ts = Timestamp.valueOf(LocalDateTime.now());
        	  ps.setTimestamp(5,ts);
        	  ps.setTimestamp(6,ts);
        	 int rows= ps.executeUpdate();
        	 //System.out.print(rows);
        	 return 1;  
          }
          
          //Read all bank details of user in database
          public BankDetails readAccount(Long acc_id) throws SQLException {
        	  String sql="select * from account_info where acc_id=?";
        	  PreparedStatement ps=connection.prepareStatement(sql);
        	  ps.setLong(1, acc_id);
        	  ResultSet rs=ps.executeQuery();
        	 // System.out.print(rs);
        	  if(rs!=null && rs.next()) {
        		  BankDetails b=new BankDetails(rs.getString(1),
        				  rs.getString(2),
        				  rs.getDouble(3),
        				  rs.getLong(4),
        				  rs.getString(5),
        				  rs.getTimestamp(6),
        				  rs.getTimestamp(7)
        				  );
        		          return b;
        		  }
        	      return null;
        	  }
          
           //Delete all bank details of the user in database
          public boolean deleteAccount(Long acc_id) throws SQLException {
        	      String sql="delete from account_info where acc_id=?";
                  PreparedStatement ps=connection.prepareStatement(sql);
                  ps.setLong(1, acc_id);
                  int i=ps.executeUpdate();
                  if(i==1) {
                	  return true;
                  }
                  else {
                	  return false;
                  }
           }
          
          //Update the credentials
          public boolean update(BankDetails b) throws SQLException {
        	  String sql="update account_info set acc_type=?,phone=?";
        	  PreparedStatement ps=connection.prepareStatement(sql);
        	  ps.setString(1,b.getAcc_type());
        	  ps.setString(2,b.getPhone());
        	  int i=ps.executeUpdate();
        	  if(i==1) {
        		  return true;
        	  }
        	  else {
        		  return false;
        	  }
          }
         
          
          public static void main(String[] args) throws SQLException {
        	  BankAcccess ba = new BankAcccess();
        	  Scanner sc=new Scanner(System.in);
        	  boolean flag=true;
        	  while(flag) {
        		 System.out.println("\t\t\t\t\t<---JDBC-Based Banking System--->");
        		 System.out.println("Type 1 for Add_New_Account");
        		 System.out.println("Type 2 for Bank_Statement");
        		 System.out.println("Type 3 for Account_Details_Updation");
        		 System.out.println("Type 4 for Deleted_Account");
        		 System.out.println("Type 5 for Exit");
        		 int choice =sc.nextInt();
        		 switch(choice) {
        		      case 1:{
        		    	      System.out.print("Enter your Name:");
        		    	      String name=sc.next();
        		    	      System.out.print("Enter Your Account Type(Savings or Current):");
        		    	      String account=sc.next();
        		    	      System.out.print("Enter Initial Balance:(Minumum 1000)");
        		    	      double bal=sc.nextDouble();
        		    	      if(bal<1000) 
        		    	      {
        		    	    	  System.out.println("Initial deposit must be at least Rs.1000. Please add more money.");
        		    	      }
        		    	      else
        		    	      {
        		    	    	  System.out.print("Enter Phone Number:");
        		    	    	  String phone=sc.next();
        		    	          BankDetails d=new BankDetails(name,account,bal,phone);
                                  int i=ba.addAccount(d); 
                                  if (i==1)
                                  {
                                  System.out.println("Account Created Successfully...");
                                  }
                                  else 
                                  {
                                	    System.out.println("Failed to create Account..."); 
                                   }
        		    	       }  
        		               } 
        		               break;
        		       case 2:{
        		    	       System.out.print("Enter your Account ID:");
        		    	       Long id=sc.nextLong();
        		    	       BankDetails d=ba.readAccount(id);
        		    	       if(d!=null) 
        		    	       {
        		    	    	  System.out.println(d);
        		    	       }
        		    	       else 
        		    	       {
        		    	    	  System.out.println("Account not Found by Given ID...");
        		    	       } 
        		               }
        		               break;
        		       case 3:{
        		    	       System.out.print("Enter your Account ID:");
        		    	       Long id=sc.nextLong();
        		    	       BankDetails d=ba.readAccount(id);
        		    	       if(d!=null) 
        		    	       {
        		    	    	   System.out.print("Do you want to change Account Type(Y or N):");
        		    	    	   char ch=sc.next().charAt(0);
        		    	    	   if(ch=='y' || ch=='Y') 
        		    	    	   {
        		    	    		   System.out.print("Enter Your required Update type:");
        		    	    		   String type=sc.next();
        		    	    		   if(type.equals(d.getAcc_type())) 
        		    	    		   {
        		    	    			  System.out.println("You are Entering Existence Account Type");
        		    	    		   }
        		    	    		   else
        		    	    		   {
        		    	    			   d.setAcc_type(type);
        		    	    			   ba.update(d);
        		    	    			   System.out.println("Your updation done successfully...");
        		    	    		   }  
        		    	    	   }
        		    	    	   System.out.print("Do you want to change Phone Number(Y or N):");
        		    	    	   char ch1=sc.next().charAt(0);
        		    	    	   if(ch1=='y' || ch1=='Y') 
        		    	    	   {
        		    	    		   int Otp=(int)(Math.random()*9000)+1000;
        		    	    		   System.out.println("Your Otp is:"+Otp);
        		    	    		   System.out.print("Enter Your Otp:");
        		    	    		   int UserOtp=sc.nextInt();
        		    	    		   if(Otp==UserOtp) 
        		    	    		   {
        		    	    			   System.out.print("Enter Your required Update Phone Number: ");
        		    	    			   String phno=sc.next();
        		    	    			   d.setPhone(phno);
        		    	    			   ba.update(d);
                   		    	    	   System.out.println("Your updation done successfully...");
        		    	    		   }
        		    	    		   else
        		    	    		   {
        		    	    			   System.out.println("Ooch! OTP does not Matched...");        		    	    		 
        		    	    		   }
        		    	    	   }
        		    	      }	      
        		             }
        		              break;
        		       case 4:{ 
        		    	       System.out.print("Enter Your Account ID:");
        		    	       Long id=sc.nextLong();
        		    	       boolean res=ba.deleteAccount(id);
        		    	       if(res==true)
        		    	       {
        		    	    	   System.out.println("Your Account Detials Deleted Successfully... ");
        		    	       }
        		    	       else 
        		    	       {
        		    	    	   System.out.println("Your Account Details Deletion Process Failed...");
        		    	       }
        		               }
        		               break;
        		       case 5:{
        		    	       System.out.print("Have a Good Day, Bye!");
        					   flag = false;
        		               }
        		               break;
        		       default:{
        		    	        System.out.print("Wrong Input...");
        		               }
        		    	  }
        		     }
          }          
}

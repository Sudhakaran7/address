/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.dao;

import mvc.models.Person;
import mvc.util.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultListModel;
import mvc.views.DetailViewPanel;
import mvc.views.NameListPanel;

/**
 *
 * @author Admin
 */
public class AddressBookDAOImplementation implements AddressBookDAO{
    NameListPanel list;
    Connection conn;
    Statement st;
    /*public AddressBookDAOImplementation ()
    {
        conn= DBConnection.getInstance().getConnect();
        
    }*/
    
    @Override
    public void addPerson(Person person) 
    {   
       try
       {
          conn = DBConnection.getInstance().getConnect();
           st = conn.createStatement();
           String qry;
           qry = "insert into AddressBook values ('"+person.getName()+"','"+person.getMob()+"','"+person.getEmail()+"','"+person.getaddress()+"')";
           //System.out.println(qry);
           st.executeUpdate(qry);
           conn.close();
        }
            
       catch(SQLException e)
       {
           System.out.println(e);
       }
           
    }
    
    @Override
     public void removePerson(String name)
     {
         try
         {
           conn = DBConnection.getInstance().getConnect();
           st = conn.createStatement();
           String qry="delete from AddressBook where name='"+name+"'";
           st.executeUpdate(qry);
           conn.close();
         }
         catch (SQLException e)
         {
             System.out.println(e);
         }
     }
    
    @Override
     public void updatePerson(Person person,String name)
     {
         try
       {
           conn = DBConnection.getInstance().getConnect();
           st = conn.createStatement();
            String qry="update AddressBook set name='"+person.getName()+"',mob='"+person.getMob()+"',email='"+person.getEmail()+"',address='"+person.getaddress()+"' where name='"+name+"'";
           st.executeUpdate(qry);
           conn.close();
        }
            
       catch(SQLException e)
       {
          System.out.println(e); 
       }
     }
    
    /**
     *to display all names to select
     * @param namePanel
     * @return 
     */
    @Override
    public DefaultListModel getAllNames(NameListPanel namePanel) 
    {
             DefaultListModel<String> dlm = new DefaultListModel<>();
            try {
         conn = DBConnection.getInstance().getConnect();
            Statement stmt;
                 stmt = conn.createStatement();
            String qry = "select * from AddressBook order by name asc";
                 try (ResultSet rs = stmt.executeQuery(qry)) {
                     while (rs.next()){
                         String name = rs.getString(1);
                         dlm.addElement(name);
                     }
                     
                     namePanel.getJList().setModel(dlm);
                 }
            stmt.close();
           conn.close();
        }
           catch (SQLException ex) {
                   System.out.println(ex+"NO Records/Cannot retrieve records");
                   }
           
        return dlm;
    }
    
    
    @Override
    public void getSelectedName(DetailViewPanel detailPanel,String selectedName)
    {
        try {
            conn = DBConnection.getInstance().getConnect();
            Statement stmt;
            stmt = conn.createStatement();
            String qry = "select * from AddressBook where name = '"+selectedName+"'";
            ResultSet rs;
            rs = stmt.executeQuery(qry);
            while(rs.next()){
             detailPanel.setName(rs.getString("name"));
             detailPanel.seteMail(rs.getString("email"));
             detailPanel.setMobile(rs.getString("mob"));
             detailPanel.setAddress(rs.getString("address"));
             System.out.println(qry);
           }
            conn.close();
        }
         catch (SQLException ex) {
                   System.out.println("NO Records/Cannot retrieve records");
                   }
    }
           
    
}

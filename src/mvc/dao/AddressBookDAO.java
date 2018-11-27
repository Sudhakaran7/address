
package mvc.dao;

import mvc.models.Person;
import mvc.views.NameListPanel;
import mvc.views.DetailViewPanel;


/**
 *
 * @author Bharathy Annamalai  KGiSL
 */
import javax.swing.DefaultListModel;
public interface AddressBookDAO {
    
    public void addPerson(Person person);
    public void removePerson(String name);
    public void updatePerson(Person person,String name);
    public DefaultListModel getAllNames(NameListPanel namepanel);
    public void getSelectedName(DetailViewPanel detailPanel,String selectedName);
    
}

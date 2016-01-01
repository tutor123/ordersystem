package onlineshop.item.models;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
@Transactional
public class Itemdao {
	@Autowired
	  private SessionFactory _sessionFactory;
	private Session getSession() {
	    return _sessionFactory.getCurrentSession();
	  }
	  public void save(Item i) {
		    getSession().save(i);
		    return;
		  }
		  
		  public void delete(String name) {
		    getSession().delete(name);
		    return;
		  }
		  
		  @SuppressWarnings("unchecked")
		public List<Item> getAll() {
			    return getSession().createQuery("from Item").list();
			  }
		  
			  public void update(Item i) {
			    getSession().update(i);
			    return;
			  }
}

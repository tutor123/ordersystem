package onlineshop.order.models;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import onlineshop.order.models.*;
@Repository
@Transactional
public class Orderdao {
	@Autowired
	  private SessionFactory _sessionFactory;
	private Session getSession() {
	    return _sessionFactory.getCurrentSession();
	  }
	public void save(Order o) {
	    getSession().save(o);
	    return;
	  }
	  
	  public void delete(Order o) {
	    getSession().delete(o);
	    return;
	  }
	  @SuppressWarnings("unchecked")
	public List<Item> getAll(Order o) {
		    return getSession().createQuery("from Order").list();
		  }
	  
}

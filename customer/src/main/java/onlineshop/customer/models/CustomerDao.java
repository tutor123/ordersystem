package onlineshop.customer.models;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;





@Repository
@Transactional
public class CustomerDao {
	@Autowired
	  private SessionFactory _sessionFactory;
	private Session getSession() {
	    return _sessionFactory.getCurrentSession();
	  }
	  public void save(Customer c) {
		    getSession().save(c);
		    return;
		  }
		  
		  public void delete(Customer c) {
		    getSession().delete(c);
		    return;
		  }
		  @SuppressWarnings("unchecked")
		public List<Customer> getAll() {
			    return getSession().createQuery("from Customer").list();
			  }
		  public Customer getById(long id) {
			    return (Customer) getSession().load(Customer.class, id);
			  }

			  public void update(Customer c) {
			    getSession().update(c);
			    return;
			  }
}


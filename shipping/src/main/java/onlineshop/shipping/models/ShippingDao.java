package onlineshop.shipping.models;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ShippingDao {
	@Autowired
	  private SessionFactory _sessionFactory;
	private Session getSession() {
	    return _sessionFactory.getCurrentSession();
	  }
	public void save(ShippingRecord srd) {
	    getSession().save(srd);
	    return;
	  }
	  
	  public void delete(ShippingRecord srd) {
	    getSession().delete(srd);
	    return;
	  }
	  @SuppressWarnings("unchecked")
	public List<ShippingRecord> getAll() {
		    return getSession().createQuery("from Shipping").list();
		  }
	  
}

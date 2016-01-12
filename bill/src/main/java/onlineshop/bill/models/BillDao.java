package onlineshop.bill.models;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;





@Repository
@Transactional
public class BillDao {
	@Autowired
	  private SessionFactory _sessionFactory;
	private Session getSession() {
	    return _sessionFactory.getCurrentSession();
	  }
	  public int save(Bill b) {
		    getSession().save(b);
		    return b.getId();
		  }
	  @SuppressWarnings("unchecked")
	public List<Bill> getAll() {
		    return getSession().createQuery("from Bill").list();
		  }
		  

}

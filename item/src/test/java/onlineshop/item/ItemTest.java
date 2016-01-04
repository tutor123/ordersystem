package onlineshop.item;



import org.junit.Before;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;



import onlineshop.item.controllers.ItemController;
import onlineshop.item.models.Item;
import onlineshop.item.models.Itemdao;

import static org.mockito.Mockito.*;

public class ItemTest {

	@InjectMocks
	private ItemController itemc;
	@Mock
	private Itemdao itemd;
	
	@Before 
	public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

	@Test
	public void testListItem() {
		List<Item> it = new ArrayList<Item>();
		it.add(new Item("7-up",30));
		Mockito.when(itemd.getAll()).thenReturn(it);
		Assert.assertEquals(itemc.getAll().size(), it.size());
	}
	@Test 
	public void testAddItem(){
		Item i = new Item("ginger ale",35f);
		doNothing().when(itemd).save(i);
		Assert.assertEquals(itemc.addItem("ginger ale", 35f), "item succesfully created!");
		
	}

}

import static org.junit.Assert.*;

import org.junit.Test;


public class LinkedListTest {

	@Test
	public void testSize() {
		LinkedList list=new LinkedList();
		list.add(10);
		list.add(11);
		list.add(12);
		list.add(13);
		int sizeActual=list.size();
		int sizeExpected=4;
		assertEquals(sizeExpected, sizeActual);
		//fail("Not yet implemented");
	}
	
	@Test
	public void testGet(){
		LinkedList list=new LinkedList();
		list.add(10);
		list.add(11);
		list.add(12);
		list.add(13);
		
		ReturnObject expectedGet=new ReturnObjectImpl(12);
		ReturnObject actualGet=list.get(2);
		assertEquals(expectedGet, actualGet);

		
		
	}

}

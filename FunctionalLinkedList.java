
public class FunctionalLinkedList extends LinkedList implements FunctionalList {

	@Override
	public ReturnObject head() {
		return get(0);
	}

	@Override
	public FunctionalList rest() {
		if(isEmpty()){
			return new FunctionalArrayList();
		}
		FunctionalList list=new FunctionalArrayList();
		for (int i = 1; i < size(); i++) {
			list.add(get(i).getReturnValue());
		}
		return list;
	}
}

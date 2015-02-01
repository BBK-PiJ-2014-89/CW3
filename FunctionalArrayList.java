
public class FunctionalArrayList extends ArrayList implements FunctionalList {
	@Override
	public ReturnObject head() {
		return 	get(0);
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
	
	public static void main(String[] args) {
		FunctionalArrayList list=new FunctionalArrayList();
		
		list.add(11);
		list.add(12);
		list.add(13);
		list.add(14);
		list.add(15);
		list.print();
		
		System.out.println("head <"+list.head()+">");
		System.out.println("rest <"+list.rest()+">");
		
	}

}

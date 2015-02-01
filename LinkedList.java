
public class LinkedList implements List {
	private Object obj;
	private LinkedList next;
	
	public LinkedList(){
		next=null;
	}
	public LinkedList(Object obj){
		next=null;
		this.obj=obj;
	}

	@Override
	public boolean isEmpty() {
		if (size()==0){
			return true;
		}else return false;
	}

	@Override
	public int size() {
		while(next!=null){
			return next.size()+1;
		}
		return 0;
	}

	@Override
	public ReturnObject get(int index) {
		LinkedList current=next;
		int i=0;
		if(isEmpty()){
			return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		}else if(index>=size()||index<0)return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		while(i!=index){
			i++;
			current=current.next;
		}
		return new ReturnObjectImpl(current);
	}

	@Override
	public ReturnObject remove(int index) {
		ReturnObject current=get(index);
		if(index>=size()||index<0)return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		if(index==0){
			this.next=next.next;
		}else next.remove(index-1);
		return current;
	}

	@Override
	public ReturnObject add(int index, Object item) {
		if(index>=size()||index<0)return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		LinkedList temp=new LinkedList(item);
		LinkedList current=next;
		int i=1;
		while(i!=index){
			current=current.next;
			i++;
		}
		temp.next=current.next;
		current.next=temp;
		return null;
	}

	@Override
	public ReturnObject add(Object item) {
		while(next!=null){
			return next.add(item);
		}next=new LinkedList(item);
		return null;
	}
	
	public String toString(){
		return ""+obj;
	}
	
	public void print(){
		LinkedList current=next;
		int i=0;
		while(current!=null){
			System.out.println("["+i+"]"+"["+current.toString()+"]");	
			current=current.next;
			i++;
		}
	}
}

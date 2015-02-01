
public class StackImpl extends AbstractStack{
	public StackImpl(List list) {
		super(list);
	}

	@Override
	public boolean isEmpty() {
		return internalList.isEmpty();
	}

	@Override
	public int size() {
		return internalList.size();
	}

	@Override
	public void push(Object item) {
		internalList.add(item);
	}

	@Override
	public ReturnObject top() {
		if(isEmpty()){
			return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		}else return internalList.get(size()-1);
	}

	@Override
	public ReturnObject pop() {
		if(isEmpty()){
			return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		}else return internalList.remove(size()-1);
	}
	
	
	public static void main(String[] args) {
		LinkedList list=new LinkedList();
		StackImpl stack=new StackImpl(list);
		
		stack.push(1);
		stack.push(1);
		stack.push(1);
		stack.push(2);

		list.print();
		System.out.println(stack.top());
		list.print();
		System.out.println(stack.pop());
		list.print();

	}

}

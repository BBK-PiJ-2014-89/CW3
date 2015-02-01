
public class ImprovedStackImpl implements ImprovedStack{
	private List list;
	
	public ImprovedStackImpl() {
		list=new ArrayList();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public void push(Object item) {
		list.add(item);
	}

	@Override
	public ReturnObject top() {
		return list.get(size()-1);
	}

	@Override
	public ReturnObject pop() {
		ReturnObject temp=top();
		list.remove(size()-1);
		return temp;
	}

	@Override
	public ImprovedStack reverse() {
		ImprovedStackImpl newStack=new ImprovedStackImpl();
		for(int i=size()-1;i>=0;i--){
			Object temp=list.get(i).getReturnValue();
			newStack.push(temp);
		}
		return newStack;
	}

	@Override
	public void remove(Object object) {
		for(int i=0;i<size();i++){    
			if(list.get(i).getReturnValue().equals(object)){
				list.remove(i);
				i--;
			}
		}
	}
}

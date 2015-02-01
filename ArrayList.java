
public class ArrayList implements List {
	private Object[] objectArray;
	private int size;
	private static int INITIAL_ARRAY_SIZE = 5;
	
	public ArrayList(){
		objectArray=new Object[INITIAL_ARRAY_SIZE];
		size=0;
	}
	
	@Override
	public boolean isEmpty() {
		if(size==0){
			return true;
		}else return false;
	}

	@Override
	public int size() {
		return size;
	}
	
	@Override
	public ReturnObject get(int index) {
		if(isEmpty()){
			return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		}else if(index>=size()||index<0){
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		}else{
			return new ReturnObjectImpl(objectArray[index]);
		}
	}

	@Override
	public ReturnObject remove(int index) {	
		ReturnObject current=get(index);
		if(!current.hasError()){
			size--;
			for(int i=index;i<size();i++){
				objectArray[i]=objectArray[i+1];
			}
		}
	return current;
	}

	@Override
	public ReturnObject add(int index, Object item) {
		if(isAlmostFull())reserveMoreMemory();
		if(item==null) return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
		ReturnObject current=get(index);
		if(!current.hasError()){
			for(int i=size;i>=index;i--){
				objectArray[i+1]=objectArray[i];
			}objectArray[index]=item;
			size++;
		}
		return null;
	}

	@Override
	public ReturnObject add(Object item) {
		if(isAlmostFull())reserveMoreMemory();
		//ReturnObject current=new ReturnObjectImpl(item);
		Object current=item;
		if(item==null){
			return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
		}else{
			objectArray[size()]=current;
			size++;
		}
		return null;
	}
    private boolean isAlmostFull() {
	  if (objectArray.length - size < 2) {
		return true;
	  } else {
		return false;
	  }
    }
    
    private void reserveMoreMemory() {
	  Object[] biggerArray = new Object[size*2];
	  for (int i = 0; i < size; i++) {
		biggerArray[i] = this.objectArray[i];
	  }
	  this.objectArray = biggerArray;
    }
}

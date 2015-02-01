
public class ReturnObjectImpl implements ReturnObject {
	
	private ErrorMessage errorMessage;
	private Object object;

	public ReturnObjectImpl(ErrorMessage error){
		object=null;
		errorMessage=error;
	}
	public ReturnObjectImpl(Object object){
		this.object=object;
		this.errorMessage=errorMessage.NO_ERROR;
	}
	
	@Override
	public boolean hasError() {
		if (errorMessage.equals(ErrorMessage.NO_ERROR)) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public ErrorMessage getError() {
		return errorMessage;
	}

	@Override
	public Object getReturnValue() {
		return object;
	}
	
	@Override
	public String toString() {
		if(errorMessage==ErrorMessage.NO_ERROR){
			return object+"";
		}else return ""+errorMessage;
	}	

}

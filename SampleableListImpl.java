
public class SampleableListImpl extends LinkedList implements SampleableList{

	@Override
	public SampleableList sample() {
		SampleableList list=new SampleableListImpl();
		for(int i=0;i<size();i+=2){
			list.add(get(i).getReturnValue());
		}
		return list;
	}
}

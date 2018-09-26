package practica3;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Iterator;

public class StringConverterSet extends AbstractSet<Object> {
	private ArrayList<Object> set;
	@Override
	public Iterator<Object> iterator() {
		return new IteratorStringAdapter();
	}
	public boolean add(Object item){
		if (set.contains(item))
		    return false;
		else
			return set.add(item);
		
	}
	
	@Override
	public int size() {
		return set.size();
	}
	
	private class IteratorStringAdapter implements Iterator<Object>{
        int index=0;
		@Override
		public boolean hasNext() {
			return index< size();
		}

		@Override
		public String next() {
			return set.get(index++).toString();
		}
		
	}

}

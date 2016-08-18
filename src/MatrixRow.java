

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrixRow {
	private List<Integer>  values    = new ArrayList<Integer>();
	private List<Integer>  positions = new ArrayList<Integer>();

	public MatrixRow() {
	}
	
	public MatrixRow(Integer[] values,Integer[] positions) {
		this.values = Arrays.asList(values);
		this.positions = Arrays.asList(positions);
	}

	public void addValue(Integer value, Integer position){
		values.add(value);
		positions.add(position);
	}

	public Integer getValue(Integer position){
		for(int i=0;i<positions.size();i++){
	    	   if (positions.get(i).equals(position)){
	    		  return values.get(i); 
	    	   } else if (positions.get(i).compareTo(position)>0){
	    		   return 0;
	    	   }
		}
		return 0;
	}
   

}

package homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 
		


@Data
@AllArgsConstructor
public class Word {
	private String word;
	private List<Means> mean = new ArrayList<>();
	
	
	
	public Word(String word) {
		super();
		this.word = word;
	}
	
	public void addingMean(int index,String newMean) {
        mean.get(index).addMean(newMean);
	}
	

	
	
	public boolean containsMean(String newMean) {
	    for (int i = 0; i < mean.size(); i++) {
	        Means m = mean.get(i);
	        if (m.getMeanList().contains(newMean)) {
	            return true;
	        }
	    }
	    return false;
	}

	@Override
	public String toString() {
		return word + " : " + mean.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		return Objects.equals(word, other.word);
	}

	@Override
	public int hashCode() {
		return Objects.hash(word);
	}





	
	
	
	
	
	


}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Means{
	private String wordClass;
	private List<String> meanList = new ArrayList<String>();
	
	  public void addMean(String newMean) {
	        meanList.add(newMean);
	        
	    }

	public Means(String wordClass) {
		super();
		this.wordClass = wordClass;
	}

	@Override
	public String toString() {
		return "(" + wordClass + ")" + meanList;
	}

	
	  
	  
	  

}
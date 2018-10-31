package practica6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GramasHash {
   private HashMap<String,ArrayList<String>> dictionary= new HashMap<>();
   private final int Q=2;

   public HashMap<String,ArrayList<String>> getDictionary() {
	  return dictionary;
   }
   
   public void factorize(String word) {
      this.factorizeWord(word,"#"+word+"$");
   }
   
   private void factorizeWord(String word, String grammaWord) {
	   if (grammaWord.length()>1) {
		   String gramma=grammaWord.substring(0,Q);
		   ArrayList<String> wordList= new ArrayList<>();
		   wordList.add(word);
		   ArrayList<String> values=this.dictionary.putIfAbsent(gramma,wordList);
		   if (values !=null) {
			   values.addAll(wordList);
		   }
		   this.factorizeWord(word,grammaWord.substring(1));
	   }
	   
   }
   
   public static void main(String[] args) {
	   GramasHash gramas=new GramasHash();
	   gramas.factorize("hola");
	   gramas.factorize("holalala");
	   gramas.factorize("Algo");
	   gramas.factorize("Giuseppe");
	   gramas.factorize("Kilimanjaro");
	   HashMap<String,ArrayList<String>> dict=gramas.getDictionary();
	   
	   for (Map.Entry<String, ArrayList<String>> entry : dict.entrySet()) {
		   String key = entry.getKey();
		   ArrayList<String> value = entry.getValue();
		   System.out.println(key+":");
		   for (String i :value) {
			   System.out.print(i+" - ");
		   }
		   System.out.println("");
		   System.out.println("-----");
		   
	   }
   }


}

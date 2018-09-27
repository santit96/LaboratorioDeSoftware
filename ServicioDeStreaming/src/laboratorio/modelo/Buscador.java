package laboratorio.modelo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Buscador {
	
   public static Comparator<Pelicula> defaultComparator=new TitleComparator();
   public static Comparator<Pelicula> appreciationComparator=new AppreciationComparator();
   
   private ArrayList<Pelicula> peliculas;
   
   public Buscador(){
	   this.peliculas=new ArrayList<Pelicula>();
   }

   public void setPeliculas(ArrayList<Pelicula> peliculas) {
	   this.peliculas=peliculas;
   }
   
   public ArrayList<Pelicula> getPeliculas(){
	   return this.peliculas;
   }
   
   public List<Pelicula> seleccionar(Genero genero,ClasificacionEdad ce,Rango valoracion,Rango reproduccion,Comparator<Pelicula> comp){
	
	   Iterator<Pelicula> iterator= peliculas.listIterator();
	   List<Pelicula> filtradas=this.filter(iterator,genero,ce,valoracion,reproduccion);
	   filtradas.sort(comp);
	   return filtradas;
   }
   
   private List<Pelicula> filter(Iterator<Pelicula> iterator, Genero genero, ClasificacionEdad ce, Rango valoracion,
		Rango reproduccion) {
	    if (iterator.hasNext()){
	    	Pelicula pelicula=iterator.next();
	    	List<Pelicula> filtradas=this.filter(iterator,genero,ce,valoracion,reproduccion);
	    	if (pelicula.getGeneros().contains(genero) && pelicula.getAge_clasification().equals(ce) && pelicula.getAppreciation()>valoracion.getLimiteInferior() && pelicula.getAppreciation()<=valoracion.getLimiteSuperor() && pelicula.getReproductions()>reproduccion.getLimiteInferior() && pelicula.getReproductions()<reproduccion.getLimiteSuperor())
	    	    filtradas.add(pelicula);
	    		return filtradas;
	    }
	    else
	    	return new ArrayList<Pelicula>();
   }

private static class TitleComparator implements Comparator<Pelicula>{

	  @Override
	  public int compare(Pelicula arg0, Pelicula arg1) {
		return arg0.getTitle().compareTo(arg1.getTitle());
	  }
   }
   
   private static class AppreciationComparator implements Comparator<Pelicula>{

		@Override
		public int compare(Pelicula arg0, Pelicula arg1) {
			if (arg0.getAppreciation() > arg1.getAppreciation())
				return 1;
			else if (arg0.getAppreciation() < arg1.getAppreciation())
				     return -1;
			else return 0;
		}
	   }
   
   
}

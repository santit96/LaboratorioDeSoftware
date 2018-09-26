package laboratorio.modelo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Buscador {
   private ArrayList<Pelicula> peliculas;
   private Comparator comparator;
   public ArrayList<Pelicula> getPeliculas() {
	   return this.peliculas;
   }
   
   public List<Pelicula> seleccionar(Genero genero,ClasificacionEdad ce,Rango valoración,Rango reproducción,Comparator<Pelicula> comp){
	   return new ArrayList<Pelicula>();
	   
   }
   
   
}

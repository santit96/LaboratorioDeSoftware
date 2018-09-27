package laboratorio.modelo;

import java.util.ArrayList;

public class Pelicula {
   private String title;
   private int year;
   private String country;
   private ClasificacionEdad age_clasification;
   private ArrayList<Genero> generos;
   private int reproductions;
   private float appreciation;
   
   
   
   public Pelicula(String title, int year, String country, ClasificacionEdad age_clasification, ArrayList<Genero> generos,
		int reproductions, float appreciation) {
	  super();
	  this.title = title;
	  this.year = year;
	  this.country = country;
	  this.age_clasification = age_clasification;
	  this.generos=new ArrayList<Genero>();
	  this.generos.addAll(generos);
	  this.reproductions = reproductions;
	  this.appreciation = appreciation;
   }

   public String getTitle() {
	  return title;
   }

   public void setTitle(String title) {
	  this.title = title;
   }
  
   public int getYear() {
	  return year;
   }
  
   public void setYear(int year) {
	  this.year = year;
   }
  
   public String getCountry() {
	  return country;
   }
  
   public void setCountry(String country) {
	  this.country = country;
   }
  
   public ClasificacionEdad getAge_clasification() {
	  return age_clasification;
   }
  
   public void setAge_clasification(ClasificacionEdad age_clasification) {
	  this.age_clasification = age_clasification;
   }
  
   public ArrayList<Genero> getGeneros() {
	  return generos;
   }
  
   public void setGeneros(ArrayList<Genero> generos) {
	  this.generos = generos;
   }
  
   public int getReproductions() {
	  return reproductions;
   }
  
   public void setReproductions(int reproductions) {
	  this.reproductions = reproductions;
   }
  
   public float getAppreciation() {
	  return appreciation;
   }
  
   public void setAppreciation(float appreciation) {
	  this.appreciation = appreciation;
   }
  
}

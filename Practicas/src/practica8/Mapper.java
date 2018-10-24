package practica8;
import java.io.IOException;
import java.lang.reflect.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class Mapper {
	
	public static void map(Class<?> cl) throws IllegalArgumentException, IllegalAccessException, InstantiationException {
		if (cl.isAnnotationPresent(Archivo.class)) {
			Archivo archivo=cl.getAnnotation(Archivo.class);
			
			//Tomo de la anotacion el nombre del archivo
			String fileName= archivo.nombre();
			//Si no esta seteado entonces es el nombre de la clase
			if (fileName.equals(""))
				fileName=cl.getName();
			
			Path file = Paths.get(fileName);
			List<String> nameLine=Arrays.asList("<nombreClase>"+cl.getName()+"</nombreClase>");
			try {
				Files.write(file,nameLine,Charset.forName("UTF-8"));
				Object instance=cl.newInstance();
				for (Field field : cl.getDeclaredFields()) {
					if (field.isAnnotationPresent(AlmacenarAtributo.class)) {
						//Agrego al archivo la linea del nombre del atributo
						field.setAccessible(true);
						List<String> attributeLine=Arrays.asList("<nombreAtributo>"+field.getName()+"</nombreAtributo>");
						Files.write(file, attributeLine, Charset.forName("UTF-8"),StandardOpenOption.APPEND);
						//Agrego al archivo la linea del valor del atributo
						List<String> atributeValueLine=Arrays.asList("<valorAtributo>"+field.get(instance)+"</valorAtributo>");
						Files.write(file, atributeValueLine, Charset.forName("UTF-8"),StandardOpenOption.APPEND);
					}
				}
				System.out.println("Se hizo el mapeo de la clase en forma correcta");
			} catch (IOException e) {
				System.out.println("No se pudo escribir el archivo" + e);
			}
			
		}
		else
			System.out.println("La clase no posee la anotacion @Archivo, no puede ser mapeada");
		
	}

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, InstantiationException {
		if (args.length!=1) {
			System.out.println("Falta el nombre de la clase a mapear");
		}
		else {
			try {
				Class<?> classToMap = Class.forName(args[0]);
				map(classToMap);
			} catch (ClassNotFoundException e) {
				System.out.println("Esa clase ,"+args[0]+",no existe");
			}
		}
	}

}

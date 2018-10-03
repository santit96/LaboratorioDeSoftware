package practica6;

public class Veterinaria<T extends Animal> {
    private T animal;
    public void setAnimal(T x) {
        animal = x;
    }
    public T getAnimal() {
        return animal;
    }
    
    public static void main(String[] args) {
    	Veterinaria <Gato> vet = new Veterinaria<Gato>();
    	Veterinaria <? super Gato> vet1 = new Veterinaria <Animal>();
    	Veterinaria <?> vet2 = new Veterinaria<Gato>();
    	vet.setAnimal(new Gato());
    	Veterinaria vet3 = new Veterinaria ();
    	vet3.setAnimal(new Perro());
    	
    }
	
}

package Task4.com.example;
import java.lang.reflect.Field;

class Animal {
    private String privateField = "Private Field";
    protected int protectedField = 42;
    public String publicField = "Public Field";
}

class Cat {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        Animal animal = new Animal();

        Class<? extends Animal> animalClass = animal.getClass();

        Field privateField = animalClass.getDeclaredField("privateField");
        privateField.setAccessible(true);

        Field protectedField = animalClass.getDeclaredField("protectedField");
        protectedField.setAccessible(true);

        Field publicField = animalClass.getDeclaredField("publicField");

        privateField.set(animal, "New Private Field Value");
        protectedField.set(animal, 84);
        publicField.set(animal, "New Public Field Value");

        System.out.println("privateField: " + privateField.get(animal));
        System.out.println("protectedField: " + protectedField.get(animal));
        System.out.println("publicField: " + publicField.get(animal));
    }
}

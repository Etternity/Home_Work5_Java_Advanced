package Task3.com.example;
import java.lang.reflect.*;
import java.util.Arrays;

class MyClass {
    private int privateField;
    public String publicField;
    protected double protectedField;

    public MyClass() {
    }

    public MyClass(int privateField, String publicField, double protectedField) {
        this.privateField = privateField;
        this.publicField = publicField;
        this.protectedField = protectedField;
    }

    private void privateMethod() {
        System.out.println("Private method called");
    }

    public void publicMethod() {
        System.out.println("Public method called");
    }

    protected void protectedMethod() {
        System.out.println("Protected method called");
    }
}

public class ReflectionExample {
    public static void main(String[] args) {
        Class<?> myClass = MyClass.class;

        Field[] fields = myClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("Field name: " + field.getName());
            System.out.println("Field type: " + field.getType());
            System.out.println("Field modifiers: " + Modifier.toString(field.getModifiers()));
            System.out.println();
        }

        Constructor<?>[] constructors = myClass.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println("Constructor name: " + constructor.getName());
            System.out.println("Constructor parameters: " + Arrays.toString(constructor.getParameterTypes()));
            System.out.println("Constructor modifiers: " + Modifier.toString(constructor.getModifiers()));
            System.out.println();
        }

        Method[] methods = myClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("Method name: " + method.getName());
            System.out.println("Method return type: " + method.getReturnType());
            System.out.println("Method parameters: " + Arrays.toString(method.getParameterTypes()));
            System.out.println("Method modifiers: " + Modifier.toString(method.getModifiers()));
            System.out.println();
        }
    }
}

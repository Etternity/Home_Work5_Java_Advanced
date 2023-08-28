package Task2.com.example;
import java.lang.reflect.*;

public class ReflectionExample {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Введіть ім'я класу (з повною назвою, наприклад, java.lang.String): ");
        String className = scanner.nextLine();

        try {
            Class<?> clazz = Class.forName(className);
            printClassInformation(clazz);
        } catch (ClassNotFoundException e) {
            System.out.println("Клас не знайдено.");
        }
    }

    public static void printClassInformation(Class<?> clazz) {
        System.out.println("Інформація про клас: " + clazz.getName());

        System.out.println("Модифікатори класу: " + Modifier.toString(clazz.getModifiers()));

        Class<?> superClass = clazz.getSuperclass();
        if (superClass != null) {
            System.out.println("Суперклас: " + superClass.getName());
        }

        System.out.println("Інтерфейси:");
        Class<?>[] interfaces = clazz.getInterfaces();
        for (Class<?> iface : interfaces) {
            System.out.println("- " + iface.getName());
        }

        System.out.println("Поля:");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("- " + Modifier.toString(field.getModifiers()) + " " + field.getType().getName() + " " + field.getName());
        }

        System.out.println("Методи:");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.print("- " + Modifier.toString(method.getModifiers()) + " " + method.getReturnType().getName() + " " + method.getName() + "(");
            Parameter[] parameters = method.getParameters();
            for (int i = 0; i < parameters.length; i++) {
                System.out.print(parameters[i].getType().getName() + " " + parameters[i].getName());
                if (i < parameters.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println(")");
        }
    }
}

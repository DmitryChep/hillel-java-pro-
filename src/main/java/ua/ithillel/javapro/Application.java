package ua.ithillel.javapro;

import java.lang.reflect.Method;

import java.util.OptionalInt;

public class Application {
    public static void main(String[] args) {
        int[] array = {3, 2, 5, 4, 1};
        // find and print second-smallest number in array
        OptionalInt resultSecondSmallestNumber = ArrayUtils.secondSmallestNumber(array);
        resultSecondSmallestNumber.ifPresent(i -> System.out.println("Second smallest number in array is: " + i + "\n"));

        // get and print information about method using reflexion
        Class<ArrayUtils> clazz = ArrayUtils.class;
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("Method: " + declaredMethod.getName());
            System.out.println("Return type: " + declaredMethod.getAnnotatedReturnType());
            System.out.println("Modifiers: " + declaredMethod.getModifiers());

            // get and print information about annotation if it is presents using reflexion
            if (declaredMethod.isAnnotationPresent(Author.class) || declaredMethod.isAnnotationPresent(MethodInfo.class)) {
                Author author = declaredMethod.getAnnotation(Author.class);
                MethodInfo methodInfo = declaredMethod.getAnnotation(MethodInfo.class);
                System.out.println("Annotation Author: " + author.toString());
                System.out.println("Annotation MethodInfo: " + methodInfo);
            }
        }
    }
}

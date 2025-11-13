import java.util.Scanner;

public class QuadraticEquationSolverr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input coefficients
        System.out.print("Enter coefficient a: ");
        double a = sc.nextDouble();
        System.out.print("Enter coefficient b: ");
        double b = sc.nextDouble();
        System.out.print("Enter coefficient c: ");
        double c = sc.nextDouble();

        // Check if 'a' is zero (not a quadratic equation)
        if (a == 0) {
            System.out.println("This is not a quadratic equation (a cannot be zero).");
        } else {
            double discriminant = b * b - 4 * a * c;

            // Check discriminant
            if (discriminant > 0) {
                // Two distinct real roots
                double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
                System.out.println("The equation has two real roots:");
                System.out.println("Root 1 = " + root1);
                System.out.println("Root 2 = " + root2);
            } else if (discriminant == 0) {
                // One real root (repeated)
                double root = -b / (2 * a);
                System.out.println("The equation has one real root:");
                System.out.println("Root = " + root);
            } else {
                // No real roots
                System.out.println("The equation has no real solutions.");
            }
        }

        sc.close();
    }
}

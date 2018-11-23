package Question02;

import java.util.Comparator;
import java.util.Arrays;

class Circle {

    int r;

    public Circle(int r) {
        this.r = r;
    }

    @Override
    public String toString() {
        return "Circle with radius: " + r;
    }
}

class OrderByRadius implements Comparator<Circle> {

    @Override
    public int compare(Circle left, Circle right) {
        return (left.r - right.r);
    }
}

public class Selection {

    /**
     * @param args the command line arguments
     */
    public static <AnyType> void SelectionSort(AnyType[] a, Comparator<? super AnyType> cmp) {
        int n = a.length;

        for (int i = 0; i < n - 1; i++) {
            int lei = i;
            for (int j = i + 1; j < n; j++) {
                if (cmp.compare(a[j], a[lei]) < 0) {
                    lei = j;
                }
            }
            AnyType swap = a[lei];
            a[lei] = a[i];
            a[i] = swap;
        }

    }

    public static void main(String[] args) {
        Circle[] c = {new Circle(30), new Circle(20), new Circle(10), new Circle(40), new Circle(5)};
        Comparator<Circle> cmp = new OrderByRadius();
        SelectionSort(c, cmp);

        System.out.println(Arrays.toString(c));
    }

}

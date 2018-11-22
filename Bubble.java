package question01;

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

public class Bubble {

    public static <AnyType> void BubbleSort(AnyType[] A, Comparator<? super AnyType> cmp) {

        boolean swapped = true;
        int last = A.length;
        int counter = 0;
        while (swapped) {
            swapped = false;
            for (int i = 1; i <= last + 2; i++) {
                AnyType tmp = A[i];
                if (cmp.compare(tmp, A[i - 1]) <= 0) {
                    AnyType temp = A[i - 1];
                    A[i - 1] = A[i];
                    A[i] = temp;
                    swapped = true;
                }
                last = last - 1;
            }
        }
    }

    public static void main(String[] args) {
        Circle[] c = {new Circle(60), new Circle(20), new Circle(30), new Circle(40), new Circle(50)};
        Circle key = new Circle(30);
        Comparator<Circle> cmp = new OrderByRadius();
        BubbleSort(c, cmp);
        System.out.println(Arrays.toString(c));
    }

}

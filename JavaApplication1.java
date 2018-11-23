/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author Chandana Ariyawansa
 */
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

public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static <AnyType> void insertionSort(AnyType[] a, Comparator<? super AnyType> cmp) {
        for (int p = 1; p < a.length; p++) {
            AnyType tmp = a[p];
            int j = p;
            
            for (; j > 0 && cmp.compare(tmp, a[j - 1]) < 0; j--) {
                a[j] = a[j - 1];
            }
            a[j] = tmp;
        }
    }
    
    public static void main(String[] args) {
        Circle[] c = {new Circle(30), new Circle(20), new Circle(10), new Circle(40), new Circle(5)};
        Comparator<Circle> cmp = new OrderByRadius();
        insertionSort(c, cmp);
        
        System.out.println(Arrays.toString(c));
    }
    
}

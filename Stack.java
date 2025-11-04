
package stack;

import java.util.Scanner;

public class Stack {

    // Stack class
    static class stack {
        int[] arr;
        int top;
        int size;

        // Constructor
        stack(int size) {
            this.size = size;
            arr = new int[size];
            top = -1;
        }

        // Push operation
        void push(int val) {
            if (top == size - 1) {
                System.out.println("Stack Overflow!");
            } else {
                arr[++top] = val;
                System.out.println(val + " pushed into stack.");
            }
        }

        // Pop operation
        void pop() {
            if (isEmpty()) {
                System.out.println("Stack Underflow!");
            } else {
                System.out.println(arr[top] + " popped from stack.");
                top--;
            }
        }

        // Peek operation
        void peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty!");
            } else {
                System.out.println("Top element: " + arr[top]);
            }
        }

        // Check if empty
        boolean isEmpty() {
            return top == -1;
        }

        // Display all elements
        void display() {
            if (isEmpty()) {
                System.out.println("Stack is empty!");
                return;
            }
            System.out.print("Stack elements: ");
            for (int i = top; i >= 0; i--) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter stack size: ");
        int size = sc.nextInt();

        stack s = new stack(size);

        while (true) {
            System.out.println("\n---- STACK MENU ----");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. IsEmpty");
            System.out.println("5. Display");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter value to push: ");
                    int val = sc.nextInt();
                    s.push(val);
                    break;
                case 2:
                    s.pop();
                    break;
                case 3:
                    s.peek();
                    break;
                case 4:
                    if (s.isEmpty())
                        System.out.println("Stack is empty.");
                    else
                        System.out.println("Stack is not empty.");
                    break;
                case 5:
                    s.display();
                    break;
                case 6:
                    System.out.println("Exiting program...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}

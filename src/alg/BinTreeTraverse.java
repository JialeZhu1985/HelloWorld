package alg;

import java.util.Stack;

public class BinTreeTraverse<T> {
    
    void template(TreeNode<T> root) {
        if (root == null) {
            return;
        }
        
        TreeNode<T> p = root;
        Stack<TreeNode<T>> stack = new Stack<TreeNode<T>>();
        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                p = p.right;
            }
        }
    }
    
    void preOrder(TreeNode<T> root) {
        if (root == null) {
            return;
        }
        
        TreeNode<T> p = root;
        Stack<TreeNode<T>> stack = new Stack<TreeNode<T>>();
        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                System.out.print(p.value + " ");
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                p = p.right;
            }
        }
    }
    
    void preOrder2(TreeNode<T> root) {
        if (root == null) {
            return;
        }
        
        TreeNode<T> p = root;
        Stack<TreeNode<T>> stack = new Stack<TreeNode<T>>();
        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                p.mileStone = 0;
                System.out.print(p.value + " ");
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                if (p.mileStone == 0) {
                    p.mileStone = 1;
                    stack.push(p);
                    p = p.right;
                } else if (p.mileStone == 1) {
                    p.mileStone = 2;
                    p = null;
                }
            }
        }
    }
    
    void inOrder(TreeNode<T> root) {
        if (root == null) {
            return;
        }
        
        TreeNode<T> p = root;
        Stack<TreeNode<T>> stack = new Stack<TreeNode<T>>();
        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                System.out.print(p.value + " ");
                p = p.right;
            }
        }
    }
    
    void inOrder2(TreeNode<T> root) {
        if (root == null) {
            return;
        }
        
        TreeNode<T> p = root;
        Stack<TreeNode<T>> stack = new Stack<TreeNode<T>>();
        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                p.mileStone = 0;
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                if (p.mileStone == 0) {
                    p.mileStone = 1;
                    System.out.print(p.value + " ");
                    stack.push(p);
                    p = p.right;
                } else if (p.mileStone == 1) {
                    p.mileStone = 2;
                    p = null;
                }
            }
        }
    }
    
    void postOrder(TreeNode<T> root) {
        if (root == null) {
            return;
        }
        
        TreeNode<T> p = root;
        Stack<TreeNode<T>> stack = new Stack<TreeNode<T>>();
        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                p.mileStone = 0;
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                if (p.mileStone == 0) {
                    p.mileStone = 1;
                    stack.push(p);
                    p = p.right;
                } else if (p.mileStone == 1) {
                    p.mileStone = 2;
                    System.out.print(p.value + " ");
                    p = null;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        BinTreeTraverse<Integer> binTreeTraverse = new BinTreeTraverse<Integer>();
        binTreeTraverse.preOrder(buildTree());
        System.out.println();
        binTreeTraverse.preOrder2(buildTree());
        System.out.println();
        binTreeTraverse.inOrder(buildTree());
        System.out.println();
        binTreeTraverse.inOrder2(buildTree());
        System.out.println();
        binTreeTraverse.postOrder(buildTree());
    }
    
    /**
     * -            1
     * -        2       3
     * -    4       5       6
     * 
     * -          7   8
     */
    private static TreeNode<Integer> buildTree() {
        TreeNode<Integer> root = new TreeNode<Integer>(1);
        root.left = new TreeNode<Integer>(2);
        root.right = new TreeNode<Integer>(3);
        root.left.left = new TreeNode<Integer>(4);
        root.left.right = new TreeNode<Integer>(5);
        root.right.right = new TreeNode<Integer>(6);
        root.left.right.left = new TreeNode<Integer>(7);
        root.left.right.right = new TreeNode<Integer>(8);
        
        return root;
    }
}

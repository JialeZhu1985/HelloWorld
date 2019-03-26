package alg;

public class TreeNode<T> {

    public TreeNode<T> left;
    public TreeNode<T> right;

    public T value;
    
    public int mileStone;

    public TreeNode(T value) {
        this.value = value;
    }
}

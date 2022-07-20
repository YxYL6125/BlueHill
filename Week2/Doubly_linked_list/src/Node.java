/**
 * @program: BlueHill
 * @description: 节点类
 * @author: YxYL
 * @create: 2022-07-20 15:46
 **/

public class Node<T> {
    private T  data;//存储数据
    private Node preNode;//前驱
    private Node nextNode;//后驱

    public Node() {
    }

    public Node(T data, Node preNode, Node nextNode) {
        this.data = data;
        this.preNode = preNode;
        this.nextNode = nextNode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node getPreNode() {
        return preNode;
    }

    public void setPreNode(Node preNode) {
        this.preNode = preNode;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}

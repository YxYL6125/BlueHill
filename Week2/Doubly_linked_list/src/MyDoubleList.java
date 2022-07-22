/**
 * @program: BlueHill
 * @description: 双向链表
 * @author: YxYL
 * @create: 2022-07-20 15:47
 **/

public class MyDoubleList<T> {
    private int size;//长度(个数)
    private Node head;//头节点
    private Node last;//尾节点

    public MyDoubleList() {
        this.head = new Node(null, null, null);//初始化头结点
        this.size = 0;//初始化长度
    }


    /**
     * 添加元素
     *
     * @param data 元素
     */
    public void add(T data) {
        if (isEmpty()) {//如果链表为空
            Node addNode = new Node(data, head, null);//创建节点
            head.setNextNode(addNode);//指向头结点
            last = addNode;//变成尾节点
        } else {//不为空，即有last
            Node node = last;//记录last
            Node addNode = new Node(data, node, null);//指向记录的last
            node.setNextNode(addNode);
            last = addNode;
        }
        size++;//长度+1
    }

    /**
     * 指定位置插入元素
     *
     * @param index 位置索引
     * @param data  元素
     */
    public void insert(int index, T data) {
        if (index < 1 || index > size) {
            throw new RuntimeException("检查长度咯");
        }

        Node frontNode = head;//记录头结点
        for (int i = 0; i < index; i++) {
            frontNode = frontNode.getNextNode();//将front移动到带插入点前一个节点的位置
        }
        //断链增链
        Node currentNode = frontNode.getNextNode();
        Node insertNode = new Node(data, frontNode, currentNode);
        currentNode.setPreNode(insertNode);
        frontNode.setNextNode(insertNode);

        size++;//长度+1
    }


    /**
     * 获取指定位置的元素
     *
     * @param index 位置索引
     * @return 元素
     */
    public T get(int index) {
        if (index < 0 || index > size) {
            throw new RuntimeException("检查位置是否正确");
        }

        try {
            Node<T> node = head;//记录头节点
            for (int i = 0; i < index + 1; i++) {
                node = node.getNextNode();
            }
            return (T) node.getData();
        } catch (NullPointerException e) {
            throw new NullPointerException("节点不能为null哦");
        }
    }

    /**
     * 删除指定索引元素
     *
     * @param index 位置索引
     */
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new RuntimeException("检查位置是否正确");
        }

        Node front = head;//记录头结点
        for (int i = 0; i < index; i++) {
            front = front.getNextNode();
        }

        Node current = front.getNextNode();//下一个节点

        if (index == size - 1) {//删除最后一个元素
            front.setNextNode(null);//指向null
            this.last = front;//更新尾节点
            System.out.println("删除数据:" + current.getData());
        } else if (index == 0) {//删除头元素
            this.head = front.getNextNode();
            System.out.println("删除了：" + head.getData());
        } else {//不是最后一个元素
            Node behind = current.getNextNode();
            front.setNextNode(behind);
            behind.setPreNode(front);
            size--;
            System.out.println("删除数据:" + current.getData());
        }
    }

    /**
     * 翻转链表
     *
     * @param list
     */
    public void reserve(MyDoubleList list) {
        if (list.isEmpty() || list.size <= 0) {
            throw new RuntimeException("链表不需要翻转哟");
        }

        /*Node<T> pre;
        Node<T> next;
        Node<T> newPre = new Node<>();
        Node<T> newLast = new Node<>();

        for (Node<T> node = head; node != null; node = node.getPreNode()) {//遍历链表
            pre = node.getPreNode();
            next = node.getNextNode();

            if (node.getPreNode() == null) {//当node为头节点时
                newLast = node.getNextNode();
            } else if (node.getNextNode() == null) {//node是尾节点时
                newPre = node;
            }
            node.setNextNode(pre);
            node.setPreNode(next);
           
        }
        head = newPre;
        last = newLast;*/
        Node temp = head.getNextNode();//定义辅助指针
        Node next = null;
        Node reserveHead = new Node();
        while (temp != null) {
            next = temp.getNextNode();
            temp.setNextNode(reserveHead.getNextNode());
            reserveHead.setNextNode(temp);
            temp = next;
        }
        head.setNextNode(reserveHead.getNextNode());//排序

    }

    public boolean isEmpty() {
        return size == 0;
    }


    public int getSize() {
        return size;
    }
}

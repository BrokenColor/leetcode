//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。 
//
// 
// 
// 实现 LRUCache 类： 
//
// 
// LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
// 
//
// 
// 
// 
//
// 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 3000 
// 0 <= value <= 104 
// 最多调用 3 * 104 次 get 和 put 
// 
// Related Topics 设计 哈希表 链表 双向链表


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {

    private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
    private int capacity;
    private DLinkedNode head; //头节点
    private DLinkedNode tail; //尾节点

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) return -1;

        moveToHead(node);
        //返回值
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null){//不存在
            //创建一个节点
            node = new DLinkedNode(key, value);
            //添加到表头
            addHead(node);
            //添加到map中
            cache.put(key,node);
            if (cache.size() > capacity){
                //删除队尾元素
                int deleteTailKey = deleteTail();
                //map中删除元素
                cache.remove(deleteTailKey);
            }
        }else{//存在该节点
            node.value = value;
            moveToHead(node);
        }
    }

    /**
     * 添加node节点到链表头
     * @param node
     */
    public void addHead(DLinkedNode node){
        if (node == null) return;

        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    /**
     * 移动节点到链表头
     * @param node
     */
    public void moveToHead(DLinkedNode node){
        //删除节点
        deteleNode(node);
        //添加到表头
        addHead(node);
    }

    /**
     * 删除node节点
     * @param node
     */
    public void deteleNode(DLinkedNode node){
        if (node == null) return;

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public int deleteTail(){
        if (head.next == tail) return -1;

        int DeletKey = tail.prev.key;
        deteleNode(tail.prev);
        return DeletKey;
    }



}
//定义节点
class DLinkedNode{
    DLinkedNode next;
    DLinkedNode prev;
    int key;
    int value;

    public DLinkedNode(){}
    public DLinkedNode(int key, int value){
        this.key = key;
        this.value = value;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

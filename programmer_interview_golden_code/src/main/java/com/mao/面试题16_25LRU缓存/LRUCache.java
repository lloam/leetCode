package com.mao.面试题16_25LRU缓存;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: lloam
 * Date: 2021/9/25 22:37
 * Description:
 * 设计和构建一个“最近最少使用”缓存，该缓存会删除最近最少使用的项目。缓存应该从键映射到值(允许你插入和检索特定键对应的值)，并在初始化时指定最大容量。当缓存被填满时，它应该删除最近最少使用的项目。
 *
 * 它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 */
public class LRUCache {

    // 方便访问时间复杂度为 O(1)
    private Map<Integer, Node<Integer,Integer>> cache = new HashMap<>();
    private int capacity;
    private int size;
    private Node<Integer,Integer> head;
    private Node<Integer,Integer> tail;

    /**
     * 构造函数，指定容量，大小，和初始化头部和尾部
     * @param capacity
     */
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new Node<>();
        tail = new Node<>();
        head.next = tail;
        tail.prev = head;
    }

    /**
     * 获取元素，先获取，然后再将元素节点移到头部
     * @param key
     * @return
     */
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }else {
            Node<Integer, Integer> node = cache.get(key);
            moveToHead(node);
            return node.value;
        }
    }

    /**
     * put 值
     * 先判断有没有
     * 有则覆盖，移到头部
     * 没有则判断是否达到容量，达到容量先删除尾部节点，然后头部添加节点
     * 没达到容量直接头部添加节点
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            // 缓存中有
            Node<Integer, Integer> node = cache.get(key);
            node.value = value;
            moveToHead(node);
        }else {
            // 缓存中没有，新建一个节点
            Node<Integer, Integer> newNode = new Node<>(key, value);
            if (size == capacity) {
                // 达到容量，先删再加 ==> 删除链表和缓存中的记录
                Node<Integer, Integer> lastNode = removeLastNode();
                cache.remove(lastNode.key);
                size--;
            }
            // 添加新节点
            addToHead(newNode);
            // 缓存添加节点
            cache.put(key, newNode);
            size++;
        }
    }

    /**
     * 在头部添加
     * @param node
     */
    private void addToHead(Node<Integer,Integer> node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    /**
     * 删除指定节点
     * @param node
     */
    private void removeNode(Node<Integer,Integer> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    /**
     * 将指定节点移到头部
     * @param node
     */
    private void moveToHead(Node<Integer,Integer> node) {
        removeNode(node);
        addToHead(node);
    }

    /**
     * 删除最后一个节点，也就是最少使用的
     */
    private Node<Integer,Integer> removeLastNode() {
        Node<Integer,Integer> lastNode = tail.prev;
        removeNode(lastNode);
        return lastNode;
    }

    /**
     * 双向链表
     * @param <k>
     * @param <v>
     */
    class Node<k,v> {
        k key;
        v value;
        Node<k,v> prev;
        Node<k,v> next;

        public Node(k key, v value) {
            this.key = key;
            this.value = value;
        }

        public Node() {
        }
    }
}

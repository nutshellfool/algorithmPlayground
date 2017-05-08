package me.lirui.algo.linkedlist;

/**
 * Created by RichardLee on 2017/3/21.
 */
public class SingleLinkedNode {
    private int value;
    private SingleLinkedNode next;

    public SingleLinkedNode() {}

    public SingleLinkedNode(int value, SingleLinkedNode next) {
        super();
        this.value = value;
        this.next = next;
    }


    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public SingleLinkedNode getNext() {
        return next;
    }

    public void setNext(SingleLinkedNode next) {
        this.next = next;
    }

}

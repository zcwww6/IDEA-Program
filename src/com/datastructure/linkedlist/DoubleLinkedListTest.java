package com.datastructure.linkedlist;

public class DoubleLinkedListTest {
}

class DoubleLinkedList{
    //初始化一个头结点,头结点不变
    private static final HeroNode2 head = new HeroNode2(0," "," ");
    //返回头结点
    public HeroNode2 getHead(){
        return head;
    }
    //遍历双向链表的一个方法
    //显示链表
    public void showNode(){
        //判断链表是否为空
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        //遍历链表
        HeroNode2 temp = head.next;
        while(true){
            if(temp == null){
                break;
            }
            System.out.println(temp.toString(temp));
            temp = temp.next;
        }

    }

    //添加节点到双向链表尾部
    public void add(HeroNode2 node){
        HeroNode2 temp = head;
        //遍历链表

        while(true){
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        //构成一个双向链表
        temp.next = node;
        node.pre = temp;
    }

    //修改一个节点的内容

}

class HeroNode2{
    public int no;
    public String name;
    public String nickName;
    public HeroNode2 next;//指向下一个结点
    public HeroNode2 pre;//指向上一个结点，默认为空

    public HeroNode2(int hNo,String hName,String hNickName){
        this.no = hNo;
        this.name = hName;
        this.nickName = hNickName;

    }
    public HeroNode2(){

    }
    public String toString(HeroNode2 node){
        return "{" + node.no +"," + node.name +"," + node.nickName + "}";
    }


}



























package com.datastructure.linkedlist;

public class singleLinkedListTest {

    public static void main(String[] args) {
        //创建节点
        HeroNode heroNode1 = new HeroNode(1, "Songjiang", "jishiyu");
        HeroNode heroNode2 = new HeroNode(2, "lujunyi", "yuqilin");
        HeroNode heroNode3 = new HeroNode(3, "wuyong", "zhiduoxing");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //singleLinkedList.add1(heroNode1);
        singleLinkedList.add1(heroNode2);
        singleLinkedList.add1(heroNode3);
        singleLinkedList.add1(heroNode1);
        singleLinkedList.showNode();
    }


}
//定义一个单链表类
class SingleLinkedList{
    //初始化一个头结点,头结点不变
    private static final HeroNode head = new HeroNode(0," "," ");
    //添加节点到链表
    public void add(HeroNode node){
        HeroNode temp = head;
        //遍历链表

        while(true){
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
    }
    //按顺序添加英雄
    public void add1(HeroNode node){
        HeroNode temp = head;
        boolean flag = false;
        while(true){
            if(temp.next == null){
                break;
            }
            if(temp.next.no > node.no){
                break;
            } else if(temp.next.no == node.no){
                flag = true;
               // System.out.println("该位置已经有人啦！");
                break;
            }
            temp = temp.next;
        }
        if(flag){
            //不能添加
            System.out.println("该位置已经有人啦！");
        } else {
            node.next = temp.next;
            temp.next = node;
        }

    }

    //显示链表
    public void showNode(){
        //判断链表是否为空
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        //遍历链表
        HeroNode temp = head.next;
        while(true){
            if(temp == null){
                break;
            }
            System.out.println(temp.toString(temp));
            temp = temp.next;
        }

    }

}

//创建一个英雄类
class HeroNode{
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int hNo,String hName,String hNickName){
        this.no = hNo;
        this.name = hName;
        this.nickName = hNickName;

    }
    public HeroNode(){

    }
    public String toString(HeroNode node){
        return "{" + node.no +"," + node.name +"," + node.nickName + "}";
    }

}

































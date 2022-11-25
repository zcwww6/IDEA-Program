package com.datastructure.linkedlist;



/*
    1.单向环形链表的应用场景：约瑟夫问题
    2.构建一个单向环形链表的思路：
        1.先创建第一个结点，让first指向该节点，并形成环形
        2.后面当我们每创建一个新的节点，就把该节点加入到已有的环形链表中
    3.遍历环形链表
        1.先让一个辅助 变量指向first
        2.然后通过一个while循环遍历该环形链表
    4.约瑟夫出队序列解决思路
        1.根据用户的输入生成一个小孩出圈的顺序
        2.创建一个辅助指针，helper,事先应该指向环形链表的最后一个节点
        3.当小孩报数时，让first和helper同时移动m-1次
        4.此时就可以将first指向的小孩节点出圈
            first=first.next;
            helper.next=first;
            原来first指向的结点就没有任何引用，会被回收

 */
public class SingleCircleLinkedListTest {
    public static void main(String[] args) {
        //测试构建环形链表和遍历是否ok
        SingleCircleLinkedList singleCircleLinkedList = new SingleCircleLinkedList();
        singleCircleLinkedList.addBoy(5);//加入5个小孩节点
        singleCircleLinkedList.showBoy();

        //测试小孩出圈
        singleCircleLinkedList.countBoy(1,2,5);

    }
}

//创建一个环形的单向链表

class SingleCircleLinkedList{
    //创建一个first节点
    private Boy first = new Boy(-1);
    //加入小孩节点，构建成一个环形链表
    public void addBoy(int nums){
        //对nums做一个检查
        if(nums < 1){
            System.out.println("nums数据不正确");
            return;
        }
        //使用for循环创建环形链表
        Boy curBoy = null;//辅助指针
        for(int i = 1;i <= nums;i++){
            //根据编号创建小孩节点
            Boy boy = new Boy(i);
            //如果是第一个小孩，让first指向
            if(i == 1){
                first = boy;
                first.setNext(first);//构成环
                curBoy = first;//让curBoy指向第一个小孩
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }

        }
    }

    //遍历当前环形链表
    public void showBoy(){
        if(first == null){
            System.out.println("链表为空");
            return;
        }
        //因为first不能动，因此使用辅助指针完成遍历
        Boy curBoy = first;
        while(true){
            System.out.printf("小孩的编号%d\n",curBoy.getNo());
            if(curBoy.getNext() == first){
                //说明已经遍历完毕
                break;
            }
            curBoy = curBoy.getNext();//curBoy后移
        }
    }

    //根据用户的输入，计算出出圈的顺序
    public void countBoy(int startNo,int countNum,int nums){
        //三变量分别表示从哪个开始数，跨度，总数
        //先对数据进行校验
        if(first == null || startNo < 1 || startNo > nums ){
            //参数输入有误，请重新输入
            System.out.println("参数输入有误，请重新输入");
            return;
        }
        //创建辅助指针，帮助小孩出圈
        Boy helper = first;
        while(true){
            if(helper.getNext() == first){
                //说明helper指向了最后小孩节点
                break;
            }
            helper = helper.getNext();
        }
        //小孩报数前，先让first和helper移动k-1次
        for(int j = 0;j < startNo-1; j++){
            first = first.getNext();
            helper = helper.getNext();
        }

        while(true){
            if(helper == first){
                //说明圈中只有一个节点
                break;
            }
            //让first和helper同时移动countNum-1,
            for(int j=0;j < countNum-1;j++){
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.printf("小孩%d出圈",first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留在圈中的小孩编号%d",first.getNo());
    }

}

//创建一个boy类，表示一个节点
class Boy{
    private int no;
    private Boy next;//指向下一个结点

    public Boy(int no){
        this.no = no;
    }
    public int getNo(){
        return no;
    }
    public void setNo(int no){
        this.no = no;
    }
    public void setNext(Boy boy){
        this.next = boy;
    }
    public Boy getNext(){
        return next;
    }
}



























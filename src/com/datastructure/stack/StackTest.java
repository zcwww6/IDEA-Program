package com.datastructure.stack;

import java.util.Scanner;

public class StackTest {
    //测试
    public static void main(String[] args) {
        Stack stack = new Stack(10);
        String key = "";
        boolean loop = true;//控制是否退出菜单
        Scanner scanner = new Scanner(System.in);
        while(loop){
            System.out.println("show:表示显示栈");
            System.out.println("push:表示压入栈");
            System.out.println("pop:表示出栈");
            System.out.println("exit:退出程序");
            System.out.println("请输入你的选择");
            key = scanner.next();
            switch(key){
                case "show":
                    stack.showStack();
                    break;
                case "push":
                    System.out.println("请输入一个要入栈的数：");
                    int num = scanner.nextInt();
                    stack.push(num);
                    System.out.println("入栈成功！");
                    break;
                case "pop":
                    System.out.println("出栈的数据是：" + stack.pop());
                    break;
                case "exit":
                    loop = false;
                    break;
                default:
                    System.out.println("输入格式不正确！");
                    break;
            }
        }
    }
}

class Stack {
    private int maxSize;
    private int[] stack;//数组模拟栈
    private int top = -1;//栈顶，初始化为-1

    //构造器
    public Stack(int maxSize){
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //判断栈满
    public boolean isFull(){
        return top == maxSize - 1;
    }

    //判断栈空
    public boolean isEmpty(){
        return top == -1;
    }

    //入栈
    public void push(int value){
        //先判断是否满
        if(isFull()){
            return ;
        }
        top++;
        stack[top] = value;
    }
    //出栈
    public int pop(){
        if(isEmpty()){
            System.out.println("栈空");
            return -1;
        }
        int value = stack[top];
        top--;
        return value;
    }
    //遍历栈,需要从栈顶开始显示
    public void showStack(){
        if(isEmpty()){
            System.out.println("没有数据");
            return;
        }
        for(int i = top; i >= 0; i--){
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
    }


}






























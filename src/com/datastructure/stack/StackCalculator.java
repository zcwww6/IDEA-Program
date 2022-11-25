package com.datastructure.stack;

import java.util.Scanner;

public class StackCalculator {
    public static void main(String[] args) {
        //要计算的表达式
        String expression = "";
        Scanner scanner = new Scanner(System.in);
        expression=scanner.nextLine();
        //创建两个栈，数栈和符号栈
        Stackk nStackk = new Stackk(20);
        Stackk oStackk = new Stackk(10);
        //扫描表达式
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch =' ';//将每次扫描到的char保存到ch
        String keepNum = "";
        //开始循环扫描
        while(true){
            //依次得到expression的每个字符
            ch = expression.substring(index,index+1).charAt(0);
            //判断ch是什么类型，然后做相应的处理
            if(oStackk.isOper(ch)){//如果是运算符
                //判断当前栈是否为空
                if(!oStackk.isEmpty()){
                    //比较运算符优先级
                    if(oStackk.priority(ch) <= oStackk.priority(oStackk.top())){
                        num2 = nStackk.pop();
                        num1 = nStackk.pop();
                        oper = oStackk.pop();
                        res = nStackk.cal(num1,num2,oper);
                        //把运算的结果存入到数栈
                        nStackk.push(res);
                        //把当前的符号入符号栈
                        oStackk.push(ch);
                    }else{
                        oStackk.push(ch);
                    }
                }else{
                    //直接入栈
                    oStackk.push(ch);
                }

            }else {//如果是数字则直接入栈
                //当处理多位数是，不能发现是一个数字就立即入栈，因为它可能是多位数
                //在处理数是需要向expression的表达式的Index后再看一位，如果是数就继续进行扫描，如果是符号则将当前数入栈
                //因此要定义一个字符串变量用于拼接
                keepNum += ch;
                //如果ch已经是expression的最后一位，则不需要判断
                if (index == expression.length() - 1) {
                    nStackk.push(Integer.parseInt(keepNum));
                } else {
                    //判断下一个字符是否是数字,如果是则继续进行扫描，如果是运算符则入栈
                    if (oStackk.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
                        //如果后一位是运算符，则入栈
                        nStackk.push(Integer.parseInt(keepNum));
                        /////重要！！！！清空keepNum;
                        keepNum = "";
                    }
                }
            }
            //让index+1,并判断是否扫描到expressin的最后
            index++;
            if(index >= expression.length()){
                break;
            }
        }
        //扫描完毕，顺序地从数栈和符号栈中pop出相应的数字和符号，并运行
        while(true){
            //如果符号栈为空，则计算结束,最后的结果是数栈中只有一个数字
            if(oStackk.isEmpty()){
                break;
            } else {
                num2 = nStackk.pop();
                num1 = nStackk.pop();
                oper = oStackk.pop();
                res = nStackk.cal(num1, num2, oper);
                nStackk.push(res);

            }
        }
        System.out.println("最后的计算结果为：" + expression + "=" + nStackk.pop());
    }


}

//创建一个栈，直接使用前面创建好的栈
//需要扩展功能
class Stackk {
    private int maxSize;
    private int[] stack;//数组模拟栈
    private int top = -1;//栈顶，初始化为-1

    //构造器
    public Stackk(int maxSize){
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
    //查看栈顶的元素但不出栈
    public int top(){
        int value = stack[top];
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
    //返回运算符的优先级,使用数字表示，数字越大则优先级越高
    public int priority(int oper){
        if(oper == '*' || oper == '/'){
            return 1;
        }
        else if(oper == '+' || oper == '-'){
            return 0;
        }
        else{
            return -1;//嘉定目前的表达式只有+-*/
        }
    }
    //判断是不是一个运算符
    public boolean isOper(char val){
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    //计算方法
    public int cal(int num1,int num2,int oper){
        int res = 0;//用于存放计算的结果
        switch(oper){
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num1 - num2;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num1 / num2;
                break;
            default:
                break;
        }
        return res;
    }
}


























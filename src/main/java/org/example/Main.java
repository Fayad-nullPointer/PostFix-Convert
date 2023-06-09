package org.example;

import java.util.Scanner;

class Node{
    Node Next;
    char data;

    public Node(char data){
        this.data=data;
        this.Next=null;
    }

}
class Stack{
    Node Top;
public Stack(){
    this.Top=null;
}
public boolean isEmpty(){
    return(Top==null);
}
public void Push(char data){
    Node n=new Node(data);
    if(isEmpty())Top=n;
    else{
        n.Next=Top;
        Top=n;}
}


    public char pop(){
        if(!isEmpty()){
        char x= Top.data;
        Top=Top.Next;
        return  x;
        }

        return 0;
    }
    public char Peek(){
    if(!isEmpty()){
    char x=pop();
        Push(x);
    return x;
    }

        return 0;
    }





}


public class Main {
    public static void Print(Stack s1){
        Stack tmp=new Stack();
        while(!s1.isEmpty()){
            char x=s1.pop();
            //System.out.println(x);
            tmp.Push(x);
        }
        while(!tmp.isEmpty()){
            char y=tmp.pop();
            System.out.println(y); //Non REv
            s1.Push(y);
        }
    }



    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        System.out.println("PLEASE ENTER INFIX STRING");
//        String c=sc.next();
//      System.out.println("PostFix is"+"   "+ConvertInfixTopostFix(c));
//      sc.close();
//        System.out.println("BY:AHMED ASHRAF FAYAD");
//        System.out.println("ID:20221374447");
//        System.out.println("Enter PostFix To Evaluate");
//     Scanner s=new Scanner(System.in);
//        String x=s.next();
     EvaluatePostFixExceprission(" 345+*612+/-");
//     s.close();





    }
    public static String ConvertInfixTopostFix(String x){
        String postFix="";
        Stack operators=new Stack();
        char z;
        for(int i=0;i<x.length();++i){
            z=x.charAt(i);
            if(Character.isDigit(z)) postFix=postFix+z;
            else if (z=='(') {
                operators.Push(z);
            }
            else if (z==')') {
                while (operators.Peek()!='('){
                    postFix=postFix+operators.pop();
                }
                operators.pop(); //REMOVE OPEN BRACKET ACCORDING TO ALGORITHM
            }
            //Check isEmpty of Stack if Exsist Brackets or No Exsist of Open Bracket And Check Precedence
            else{
                while (!operators.isEmpty()&&!(operators.Peek()=='(')&&prec(z)<=prec(operators.Peek())) postFix=postFix+operators.pop();

                operators.Push(z);
            }

        }
        //if the while Loop Condition not evaluated.

        while (!operators.isEmpty())
            postFix=postFix+operators.pop();

        return postFix;
    }
    public static int prec(char x){
        if(x=='+'||x=='-')return 1;
        if(x=='*'||x=='/'||x=='%')return 2;
        return 0;
    }

    public static void EvaluatePostFixExceprission(String x){
        Stack operators=new Stack();
        Stack operands=new Stack();
        char []z=x.toCharArray();
        for(int i=0;i<z.length;++i) {
            if (Character.isDigit(z[i])) {
                operands.Push(z[i]);
            } else if (!Character.isDigit(z[i])) {
                operators.Push(z[i]);
            }
            char op1 = operands.pop();
            char op2 = operands.pop();
            char w = operators.pop();
            int res = evaluateopeartors(op1, op2, w);
            operands.Push((char) res);

        }
      System.out.println((int)operands.pop());
        //New Way Start From Here....->

//        Stack s1=new Stack();
//        char[] a=x.toCharArray();
//        int i=0;
//        while(i<a.length){
//            if(Character.isDigit(a[i])) s1.Push( a[i]);
//            int op1=s1.pop();
//            int op2=s1.pop();
//            int res= evaluateopeartors(op1,op2,a[i]);
//            s1.Push((char) res);
//            i++;
//        }
////         System.out.println((int) s1.pop());
//
    }



    public static int evaluateopeartors(int op1,int op2,char operator){
        switch (operator){
            case '+':
               System.out.println(op1+" + "+op2);
                return  (op1+op2);
            case '-':
                System.out.println(op1+" - "+op2);
                return (op1-op2);
            case '/':
                System.out.println(op1+" / "+op2);
                return  (op1/op2);
            case '*':
                System.out.println(op1+" * "+op2);
                return  (op1*op2);
            default: return 0;
        }

    }

}
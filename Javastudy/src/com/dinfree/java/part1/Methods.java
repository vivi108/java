package com.dinfree.java.part1;

public class Methods {
	String name;

    Methods() {
        name = "ȫ�浿";
        System.out.printf("#������: %s\n",name);
    }

    void printName() {
        System.out.printf("#printName(): %s\n",name);
    }
    
    void printName(String name) {
        System.out.printf("#printName(String name): %s\n", name);
    }

    void printNames(String...name) {
    	System.out.println("#printNames(String...name)");
        for(String s : name) {
            System.out.println(s);
        }
    }

    int calc(int num1, int num2){
        return num1+num2;
    }
    
    public static void main(String[] args) {
    	Methods m = new Methods();
    	m.printName();
    	m.printName("��浿");
    	m.printNames("�ƹ���","ȫ�浿","����");
    	System.out.printf("#calc(int num1, int num2): %d ", m.calc(20,50));
    }
}

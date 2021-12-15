package com.dinfree.java.part1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Collection종합실습예제 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//collection 인터페이스는 list 와 set의 상위 인터페이스 이다.
		Map<String, String> map = new HashMap<>();
		map.put("1", "홍길동");
		map.put("2", "김사랑");
		System.out.println(map.get("2"));
		
		for(Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + entry.getValue());
		}
		for (String s : map.keySet()) {
			System.out.println(s);
		}
		for (String s : map.values()) {
			System.out.println(s);
		}
	
	}

}

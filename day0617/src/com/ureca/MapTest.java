package com.ureca;

import java.util.*;

public class MapTest {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "홍길동"); // string -> String Object
        map.put("age", 13); // int -> Integer Object
        map.put("job", "학생");

        Map<String, String> map2 = new HashMap<>();
        map2.put("k1", "홍길동");
        map2.put("k2", "길라임");
        map2.put("k3", "김주원");
        map2.put("k4", "깅뮤신");
        map2.put("k3", "이순신"); // 중복 키 -> 덮어쓰기

        System.out.println(map2.get("k3")); // k3: 이순신 저장

        map2.remove("k4");
        map2.replace("k3", "하순신");

        // Map 전체 데이터 출력
        Collection<String> collection = map2.values();
        Iterator<String> iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Map의 key값 얻어오기
        Set<String> set = map2.keySet();
        Iterator<String> keyset = set.iterator();
        while (keyset.hasNext()) {
            String key = keyset.next();
            System.out.println(key + "=>" + map2.get(key));
        }
    }
}

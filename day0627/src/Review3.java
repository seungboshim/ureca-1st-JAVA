public class Review3 {
    public static void main(String[] args) {
        String s1 = "java";
        String s2 = "java";
        System.out.println(s1 == s2); // true
        System.out.println(s1.equals(s2)); // true

        String s3 = new String("java");
        String s4 = new String("java");
        System.out.println(s3 == s4); // false
        System.out.println(s3.equals(s4)); // true
    }
}

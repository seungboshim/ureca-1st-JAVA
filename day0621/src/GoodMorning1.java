public class GoodMorning1 {

   static int[] num = {1, 2, 3, 4};
   static int R = 2;
   static int N = num.length;
   static int[] answer = new int[R];
   static StringBuilder sb = new StringBuilder();
   static boolean[] selected = new boolean[N];

   /** StringBuilder sb에 append */
   private static void appendStr(int R) {
      sb.append('[');
      for (int i = 0; i < R; i++) {
         sb.append(answer[i]);
         if (i < R - 1) {
            sb.append(" ");
         }
      }
      sb.append(']').append(' ');
   }

   /** append 끝난 스트링 출력 */
   private static void printStr() {
      System.out.println(sb.toString());
      sb.setLength(0);
   }

   public static void main(String[] args) {

//      1. num에서 R개를 뽑아서 만들 수 있는 순열을 모두 출력하시오.
      System.out.println("----- 순열 -----");
      makePermutation(0);
      printStr();
      
//      2. num에서 R개를 뽑아서 만들 수 있는 조합을 모두 출력하시오.
      System.out.println("----- 조합 -----");
      makeCombination(0, 0);
      printStr();
      
//      3. num으로 구성할 수 있는 모든 부분집합을 출력하시오.
      System.out.println("----- 부분집합 -----");
      makeSubset(0);
      printStr();
   }

   private static void makePermutation(int depth) {
      if (depth == R) {
         appendStr(R);
         return;
      }
      for (int i = 0; i < N; i++) {
         if (!selected[i]) {
            selected[i] = true;
            answer[depth] = num[i];
            makePermutation(depth + 1);
            selected[i] = false;
         }
      }
   }

   private static void makeCombination(int depth, int start) {
      if (depth == R) {
         appendStr(R);
         return;
      }
      for (int i = start; i < N; i++) { // 시작점부터..
         if (!selected[i]) {
            selected[i] = true;
            answer[depth] = num[i];
            makeCombination(depth + 1, i);
            selected[i] = false;
         }
      }
   }

   private static void makeSubset(int depth) {
      if (depth == N) {
         sb.append('[');
         for (int i = 0; i < N; i++) {
            if (selected[i]) {
               sb.append(num[i]);
               if (i < selected.length - 1) {
                  sb.append(" ");
               }
            }
         }
         sb.append(']').append(' ');
         return;
      }

      selected[depth] = true;
      makeSubset(depth + 1);
      selected[depth] = false;
      makeSubset(depth + 1);
   }
}
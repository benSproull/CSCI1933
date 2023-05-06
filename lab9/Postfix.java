public class Postfix {

    public static double evaluate(String[] expression) {
       try {
           double ans = 0;
           //String[] stack = new String[10];
           Stack<String> st = new Stack<>();
           for (int i = 0; i < expression.length; i++) {
               if (!expression[i].equals("+") && !expression[i].equals("-") && !expression[i].equals("*") && !expression[i].equals("/")) {
                   st.push(expression[i]);
               } else {
                   String num1 = st.pop();
                   String num2 = st.pop();
                   double d1 = Double.parseDouble(num1);
                   double d2 = Double.parseDouble(num2);
                   //st.push(num2, expression[i], num1);
                   //st.push(d1);
                   //st.push(d2);

                   if (expression[i].equals("+")) {
                       ans = d1 + d2;
                   }
                   if (expression[i].equals("-")) {
                       ans = d2 - d1;
                   }
                   if (expression[i].equals("*")) {
                       ans = d2 * d1;
                   }
                   if (expression[i].equals("/")) {
                       ans = d2 / d1;
                   }
                   st.push(String.valueOf(ans));
               }
           }
           return ans;
       } catch (StackException e){
           System.out.println("Error, size of stack is" + e.getSize());
       } finally {
           System.out.println("Evaluation Complete");
       }
        return 0.0;
    }
    public static void main(String[] args) throws StackException {
        System.out.println(evaluate(new String[]{"1","2","3","4","5","6","7", "-"}));
    }
}

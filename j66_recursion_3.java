import java.util.List;

public class j66_recursion_3 {
    
     
    // this function removes the particular character from the string 
    static String cal(int i,int n , String s , char c ,String ans){
        if(i==n) return ans;

        if(s.charAt(i)==c) 
        return cal(i+1, n, s, c, ans);

        return cal(i+1, n, s, c, ans+s.charAt(i));
        
    }

    static String fun(String s , String target){ // removes a substring from string using recurion 
        if(s.isEmpty()) return "";

        if(s.startsWith(target)) return fun(s.substring(target.length()), target);

        return s.charAt(0)+fun(s.substring(1), target);
    }
    public static void main(String[] args) {
        String s="acabbbacd";

        char c='a';
        
        String result="";
        result=cal(0, s.length(), s, c,result);

        System.out.println(result);

        String s2="daabcbaabcbc";
        String target="abc";
        result=s2;

        while(result.contains(target)) // kept on calling the fun until there is no target sequence left in our result
         result=fun(result, target);

        System.out.println(result);
    }
}

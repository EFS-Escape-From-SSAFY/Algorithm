import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class bj_5052 {
    static class Node{
        HashMap<Character, Node> next;
        boolean finished;
        char c;
        public Node(char c){
            this.next = new HashMap<>();
            this.c = c;
            finished = false;
        }
        public void add(char c){
            next.put(c,new Node(c));
        }
        public boolean contains(char c){
            return next.containsKey(c);
        }
    }
    static boolean add(Node node, String s){
        char current = s.charAt(0);
        if(node.contains(current)){
            if(node.next.get(current).finished){
                return false;
            }
            if(s.length()==1){
                node.next.get(current).finished = true;
                return false;
            }
            return add(node.next.get(current),s.substring(1));
        }else{
            if(s.length()==1){
                node.add(current);
                node.next.get(current).finished=true;
                return true;
            }else {
                node.add(current);
                return add(node.next.get(current), s.substring(1));
            }
        }
    }
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            int m = Integer.parseInt(br.readLine());
            boolean check = true;
            Node start = new Node('s');
            for(int j=0;j<m;j++){
                String temp = br.readLine();
                if(!add(start,temp)){
                    check = false;
                }
            }
            if(check) {
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}

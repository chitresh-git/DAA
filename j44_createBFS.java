// creating a binary tree using breadth first search 
import java.util.LinkedList;
import java.util.Queue;
public class j44_createBFS {
    static class Node{
        int data;
        Node right;
        Node left;

        Node(int val){   // will create a single node (element of tree)
            data=val;
            right=null;
            left=null;

        }
    }
   static int i=0;
   static Node createTree(int data[]){  // will create a binary tree using a level order traversal (BFS) method 
        Queue <Node> q= new LinkedList<>();
        Node root=new Node(data[i]);
        q.add(root);

        while(!q.isEmpty() && i<data.length-2){
            Node temp=q.peek();

            q.poll();

            i++;
            int leftdata=data[i];              // data for left child 
            if(leftdata!=-1){
                temp.left=new Node(leftdata);
                q.add(temp.left);
            }
            
            i++;
            int rightdata=data[i];            // data for right child 
            if(rightdata!=-1){
                temp.right= new Node(rightdata);
                q.add(temp.right);
            }

        }

        return root;
    }

    static void levelOrderAdvance(Node root){  // will print the level order traversal in tree structure
        Queue<Node> q =new LinkedList<>();
             q.offer(root);
             q.offer(null);
              
             while(!q.isEmpty()){
                Node temp=q.peek();
                q.poll();
                
                if(temp==null){
                    System.out.println("\n");
                    if(!q.isEmpty())
                    q.offer(null);
                }
    
                else{
                    System.out.print(temp.data+" ");
    
                    if(temp.left!=null){
                        q.offer(temp.left);
                    }
                    if(temp.right!=null){
                        q.offer(temp.right);
                    }
                }
             }
    
        }

    public static void main(String[] args) {
        int a[]={0,2,1,0,0,0,0,2,2,2,2,1,1,1,1};
        Node root =createTree(a);
        levelOrderAdvance(root);

        
    }
}

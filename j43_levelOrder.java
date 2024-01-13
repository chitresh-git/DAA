
// LELVEL ORDER TRAVERSAL using LINKED LIST implementation of binary tree 
// also known as BFS (breadth first search)

import java.util.LinkedList;
import java.util.Queue;

public class j43_levelOrder {

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
  static int j=0;
  static  Node create(Node root,int data[]){
      
      int val=data[j];
      if(val==-1)
      return null;       // if data is -1 then root node will become null
          
        

        root=new Node(val);      // creating a root of node 

        j++;
        // root.left= new Node(data[j]);
        root.left=create(root.left,data);     // calling the function for left child 
        
        j++;
        root.right=create(root.right,data);    // calling the funtion for right child 
        return root;
    

    }
static int level=0;
static void levelOrderAdvance(Node root){  // will print the level order traversal in tree structure
    Queue<Node> q =new LinkedList<>();
         q.offer(root);
         q.offer(null);     // null will be used as seperator to represent the end of level 
          
         while(!q.isEmpty()){
            Node temp=q.peek();
            q.poll();
            
            if(temp==null){        // here it means that one level in ended 
                level++;
                System.out.println(" <---level = "+level+"  \n");
                if(!q.isEmpty())
                q.offer(null);    // marking the end of next level 
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

static void levelOrder(Node root){ // will print level order traversal in array form 
    Queue<Node> q =new LinkedList<>();
         q.offer(root); // adding a node to the queue at rear
          
         while(!q.isEmpty()){
            Node temp=q.peek();  //extracting the front of the queue 
            q.poll();             // deleting the front element 
            
            System.out.print(temp.data+" ");     // printing excracted front node  


                 if(temp.left!=null){
                    q.offer(temp.left);          // adding left of front node to the queue 
                }
                if(temp.right!=null){
                    q.offer(temp.right);            // adding right of front node to the queue 
                } 
            
         }

    

    }

    public static void main(String[] args) {

        
       
        // recursive approach to create a binary tree 
        Node root=null;
        
        int a[]={2,6,3,-1,-1,1,-1,-1,4,5,-1,-1,7,-1,-1};
        // int a[]={1,2,4,5,3,6,7,-1};
        root=create(root,a); // will create a binary using array data , -1 represents the null 

        levelOrder(root);
        System.out.println("\nprinting in level wise structure: \n");
        levelOrderAdvance(root);




    }
    
}

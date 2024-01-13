// BINARY SEARCH TREE 
// IMPLEMENTATION OF INSERTION OPERATION IN BST 

import java.util.LinkedList;
import java.util.Queue;

public class j46_BST {
    
   static class Node{
        int data;
        Node left,right;

        Node(int val){
            data=val;
            left=right=null;
        }
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
                else level=0;
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

    static void Inorder(Node root){        // inorder traversal of BST always gives elements in ascending order 
        if(root!=null){
            Inorder(root.left);
            System.out.print(root.data+" ");
            Inorder(root.right);
        }
    }

    // recursive approach 
   static Node insert(Node root ,int val){ // insert the nodes in BST at thier proper place 
        if(root==null){
            Node n=new Node(val);
            root=n;
            return root;
        }
        if(root.data==val){            // because duplicates are not allowed in BST 
            System.out.println(val+" can not be inserted because it is already present in BST ");
            return root;
        }

        if(val<root.data)                // inserting in left subtree 
        root.left=insert(root.left,val);
 
        else                               // inserting in right subtree 
        root.right=insert(root.right, val);

        return root;

    }
   

   static Node create(int data[],Node root){ // construct the BST by calling  the insert() for all the elements 
        for(int i:data)
        root=insert(root, i);

        return root;
    }

    public static void main(String[] args) {
        int data[]={10,8,12,4,9,11,14};

        Node root=null;
        root=create(data, root);
        levelOrderAdvance(root);

        
        root=insert(root, 16);
        root=insert(root, 13);
        root=insert(root, 4);
        levelOrderAdvance(root);

        Inorder(root);

    }
}

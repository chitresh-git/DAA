import java.util.Scanner;
// LINKED LIST implementation of binary tree 
// a tree is linear data structure and a tree in which every node has atmost 2 childs is known as binary tree

public class j42_binaryTree {

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

  static  Node create(Node root){
        Scanner s=new Scanner(System.in);
        System.out.println("enter the data :");
        int val=s.nextInt();
         
        if(val==-1){        // if data is -1 then root node will become null
            return null;
        }

        root=new Node(val);      // creating a root of node 

        System.out.println("enter the data for left of "+val);
        root.left=create(root.left);     // calling the function for left child 
        
        System.out.println("enter the data for right of "+val);
        root.right=create(root.right);    // calling the funtion for right child 

        return root;

    }

    public static void main(String[] args) {
        // simple binary tree 
        Node newRoot=new Node(1);
        newRoot.left=new Node(2);
        newRoot.right=new Node(3);

        System.out.println(newRoot.data);
        System.out.println(newRoot.left.data);
        System.out.println(newRoot.right.data);
        
       
        // recursive approach to create a binary tree 
        Node root=null;
        root=create(root);
        System.out.println(root.data);



    }
    
}

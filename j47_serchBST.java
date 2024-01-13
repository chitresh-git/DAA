// IMPLEMENTATION OF SEARCHING , MIN AND MAX FUNCTION IN BST 

public class j47_serchBST {
    static class Node{
        int data;
        Node left,right;

        Node(int val){
            data=val;
            left=right=null;
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

static void search(Node root, int x){      // will the element in bst
        
        while(root!=null){

            
            System.out.println(root.data);
            if(root.data==x){
                System.out.println("element is found ");
                return;
            }
            
            if(x>root.data)
            root=root.right;
            else 
            root=root.left;
        }
    
    System.out.println("element not found ");

}

static int min(Node root){  // return minimum element 
    while(root.left!=null){
        root=root.left;
    }
    return root.data;
}

static int max(Node root){  // return maximum element 
    while(root.right!=null){
        root=root.right;
    }
    return root.data;
}

public static void main(String[] args) {
    int data[]={10,8,12,4,9,11,14};

    Node root=null;
    root=create(data, root);

    search(root, 11);
    search(root, 9);

    System.out.println("smallest element in bst is "+min(root));
    System.out.println("largest  element in bst is "+max(root));
}
}

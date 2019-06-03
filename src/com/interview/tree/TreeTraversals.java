package com.interview.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Youtube link - https://youtu.be/nzmtCFNae9k
 * Youtube link - https://youtu.be/elQcrJrfObg
 * Youtube link - https://youtu.be/qT65HltK2uE
 * Youtube link - https://youtu.be/ZM-sV9zQPEs
 * 
 * http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/
 * http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/
 * http://www.geeksforgeeks.org/iterative-preorder-traversal/
 */
public class TreeTraversals {

    public void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
    
    public void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    
    public void postOrder(Node root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public void inorderItr(Node root){
        Deque<Node> stack = new LinkedList<Node>();
        Node node = root;
        while(true){
            if(node != null){
                stack.addFirst(node);
                node = node.left;
            }
            else{
                if(stack.isEmpty()){
                    break;
                }
                node = stack.pollFirst();
                System.out.println(node.data);
                node = node.right;
            }
        }
    }
    
    public void preOrderItr(Node root){
        Deque<Node> stack = new LinkedList<Node>();
        stack.addFirst(root);
        while(!stack.isEmpty()){
            root = stack.pollFirst();
            System.out.print(root.data + " ");
            if(root.right != null){
                stack.addFirst(root.right);
            }
            if(root.left!= null){
                stack.addFirst(root.left);
            }
        }
    }
    
    public void postOrderItr(Node root){
        Deque<Node> stack1 = new LinkedList<Node>();
        Deque<Node> stack2 = new LinkedList<Node>();
        stack1.addFirst(root);
        while(!stack1.isEmpty()){
            root = stack1.pollFirst();
            if(root.left != null){
                stack1.addFirst(root.left);
            }
            if(root.right != null){
                stack1.addFirst(root.right);
            }
            stack2.addFirst(root);
        }
        while(!stack2.isEmpty()){
            System.out.print(stack2.pollFirst().data + " ");
        }
    }
    
    public void postOrderItrOneStack(Node root){
        Node current = root;
        Deque<Node> stack = new LinkedList<>();
        while(current != null || !stack.isEmpty()){
            if(current != null){
                stack.addFirst(current);
                current = current.left;
            }else{
                Node temp = stack.peek().right;
                if (temp == null) {
                    temp = stack.poll();
                    System.out.print(temp.data + " ");
                    while (!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.poll();
                        System.out.print(temp.data + " ");
                    }
                } else {
                    current = temp;
                }
            }
        }
    }
    
    
    node search(Node node,int key){
	if(node == null){
		return null;
	}
	if(node.data == key){
		return node;
	}
	else if(node.data < key){
		return search(node.right,key);
	}
	else{
		return search(node.left,key);
	}
}


node insertBST(node root,int data){
	Node node = new Node(data);
	if(root == null){
		return node;
	}
	Node parent = null, current = root;
	while(current !=null){
		parent = current;
		if(current.data <= data){
			current = current.right;
		}
		else{
			current = current.left;
		}
	}
	if(parent.data <=data){
		parent.right = node;
	}
	else{
		parent.left = node;
	}
	
	return root;
	
	
}



boolean checkTwoTreesame(Node root1,node root2){
	if(root1 == null && root2 == null){
		return true
	}
	if(root1 == null || root2 == null){
		return false;
	}
	
	return root1.data == root2.data && checkTwoTreesame(root1.left, root2.left) && checkTwoTreesame(root1.right,root2.right)

}


int sizeofTree(Node node){
	if(node == null){
		return 0;
	}
	return 1+ sizeofTree(node.left)+ sizeofTree(node.right);
}


int heightOfTree(Node node){

	if(node == null){
		return 0;
	}
	return 1 + Math.max(heightOfTree(node.left),heightOfTree(node.right));
}


boolean checkTreeIsBST(Node node,int min,int max){
	if(node == null){
		return true;
	}
	if(node.data <=min || node.data > max){
		return false;
	}
	
	return  checkTreeIsBST(node.left,min,node.data) && checkTreeIsBST(node.right,node.data,max) 
}

//needs two stack to handle this
void iterativePostOrderTraversal(Node node){
	if(node ==null){
		return;
	}
	Stack<Node> stack1 = new Stack<Node>();
	Stack<Node> stack2 = new Stack<Node>();
	stack1.push(node);
	Node temp;
	while(!stack1.isEmpty()){
		temp = stack1.pop();
		stack2.push(temp);
		if(temp.left !=null){
			stack1.push(temp.left);
		}
		if(temp.right !=null){
			stack1.push(temp.right);
		}
	}
	
	while(!stack2.isEmpty()){
		temp = stack2.pop()
		System.out.println(temp.data);
		
	}
}


void preOrderTraversal(Node node){

	if(node == null){
		return;
	}
	Stack<node> stack = new Stack<Node>();
	stack.push(node);
	Node temp;
	while(!stack.isNotEmpty()){
		temp = stack.pop();
		System.out.println(temp.data);
		//caution to be taken to push the right node first
		if(temp.right !=null){
			stack.push(temp.right);
		}
		if(temp.left !=null){
			stack.push(temp.left);
		}
	}
}

//delegant with this
void inOrderTraversal(Node node){

	if(node == null){
		return;
	}
	Stack<node> stack = new Stack<Node>();
	while(true){
		if(node !=null){
			stack.push(node);
			node =node.left;
		}
		else{
		if(stack.isEmpty) break;
			node = stack.pop();
			System.out.println(node.data);
			node = node.right();
		}
	}
}


int countLeafNodes(Node node){
	if(node == null){
		return 0;
	}
	if(node.leftChild ==null && node.rightChild ==null){
		return 1;
	}
	return countLeafNodes(node.leftChild) + countLeafNodes(node.rightChild)
}



void mirrorTree(Node node){
	if(node == null){
		return;
	}
	mirrorTree(node.leftChild);
	mirrorTree(node.rightChild);
	Node temp = node.leftChild;
	node.leftChild = node.rightChild;
	node.rightChild = temp;
}


void printLeafNodes(Node node){
	if(node == null){
		return;
	}
	if(node.leftChild == null && node.rightChild == null){
		System.out.println(node.data);
	}
	printLeafNodes(node.leftChild);
	printLeafNodes(node.rightChild);
}

void printLevelOrderTraversal(Node node){
	Queue<Node> qu = new LinkedList<Node>();
	qu.add(node);
	while(!qu.isEmpty){
		Node temp = qu.poll();
		System.out.println(temp.data);
		if(temp.leftChild !=null){
			qu.add(temp.leftChild)
		}
		if(temp.rightChild !=null){
			qu.add(temp.rightChild)
		}
	}
}

void printLevelByLevel(Node node){
	Queue<Node> qu = new LinkedList<Node>();
	qu.add(node);
	qu.add(null);
	
	while(!qu.isEmpty){
		if(qu.size() == 1){
			if(qu.poll == null){
				break;
			}
		}
		Node temp = qu.poll();
		if(temp == null){
			System.out.println();
			qu.add(null);
		}
		else{
			System.out.println(temp.data);
			if(temp.leftChild !=null){
				qu.add(temp.leftChild);
			}
			if(temp.rightChild !=null){
				qu.add(temp.right);
			}
		}
	}
}


void printReverseLevelOrderTraversal(Node node){
	Queue<Node> qu = new LinkedList<>();
	Stack<Node> st = new Stack();
	qu.add(node);
	while(!qu.isEmpty()){
		Node temp = qu.pull();
		if(temp.leftChild !=null){
			qu.add(temp.leftChild)
		}
		if(temp.rightChild !=null){
			qu.add(temp.rightChild)
		}
		st.push(temp);
	}
	
	while(!st.isEmpty()){
		System.out.println(st.pop().data);
	}
}

boolean rootToLeafSum( Node node,int sum,List<Integer> result){
	if(node == null){
		return false;
	}
	if(node.leftChild == null && node.rightChild == null){
		if(node.data == sum){
			return true; 
		}
		return false;
	}
	if(rootToLeafSum(node.leftChild,sum-node.data,result)){
		result.add(node.data);
		return true;
	}
	if(rootToLeafSum(node.rightChild,sum-node.data,result)){
		result.add(node.data);
		return true;
	}
	return false;
}


void maxElementBST(Node node){
	if( node == null){
		
	}
	Node current = node;
	while(current.rightChild !=null){
		current = current.rightChild;
	}
	System.out.pritln(current.data);
}

void printSpiralLevelOrderTraversal(Node node){
	Stack<Node> s1 = new Stack<>();
	Stack<Node> s2 = new Stack<>();
	s1.push(node);
	while(!s1.isEmpty() || !s2.isEmpty()){
		while(!s1.isEmpty()){
			node = s1.pop();
			System.out.println(node.data);
			if(node.leftChild !=null){
				s2.push(node.leftChild)
			}
			if(node.rightChild !=null){
				s2.push(node.rightChild);
			}
		}
		while(!s2.isEmpty()){
			node = s2.pop();
			System.out.println(node.data);
			if(node.leftChild !=null){
				s1.push(node.leftChild)
			}
			if(node.rightChild !=null){
				s1.push(node.rightChild);
			}
		}
	}
}
 
 
 //lowest common ancestor of binary tree
Node lowestCommonAncestorBT(Node node,int p,int q){
	if(node == null){
		return;
	}
	
	if(node.data == q || node.data == p){
		return node;
	}
	
	Node left = lowestCommonAncestor(node.leftChild,p,q);
	Node right = lowestCommonAncestor(node.rightChild,p,q);	
	if(left != null && right != null){
		return node;
	}
	else if(left ==null && right == null){
		return null;
	}
	else{
		return (left != null ? left : right);
	}
}


Node LowestCommonAncestorBST(Node root,Node n1,Node n2){
	if(root.data > Math.max(n1.data,n2.data)){
		return LowestCommonAncestor(root.leftChild,n1,n2)
	}
	else if(root.data < Math.min(n1.data,n2.data)){
		return LowestCommonAncestor(root.rightChild,n1,n2)
	}
	else{
		return root;
	}
}

Vertical order traversing(level order traversal + hash table)

1. Add root (Enqueue root)
2. Add 0 to hash table with HD(horizonatal distance) as key
3. while(queue is empty){
		3.1 poll the node from queue
		3.2 find the left node HD =( parent node HD - 1) put it in hash table, if key present already updated the nodes in value 
		3.3 find the right node HD =( parent node HD + 1) put it in hash table, if key present already updated the nodes in value 
		3.4 add left node and right node toqueue
	}
	
4 traverse the hash table and print it	

Top View of binary tree
same as above vertical order traversing, but the hash table values might be more than one, we should print the 0th element value in the value, since only one node can be seen when seen from the top of the tree



Print all ancestors of node of binary tree

int printAllAncestorNodes(Node node,int p){
	if(node!=null){
		if(node.data == p){
			return 1;
		}
		if(printAllAncestorNodes(node.leftChild,p) || printAllAncestorNodes(node.rightChild,p)){
			System.out.println(node.data);
			return 1;
		}
	}
	return 0;
}

    public static void main(String args[]){
        BinaryTree bt = new BinaryTree();
        Node head = null;
        head = bt.addNode(10, head);
        head = bt.addNode(15, head);
        head = bt.addNode(19, head);
        head = bt.addNode(17, head);
        head = bt.addNode(11, head);

        head = bt.addNode(-11, head);


        TreeTraversals tt = new TreeTraversals();
        tt.postOrder(head);
        System.out.println();
        tt.postOrderItr(head);
        System.out.println();
        tt.postOrderItrOneStack(head);
    }
}

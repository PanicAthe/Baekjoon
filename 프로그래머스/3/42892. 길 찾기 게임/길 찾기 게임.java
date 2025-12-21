import java.util.*;

class Solution {
    Node root;
    ArrayList<Integer> pre = new ArrayList<>();
    ArrayList<Integer> post = new ArrayList<>();
    
    static class Node{
        int x;
        int y;
        int index;
        Node leftChild;
        Node rightChild;
        
        public Node(int x, int y, int index, Node left, Node right){
            this.x = x;
            this.y = y;
            this.index = index;
            this.leftChild = left;
            this.rightChild = right;
        }
    }
    
    public Node insert(Node top, Node node){

       if(node.x<top.x){
            // 삽입하려는 노드가 왼쪽
            if(top.leftChild == null){
                top.leftChild = node;
            }else{
                top.leftChild = insert(top.leftChild, node);
            }
        }else{
            // 삽입하려는 노드가 오른쪽
            if(top.rightChild == null){
                top.rightChild = node;
            }else{
                top.rightChild = insert(top.rightChild, node);
            }
        }        
        return top;      
    }
    
    public void preorder(Node current){
        if(current==null){
            return;
        }
        pre.add(current.index);
        preorder(current.leftChild);
        preorder(current.rightChild);      
    }
    
    public void postorder(Node current){
        if(current==null){
            return;
        }
        postorder(current.leftChild);
        postorder(current.rightChild);    
        post.add(current.index);
    }
    
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][nodeinfo.length];
        
        List<Node> nodes = new ArrayList<>();
        
        // 노드에 x,y 정보와 기존 index까지 저장
        for (int i = 0; i < nodeinfo.length; i++) {
            nodes.add(new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1, null, null));
        }

        // 노드 y 내림차순, x 오름차순으로 정렬
        nodes.sort((a, b) -> {
            if (a.y == b.y) return a.x - b.x;
            return b.y - a.y;
        });
    
        root = nodes.get(0);
        for (int i = 1; i < nodes.size(); i++) {
            insert(root, nodes.get(i));
        }

        preorder(root);
        postorder(root);
        answer[0] = pre.stream().mapToInt(Integer::intValue).toArray();
        answer[1] = post.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
}

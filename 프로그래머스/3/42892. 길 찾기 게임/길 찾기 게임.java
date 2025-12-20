import java.util.*;

class Solution {
    ArrayList<Integer> pre = new ArrayList<>();
    ArrayList<Integer> post = new ArrayList<>();
    
    static class Node {
        int index; 
        int x;     
        int y;     
        Node leftChild;
        Node rightChild;
        
        public Node(int index, int x, int y, Node left, Node right){
            this.index = index;
            this.x = x;
            this.y = y;
            this.leftChild = left;
            this.rightChild = right;
        }
    }
    
    public Node insert(Node top, Node node){
        int currentX = top.x; 
        int insertX = node.x;

        if(insertX < currentX){
            // 삽입하려는 노드가 왼쪽
            if(top.leftChild == null){
                top.leftChild = node;
            }else{
                insert(top.leftChild, node);
            }
        }else{
            // 삽입하려는 노드가 오른쪽
            if(top.rightChild == null){
                top.rightChild = node;
            }else{
                insert(top.rightChild, node); 
            }
        }
        
        return top;      
    }
    
    public void preorder(Node current){
        if(current == null){
            return;
        }
        pre.add(current.index + 1); 
        preorder(current.leftChild);
        preorder(current.rightChild);      
    }
    
    public void postorder(Node current){
        if(current == null){
            return;
        }
        postorder(current.leftChild);
        postorder(current.rightChild);    
        post.add(current.index + 1);
    }
    
    public int[][] solution(int[][] nodeinfo) {
        // 1. 노드 리스트 생성 (정렬 전 원래 인덱스와 좌표 저장)
        ArrayList<Node> nodes = new ArrayList<>();
        for(int i=0; i<nodeinfo.length; i++) {
            nodes.add(new Node(i, nodeinfo[i][0], nodeinfo[i][1], null, null));
        }

        // 2. 정렬 (Y좌표 내림차순, X좌표 오름차순)
        Collections.sort(nodes, (n1, n2) -> {
            if (n1.y == n2.y) return n1.x - n2.x; // Y 같으면 X 오름차순
            return n2.y - n1.y; // Y 내림차순
        });

        // 3. 트리 구성
        Node root = nodes.get(0); 
        for(int i=1; i<nodes.size(); i++){
            insert(root, nodes.get(i));            
        }
        
        // 4. 순회 및 결과 반환
        preorder(root);
        postorder(root);
        
        int[][] answer = new int[2][nodeinfo.length];
        answer[0] = pre.stream().mapToInt(Integer::intValue).toArray();
        answer[1] = post.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }
}
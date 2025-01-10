package Tries;

class Node{
    Node[] links = new Node[26];
    boolean flag = false;

    boolean containsChar(char ch){
        return links[ch-'a'] != null;
    }

    void put(char ch, Node node){
        links[ch-'a'] = node;
    }

    Node get(char ch){
        return links[ch-'a'];
    }

    void setEnd(){
        flag = true;
    }

    boolean isEnd(){
        return flag;
    }
}

public class Trie {
    private static Node root;
    
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node temp = root;
        for(char ch: word.toCharArray()){
            if(!temp.containsChar(ch)){
                temp.put(ch,new Node());
            }
            temp = temp.get(ch);
        }
        temp.setEnd();
    }
    
    public boolean search(String word) {
        Node temp = root;
        for(char ch: word.toCharArray()){
            if(!temp.containsChar(ch)){
                return false;
            }
            temp = temp.get(ch);
        }
        return temp.isEnd();
    }
    
    public boolean startsWith(String prefix) {
        Node temp = root;
        for(char ch: prefix.toCharArray()){
            if(!temp.containsChar(ch)){
                return false;
            }
            temp = temp.get(ch);
        }
        return true;
    }
}

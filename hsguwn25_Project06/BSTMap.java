/**
File: BSTMap.java
Author: Hesed Guwn
Date: 10/29/2022
Project06
Course: CS231 B
**/

import java.util.ArrayList;

public class BSTMap<K extends Comparable<K>, V> implements MapSet<K,V> 
{
    //Node class creates node object that holds values for each part of the tree
    private class Node
    {
        //Fields right and left are nodes connected to the right and left of the root and kvp is a key value pair data stored inside node
        Node left;
        Node right;
        KeyValuePair<K, V> kvp;

        //Constructs node
        public Node(KeyValuePair<K,V> kvp)
        {
            this.kvp = kvp;
            this.left = null;
            this.right = null;
        }

        //Returns key
        public K getKey()
        {
            return kvp.getKey();
        }

        //Returns value
        public V getValue()
        {
            return kvp.getValue();
        }
    }

    //Field root is the start of the tree and size is how many nodes are in the tree
    private Node root;
    private int size;

    //Constructs the binary search tree and initializes fields
    public BSTMap()
    {
        root = null;
        size = 0;
    }

    //Returns value given key
    public V get(K key)
    {
        return get(key, this.root);
    }

    private V get(K key, Node cur)
    {
        if (cur == null)
        {
            return null;
        }
        if(key.compareTo(cur.getKey()) < 0)
        {
            return get(key, cur.left);
        }
        else if (key.compareTo(cur.getKey()) > 0)
        {
            return get(key, cur.right);
        }
        else 
        {
            return cur.getValue();
        }
    }

    //Returns int size of tree
    public int size()
    {
        return this.size;
    }

    //Resets fields
    public void clear()
    {
        this.size = 0;
        this.root = null;
    }

    //Places new node in tree with key and value
    public V put(K key, V value)
    {
        if(this.root == null)
        {
            this.root = new Node(new KeyValuePair<K,V>(key, value));
            size++;
            return null;
        }
        return this.put(key, value, this.root);
    }

    //Helper method for put
    private V put(K key, V value, Node cur) 
    {
        if (key.compareTo(cur.getKey()) < 0)
        {
            if (cur.left != null)
            {
                // return the recursive call's result to the left
                return put(key, value, cur.left);
            } 
            else 
            {
                // insert a new Node with the given KeyValuePair to the left of cur
                Node left = new Node(new KeyValuePair<K, V>(key, value));
                cur.left = left;
                size++;
                return null;
            }
        } 
        else if (key.compareTo(cur.getKey()) > 0)
        {
            if (cur.right != null)
            {
                // return the recursive call's result to the right
                return put(key, value, cur.right);
            } 
            else 
            {
                // insert a new Node with the given KeyValuePair to the right of cur
                Node right = new Node(new KeyValuePair<K, V>(key, value));
                cur.right = right;
                size++;
                return null;
            }
        } 
        else 
        { 
            // in this case, cur.getKey() == key
            // Set the value of cur's KeyValuePair to be the given value and return the old one
            V oldValue = cur.getValue(); 
            cur.kvp = new KeyValuePair<K, V>(key, value);
            return oldValue;
        }
    }

    //Returns boolean that tells if tree has given key
    public boolean containsKey(K key)
    {
        V value = get(key);

        if (value == null)
        {
            return false;
        } else {
            return true;
        }
    }
    
    //Returns ArrayList of all keys in sorted order from least to greatest
    public ArrayList<K> keySet()
    {
        ArrayList<K> output = new ArrayList<K>();
        keySet(root, output);
        return output;
    }

    //Helper method for keySet()
    private void keySet(Node cur, ArrayList<K> output)
    {
        if(cur == null)
        {
            return;
        }
        // recurse to the left
        keySet(cur.left, output);
        // add my own key to the output
        output.add(cur.getKey());
        // recurse to the right 
        keySet(cur.right, output);
    }

    //Returns ArrayList of all values in sorted order from least to greatest
    public ArrayList<V> values()
    {
        ArrayList<V> output = new ArrayList<V>();
        values(root, output);
        return output;
    }

    //Helper method for values()
    private void values(Node cur, ArrayList<V> output)
    {
        if(cur == null)
        {
            return;
        }
        // recurse to the left
        values(cur.left, output);
        // add my own key to the output
        output.add(cur.getValue());
        // recurse to the right 
        values(cur.right, output);
    }

    //Returns an ArrayList of each KeyValuePair in the map in the same order as the keys as returned by keySet().
    public ArrayList<KeyValuePair<K, V>> entrySet()
    {
        ArrayList<KeyValuePair<K,V>> output = new ArrayList<KeyValuePair<K,V>>();
        entrySet(root, output);
        return output;
    }

    //Helper method for entrySet()
    private void entrySet(Node cur, ArrayList<KeyValuePair<K,V>> output)
    {
        if(cur == null)
        {
            return;
        }
        // add my own key to the output
        output.add(cur.kvp);
        
        // recurse to the left
        entrySet(cur.left, output);
        
        // recurse to the right 
        entrySet(cur.right, output);
    }

    //Finds the left most node of binary tree
    public KeyValuePair<K,V> minValue(Node root) 
    {
        Node min = root;
       
        //find minval
        while (min.left != null) 
        {
            min = min.left;
        }
        return min.kvp;
    }

    //Removes a node containing the key
    public void remove(K key)
    {
        remove(key, this.root);
    }

    //Helper method for remove 
    private void remove(K key, Node cur)
    {
        //Nothing to remove
        if (size == 0){
            return;
        }

        Node prev = null;

        //Loop that runs until a case is caught
        while (true)
        {
            //Checks if the value of the key is less than the current node key value
            if (key.compareTo(cur.getKey()) < 0)
            { 
                //Iterates left
                prev = cur;
                if (cur.left == null)
                {
                    return;
                } 
                cur = cur.left;
            } 
            //Checks if the value of the key is greater than the current node ket value
            else if (key.compareTo(cur.getKey()) > 0)
            {
                //Iterates right
                prev = cur;
                if (cur.right == null)
                {
                    return;
                }
                cur = cur.right;
            }
            //Checks if key is the same as the current node key/place where we delete node
            else 
            { 
                //Checks if there are no children
                if (cur.left == null && cur.right == null)
                {
                    //Removes reference to current node using previous
                    if (cur == prev.left) 
                    {
                        prev.left = null;
                    }
                    else 
                    {
                        prev.right = null;
                    }
                } 
                //If only left child exists
                else if (cur.right == null)
                {
                    //Makes left child the replacements
                    if (cur == prev.left) 
                    {
                        prev.left = cur.left;
                    }
                    else 
                    {
                        prev.right = cur.left;
                    }
                } 
                // if only right child exists
                else if (cur.left == null)
                {
                    //Replaces current with right child
                    if (cur == prev.left) 
                    {
                        prev.left = cur.right;
                    }
                    else 
                    {
                        prev.right = cur.right;
                    }
                } 
                //If both children exist
                else 
                {
                    Node cur2 = cur;
                    Node prev2 = cur;
                    
                    cur2 = cur.left;

                    //Iterates to the right until cur2 is the node we replace cur with
                    while (cur2.right != null)
                    {
                        prev2 = cur2;
                        cur2 = cur2.right;
                    } 
                    if (cur2 == prev2.right)
                    {
                        prev2.right = cur2.left;  
                    } 
                    else 
                    {
                        prev2.left = cur2.left;
                    }
                    if (prev.left == cur) 
                    {
                        prev.left = cur2;
                    }
                    else 
                    {
                        prev.right = cur2;
                    }
                    cur.kvp = cur2.kvp;
                }
                size--;
                return ;
            }
        }
    }

    //Returns string representation of tree
    public String toString()
    {
        return toString(root, 0, "root");
    }

    //Helper method for toString()
    private String toString(Node cur, int depth, String direction){
        if (cur == null){
            return "";
        }

        String left = toString(cur.left, depth + 1, "left");
        String middle = direction + '\t' + "   ".repeat(depth) + cur.kvp + '\n';
        String right = toString(cur.right, depth + 1, "right");

        return right + middle + left;
    }

    public static void main(String[] args) 
    {
        //Tests all methods
        BSTMap<String, Integer> map = new BSTMap<String, Integer>();
        map.put("Los Pollos Hermanos", 5);
        map.put("JESSE JESSE WE NEED TO COOK", 3);
        map.put("I DONT KNOW MR WHITE SEEMS KINDA LAME", 12);
        map.put("WALTUH", 9);
        System.out.println(map);
        System.out.println(map.size);
        System.out.println(map.get("WALTUH"));
        System.out.println(map.containsKey("WALTUH"));
        System.out.println(map.containsKey("JESSE"));
        System.out.println(map.keySet());
        System.out.println(map.entrySet());
        System.out.println(map.values());
        map.remove("JESSE JESSE WE NEED TO COOK");
        System.out.println(map);
        map.clear();
        System.out.println(map.size());
    }
    
}

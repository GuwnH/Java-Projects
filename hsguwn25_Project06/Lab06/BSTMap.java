package Lab06;

/**
File: WordCounter.java
Author: Hesed Guwn
Date: 10/29/2022
Project06
Course: CS231 B
**/


import java.util.ArrayList;

public class BSTMap<K extends Comparable<K>, V> implements MapSet<K,V> 
{
    private class Node
    {
        Node left;
        Node right;
        KeyValuePair<K, V> kvp;

        public Node(KeyValuePair<K,V> kyp)
        {
            this.kvp = kvp;
            this.left = null;
            this.right = null;
        }

        public K getKey()
        {
            return kvp.getKey();
        }

        public V getValue()
        {
            return kvp.getValue();
        }
    }

    private Node root;
    private int size;

    public BSTMap()
    {
        root = null;
        size = 0;
    }

    public V get(K key)
    {
        return get(key, root);
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

    public int size()
    {
        return this.size;
    }

    public void clear()
    {
        this.size = 0;
        this.root = null;
    }

    public V put(K key, V value)
    {
        return this.put(key, value, this.root);
    }

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

    public boolean containsKey(K key)
    {
        if (size == 0) 
        {
            return false;
        }
        Node cur = root;
        while (true) 
        {
            if (key.compareTo(cur.getKey()) < 0) 
            {
                if (cur.left == null) 
                {
                    return false;
                }
                cur = cur.left;
            } 
            else if (key.compareTo(cur.getKey()) > 0) 
            {
                if (cur.right == null) 
                {
                    return false;
                }
                cur = cur.right;
            } 
            else 
            { // if cur.data == item
                return true;
            }
        }
    }
    
    public ArrayList<K> keySet()
    {
        ArrayList<K> output = new ArrayList<K>();
        keySet(root, output);
        return output;
    }

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

    public ArrayList<V> values()
    {
        ArrayList<V> output = new ArrayList<V>();
        values(root, output);
        return output;
    }

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

    public ArrayList<KeyValuePair<K, V>> entrySet()
    {
        ArrayList<KeyValuePair<K,V>> output = new ArrayList<KeyValuePair<K,V>>();
        entrySet(root, output);
        return output;
    }

    private void entrySet(Node cur, ArrayList<KeyValuePair<K,V>> output)
    {
        if(cur == null)
        {
            return;
        }
        // recurse to the left
        entrySet(cur.left, output);
        // add my own key to the output
        output.add(cur.kvp);
        // recurse to the right 
        entrySet(cur.right, output);
    }

    public String toString()
    {
        return toString(root, 0, "root");
    }

    public String toString(Node cur, int depth, String direction){
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
        
    }
    
}

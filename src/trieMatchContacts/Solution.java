package trieMatchContacts;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {


    private static Node root = new Node();

    
    private static void add(String contact) {

        Node previousNode = root;

        for (int i =0; i < contact.length(); i ++) {

            char s = contact.charAt(i);

                  if(i == 0) {

                if (root.childrens.containsKey(s)) {
                    previousNode = root.childrens.get(s);
                } else {

                    Node node = new Node();
                    node.nodeValue = s;
                    root.childrens.put(s, node);
                    previousNode = node;

                }
            } else {

                if (previousNode.childrens.containsKey(s)) {

                    previousNode = previousNode.childrens.get(s);

                } else {
                    Node node = new Node();
                    node.nodeValue = s;
                    previousNode.childrens.put(s, node);
                    previousNode = node;

                }
            }

            if (i == contact.length() - 1) {
                previousNode.isEndOfWord = true;
            } else {
                      previousNode.childCount++;
            }

        }

    }

    private static void findAndPrint(String pattern) {

        Node previousNode = root;

        for (Character s: pattern.toCharArray()) {

            if (previousNode.childrens.containsKey(s)) {
                previousNode = previousNode.childrens.get(s);
            } else {
                previousNode = null;

            }
        }

        if (Objects.isNull(previousNode)) {
            System.out.println(0);
        } else {
            System.out.println(previousNode.childCount);
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();

            if(op.equals("add")) {
                add(contact);
            } else {
                findAndPrint(contact);
            }
        }

    }
}


class Node {

    public Map<Character, Node> childrens;

    public int childCount = 0;

    public Boolean isEndOfWord;

    public Node() {
        childrens = new HashMap<>();
        childCount = 0;
        isEndOfWord = false;
    }

    public char nodeValue;
}
package com.learning.algorithms.leetcode;

/**
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 *
 * 示例:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 * 说明:
 *
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-trie-prefix-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: qdj
 * @date: 2019-12-06 15:53
 **/
public class S208Trie {

    private TreeNode root;

    /** Initialize your data structure here. */
    public S208Trie() {
        root = new TreeNode();
        // 设根节点level=-1
        root.level = -1;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] wordChars = word.toCharArray();
        if (this.root != null){
            TreeNode currentNode = root;
            for (int i = 0; i < wordChars.length; i++){
                int index = wordChars[i] - 'a';
                // 首先判断当前节点是否有存取，没有先创建节点
                if (currentNode.children[index] == null){
                    // 这里new会构建其children
                    currentNode.children[index] = new TreeNode();
                    // 树的深度
                    currentNode.children[index].level = i;
                    currentNode.children[index].parent = currentNode;
                    currentNode.children[index].val = wordChars[i];

                }
                // 表示当前单词可以作为词尾
                if (i == wordChars.length - 1) {
                    currentNode.children[index].isLast = true;
                }
                currentNode = currentNode.children[index];
            }
        } else {
            System.out.println("当前树未完成初始化");
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] wordChars = word.toCharArray();
        if (this.root != null){
            TreeNode currentNode = root;
            for (int i = 0; i < wordChars.length; i++){
                int index = wordChars[i] - 'a';
                if (currentNode.children[index] == null){
                    return false;
                }
                // 判断最后一个字符在树中是否作为词尾标记
                if (i == (wordChars.length - 1) && currentNode.children[index].isLast){
                    return true;
                }
                currentNode = currentNode.children[index];
            }
        }
        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] wordChars = prefix.toCharArray();
        if (this.root != null){
            TreeNode currentNode = root;
            for (int i = 0; i < wordChars.length; i++){
                int index = wordChars[i] - 'a';
                if (currentNode.children[index] == null){
                    return false;
                }
                currentNode = currentNode.children[index];
            }
            return true;
        }
        return false;
    }

    public class TreeNode{
        public TreeNode[] children = new TreeNode[26];   // 向下
        public TreeNode parent;  // 向上
        public int level;
        public boolean isLast ;
        public char val; // val在这里其实可以不存，其index就代表了英文字符值
    }

    public static void main(String[] args) {
        S208Trie tree = new S208Trie();

        System.out.println(tree.search("apple"));
        tree.insert("apple");
        System.out.println(tree.search("apple"));
        System.out.println(tree.search("app"));
        System.out.println(tree.startsWith("app"));
        tree.insert("app");
        System.out.println(tree.search("app"));
    }
}
package com.learning.algorithms.leetcode;

import java.util.*;

/**
 * 给出一个字符串数组words组成的一本英语词典。
 * 从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。若其中有多个可行的答案，则返回答案中字典序最小的单词。
 * 若无答案，则返回空字符串。
 *
 * 示例 1:
 * 输入:
 * words = ["w","wo","wor","worl", "world"]
 * 输出: "world"
 * 解释:
 * 单词"world"可由"w", "wo", "wor", 和 "worl"添加一个字母组成。
 *
 * 示例 2:
 * 输入:
 * words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
 * 输出: "apple"
 * 解释:
 * "apply"和"apple"都能由词典中的单词组成。但是"apple"得字典序小于"apply"。
 * 注意:
 *
 * 所有输入的字符串都只包含小写字母。
 * words数组长度范围为[1,1000]。
 * words[i]的长度范围为[1,30]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-word-in-dictionary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: qdj
 * @date: 2019-12-11 19:27
 **/
public class S720LongestWord {

    public static class TrieTree{
        public TreeNode root;
        public TrieTree(){
            this.root = new TreeNode();

        }
        public void insert(String word){
            char[] wordChars = word.toCharArray();
            if (this.root != null){
                TreeNode currentNode = root;
                for (int i = 0; i < wordChars.length; i++){
                    int index = wordChars[i] - 'a';
                    if (currentNode.children[index] == null){
                        currentNode.children[index] = new TreeNode();
                        currentNode.children[index].parent = currentNode;
                        currentNode.children[index].value = wordChars[i];
                        currentNode.children[index].level = i + 1;
                    }
                    if (i == wordChars.length - 1){
                        currentNode.children[index].isTail = true;
                    }
                    currentNode = currentNode.children[index];
                }
            }
        }

        public String getLongestWord(){
            Stack<TreeNode> stack = new Stack<TreeNode>();
            TreeNode longestTailNode = this.root;
            String longestWord = "";

            if (this.root != null){
                stack.push(this.root);
                while (!stack.isEmpty()){
                    TreeNode currentNode = stack.pop();
                    for (int i = 0; i < currentNode.children.length; i++){
                        if (currentNode.children[i] != null && currentNode.children[i].isTail){
                            stack.push(currentNode.children[i]);
                        }
                    }
                    if (currentNode != root ) {
                            if (currentNode.level > longestTailNode.level ){
                                longestTailNode = currentNode;
                            } else if (currentNode.level == longestTailNode.level){
                                // todo 递归到上层，比较字典序，确定是否更新值，比较啰嗦
                            }
                    }
                }
                if (longestTailNode != this.root){
                    TreeNode tailNode = longestTailNode;
                    while (tailNode != root){
                        longestWord = String.valueOf(tailNode.value).concat(longestWord);
                        tailNode = tailNode.parent;
                    }
                }
            }
            return longestWord;
        }

        public String getLongestWord(String[] words){
            String longestWord = "";
            if (this.root != null){
                for (String word: words) {
                    char[] wordChars = word.toCharArray();
                    TreeNode node = this.root;
                    boolean isValid = true;
                    for (char wordChar : wordChars) {
                        if (!node.children[wordChar - 'a'].isTail) {
                            isValid = false;
                            break;
                        }
                        node = node.children[wordChar - 'a'];
                    }

                    if (!isValid) {
                        continue;
                    }
                    if (longestWord.length() < word.length()
                            || (longestWord.length() == word.length() && longestWord.compareTo(word) > 0)){
                        longestWord = word;
                    }
                }
            }
            return longestWord;
        }
    }

    public static class TreeNode{
        public TreeNode[] children = new TreeNode[26];
        public TreeNode parent;
        public boolean isTail;
        public char value;
        public int level;
    }

    public String longestWord2(String[] words){
        TrieTree tree = new TrieTree();
        for (String word: words) {
            tree.insert(word);
        }
        return tree.getLongestWord(words);
    }

    public String longestWord(String[] words) {
        Set<String> dict = new HashSet<String>(Arrays.asList(words));
        String ret = "";
        for (String word: words) {
            for (int i = 0; i < word.length(); i++){
                String a = word.substring(0, i + 1);
                if (!dict.contains(word.substring(0, i + 1))){
                    break;
                }
                if (i == word.length() - 1 ){
                    if (word.length() > ret.length() || ( word.length() == ret.length() && word.compareTo(ret) < 0)){
                        ret = word;
                    }
                }
            }
        }
        return ret;
    }


    public static void main(String[] args) {
        String[] words = new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"};
        String[] words2 = new String[]{"m","mo","moc","moch","mocha","l","la","lat","latt","latte","c","ca","cat"};
        S720LongestWord instance = new S720LongestWord();
        String ret = instance.longestWord(words2);
        String ret2 = instance.longestWord2(words2);
        System.out.println("=====1 "  + ret);
        System.out.println("=====2 " + ret2);
    }
}
package xhang.leetcode;

import java.util.*;

/**
 * @Author xhang
 *
 * 面试题 17.22. 单词转换
 * 给定字典中的两个词，长度相等。写一个方法，把一个词转换成另一个词， 但是一次只能改变一个字符。
 * 每一步得到的新词都必须能在字典中找到。
 *
 * 编写一个程序，返回一个可能的转换序列。如有多个可能的转换序列，你可以返回任何一个。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-transformer-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * https://leetcode-cn.com/problems/word-transformer-lcci/
 **/
public class FindLadders {

    /*DFS*/
    public List<String> findLaddersDfs(String beginWord, String endWord, List<String> wordList) {
        List<String> res=new ArrayList<>();
        Set<String> set=new HashSet<>(wordList);
        if(beginWord.length()!=endWord.length() || !set.contains(endWord)) return res;
        set.clear();
        res.add(beginWord);
        boolean ans=track_back(beginWord,endWord,wordList,res,set,new HashSet<String>());
        if(!ans) return new ArrayList<String>();
        return res;
    }

    private boolean track_back(String beginWord,String endWord,List<String> wordList,List<String> res,Set<String> set,Set<String> set2) {
        //if(set.contains(beginWord)) return false;
        if(beginWord.equals(endWord)) return true;
        if(differOne(beginWord,endWord)) {
            res.add(endWord);
            return true;
        }
        for(String s:wordList) {
            if(differOne(s,res.get(res.size()-1)) && !set2.contains(s) && !set.contains(beginWord)) {
                res.add(s);
                set2.add(s);
                boolean t=track_back(s,endWord,wordList,res,set,set2);
                if(t) return true;
                else {
                    res.remove(res.size()-1);
                    set2.remove(s);
                    set.add(s);
                }
            }
        }
        return false;
    }

    /**
     * 判断两个字符串是否只有一个字符不同
     * @param s
     * @param beginWord
     * @return
     */
    private boolean differOne(String s,String beginWord) {
        if(s.length()!=beginWord.length()) return false;
        int count=0;
        for(int i=0;i<s.length();++i) {
            if(s.charAt(i)!=beginWord.charAt(i)) {
                ++count;
                if(count>1) break;
            }
        }
        return count==1;
    }

    /*BFS*/
    public List<String> findLaddersBfs(String beginWord, String endWord, List<String> wordList) {
        List<String> res=new LinkedList<>();
        if(wordList.size()==0 || !wordList.contains(endWord)) return res;
        Set<String> set=new HashSet<>(wordList);
        Map<String,String> map=new HashMap<>();
        Queue<String> queue=new LinkedList<>();
        queue.add(beginWord);
        int length=0;
        while(queue.size()>0){
            ++length;
            int size=queue.size();
            for(int i=0;i<size;++i)
            {
                String start=queue.poll();
                for(String s:wordList)
                {
                    if(set.contains(s) && difference(s,start)) {
                        map.put(s,start);
                        queue.add(s);
                        if(s.equals(endWord)) {
                            while(!s.equals(beginWord)) {
                                res.add(0,s);
                                s=map.get(s);
                            }
                            res.add(0,beginWord);
                            return res;
                        }
                        set.remove(s);
                    }
                }
            }
        }
        return res;
    }

    private boolean difference(String s1,String s2){
        int n=0;
        for(int i=0;i<s1.length();++i)
        {
            if(s1.charAt(i)!=s2.charAt(i)) ++n;
            if(n>1) return false;
        }
        return n==1;
    }


    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> stringList = Arrays.asList("hot","dot","dog","lot","log","cog"); // ["hit","hot","dot","lot","log","cog"]
        //List<String> stringList = Arrays.asList("hot","dot","dog","lot","log");

        //System.out.println(findLadders(beginWord, endWord, stringList));
    }
}

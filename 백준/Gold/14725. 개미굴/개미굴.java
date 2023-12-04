import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

    static class TrieNode{
        Map<String, TrieNode> childNode = new HashMap<>();

        public void insert(String word){
            TrieNode trieNode = this;
            String[] str = word.split(",");

            for(int i = 0; i<str.length; i++){
                String temp = str[i];

                trieNode.childNode.putIfAbsent(temp, new TrieNode()); //temp가 존재하는 경우 value를 반환, 아니라면 temp와 value 값을 저장하고 null 반환
                trieNode = trieNode.childNode.get(temp);
            }
        }

        public void print(TrieNode trie, int depth){
            TrieNode trieNode = trie;

            if(trieNode != null){
                List<String> ant = new ArrayList<>(trieNode.childNode.keySet());
                Collections.sort(ant); //사전 순으로 출력해야함

                for(String str : ant){
                    for(int i= 0; i<depth; i++){
                        System.out.print("--");
                    }
                    System.out.println(str);
                    print(trie.childNode.get(str), depth+1);
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        TrieNode node = new TrieNode();

        for(int i = 0; i < N; i++){
            String[] input = br.readLine().split(" ");

            int M = Integer.parseInt(input[0]);
            String str = "";

            //앞의 숫자를 지워낸 먹이 정보만 있는 문자열을 얻기 위함
            for(int j = 1; j<= M; j++){
                str += input[j]+ ",";
            }

            node.insert(str);
        }

        node.print(node, 0);
    }
}
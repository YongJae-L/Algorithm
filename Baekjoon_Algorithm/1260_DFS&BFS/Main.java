import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
  static int V;
  static int E;
  static int S;
  static int Z;
  static int [][] graph;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    V=sc.nextInt();
    E=sc.nextInt();
    S=sc.nextInt();
    graph = new int[V+1][V+1];
    for(int i=0;i<E;i++) {
      int x = sc.nextInt();
      int y = sc.nextInt();
      graph[x][y]=1;
      graph[y][x]=1;
    }
    sc.close();

    dfs();
    System.out.println();
    bfs();

  }
  static void bfs() {
    ArrayList<Integer> bfs = new ArrayList<>();
    boolean [] visit = new boolean[V+1];
    Queue<Integer> Q = new LinkedList<>();
    Q.add(S);
    visit[S] = true;
    while(!Q.isEmpty()) {
      int q = Q.poll();
      System.out.print(q+" ");
      for(int i=1;i<V+1;i++) {
        if(graph[q][i]==1 && visit[i]==false) {
          Q.add(i);
          visit[i] = true;
        }
      }
    }
  }
  static void dfs() {
    Stack<Integer> stack = new Stack<>();
    boolean [] visit = new boolean[V+1];
    stack.push(S);
    System.out.print(S+" ");
    visit[S] = true;
    while(!stack.isEmpty()) {
      int s = stack.peek();
      int check=1;
      for(int i=1;i<V+1;i++) {
        if(graph[s][i]==1 && visit[i]==false) {
          stack.push(i);
          System.out.print(i+" ");
          visit[i]=true;
          check=0;
          break;
        }
      }
      if(check==1) {
        stack.pop();
      }
    }
  }
}
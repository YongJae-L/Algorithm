import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
  static int[][] arr;
  static boolean[][] visit;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();
    sc.nextLine();
    arr = new int[N+1][M+1];
    visit = new boolean[N+1][M+1];
    for(int i=1;i<N+1;i++) {
      String temp = sc.nextLine();
      for(int j=1;j<M+1;j++) {
        arr[i][j]=Integer.parseInt(temp.substring(j-1, j));
      }
    }
    Mi mi = new Mi(1,1,0);
    Queue<Mi> Q = new LinkedList<>();
    int x=1;
    int y=1;
    int c=0;
    Q.add(mi);
    visit[x][y]=true;
    while(!Q.isEmpty()) {
      mi=Q.poll();
      x=mi.x;
      y=mi.y;
      c=mi.c;
      if(x==N && y==M) {
        System.out.println(c);
        break;
      }
      if(x<N) {
        if(arr[x+1][y]==1 && visit[x+1][y]==false) {
          Q.add(new Mi(x+1,y,c));
          visit[x+1][y]=true;
        }
      }
      if(x>1) {
        if(arr[x-1][y]==1 && visit[x-1][y]==false) {
          Q.add(new Mi(x-1,y,c));
          visit[x-1][y]=true;
        }
      }
      if(y<M) {
        if(arr[x][y+1]==1 && visit[x][y+1]==false) {
          Q.add(new Mi(x,y+1,c));
          visit[x][y+1]=true;
        }
      }
      if(y>1) {
        if(arr[x][y-1]==1 && visit[x][y-1]==false) {
          Q.add(new Mi(x,y-1,c));
          visit[x][y-1]=true;
        }
      }
    }
    sc.close();
  }
}

class Mi {
  int x,y,c;
  public Mi(int x, int y, int c){
    this.x=x;
    this.y=y;
    this.c=c+1;
  }

}
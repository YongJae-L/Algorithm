
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
  static int [][] arr;
  static boolean [][] visit;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();
    arr = new int[num][num];
    visit = new boolean[num][num];
    Queue<Integer> Qx = new LinkedList<>();
    Queue<Integer> Qy = new LinkedList<>();
    ArrayList<Integer> al = new ArrayList<>();
    int dan = 0;
    sc.nextLine();
    for(int i=0;i<num;i++) {
      String temp = sc.nextLine();
      for(int j=0;j<num;j++) {
        arr[i][j]=Integer.parseInt(temp.substring(j, j+1));
      }
    }
    
    for(int i=0;i<num;i++) {
      for(int j=0;j<num;j++) {
        if(arr[i][j]==1 && visit[i][j]==false) {
          dan++;
          Qx.add(i);
          Qy.add(j);
          int c =1;
          visit[i][j]=true;
          int x=0;
          int y=0;
          ////////
          while(!Qx.isEmpty()) {
            x=Qx.poll();
            y=Qy.poll();
            if(x+1<num) {
              if(arr[x+1][y]==1 && visit[x+1][y]==false) {
                Qx.add(x+1);
                Qy.add(y);
                c++;
                visit[x+1][y]=true;
              }
            }

            if(x>0) {
              if(arr[x-1][y]==1 && visit[x-1][y]==false) {
                Qx.add(x-1);
                Qy.add(y);
                c++;
                visit[x-1][y]=true;
              }
            }

            if(y>0) {
              if(arr[x][y-1]==1 && visit[x][y-1]==false) {
                Qx.add(x);
                Qy.add(y-1);
                c++;
                visit[x][y-1]=true;
              }
            }

            if(y+1<num) {
              if(arr[x][y+1]==1 && visit[x][y+1]==false) {
                Qx.add(x);
                Qy.add(y+1);
                c++;
                visit[x][y+1]=true;
              }
            }
          }
          al.add(c);
          ////////
        }
      }
    }
    
    System.out.println(dan);
    Collections.sort(al);
    for(int i=0;i<al.size();i++) {
      System.out.println(al.get(i));
    }
    sc.close();
  }
}
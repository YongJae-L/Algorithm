import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    Stack<S> stack = new Stack<>();
    Long N = Long.parseLong(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    stack.push(new S(Long.parseLong(st.nextToken()),1L));
    bw.append("0");

    for(long i=1;i<N;i++) {
      S now = new S(Long.parseLong(st.nextToken()),i+1);
      while(!stack.isEmpty()) {
        if(now.num<stack.peek().num) {
          bw.append(" "+stack.peek().i);
          stack.push(now);
          break;
        } else {
          stack.pop();
        }
      }
      if(stack.isEmpty()) {
        bw.write(" 0");
        stack.push(now);
      }
    }
    bw.flush();
    br.close();
    bw.close();
  }
   static class S {
	  Long num;
	  Long i;
	  public S(Long num, Long i) {
		  this.num=num;
		  this.i=i;
	  }
  }
}
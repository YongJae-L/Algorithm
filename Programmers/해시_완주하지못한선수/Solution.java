import java.util.HashMap;
class Solution {
    public String solution(String[] participant, String[] completion) {
    HashMap<String , Integer> map = new HashMap<>();
    String answer="";
    for(int i=0;i<participant.length;i++)
      map.put(participant[i],0);
    for(int i=0;i<completion.length;i++)
      map.put(completion[i],map.get(completion[i])+1);
    for(int i=0;i<participant.length;i++)
          map.put(participant[i],map.get(participant[i])-1);
    for(int i=0;i<participant.length;i++) {
      if(map.get(participant[i]) != 0) {
        answer = participant[i];
        break;
      }
    }
    return answer;
  }
}
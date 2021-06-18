/*
 * 디스크 컨트롤러
 * 
 * 하드디스크는 한 번에 하나의 작업만 수행할 수 있습니다. 디스크 컨트롤러를 구현하는 방법은 여러 가지가 있습니다. 가장 일반적인 방법은 요청이 들어온 순서대로 처리하는
 * 것입니다.
 * 
 * 예를들어
 * 
 * - 0ms 시점에 3ms가 소요되는 A작업 요청 - 1ms 시점에 9ms가 소요되는 B작업 요청 - 2ms 시점에 6ms가 소요되는 C작업 요청 와 같은 요청이 들어왔습니다.
 * 이를 그림으로 표현하면 아래와 같습니다. Screen Shot 2018-09-13 at 6.34.58 PM.png
 * 
 * 한 번에 하나의 요청만을 수행할 수 있기 때문에 각각의 작업을 요청받은 순서대로 처리하면 다음과 같이 처리 됩니다. Screen Shot 2018-09-13 at
 * 6.38.52 PM.png
 * 
 * - A: 3ms 시점에 작업 완료 (요청에서 종료까지 : 3ms) - B: 1ms부터 대기하다가, 3ms 시점에 작업을 시작해서 12ms 시점에 작업 완료(요청에서 종료까지
 * : 11ms) - C: 2ms부터 대기하다가, 12ms 시점에 작업을 시작해서 18ms 시점에 작업 완료(요청에서 종료까지 : 16ms) 이 때 각 작업의 요청부터 종료까지
 * 걸린 시간의 평균은 10ms(= (3 + 11 + 16) / 3)가 됩니다.
 * 
 * 하지만 A → C → B 순서대로 처리하면 Screen Shot 2018-09-13 at 6.41.42 PM.png
 * 
 * - A: 3ms 시점에 작업 완료(요청에서 종료까지 : 3ms) - C: 2ms부터 대기하다가, 3ms 시점에 작업을 시작해서 9ms 시점에 작업 완료(요청에서 종료까지 :
 * 7ms) - B: 1ms부터 대기하다가, 9ms 시점에 작업을 시작해서 18ms 시점에 작업 완료(요청에서 종료까지 : 17ms) 이렇게 A → C → B의 순서로 처리하면
 * 각 작업의 요청부터 종료까지 걸린 시간의 평균은 9ms(= (3 + 7 + 17) / 3)가 됩니다.
 * 
 * 각 작업에 대해 [작업이 요청되는 시점, 작업의 소요시간]을 담은 2차원 배열 jobs가 매개변수로 주어질 때, 작업의 요청부터 종료까지 걸린 시간의 평균을 가장 줄이는
 * 방법으로 처리하면 평균이 얼마가 되는지 return 하도록 solution 함수를 작성해주세요. (단, 소수점 이하의 수는 버립니다)
 * 
 * 제한 사항 jobs의 길이는 1 이상 500 이하입니다. jobs의 각 행은 하나의 작업에 대한 [작업이 요청되는 시점, 작업의 소요시간] 입니다. 각 작업에 대해 작업이
 * 요청되는 시간은 0 이상 1,000 이하입니다. 각 작업에 대해 작업의 소요시간은 1 이상 1,000 이하입니다. 하드디스크가 작업을 수행하고 있지 않을 때에는 먼저 요청이
 * 들어온 작업부터 처리합니다. 
 * 입출력 예 
 * jobs return [[0, 3], [1, 9], [2, 6]] 9 
 * 입출력 예 설명
 * 문제에 주어진 예와 같습니다.
 * 
 * 0ms 시점에 3ms 걸리는 작업 요청이 들어옵니다. 1ms 시점에 9ms 걸리는 작업 요청이 들어옵니다. 2ms 시점에 6ms 걸리는 작업 요청이 들어옵니다.
 * 
 * 

핵심 : 우선 시작시간이 빠른 것을 먼저 실행을 하되 실행 가능 상태의 Job중에 소요시간이 짧은 것을 먼저 실행시켜야 함.

 */
package algorithm.programers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class DiskController {

  public int solution(int[][] jobs) {

    List<Integer> times = new ArrayList<>();
    PriorityQueue<Job> readyJobs = new PriorityQueue<>((o1, o2) -> o1.start - o2.start); //실행시간 순
    PriorityQueue<Job> runableJobs = new PriorityQueue<>((o1, o2) -> o1.time - o2.time); //소요시간 순

    for (int[] job : jobs) {
      readyJobs.add(new Job(job));
    }
    
    //현재시각
    int curTime = 0;

    while (!runableJobs.isEmpty() || !readyJobs.isEmpty()) {

      // 실행가능 Job이 비어있으면 추가
      if (runableJobs.isEmpty()) {
        runableJobs.add(readyJobs.poll());
      }
      
      //실행 Job
      Job runJob = runableJobs.poll();

      // 실행 Job의 시작시간이 현재시간보다 크면
      // 소요시간 = Job소요시간
      // 실행 후 현재시각 = 현재시각 + (Job시작시각 - 현재시각) + Job소요시간
      if (curTime < runJob.start) {
        times.add(runJob.time);
        curTime += (runJob.start - curTime) + runJob.time;
        
      // 실행 Job의 시작시간이 현재시간보다 크면
      // 소요시간 = 현재시각 - Job시작시간 + Job소요시간
      // 실행 후 현재시각 = 현재시각 + Job소요시간
      } else {
        times.add(curTime - runJob.start + runJob.time);
        curTime += runJob.time;
      }

      
      if (!readyJobs.isEmpty()) {
        
        //현재시각보다 작거나 같은 시작시간을 가진 Job을 실행가능 Job에 추가
        Iterator<Job> chkJob = readyJobs.iterator();
        while (chkJob.hasNext()) {
          Job nextJob = chkJob.next();
          if (curTime >= nextJob.start) {
            runableJobs.add(nextJob);
            chkJob.remove();
          }
        }
      }
    }

    System.out.println(times);

    return times.stream().mapToInt(Integer::intValue).sum()/times.size();
  }

  class Job {
    int start, time;

    Job(int[] job) {
      this.start = job[0];
      this.time = job[1];
    }

    @Override
    public String toString() {
      return String.format("[%s,%s]", start, time);
    }
  }
  
  
  
  
  public int solution2(int[][] jobs) {

    int time = 0, idx = 0, curTime = 0;
    
    Queue<int[]> pq = new PriorityQueue<int[]>((i1, i2) -> i1[1] - i2[1]); //소요시간 순
    Arrays.sort(jobs, (i1, i2) -> i1[0] - i2[0]); //실행시간 순

    while (idx < jobs.length || !pq.isEmpty()) {

      //현재시간보다 작은 시작시간을 가진 Job을 큐에 등록
      while (idx < jobs.length && curTime >= jobs[idx][0]) {
        pq.add(jobs[idx]);
        idx++;
      }

      if (pq.isEmpty()) {
        
        //큐가 빈 경우 다음 실행순서인 Job의 시작시간을 현재시간으로 설정
        curTime = jobs[idx][0];
        
      } else {
        
        int[] job = pq.poll();
        curTime += job[1];          //현재시간 = 현재시간+Job소요시간
        time += curTime - job[0];   //전체소요시간 = 전체소요시간+현재시간-Job시작시간
      }
      
    }

    return time / jobs.length;
  }
}

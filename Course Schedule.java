class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] matrix = new int[numCourses][numCourses];
        int[] indegree = new int[numCourses];
        
        for(int i = 0; i < prerequisites.length; i++) {
            int curr = prerequisites[i][0];
            int prereq = prerequisites[i][1];
            indegree[curr]++;
            matrix[prereq][curr] = 1;
        }
        
        Queue<Integer> q = new LinkedList<Integer>();
        int count = 0;
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {  //start with node with only out edges
                q.offer(i);
                count++;
            }
        }
        while(!q.isEmpty()) {
            int temp = q.poll();
            for(int i = 0; i < numCourses; i++) {
                if(matrix[temp][i] != 0) {  //analyse its neighbours
                    if(--indegree[i] == 0) {    //decrease the indegree of these nodes by 1.
                        q.offer(i);
                        count++;
                    }
                }
            }
        }
        return count == numCourses;
        
    }
}

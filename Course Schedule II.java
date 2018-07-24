class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> matrix = new ArrayList<>(numCourses);
        for(int i = 0; i < numCourses; i++) {
            matrix.add(new ArrayList<Integer>());   //initialize the array list to hold neighbours
        }
        
        for(int i = 0; i < prerequisites.length; i++) {
            int curr = prerequisites[i][0];
            int pre = prerequisites[i][1];
            indegree[curr]++;
            matrix.get(pre).add(curr);
        }
        
        Queue<Integer> q = new LinkedList<Integer>();
        int[] order = new int[numCourses];
        int index = 0;
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                q.offer(i);
                order[index++] = i;
            }
        }
        
        while(!q.isEmpty()) {
            int temp = q.poll();
            List<Integer> neighbours = matrix.get(temp);
            for(int n : neighbours) {
                indegree[n]--;
                if(indegree[n] == 0) {
                    q.offer(n);
                    order[index++] = n;
                }
            }
        }
        return index == numCourses ? order : new int[0];
        
    }
}

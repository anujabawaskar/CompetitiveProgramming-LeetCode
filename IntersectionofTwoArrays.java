class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1 = nums1.length;
        int len2 = nums2.length;
        int i = 0;
        int j = 0;
        List<Integer> list = new ArrayList<Integer>();
        while(i < len1 && j < len2) {
            if(nums1[i] == nums2[j]) {
                if(!list.contains(nums1[i]))
                    list.add(nums1[i]);
                i++;
                j++;
            }
            else if(nums1[i] < nums2[j])
                i++;
            else
                j++;
        }
        int[] answer = new int[list.size()];
        int index = 0;
        for(int n:list) {
            answer[index] = n;
            index++;
        }
        return answer;
    }
}

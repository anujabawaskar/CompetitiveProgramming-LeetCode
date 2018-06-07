class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();    //use treemap to keep a sorted order
        for(int n : hand) {
            if(!map.containsKey(n))
                map.put(n, 1);
            else
                map.put(n, map.get(n) + 1);
        }
        
        while(!map.isEmpty()) {
            Map.Entry<Integer, Integer> first = map.firstEntry();   //get first entry of the map
            for(int i = 0; i < W; i++) {
                if(!map.containsKey(first.getKey() + i))
                    return false;
                int count = map.get(first.getKey() + i) - 1;    //reduce the count of next card by 1
                if(count == 0)
                    map.remove(first.getKey() + i);
                else
                    map.put(first.getKey() + i, count);
            }
        }
        return true;
    }
}

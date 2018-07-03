class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.split(" ");
        String temp;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(String word : words) {
            if(word.charAt(word.length() - 1) == '!' || word.charAt(word.length() - 1) == '?' || word.charAt(word.length() - 1) == '\''
              || word.charAt(word.length() - 1) == ',' || word.charAt(word.length() - 1) == ';' || word.charAt(word.length() - 1) == '.')
                temp = word.substring(0, word.length() - 1).toLowerCase();
            else
                temp = word.toLowerCase();
            
            if(!map.containsKey(temp))
                map.put(temp, 1);
            else
                map.put(temp, 1 + map.get(temp));
        }
        LinkedHashMap<String, Integer> sorted = sortHashMapByValues(map);
        int flag = 0;
        
        //for (Map.Entry<String, Integer> entry : sorted.entrySet()) 
           // System.out.println(entry.getKey() + " " + entry.getValue());
            
        for (Map.Entry<String, Integer> entry : sorted.entrySet()) {
            String val = entry.getKey();
            flag = 0;
            for(int i = 0; i < banned.length; i++) {
                if(val.equals(banned[i]) == true) {
                    flag = 1;
                    break;
                }
            }
            if(flag == 0)
                return val;
        }
        return null;
        
    }
    public LinkedHashMap<String, Integer> sortHashMapByValues(
        HashMap<String, Integer> passedMap) {
        List<String> mapKeys = new ArrayList<>(passedMap.keySet());
        List<Integer> mapValues = new ArrayList<>(passedMap.values());
        Collections.sort(mapValues, Collections.reverseOrder());
        Collections.sort(mapKeys, Collections.reverseOrder());
        

        LinkedHashMap<String, Integer> sortedMap =
            new LinkedHashMap<>();

        Iterator<Integer> valueIt = mapValues.iterator();
        while (valueIt.hasNext()) {
            int val = valueIt.next();
            Iterator<String> keyIt = mapKeys.iterator();

            while (keyIt.hasNext()) {
                String key = keyIt.next();
                int comp1 = passedMap.get(key);
                int comp2 = val;

                if (comp1 == comp2) {
                    keyIt.remove();
                    sortedMap.put(key, val);
                    break;
                }
            }
        }
        return sortedMap;
    }
}

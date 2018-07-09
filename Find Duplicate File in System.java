class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, ArrayList<String>> info = new HashMap<String, ArrayList<String>>();
        for(String path : paths) {
            String[] files = path.split(" ");
            String root = files[0];
            for(int i = 1; i < files.length; i++) {
                int start = files[i].indexOf("(");
                String content = files[i].substring(start + 1, files[i].indexOf(")"));
                String fileName = files[i].substring(0, start);
                //System.out.println(content);
                String fullPath = root + "/" + fileName;
                //System.out.println(fullPath);
                if(!info.containsKey(content))
                    info.put(content, new ArrayList<String>());
                info.get(content).add(fullPath);
            }
        }
        for(String key : new ArrayList<String>(info.keySet())) {
            ArrayList<String> temp = info.get(key);
            if(temp.size() == 1)
                info.remove(key);
        }
        List<List<String>> answer = new ArrayList<List<String>>(new ArrayList<>(info.values()));
        return answer;
    }
}

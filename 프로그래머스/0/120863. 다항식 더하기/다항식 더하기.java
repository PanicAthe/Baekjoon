class Solution {
    public String solution(String polynomial) {
        String[] arr = polynomial.split("\\s*\\+\\s*");
        int count=0;
        int count_x=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i].contains("x")){
                if(arr[i].length()==1){
                    count_x++;
                }else{
                    count_x += Integer.parseInt(arr[i].substring(0, arr[i].length()-1));
                }
            }else{
                count+= Integer.parseInt(arr[i]);
            }
        }
        String result = "";
        if(count_x!=0){
            if(count_x==1){
                result+="x";
            }else{
                result+=count_x+"x";
            }
            if(count!=0){
                result+=" + "+count;
            }
        }else if(count!=0){
            result+=count+"";
        }
        return result;
    }
}
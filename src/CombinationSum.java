import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class CombinationSum
{
    public static void main(String[] args){
        try{
            CombinationSum obj = new CombinationSum();
            obj.run(args);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void run(String[] args){
        System.out.println(combinationSum(new int[]{2,3,6,7},7));
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> finalList = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        returnAllCombos(candidates,target,finalList,currentList,0);
        return finalList;
    }
    public List<List<Integer>> returnAllCombos(int[] candidates,int target,List<List<Integer>> finalList,List<Integer> currentList,int largestValueUsed){
        if(target == 0){
            List<Integer> tempList = new ArrayList<>();
            boolean sameArray = true;
            HashMap<Integer,Integer> tempHoldUsed = new HashMap<>();
            for(int y=0;y<currentList.size();y++){
                tempList.add(currentList.get(y));
            }
            finalList.add(tempList);
            return finalList;
        }else{
            for(int x=0;x<candidates.length;x++){
                if(candidates[x] <= target && candidates[x] >= largestValueUsed){
                    target-=candidates[x];
                    currentList.add(candidates[x]);
                    int tempLargest = largestValueUsed;
                    largestValueUsed = candidates[x];
                    finalList = returnAllCombos(candidates,target,finalList,currentList,largestValueUsed);
                    target+=candidates[x];
                    currentList.remove(Integer.valueOf(candidates[x]));
                    largestValueUsed = tempLargest;
                }
            }
        }
        return finalList;
    }
}
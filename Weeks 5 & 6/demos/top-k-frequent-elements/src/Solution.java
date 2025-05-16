import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //make a hashmap, check if the number in the array is in there.
        //key = integer value of element in array, value = frequency
        //if not, put that number in with a frequency of 1. If it is there, increment that frequency
        //at the end do a check for the highest frequencies by sorting the values (frequencies)

        //Modify this slightly, instead of sorting at the end can we build the
        //frequency list/array in such a way that it is already sorted?

        //prepare an array for frequencies, size must be large enough to hold a frequency for each element if they were all unique
        //prepare a frequency map, k=element value, v=frequency
        //fill the map as per above
        //move the map into the frequency array where the frequency is the index
        //use the now sorted array to find the k most frequent, adding them into the solution array

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        List<Integer>[] frequencyArray = new List[nums.length+1];

        for(int i = 0; i < nums.length; i++) {
            frequencyMap.put(nums[i], frequencyMap.getOrDefault(nums[i], 0) + 1);
        }

        Set<Integer> keySet = frequencyMap.keySet();
        for(Integer element : keySet) {
            Integer frequency = frequencyMap.get(element);
            if(frequencyArray[frequency] == null) {
                frequencyArray[frequency] = new LinkedList<Integer>();
            }
            frequencyArray[frequency].add(element);
        }

        int[] solution = new int[k];
        int cursor = 0;
        for(int i = frequencyArray.length-1; i > 0; i--) {
            if(cursor >= k) break;
            if(frequencyArray[i] != null) {
                for(Integer element : frequencyArray[i]) {
                    solution[cursor] = element;
                    cursor++;
                }
            }
        }
    return solution;
    }

}

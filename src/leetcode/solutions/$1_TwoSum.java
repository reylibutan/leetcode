package leetcode.solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class $1_TwoSum {

  public static void main(String[] args) {
    $1_Solution sol = new $1_Solution();

    int[] nums = {3, 2, 4};
    int target = 6;

    System.out.println(Arrays.toString(sol.twoSum(nums, target)));
  }

}

// one-pass solution
class $1_Solution {
  public int[] twoSum(int[] nums, int target) {
    // first pass
    Map<Integer, Integer> complements = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      Integer index = complements.get(target - nums[i]);
      if (index == null) {
        complements.put(nums[i], i);
      } else if (i != index) {
        return new int[] {i, index};
      }
    }

    return null;
  }
}

class $1_TwoPassSolution {
  public int[] twoSum(int[] nums, int target) {
    // first pass
    Map<Integer, Integer> complements = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      complements.put(nums[i], i);
    }

    // second pass
    for (int i = 0; i < nums.length; i++) {
      Integer index = complements.get(target - nums[i]);
      if (!(index == null || i == index)) {
        return new int[] {i, index};
      }
    }

    return null;
  }
}

class $1_BruteForceSolution {
  public int[] twoSum(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        int diff = target - nums[i];
        if (diff == nums[j]) {
          return new int[] {i, j};
        }
      }
    }

    return null;
  }
}

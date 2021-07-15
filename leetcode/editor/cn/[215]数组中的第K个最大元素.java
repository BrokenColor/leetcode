//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列）


import javax.swing.table.TableModel;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (k > nums.length || k < 0) return -1;
        return  quickSort(nums, 0, nums.length-1, nums.length-k);
    }

    //基于快排
    public int quickSort(int[] nums, int left, int right, int index){
        if (left <= right){
             int p = partition(nums, left ,right);
             if (p == index){
                 return nums[p];
             }else {
                return p < index ? quickSort(nums, p +1, right, index) : quickSort(nums, left, p-1, index);
             }
        }
        return -1;
    }
    //找基准
    public int partition(int[] nums, int left, int right){
        int pivot = left;
        int index = left + 1;
        for (int i = index; i <= right ; i++) {
            if (nums[i] < nums[pivot]){
                swap(nums, i, index);
                index++;
            }
        }
        swap(nums, pivot, index-1);
        return index -1;
    }

    public void swap(int[] nums, int n1, int n2){
        int temp = nums[n1];
         nums[n1] = nums[n2];
         nums[n2] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

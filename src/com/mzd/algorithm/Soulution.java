package com.mzd.algorithm;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;

public class Soulution {

    public static int[] twoSum(int[] nums, int target) {
        List<Integer> dec = new LinkedList<>();
        int[] rst = new int[2];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                dec.add(nums[i] - target);
            } else {
                for (int j = 0; j < dec.size(); j++) {
                    if (dec.get(j) + nums[i] == 0) {
                        rst[0] = j;
                        rst[1] = i;
                        return rst;
                    }
                }
                dec.add(nums[i] - target);
            }

        }
        return rst;
    }

    public static void main(String[] args) {
        int[] a = new int[]{0, 2, 4, -6, 8, -10, 12};
        int[] b;
        List<List<Integer>> c;
        long start = System.currentTimeMillis();
        c = threeSum(a);
        long end = System.currentTimeMillis();
        System.out.println("消耗时间" + (end - start));
        System.out.println(c);


    }


    public static int[] twoSum2(int[] nums, int target) {
        int[] rst = new int[2];
        Map<Integer, Integer> des = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (des.containsKey(nums[i])) {
                rst[0] = des.get(nums[i]);
                rst[1] = i;
                return rst;
            } else {
                des.put(target - nums[i], i);
            }

        }
        return rst;
    }


    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Map<Integer,Integer>>> finalRst = new ArrayList<>();
        List<List<Integer>> returnRst = new ArrayList<>();
        List<Map<Integer, Integer>> rst = new LinkedList<>();
        Map<Integer, Integer> num;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                num = new HashMap<>();
                num.put(i, nums[i]);
                num.put(j, nums[j]);
                rst.add(num);
            }
        }
        Map<Integer, Integer> temp;
        Map<Integer, Integer> temp2;
        List<Map<Integer,Integer>> eachRst;
        boolean needAdd =true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < rst.size(); j++) {
               needAdd=true;
                temp = rst.get(j);
                int sum = 0;
                 eachRst =new ArrayList<>();
                for (Map.Entry<Integer, Integer> entry : temp.entrySet()) {
                    if (i != entry.getKey()) {
                        sum += entry.getValue();
                        temp2=new HashMap<>();
                        temp2.put(entry.getKey(),entry.getValue());
                        eachRst.add(temp2);
                    } else {
                        needAdd=false;
                        break;
                    }
                }
                if (needAdd&&(nums[i] + sum) == 0) {
                    temp2=new HashMap<>();
                    temp2.put(i,nums[i]);
                    eachRst.add(temp2);
                    if (eachRst.size() == 3) {
                        finalRst.add(eachRst);
                    }
                }
            }
        }

        return null;
    }


}

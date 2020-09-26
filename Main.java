import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {
    // 删除倒数第k个节点

    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = new ListNode(-1);
        ListNode cur = node;
        node.next = head;
        int count = 0;
        while (cur.next != null) {
            count++;
            cur = cur.next;
        }
        if (n == 0) {
            return node.next;
        } else {
            cur = node;
            for (int i = 1; i <= count - n; i++) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return node.next;
    }
    /******************************结束写代码******************************/


    public static void main1(String[] args){
        Scanner cin = new Scanner(System.in);
        String inputStr = null;
        while(cin.hasNext()) {
            inputStr = cin.next();
        }
        String[] split = inputStr.split(";");
        String listNodeStr = split[0];
        String[] listNodes = listNodeStr.split(",");
        ListNode listNode = new ListNode(Integer.parseInt(listNodes[0]));
        ListNode tempNode = listNode;
        for (int i = 1; i < listNodes.length; i++) {
            ListNode currNode = new ListNode(Integer.parseInt(listNodes[i]));
            tempNode.next = currNode;
            tempNode = currNode;
        }
        ListNode res = removeNthFromEnd(listNode, Integer.parseInt(split[1]));
        while (true) {
            System.out.print(res.val);
            if(res.next == null) {
                break;
            }
            System.out.print(",");
            res = res.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}

class Solution {
    // 返回子数组最大累加和

    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int maxsumofSubarray(int[] arr) {
        if(arr == null || arr.length == 0) {
            return 0;
        }
        //定义最大和，以及当前和
        int maxResult = 0;
        int curResult = 0;
        for(int i = 0; i < arr.length; i++){
            curResult += arr[i];
            //取两者间的最大值，代表子数组和的最大和
            maxResult = Math.max(maxResult,curResult);
            //如果当前和为负数的话，再往下累加，则不可能是最大值，因此将它变为0，重新开始
            //如果不是负数，那么则不改变
            curResult = curResult < 0 ? 0 : curResult;
        }
        return maxResult;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner cin = new Scanner(System.in);
        String inputStr = null;
        while(cin.hasNext()) {
            inputStr = cin.next();
        }
        int res;
        if(inputStr == null || "".equals(inputStr)) {
            res = maxsumofSubarray(null);
        } else {
            String[] split = inputStr.split(",");
            int[] inputInt = new int[split.length];
            for (int i = 0; i < split.length; i++) {
                inputInt[i] = Integer.parseInt(split[i]);
            }
            res = maxsumofSubarray(inputInt);
        }

        System.out.println(res);
    }
}
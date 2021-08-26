package com.mao.面试题03_06动物收容所;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Author: 但愿人长久
 * Date: 2021/8/16 15:48
 * Description: 动物收容所。有家动物收容所只收容狗与猫，且严格遵守“先进先出”的原则。
 * 在收养该收容所的动物时，收养人只能收养所有动物中“最老”（由其进入收容所的时间长短而定）的动物，或者可以挑选猫或狗（同时必须收养此类动物中“最老”的）。
 * 换言之，收养人不能自由挑选想收养的对象。请创建适用于这个系统的数据结构，实现各种操作方法，比如enqueue、dequeueAny、dequeueDog和dequeueCat。
 * 允许使用Java内置的LinkedList数据结构。
 * enqueue方法有一个animal参数，animal[0]代表动物编号，animal[1]代表动物种类，其中 0 代表猫，1 代表狗。
 * dequeue*方法返回一个列表[动物编号, 动物种类]，若没有可以收养的动物，则返回[-1,-1]。
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/animal-shelter-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AnimalShelf {

    // 收容所中含有的猫
    Deque<Integer> cat;

    // 收容所中含有的狗
    Deque<Integer> dog;

    public AnimalShelf() {
        cat = new LinkedList<>();
        dog = new LinkedList<>();
    }

    /**
     * 收容动物
     * @param animal
     */
    public void enqueue(int[] animal) {

        // 判断当前收容的动物是猫还是狗
        if (animal[1] == 0) {

            // 如果是猫
            cat.addLast(animal[0]);
        }else {

            // 如果是狗
            dog.addLast(animal[0]);
        }
    }

    /**
     * 收养任何动物
     * 只能收养所有动物中 “最老” 的动物
     * @return
     */
    public int[] dequeueAny() {

        if (!cat.isEmpty() && !dog.isEmpty()) {

            // 判断收容的猫和狗当中最老的是哪一个，序号越小年龄越大
            if (cat.peekFirst() < dog.peekFirst()) {

                // 猫的年龄更大，只能收养猫
                return new int[]{cat.removeFirst(), 0};
            }else {

                // 狗的年龄更大，只能收养狗
                return new int[]{dog.removeFirst(), 1};
            }

        }else if (cat.isEmpty() && dog.isEmpty()){
            return new int[]{-1, -1};
        }else if (!cat.isEmpty() && dog.isEmpty()) {
            return new int[]{cat.removeFirst(), 0};
        }else {
            return new int[]{dog.removeFirst(), 1};
        }
    }

    /**
     * 规定收养狗
     * @return
     */
    public int[] dequeueDog() {

        // 判断收养的狗年龄最大的，也就是队列中最先加入的
        if (!dog.isEmpty()) {
            return new int[]{dog.removeFirst(), 1};
        }else {
            return new int[]{-1, -1};
        }


    }

    /**
     * 规定收养猫
     * @return
     */
    public int[] dequeueCat() {

        // 判断收养的猫的年龄最大的，也就是猫的队列中最先加入的
        if (!cat.isEmpty()) {
            return new int[]{cat.removeFirst(), 0};
        }else {
            return new int[]{-1, -1};
        }
    }

//    // 收容所中含有的猫
//    Deque<int[]> cat;
//
//    // 收容所中含有的狗
//    Deque<int[]> dog;
//
//    public AnimalShelf() {
//        cat = new LinkedList<>();
//        dog = new LinkedList<>();
//    }
//
//    /**
//     * 收容动物
//     * @param animal
//     */
//    public void enqueue(int[] animal) {
//
//        // 判断当前收容的动物是猫还是狗
//        if (animal[1] == 0) {
//
//            // 如果是猫
//            cat.addLast(new int[]{animal[0], 0});
//        }else {
//
//            // 如果是狗
//            dog.addLast(new int[]{animal[0], 1});
//        }
//    }
//
//    /**
//     * 收养任何动物
//     * 只能收养所有动物中 “最老” 的动物
//     * @return
//     */
//    public int[] dequeueAny() {
//
//        // 取出 cat 队列队首
//        int[] headCat;
//        if (!cat.isEmpty()) {
//            headCat = cat.getFirst();
//        }else if (!dog.isEmpty()){
//            return dog.removeFirst();
//        }else {
//            return new int[-1, -1];
//        }
//
//        // 取出 dog 队列队首
//        int[] headDog;
//        if (!dog.isEmpty()) {
//            headDog = dog.getFirst();
//        }else if (!cat.isEmpty()) {
//            return cat.removeFirst();
//        }else {
//            return new int[]{-1, -1};
//        }
//
//        // 判断两者哪个年龄更大
//        if (headCat[0] <= headDog[0]) {
//            return cat.removeFirst();
//        }else {
//            return dog.removeFirst();
//        }
//
//    }
//
//    /**
//     * 规定收养狗
//     * @return
//     */
//    public int[] dequeueDog() {
//
//        // 判断收养的狗年龄最大的，也就是队列中最先加入的
//        if (!dog.isEmpty()) {
//            return dog.removeFirst();
//        }else {
//            return new int[]{-1, -1};
//        }
//
//
//    }
//
//    /**
//     * 规定收养猫
//     * @return
//     */
//    public int[] dequeueCat() {
//
//        // 判断收养的猫的年龄最大的，也就是猫的队列中最先加入的
//        if (!cat.isEmpty()) {
//            return cat.removeFirst();
//        }else {
//            return new int[]{-1, -1};
//        }
//    }
}

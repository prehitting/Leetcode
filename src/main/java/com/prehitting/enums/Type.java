package com.prehitting.enums;

/**
 * @ClassName AlgorithmTag
 * @Description
 * @Author 24809
 * @Date 2023-01-20 23:18
 */
public enum Type {

    None("none"),

    DynamicProgramming("动态规划"),

    Mock("模拟"),

    Hash("哈希"),

    DoublePointer("双指针"),

    BinarySearch("二分查找"),

    Recursion("递归"),

    GRAPH("图论"),

    DYEING("染色法");


    final String name;

    Type(String name) {
        this.name = name;
    }
}

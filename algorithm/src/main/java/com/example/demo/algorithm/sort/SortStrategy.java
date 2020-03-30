package com.example.demo.algorithm.sort;

import com.sun.deploy.util.ArrayUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class SortStrategy {

    private Sort sort;
    private static final Logger logger = LoggerFactory.getLogger(SortStrategy.class);

    public SortStrategy(Sort sort){
        this.sort = sort;
    }

    public void sort(Integer[] list){
        logger.info(this.sort.getClass().getSimpleName() + " 排序开始：");
        logger.info("排序前: {}", Arrays.toString(list));
        this.sort.sort(list);
        logger.info("排序后: {}", Arrays.toString(list));
    }
}

package com.bitacademy.utils;

import java.util.Comparator;

import com.bitacademy.vo.DataVO;

public class DataComparatorByTime implements Comparator<DataVO> {

    // _id,Temperature,Wtime,Humidity,waterFlow,W,time(2020/06/04/09/13/27),DustDensity
    // 내림차순 정렬
    @Override
    public int compare(DataVO o1, DataVO o2) {
        int result = o1.getTime().compareTo(o2.getTime());
        if (result > 0) {
            return -1;
        } else if (result == 0) {
            return 0;
        } else {
            return 1;
        }
    }

}
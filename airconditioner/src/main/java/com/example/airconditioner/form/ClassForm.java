package com.example.airconditioner.form;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import com.example.airconditioner.entity.Class;
import lombok.Data;

@Data
public class ClassForm {
    String className;
    String endTime;

    public Class toEntity() {
        Date startTime = new Date();
        Random rand = new Random();
        String cid = String.valueOf(rand.nextInt(1000000));

        //終了時刻をDate型に変更
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startTime);
        calendar.add(Calendar.MINUTE, Integer.parseInt(endTime));
        Date endTime = calendar.getTime();
        
        // cidの自動生成が面倒なのでとりあえず適当な乱数で
        Class c = new Class(cid, startTime, endTime, className);
        
        return c;
    }
}
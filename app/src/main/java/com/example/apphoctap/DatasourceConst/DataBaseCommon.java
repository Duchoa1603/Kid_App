package com.example.apphoctap.DatasourceConst;

import com.example.apphoctap.R;
import com.example.apphoctap.model.CardCommon;
import com.example.apphoctap.model.GhepTu;
import com.example.apphoctap.model.Quizz;

import java.util.ArrayList;
import java.util.List;

public class DataBaseCommon {
    public static List<CardCommon> getListAphabeta() {
        List<CardCommon> list = new ArrayList<>();
        list.add(new CardCommon(R.drawable.a,R.raw.a));
        list.add(new CardCommon(R.drawable.b,R.raw.b));
        list.add(new CardCommon(R.drawable.c,R.raw.c));
        list.add(new CardCommon(R.drawable.d,R.raw.d));
        list.add(new CardCommon(R.drawable.e,R.raw.e));
        list.add(new CardCommon(R.drawable.f,R.raw.f));
        list.add(new CardCommon(R.drawable.g,R.raw.g));
        list.add(new CardCommon(R.drawable.h,R.raw.h));
        list.add(new CardCommon(R.drawable.i,R.raw.i));
        list.add(new CardCommon(R.drawable.j,R.raw.j));
        list.add(new CardCommon(R.drawable.k,R.raw.k));
        list.add(new CardCommon(R.drawable.l,R.raw.l));
        list.add(new CardCommon(R.drawable.m,R.raw.m));
        list.add(new CardCommon(R.drawable.n,R.raw.n));
        list.add(new CardCommon(R.drawable.o,R.raw.o));
        list.add(new CardCommon(R.drawable.p,R.raw.p));
        list.add(new CardCommon(R.drawable.q,R.raw.q));
        list.add(new CardCommon(R.drawable.r,R.raw.r));
        list.add(new CardCommon(R.drawable.s,R.raw.s));
        list.add(new CardCommon(R.drawable.t,R.raw.t));
        list.add(new CardCommon(R.drawable.u,R.raw.u));
        list.add(new CardCommon(R.drawable.v,R.raw.v));
        list.add(new CardCommon(R.drawable.w,R.raw.w));
        list.add(new CardCommon(R.drawable.x,R.raw.x));
        list.add(new CardCommon(R.drawable.y,R.raw.y));
        list.add(new CardCommon(R.drawable.z,R.raw.z));
        list.add(new CardCommon(R.drawable.zz,R.raw.zz));
        list.add(new CardCommon(R.drawable.zzz,R.raw.zzz));
        list.add(new CardCommon(R.drawable.zzzz,R.raw.zzzz));
        list.add(new CardCommon(R.drawable.zzzzz,R.raw.zzzzz));
        list.add(new CardCommon(R.drawable.zzzzzz,R.raw.zzzzzz));
        list.add(new CardCommon(R.drawable.zzzzzzz,R.raw.zzzzzzz));
        list.add(new CardCommon(R.drawable.zzzzzzzz,R.raw.zzzzzzzz));

        return list;
    }

    public static List<CardCommon> getListNumber() {
        List<CardCommon> list = new ArrayList<>();
        list.add(new CardCommon(R.drawable.a000,R.raw.a0));
        list.add(new CardCommon(R.drawable.a001,R.raw.a1));
        list.add(new CardCommon(R.drawable.a002,R.raw.a2));
        list.add(new CardCommon(R.drawable.a003,R.raw.a3));
        list.add(new CardCommon(R.drawable.a004,R.raw.a4));
        list.add(new CardCommon(R.drawable.a005,R.raw.a5));
        list.add(new CardCommon(R.drawable.a006,R.raw.a6));
        list.add(new CardCommon(R.drawable.a007,R.raw.a7));
        list.add(new CardCommon(R.drawable.a008,R.raw.a8));
        list.add(new CardCommon(R.drawable.a009,R.raw.a9));
        return list;
    }

    public static List<CardCommon> getHinhHoc() {
        List<CardCommon> list = new ArrayList<>();
        list.add(new CardCommon("#008000",R.raw.c1));
        list.add(new CardCommon("#7FFFD4",R.raw.c2));
        list.add(new CardCommon("#50C878",R.raw.c3));
        list.add(new CardCommon("#FF0000",R.raw.c4));
        list.add(new CardCommon("#960018",R.raw.c5));
        list.add(new CardCommon("#E52B50",R.raw.c6));
        list.add(new CardCommon("#FFFF00",R.raw.c7));
        list.add(new CardCommon("#F4C430",R.raw.c8));
        list.add(new CardCommon("#CCFF00",R.raw.c9));
        list.add(new CardCommon("#FFC0CB",R.raw.c10));
        list.add(new CardCommon("#FF00FF",R.raw.c11));
        list.add(new CardCommon("#DA70D6",R.raw.c12));
        list.add(new CardCommon("#007FFF",R.raw.c13));
        list.add(new CardCommon("#800080",R.raw.c14));
        list.add(new CardCommon("#4B0082",R.raw.c15));
        list.add(new CardCommon("#772953",R.raw.c16));
        list.add(new CardCommon("#A52A2A",R.raw.c17));
        list.add(new CardCommon("#FFA500",R.raw.c18));
        list.add(new CardCommon("#D53E07",R.raw.c19));
        return list;


//        list.add(new CardCommon(R.drawable.t0,R.raw.htg));
//        list.add(new CardCommon(R.drawable.hh,R.raw.kub));
//        list.add(new CardCommon(R.drawable.ht,R.raw.hinhtru));
//        list.add(new CardCommon(R.drawable.hv,R.raw.hv));
//        list.add(new CardCommon(R.drawable.hthoi,R.raw.romb));
//        list.add(new CardCommon(R.drawable.t1,R.raw.hcn));
//        list.add(new CardCommon(R.drawable.t2,R.raw.h4));
//        list.add(new CardCommon(R.drawable.tr,R.raw.ht));
//        list.add(new CardCommon(R.drawable.t3,R.raw.h5));
//        list.add(new CardCommon(R.drawable.tug,R.raw.hthang));

//        return list;
    }


    public static List<Quizz> getListQuizzText() {
        List<Quizz> list = new ArrayList<>();
        list.add(new Quizz("6 + 7 = ?","13","12","11","10","13"));
        list.add(new Quizz("2 + 10 = ?","13","14","11","12","12"));
        list.add(new Quizz("10 + 7 = ?","16","15","17","18","17"));
        list.add(new Quizz("6 - 5 = ?","4","1","3","2","1"));
        list.add(new Quizz("10 + 15 = ?","25","24","23","22","25"));
        list.add(new Quizz("20 - 7 = ?","13","12","11","10","13"));
        list.add(new Quizz("10 - 3 = ?","6","5","4","7","7"));
        list.add(new Quizz("30 + 5 = ?","34","35","36","37","35"));
        list.add(new Quizz("50 - 20 = ?","27","28","29","30","30"));
        list.add(new Quizz("15 + 7 = ?","20","21","22","23","22"));
        list.add(new Quizz("10 + 4 = ?","13","14","15","16","14"));
        list.add(new Quizz("18 + 2 = ?","20","22","23","24","20"));
        list.add(new Quizz("23 - 7 = ?","15","17","16","20","16"));
        list.add(new Quizz("10 + 7 = ?","18","16","17","12","17"));
        list.add(new Quizz("11 + 8 = ?","17","19","11","10","19"));
        list.add(new Quizz("6 + 16 = ?","20","21","22","23","22"));
        list.add(new Quizz("20 + 1 = ?","21","12","32","40","21"));
        list.add(new Quizz("17 + 7 = ?","24","25","26","30","24"));
        list.add(new Quizz("19 + 7 = ?","13","29","26","27","26"));
        list.add(new Quizz("77 - 27 = ?","51","48","50","49","50"));
        list.add(new Quizz("15 + 4 = ?","20","21","19","18","19"));
        list.add(new Quizz("44 + 16 = ?","62","60","61","63","60"));
        list.add(new Quizz("22 + 18 = ?","40","39","41","38","40"));
        list.add(new Quizz("23 - 13 = ?","8","11","10","9","10"));
        list.add(new Quizz("71 + 14 = ?","84","83","86","85","85"));
        list.add(new Quizz("23 + 13 = ?","36","35","34","33","36"));
        list.add(new Quizz("6 + 16 = ?","20","21","22","23","22"));
        list.add(new Quizz("20 + 11 = ?","21","22","32","31","31"));
        list.add(new Quizz("17 + 32 = ?","46","47","48","49","49"));
        list.add(new Quizz("9 + 2 = ?","13","12","11","10","11"));

        return list;
    }


    public static List<GhepTu> getListNhinVat() {
        List<GhepTu> list = new ArrayList<>();
        list.add(new GhepTu(R.drawable.conbo1,"оавкор","корова"));
        list.add(new GhepTu(R.drawable.dog,"акасоб","собака"));
        list.add(new GhepTu(R.drawable.conheo,"винсья","свинья"));
        list.add(new GhepTu(R.drawable.ga,"цкуриа","курица"));
        list.add(new GhepTu(R.drawable.cat2,"окт","кот"));

        list.add(new GhepTu(R.drawable.gau,"ьддемве","медведь"));
        list.add(new GhepTu(R.drawable.ho,"грти","тигр"));
        list.add(new GhepTu(R.drawable.tho,"клиорк","кролик"));
        list.add(new GhepTu(R.drawable.voi,"носл","слон"));

        list.add(new GhepTu(R.drawable.conbo1,"оавкор","корова"));
        list.add(new GhepTu(R.drawable.dog,"акасоб","собака"));
        list.add(new GhepTu(R.drawable.conheo,"винсья","свинья"));
        list.add(new GhepTu(R.drawable.ga,"цкуриа","курица"));
        list.add(new GhepTu(R.drawable.cat2,"окт","кот"));

        list.add(new GhepTu(R.drawable.gau,"ьддемве","медведь"));
        list.add(new GhepTu(R.drawable.ho,"грти","тигр"));
        list.add(new GhepTu(R.drawable.tho,"клиорк","кролик"));
        list.add(new GhepTu(R.drawable.voi,"носл","слон"));

        list.add(new GhepTu(R.drawable.conbo1,"оавкор","корова"));
        list.add(new GhepTu(R.drawable.dog,"акасоб","собака"));
        list.add(new GhepTu(R.drawable.conheo,"винсья","свинья"));
        list.add(new GhepTu(R.drawable.ga,"цкуриа","курица"));
        list.add(new GhepTu(R.drawable.cat2,"окт","кот"));

        list.add(new GhepTu(R.drawable.gau,"ьддемве","медведь"));
        list.add(new GhepTu(R.drawable.ho,"грти","тигр"));




        return list;
    }

}

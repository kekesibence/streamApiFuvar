package hu.petrik;

import java.util.logging.SocketHandler;

public class Main {

    public static void main(String[] args) {
        Fuvars f = new Fuvars("fuvar.csv");
        //1
        System.out.println(String.format("1: Összes fuvar a listában: %s", f.getFuvarCount()));
        //2
        System.out.println(String.format("2: %s", f.getIncome()));
        //3
        System.out.println(String.format("3: Összes taxis álltal megtett mérföld: %s ", f.getAllMiles()));
        //4
        System.out.println(String.format("4: A leghosszabb fuvar: %s óra volt", (((f.getLongestFuvar()) / 60) / 60)));
        //5
        System.out.println(String.format("5: Fuvardíj/borvvaló legjobb borravaló: %s dollár volt", f.getBiggestTip()));
        //6
        System.out.println(String.format("6: A 4261-es taxis összesen: %s km-t tett meg ", f.getDistanceFromId()));
        //7
        System.out.println(String.format("7: A hibás fuvarok száma: %s\n   Az összes időtartam: %s másodperc\n   Az összes bevétele: %s dollár",
                f.getFaultyFuvar().stream().count(),
                f.getFaultyFuvar().stream().mapToInt(Fuvar::getTravelTime).sum(),
                f.getFaultyFuvar().stream().mapToDouble(fuvar -> fuvar.getPrice() + fuvar.getTip()).sum()));
        //8
        System.out.println(String.format("8: A listában %s 1452-es számú taxis", f.isThere()));
        //9
        System.out.println("9:");
        for (Fuvar fuvar :f.getCheapestFuvar()) {
            System.out.printf(fuvar + "\n");
        }
        //10
        System.out.println(String.format("10: December 24.-én %s fuvar volt", f.anyFuvarOnDec24().stream().count()));
        //11
        System.out.println(String.format("11: December 31.-én %.2f %% borravalót adtak", f.tipsOnDec31()));
    }
}
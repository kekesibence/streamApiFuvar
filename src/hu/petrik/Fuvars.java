package hu.petrik;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Fuvars {

    private List<Fuvar> fuvarList;


    public Fuvars(String fileName){
        fuvarList = new LinkedList<>();
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            br.readLine();
            String line = br.readLine();
            while (line != null){
                fuvarList.add(new Fuvar(line));
                line = br.readLine();
            }

            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.printf(e.getMessage());
        } catch (IOException e) {
            System.out.printf(e.getMessage());
        }
    }
    public String toString() {
        String s = "";
        for (Fuvar re: this.fuvarList) {
            s+= re + "\n";
        }
        return s;
    }

    public long getFuvarCount(){
        return fuvarList.stream().count();
    }

    public String getIncome() {
        return "A 6185-ös taxisnak " +
                fuvarList.stream()
                        .filter((a) -> a.getId() == 6185)
                .count() + " fuvarból " +
                fuvarList.stream()
                        .filter((a) -> a.getId() == 6185)
                        .mapToDouble((a) -> a.getPrice() + a.getTip())
                        .sum() + " dollár bevétele lett";
    }

    public double getAllMiles() {
        return fuvarList.stream()
                .mapToDouble(Fuvar::getTravelLength)
                .sum();
    }

    public int getLongestFuvar() {
         return fuvarList.stream()
                .max(Comparator.comparing(Fuvar::getTravelTime))
                .get()
                .getTravelTime();
    }

    public double getBiggestTip() {
        return fuvarList.stream()
                .max((a, b) -> (int) (a.getTip() / a.getPrice() - b.getTip() / b.getPrice()))
                .get().getTip();
    }
    public double getDistanceFromId() {
        return fuvarList.stream()
                .filter(f -> f.getId() == 4261)
                .mapToDouble(Fuvar::getTravelLength)
                .sum() * 1.6;
    }

    public List<Fuvar> getFaultyFuvar() {
        List<Fuvar> e =  fuvarList.stream()
                .filter(fuvar -> fuvar.getTravelLength() == 0 && fuvar.getPrice() > 0 && fuvar.getTravelLength() == 0)
                .toList();
        return e;
    }

    public String isThere() {
        String van = "";
        if (fuvarList.stream().anyMatch(fuvar -> fuvar.getId() == 1452)) {
            van = "van";
        }else {
            van = "nincs";
        }
        return van;
    }

    public List<Fuvar> getCheapestFuvar(){
        int number = 3;
        return fuvarList.stream()
                .sorted(Comparator.comparing(Fuvar::getTravelTime))
                .filter(fuvar -> fuvar.getTravelTime() != 0)
                .limit(number)
                .collect(Collectors.toList());
    }
    public List<Fuvar> anyFuvarOnDec24(){
        return fuvarList.stream()
                .sorted(Comparator.comparing(Fuvar::getTravelTime))
                .filter(fuvar -> fuvar.getStart().contains("12-24"))
                .collect(Collectors.toList());
    }
    public double tipsOnDec31() {
        double price =  fuvarList.stream()
                .filter(fuvar -> fuvar.getStart().contains("12-31"))
                .mapToDouble(Fuvar::getPrice).sum();
        double tips  =  fuvarList.stream()
                .filter(fuvar -> fuvar.getStart().contains("12-31"))
                .mapToDouble(Fuvar::getTip).sum();
        return price / tips;
    }

/**

    public List<RealEstate> getSalesInCity(String city) {
        return this.realEstateList.stream()
                .filter(ingatlan -> ingatlan.getCity().equals(city))
                .collect(Collectors.toList());
    }

    public List<String> getSortedCities() {
        return realEstateList.stream()
                .map(ingatlan -> ingatlan.getCity())
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<String> getTypes() {
        return realEstateList.stream()
                .map(ingatlan -> ingatlan.getType())
                .distinct()
                .collect(Collectors.toList());
    }

    public List<RealEstate> getMostExpensiveRealEstates(int number){
        return realEstateList.stream()
                .sorted( Comparator.comparing(RealEstate::getPrice).reversed())
                .limit(number)
                .collect(Collectors.toList());
    }

    public List<RealEstate> getLeastExpensiveRealEstates(int number){
        return realEstateList.stream()
                .sorted( Comparator.comparing(RealEstate::getPrice))
                .limit(number)
                .collect(Collectors.toList());
    }


    @Override
   */
}
/**
 * Edit on 2018.3.4 by zfr
 */

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {
    public ArrayList<Item> loadItems(String fileName) throws Exception{
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);//maybe ex
        ArrayList list = new ArrayList();
        while (scanner.hasNextLine()){
            String[] itemStr = scanner.nextLine().split("=");
            Item item = new Item();
            item.name = itemStr[0];
            item.weight = Integer.parseInt(itemStr[1]);//maybe ex
            list.add(item);
        }
        return list;
    }

    public ArrayList<U1> loadU1(ArrayList<Item> listItem){
        ArrayList listU1 = new ArrayList();
        int tempI=0;
        int overI=0;
        U1 u1;
        Boolean isFinish=true;
        while (isFinish){
            u1 = new U1();
            u1.currentWeight = 10000;
            u1.maxWeight = 18000;
            u1.cost = 1;
            for (int i=tempI;i<listItem.size();i++){
                if (u1.canCarry(listItem.get(i))){
                    u1.carry(listItem.get(i));
                    overI = i;
                }else{
                    tempI = i;
                    break;
                }
            }
            u1.curMax = (double) u1.currentWeight/u1.maxWeight;
            listU1.add(u1);
            if(overI==listItem.size()-1){
                isFinish =false;
            }
        }
        return listU1;
    }

    public ArrayList<U2> loadU2(ArrayList<Item> listItem) {
        ArrayList listU2 = new ArrayList();
        int tempI=0;
        int overI=0;
        U2 u2;
        Boolean isFinish=true;
        while (isFinish){
            u2 = new U2();
            u2.currentWeight = 18000;
            u2.maxWeight = 29000;
            u2.cost = 1.2;
            for (int i=tempI;i<listItem.size();i++){
                if (u2.canCarry(listItem.get(i))){
                    u2.carry(listItem.get(i));
                    overI = i;
                }else {
                    tempI=i;
                    break;
                }
            }
            u2.curMax = (double) u2.currentWeight/u2.maxWeight;
            listU2.add(u2);
            if(overI==listItem.size()-1){
                isFinish =false;
            }
        }
        return listU2;
    }

    public double runSimulation(ArrayList rocketList,int rocketType){
        //rocketType 1-U1 2-U2
        double allCost = 0;
        int repeat =0;
        if(rocketType == 1){
            for(int i=0;i<rocketList.size();i++){
                U1 u1 = (U1) rocketList.get(i);
                allCost += u1.cost;
                if(!(u1.launch()&&u1.land())){
                    i-=1;
                    //System.out.println(i);
                    repeat++;
                }
            }
        }else if(rocketType==2){
            for(int i=0;i<rocketList.size();i++){
                U2 u2 = (U2) rocketList.get(i);
                allCost += u2.cost;
                if(!(u2.launch()&&u2.land())){
                    i-=1;
                    //System.out.println(i);
                    repeat++;
                }
            }
        }
        //System.out.println(repeat);
        return allCost;
    }
}

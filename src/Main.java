/**
 * 创建一个 Simulation 对象 ok
 * 为第一阶段和第二阶段装载 Item  ok
 * 为第一阶段和第二阶段装载 U1 火箭舰队
 * 使用 U1 火箭舰队运行模拟，并显示所需的总预算。
 * 为 U2 火箭重复相同的流程，并显示所需的总预算
 *
 * finish on 2018.3.4  U1 is best.
 */

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Main {
    public static void main(String [] args) throws Exception{
        Simulation simulation = new Simulation();
        ArrayList<Item> phase1Item = simulation.loadItems("phase-1.txt");
        ArrayList<Item> phase2Item = simulation.loadItems("phase-2.txt");

        ArrayList<U1> phase1U1 = simulation.loadU1(phase1Item);
        ArrayList<U1> phase2U1 = simulation.loadU1(phase2Item);
        //System.out.println(phase1U1.size()+phase2U1.size());
        double allCostU1 = simulation.runSimulation(phase1U1,1)+simulation.runSimulation(phase2U1,1);

        ArrayList<U2> phase1U2 = simulation.loadU2(phase1Item);
        ArrayList<U2> phase2U2 = simulation.loadU2(phase2Item);
        //System.out.println(phase1U2.size()+phase2U2.size());
        double allCostU2 = simulation.runSimulation(phase1U2,2)+simulation.runSimulation(phase2U2,2);

        System.out.println(allCostU1);
        DecimalFormat df = new DecimalFormat("0.0");
        System.out.println(df.format(allCostU2));//e.g. 75.60000000000007  why?
    }
}

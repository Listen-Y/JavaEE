public class TestProcess {
    public static void main(String[] args) {
        PCB[] pcbs = new PCB[5];
        pcbs[0] = new PCB("P1", 2, 1);
        pcbs[1] = new PCB("P2", 3, 5);
        pcbs[2] = new PCB("P3", 1, 3);
        pcbs[3] = new PCB("P4", 2, 4);
        pcbs[4] = new PCB("P5", 4, 2);
        ProcessScheduling processScheduling = new ProcessScheduling();
        for (PCB p : pcbs
        ) {
            processScheduling.addPCB(p);
        }
        processScheduling.runPCB();
    }
}


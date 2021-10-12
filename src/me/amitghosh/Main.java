package me.amitghosh;

public class Main {

    public static void main(String[] args) {
        // System.out.println(equivalentArrays(new int[]{}, new int[]{}));
        // System.out.println(computeWeightedSum(new int[]{0,0,0, 4}));
        System.out.println(isTwinPaired(new int[]{17}));
    }

    static int equivalentArrays(int[] a1, int[] a2) {
        if(a1.length == 0 || a2.length == 0) return 0;
        for (int x: a1) {
            boolean found = false;
            for (int y: a2) {
                if(x == y) {
                    found = true;
                    break;
                }
            }
            if(!found) return 0;
        }
        return 1;
    }

    static int computeWeightedSum(int[] a) {
        int sum = 0;
        for (int x: a) {
            if(x % 2 == 0) { //even
                sum += 2 * x;
            } else { //odd
                sum += 3 * x;
            }
        }
        return sum;
    }

    static int isTwinPaired(int[] a) {

        int lastEvenIndex = -1;
        int lastOddIndex = -1;
        for(int i=0; i < a.length; i++) {
            if(a[i] % 2 == 0 && lastEvenIndex == -1) {
                lastEvenIndex = i;
            }

            if((a[i] % 2 == 1 || a[i] % 2 == -1) && lastOddIndex == -1) {
                lastOddIndex = i;
            }

            if(lastEvenIndex < i && lastEvenIndex != -1 && a[i] % 2 == 0) {
                if(a[lastEvenIndex]>a[i]) return 0;
            }

            if(lastOddIndex < i && lastOddIndex != -1 && (a[i] % 2 == 1 || a[i] % 2 == -1)) {
                if(a[lastOddIndex]>a[i]) return 0;
            }
        }

        return 1;
    }
}

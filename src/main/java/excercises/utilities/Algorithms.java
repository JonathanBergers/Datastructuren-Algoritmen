package excercises.utilities;

/**
 * Created by jonathan on 24-11-15.
 */
public class Algorithms {



    /**Generates an array of length n
     * with a random permutation of the numbers between the left and rightbound
     *
     * @param n
     * @return
     */
    public static int[] generatePermutations1(int n){
        int[] permutations = new int[n -1];



        for(int k=0; k<n -1; k++){
            int randomNumber = randInt(n);
            while(isInArray(randomNumber, permutations)){
                randomNumber = randInt(n);
            }
            permutations[k]=randomNumber;
        }

        return permutations;
    }
    private static boolean isInArray(int i, int[] array){
        for(int j : array){
            if(j==i){
                return true;
            }
        }
        return false;
    }


    /**Generates an array of length n
     * with a random permutation. according to excercise 2
     *
     *
     * @param n
     * @return
     */
    public static int[] generatePermutations2(int n){
        int[] a = new int[n];
        boolean[] used = new boolean[n];
        for(int k=0; k<n; k++){
            int number = randInt(n);
            while(used[number]){
                number = randInt(n);
            }
            used[number]=true;
            a[k]=number;
        }
        return a;
    }

    /**Generates an array of length n
     * with a random permutation. according to excercise 3
     * @param n
     * @return
     */
    public static int[] generatePermutations3(int n){
        int[] a = new int[n];
        for(int k=0; k<n; k++){
            a[k]=k;
            swap(a, k, randInt(k+1));
        }
        return a;
    }

    private static int[] swap(int[] a, int index1, int index2){
        int i = a[index1];
        a[index1] = a[index2];
        a[index2] = i;
        return a;
    }


    private static int randInt(int n){
        return (int) (Math.random() * n);
    }


}

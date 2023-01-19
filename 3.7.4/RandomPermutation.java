public class RandomPermutation
{
  /**
   * Genereates one permutation of random integers. The number of
   * integers to generate is designated by length and the
   * randomized list of integers is returned.
   *
   * Initial conditions: length cannot be negative
   */
   public static void next(int length)
   {
      int[] r = new int[length];
      int[] p = new int[length];
      
      for (int i = 0; i < length; i++)
        p[i] = i + 1;
        
      for (int n = length; n > 0; n--)
      {
        int pos = (int) (Math.random() * n);
        r[n-1] = p[pos];
        p[pos] = p[n-1];
      }

      String[] horse = {"Trigger", "Silver", "Lady", "Patches", "Duke", "Major", "Misty", "Buddy", "Autumn", "Spirit", "Perry"}; 
      String[] randh = new String[length];

      for (int i=0; i< horse.length; i++){
        int x = r[i]-1;
        randh[i]=horse[x];
      }
      
      for (int i = 0; i<(int)(horse.length/2);i++){
        System.out.println(randh[i*2]+" and "+randh[i*2+1]+" are paired");
      }
      if ((horse.length%2)!=0){
        System.out.println(randh[horse.length-1]+" is alone");
      }
      // debug: System.out.println(java.util.Arrays.toString(r));
      //return r;
   }

}
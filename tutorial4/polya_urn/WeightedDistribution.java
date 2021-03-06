import java.util.Random;

public class WeightedDistribution {
  private static Random generator = new Random(); // For random number generation

  public static int drawFromWeightedDistribution(int[] weights) {
    /*
     * input int array is a list of probability weights for drawing the value
     * of the associated index.
     * preconditions: weights must be positive
     * returns a randomly selected index from the weighted distribution
     */
    // conceptually it is like placing a number of balls in sequence, each labelled
    // with an index from the weights array. If index i has weight w, then there
    // will be w balls labelled with index i. We then choose a ball at random
    int total = getSum(weights);
    int remains = generator.nextInt(total);
    // to determine the value of the ball chosen we loop over each ball-value
    // and decrement <remains> until it falls below zero
    int index = 0;
    while (index < weights.length) {
      remains -= weights[index];
      if (remains < 0) {
        break;
      }
      index++;
    }
    return index;
  }

  public static int getSum(int[] array) {
    /*
     * returns the total number of balls in the urn
     */
    int sum = 0;
    for (int i : array) {
      sum += i;
    }
    return sum;
  }

}

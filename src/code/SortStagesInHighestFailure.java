package code;
import java.util.Arrays;
import java.util.Comparator;

public class SortStagesInHighestFailure {
	public static void main(String[] args) {
		Integer[] lst = {2, 1, 3, 2, 5, 6, 2, 1};
		System.out.println(Arrays.toString(sortStagesInHighestFailure(5, lst)));
	}
	
	// Given: [2, 1, 3, 2, 5, 6, 2, 1]
	// Failure prob = [failed count at that stage] / [total num of CURRENTLY ALIVE players at that stage]
	// that is [0.25, 0.5, 0.3333333333333333, 0.0, 0.5]
	// then sort stages in descending order: [2, 5, 3, 1, 4]
	public static Integer[] sortStagesInHighestFailure(final int numStages, final Integer[] playersFailedAt) {
		
		int numPlayers = playersFailedAt.length;
		Integer[] stages = new Integer[numStages];
		for (int i = 0; i < numStages; i++) {
			stages[i] = i + 1;
		}
		
		Double[] failedProbPerStage = new Double[numStages];
		Arrays.fill(failedProbPerStage, 0.0);
		
		
		for (int i = 0; i < numPlayers; i++) {
			int failedAt = playersFailedAt[i];
			if (failedAt <= numStages) {
				failedProbPerStage[failedAt - 1] += 1;
			}
		}
		System.out.println(Arrays.toString(failedProbPerStage));

		
		double playersLeft = numPlayers * 1.0;
		for (int i = 0; i < failedProbPerStage.length; i++) {
			double failedCount = failedProbPerStage[i];
			failedProbPerStage[i] /= playersLeft;
			playersLeft -= failedCount;
		}
		
		System.out.println(Arrays.toString(stages));
		System.out.println(Arrays.toString(failedProbPerStage));

		Arrays.sort(stages, new Comparator<Integer>() {
			@Override
			public int compare(final Integer o1, final Integer o2) {
				return Double.compare(failedProbPerStage[o2 - 1], failedProbPerStage[o1 - 1]);
			}
		});
		
		return stages;
	}
}

package tgipl.test;

public class MonkeySolution {
	
	public static int monkey(int[] input1)
    {
        int startIndex = 0;
        int endIndex = 0;
        int maxDistance = 0;
        int totalTree = input1.length;
        int totalLoops = totalTree / 2;
        int startingTreeHeight = 0; // Tree where one monkey will be staying
        int counter = 0;
        int distanceBetweenTress = 0;
        int maxOfTwoTreeHeights = 0; // Max of tree at the same distance from the starting point tree
        for (int i = 0; i < totalTree; i++) // We will evaluate all the trees. 
        {
            startingTreeHeight = input1[i];
            startIndex = i;
            endIndex = i;
            counter = 0;
            distanceBetweenTress = 1; // starting with 1 Unit
            maxOfTwoTreeHeights = 0;
            while (counter < totalLoops)
            {
                startIndex++; // Movement of data in One direction
                counter++;
                endIndex--; // Movement of data in opposite direction
                if (startIndex > totalTree - 1)
                {
                    break; // We have calculated the data already .
                }
                if (endIndex < 0)
                {
                    endIndex = totalTree - 1;
                }
                maxOfTwoTreeHeights = input1[startIndex];
                if (maxOfTwoTreeHeights < input1[endIndex]) // Comparing which of the tree is more taller at the same distance on both side
                {
                    maxOfTwoTreeHeights = input1[endIndex];
                }
                int currentDistance = startingTreeHeight + maxOfTwoTreeHeights + distanceBetweenTress;
                if (currentDistance > maxDistance)
                {
                    maxDistance = currentDistance; // If new distance is more update the value.
                }
                distanceBetweenTress++;
            }
        }
        return maxDistance;
    }

}

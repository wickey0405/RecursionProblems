class Solution{
    public static int maxContiguousSubarray(int[] potions){
        //ここから書きましょう
        int tempMax = potions[0];
        int maxValue = Integer.MIN_VALUE;
        for (int i = 1; i < potions.length; i++){
            if (tempMax + potions[i] > potions[i]) tempMax += potions[i];
            else tempMax = potions[i];

            if (maxValue < tempMax) maxValue = tempMax;
        }
        return maxValue;
    }
}
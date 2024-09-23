public class SearchArray {

    public int search(int[] array, int value) {
        int links = 0;
        int rechts = array.length - 1;
        int mitte;
        if (array[links] != value || array[rechts] != value) {
            while (links <= rechts) {
                mitte = (links + rechts) / 2;
                if (array[mitte] == value) {
                    return mitte;
                } else if (array[mitte] > value) {
                    rechts = mitte - 1;
                } else {
                    links = mitte + 1;
                }
            }
        } else {
            return -1;
        }

        return -1;
    }
}

class Solution {
    public String convertToTitle(int columnNumber) {
        String alp = "";

        while (columnNumber > 0) {

            int rem = columnNumber % 26;

            if (rem == 0) {
                rem = 26;
                columnNumber = (columnNumber / 26) - 1;
            } else {
                columnNumber = columnNumber / 26;
            }

            switch (rem) {
                case 1: alp = "A" + alp; break;
                case 2: alp = "B" + alp; break;
                case 3: alp = "C" + alp; break;
                case 4: alp = "D" + alp; break;
                case 5: alp = "E" + alp; break;
                case 6: alp = "F" + alp; break;
                case 7: alp = "G" + alp; break;
                case 8: alp = "H" + alp; break;
                case 9: alp = "I" + alp; break;
                case 10: alp = "J" + alp; break;
                case 11: alp = "K" + alp; break;
                case 12: alp = "L" + alp; break;
                case 13: alp = "M" + alp; break;
                case 14: alp = "N" + alp; break;
                case 15: alp = "O" + alp; break;
                case 16: alp = "P" + alp; break;
                case 17: alp = "Q" + alp; break;
                case 18: alp = "R" + alp; break;
                case 19: alp = "S" + alp; break;
                case 20: alp = "T" + alp; break;
                case 21: alp = "U" + alp; break;
                case 22: alp = "V" + alp; break;
                case 23: alp = "W" + alp; break;
                case 24: alp = "X" + alp; break;
                case 25: alp = "Y" + alp; break;
                case 26: alp = "Z" + alp; break;
            }
        }

        return alp;
    }
}
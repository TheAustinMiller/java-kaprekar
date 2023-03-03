public class Kaprekar {
    static int cnt = 0;

    public static void main(String[] args) {
        System.out.println(kaprekar(456));
    }

    public static int kaprekar(int num) {
        if (num == 6174) {
            return cnt;
        } else {
            cnt++;
            if (num < 10) {
                num *= 1000;
            } else if (num < 100) {
                num *= 100;
            } else if (num < 1000) {
                num *= 10;
            }
            int first = ascend(num);
            int second = flip(first);
            if (Math.max(first, second) == first) {
                int diff = first - second;
                if (diff < 1000) {
                    diff *= 10;
                }
                return kaprekar(diff);
            } else {
                int diff = second - first;
                if (diff < 1000) {
                    diff *= 10;
                }
                return kaprekar(diff);
            }
        }
    }

    public static int ascend(int w) {
        int[] up = new int[4];
        String word = w + "";
        for (int i = 0; i < 4; i++) {
            up[i] = Integer.parseInt(word.substring(i, i+1));
        }

        int ele = 0;
        while (ele != 4) {
            int big = Integer.MIN_VALUE;
            int bigEle = -1;
            for (int i = ele; i < 4; i++) {
                if (up[i] > big) {
                    big = up[i];
                    bigEle = i;
                }
            }
            up = swap(up, ele, bigEle);

            ele++;
        }
        String fin = "";
        for (int i = 0; i < 4; i++) {
            fin += up[i] + "";
        }
        return Integer.parseInt(fin);
    }

    public static int[] swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
        return arr;
    }

    public static int flip(int w) {
        String[] flip = new String[4];
        String word = w + "";
        for (int i = 0; i < 4; i++) {
            flip[i] = word.substring(i, i + 1);
        }
        String[] flipped = new String[4];
        flipped[0] = flip[3];
        flipped[1] = flip[2];
        flipped[2] = flip[1];
        flipped[3] = flip[0];
        String message = "";
        message += flipped[0];
        message += flipped[1];
        message += flipped[2];
        message += flipped[3];
        return Integer.parseInt(message);
    }
}
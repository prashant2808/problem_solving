import java.util.*;

public class Main {
    static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    static long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    static long count(long a, long b, long c, long mid) {
        return ((mid / a) + (mid / b) + (mid / c) - (mid / lcm(a, b)) - (mid / lcm(b, c)) - (mid / lcm(a, c)) + (mid / lcm(a, lcm(b, c))));
    }

    static long nthdivisible(long a, long b, long c, long n) {
        long l = 0;
        long h = Long.MAX_VALUE;

        while (l <= h) {
            long mid = (l + h) / 2;
            if (count(a, b, c, mid) == n) {
                return mid;
            } else if (count(a, b, c, mid) < n) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        long c = scanner.nextLong();
        long n = scanner.nextLong();
        System.out.println(nthdivisible(a, b, c, n));
    }
}

package Q2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SecretSharing {
    public static List<Integer> findSecretRecipients(int n, int[][] intervals, int firstPerson) {
        // Initialize a set to store individuals who have received the secret
        Set<Integer> recipients = new HashSet<>();
        // Add the initial person who has the secret
        recipients.add(firstPerson);
        
        // Iterate through each time interval
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            // Add individuals within the current interval to the set of recipients
            for (int i = start; i <= end; i++) {
                recipients.add(i % n); // Use modulo to handle cyclic nature of sharing
            }
        }
        
        // Convert the set to a list and sort it
        List<Integer> result = new ArrayList<>(recipients);
        Collections.sort(result);
        
        return result;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] intervals = {{0, 2}, {1, 3}, {2, 4}};
        int firstPerson = 0;
        List<Integer> recipients = findSecretRecipients(n, intervals, firstPerson);
        System.out.println("Individuals who will eventually know the secret: " + recipients);
    }
}
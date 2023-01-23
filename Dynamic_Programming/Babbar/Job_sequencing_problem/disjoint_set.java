// Time : O(n * log (max deadline)), Space : O(max deadline).
package Dynamic_Programming.Babbar.Job_sequencing_problem;
import java.util.*;
public class disjoint_set {
    class Job {
        int id, profit, deadline;
        Job(int x, int y, int z){ this.id = x; this.deadline = y; this.profit = z; }
    }
    int parent[];
    int find(int x) {
        if(x == parent[x])
            return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }
    void union(int u, int v) {
        parent[v] = u;
    }
    int[] JobScheduling(Job arr[], int n) {
        Arrays.sort(arr, (a, b)->(b.profit - a.profit));
        int maxDeadline = 0;
        for( int i = 0; i<n; i++) {
            maxDeadline = Math.max(maxDeadline, arr[i].deadline);
        }
        parent = new int[maxDeadline + 1];
        for(int i = 0; i <= maxDeadline; i++) {
            parent[i] = i;
        }
        int countJobs = 0, maxProfit = 0;
        int sequence[] = new int[maxDeadline + 1];
        for(Job x : arr) {
            int availableSlot = find(x.deadline);
            if(availableSlot > 0) {
                maxProfit += x.profit;
                countJobs++;
                sequence[availableSlot] = x.id;
                union(find(availableSlot - 1), availableSlot);
            }
        }
        return new int[] {countJobs, maxProfit};
    }
}

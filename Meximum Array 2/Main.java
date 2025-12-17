import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Using FastScanner for efficiency given multiple test cases
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastScanner in = new FastScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        
        int t = in.nextInt();
        while (t-- > 0) {
            solve(in, out);
        }
        out.close();
    }

    static class Query {
        int c, l, r;
        public Query(int c, int l, int r) {
            this.c = c;
            this.l = l;
            this.r = r;
        }
    }

    static void solve(FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        int q = in.nextInt();
        
        Query[] queries = new Query[q];
        boolean[] isType1 = new boolean[n + 1];
        boolean[] isType2 = new boolean[n + 1];

        // Read queries and mark constraints on indices
        for (int i = 0; i < q; i++) {
            int c = in.nextInt();
            int l = in.nextInt();
            int r = in.nextInt();
            queries[i] = new Query(c, l, r);
            
            // Mark indices affected by specific constraint types
            for (int j = l; j <= r; j++) {
                if (c == 1) isType1[j] = true; // Must be >= k
                else isType2[j] = true;        // Must be != k
            }
        }

        int[] a = new int[n + 1];
        // Initialize with a large value (simulating infinity or > k)
        // 10^9 is the max allowed value and satisfies "not k" and ">= k"
        Arrays.fill(a, 1000000000); 

        // --- Phase 1: Satisfy Type 1 Constraints (min = k) ---
        // Requirement: Range must contain 'k', and all values must be >= k.
        // Logic: Initialization handles >= k (since 10^9 >= k). We just need to place 'k'.
        for (Query query : queries) {
            if (query.c == 1) {
                boolean hasK = false;
                for (int j = query.l; j <= query.r; j++) {
                    if (a[j] == k) {
                        hasK = true;
                        break;
                    }
                }
                
                if (!hasK) {
                    for (int j = query.l; j <= query.r; j++) {
                        // We can only place k if Type 2 doesn't forbid it.
                        // Type 2 forbids k because MEX=k implies k is absent.
                        if (!isType2[j]) {
                            a[j] = k;
                            break; // One k is sufficient
                        }
                    }
                }
            }
        }

        // --- Phase 2: Satisfy Type 2 Constraints (MEX = k) ---
        // Requirement: Range must contain 0, 1, ..., k-1.
        // Logic: Find empty slots to place missing small numbers.
        boolean[] used = new boolean[n + 1]; 
        
        for (Query query : queries) {
            if (query.c == 2) {
                for (int val = 0; val < k; val++) {
                    boolean found = false;
                    
                    // Check if value already exists in the range
                    for (int j = query.l; j <= query.r; j++) {
                        if (a[j] == val) {
                            found = true;
                            break;
                        }
                    }
                    
                    if (!found) {
                        // Find a valid slot to place 'val'
                        for (int j = query.l; j <= query.r; j++) {
                            // Conditions to place a small number < k:
                            // 1. !isType1[j]: If it's Type 1, it MUST be >= k. So we can't put small val there.
                            // 2. !used[j]: Don't overwrite a value we explicitly placed for another requirement in this phase.
                            //    (Note: 10^9 values are considered "unused" free real estate).
                            if (!isType1[j] && !used[j]) {
                                a[j] = val;
                                used[j] = true;
                                break;
                            }
                        }
                    }
                }
            }
        }

        // Output result
        for (int i = 1; i <= n; i++) {
            out.print(a[i] + (i == n ? "" : " "));
        }
        out.println();
    }

    // Fast I/O helper class
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    String line = br.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
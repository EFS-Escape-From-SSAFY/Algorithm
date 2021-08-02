import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_2357 {
    //n:정수의 수;
    //m:구간의 수;
    static void init(int start, int end, int node){
        if(start==end){
            segmentmin[node] = numbers[start];
            segmentmax[node] = numbers[start];
            return;
        }
        int mid = (start+end)/2;
        init(start,mid,node*2);
        init(mid+1,end,node*2+1);
        segmentmin[node] = Math.min(segmentmin[node*2],segmentmin[node*2+1]);
        segmentmax[node] = Math.max(segmentmax[node*2],segmentmax[node*2+1]);
    }
    public static int minFind(int start, int end, int node, int left, int right) {
        if (right < start || end < left) {
            return Integer.MAX_VALUE;
        }
        if (left <= start && end <= right) {
            return segmentmin[node];
        }

        int mid = (start + end) / 2;

        return Math.min(minFind(start, mid, node * 2, left, right), minFind(mid + 1, end, node * 2 + 1, left, right));
    }

    public static int maxFind(int start, int end, int node, int left, int right) {
        if (right < start || end < left) {
            return Integer.MIN_VALUE;
        }
        if (left <= start && end <= right) {
            return segmentmax[node];
        }

        int mid = (start + end) / 2;

        return Math.max(maxFind(start, mid, node * 2, left, right), maxFind(mid + 1, end, node * 2 + 1, left, right));
    }

    static int n;
    static int m;
    static int[] numbers;
    static int[] segmentmin;
    static int[] segmentmax;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        numbers = new int[n];
        segmentmin = new int[n*4];
        segmentmax = new int[n*4];
        for(int i=0;i<n;i++){
            numbers[i]=Integer.parseInt(br.readLine());
        }
        init(0,n-1,1);
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(minFind(0, n-1, 1,a-1,b-1) + " " + maxFind(0, n-1, 1,a-1,b-1) + "\n");
        }
        System.out.println(sb);
    }
}

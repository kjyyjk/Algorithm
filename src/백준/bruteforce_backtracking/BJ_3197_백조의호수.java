package 백준.bruteforce_backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 두가지 로직이 존재한다.
 * 1. 백조가 백조를 만나기.
 * 2. 물이 빙판을 녹이기.
 *
 * 시간 복잡도가 타이트하기 때문에 플러드 필을 사용해야한다.
 * 물이 빙판 한 테두리를 녹이는 순간을 기점으로 레벨이 증가한다.
 * 레밸 별 백조 탐색과 물 탐색을 동시에 진행한다.
 * swan은 탐색 도중 swan을 만나면 true를 반환하고 반복을 종료한다.
 * 만약 빙판을 만난다면 다음 레벨에서 해당 지점에서 시작할 수 있게 swanTempQ에 보관한다.
 * water는 탐색 도중 빙판을 만나면 다음 레벨에서 해당 지점에서 시작할 수 있게 waterTempQ에 보관한다.
 * 한 레벨에서의 swan, water 탐색이 종료되면 각 tempQ의 정점을 Q로 옮겨 다음 레벨을 시작한다.
 *
 * 주의 ! 백조가 위치한 곳도 물이다.
 * 만약 LXXL이면 1일차에 백조가 만나야한다.
 * 
 * 주의 ! 한 레벨에서 물 탐색 시 빙판만 체크하면 된다.
 * 이미 초반 map 저장 시에 모든 물을 waterQ에 저장했기 때문에 앞으로 방문할 수 있는 곳은 결국 빙판 뿐이다.
 */
public class BJ_3197_백조의호수 {

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int r, c;
    static Queue<int[]> swanQ;
    static Queue<int[]> swanTempQ;
    static Queue<int[]> waterQ;
    static Queue<int[]> waterTempQ;
    static int[][] swanVisited;
    static int[][] waterVisited;
    static String[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new String[r + 4][c + 4];
        swanQ = new LinkedList<>();
        swanTempQ = new LinkedList<>();
        waterQ = new LinkedList<>();
        waterTempQ = new LinkedList<>();
        swanVisited = new int[r + 4][c + 4];
        waterVisited = new int[r + 4][c + 4];

        int sy = 0;
        int sx = 0;
        for (int i = 0; i < r; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < c; j++) {
                String temp = split[j];
                if (temp.equals("L")) {
                    sy = i;
                    sx = j;
                }
                if (temp.equals(".") || temp.equals("L")) { // 백조가 위치한 곳도 물
                    waterQ.add(new int[]{i, j});
                    waterVisited[i][j] = 1;
                }
                map[i][j] = temp;
            }
        }

        swanQ.add(new int[]{sy, sx});
        swanVisited[sy][sx] = 1;

        int cnt = 0;
        while (true) { // 레벨 별 반복
            if (moveSwan()) break; // 백조를 만나면 종료 
            waterMelt();
            swanQ.addAll(swanTempQ);
            swanTempQ.clear();
            waterQ.addAll(waterTempQ);
            waterTempQ.clear();
            cnt++; // 레벨 증가
        }

        System.out.println(new StringBuilder().append(cnt));
    }

    static boolean moveSwan() {
        while(!swanQ.isEmpty()) {
            int[] yx = swanQ.poll();
            for (int i = 0; i < 4; i++) {
                int ny = yx[0] + dy[i];
                int nx = yx[1] + dx[i];
                if (ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
                if (swanVisited[ny][nx] != 0) continue;
                swanVisited[ny][nx] = 1;
                if (map[ny][nx].equals("X")) { // 다음 레벨 시작 정점
                    swanTempQ.add(new int[]{ny, nx});
                } else if (map[ny][nx].equals("L")) { // 다른 백조를 만나면
                    return true;
                } else {
                    swanQ.add(new int[]{ny, nx});
                }
            }
        }
        return false;
    }

    static void waterMelt() {
        while(!waterQ.isEmpty()) {
            int[] yx = waterQ.poll();
            for (int i = 0; i < 4; i++) {
                int ny = yx[0] + dy[i];
                int nx = yx[1] + dx[i];
                if (ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
                if (waterVisited[ny][nx] != 0) continue;
                if (map[ny][nx].equals("X")) { // 다음 레벨 시작 정점
                    waterVisited[ny][nx] = 1;
                    map[ny][nx] = ".";
                    waterTempQ.add(new int[]{ny, nx});
                }
            }
        }
    }
}

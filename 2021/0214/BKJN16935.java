import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BKJN16935 {
    static int[][] array, output;
    static int N, M, R, n, m;

    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
//
//        N = sc.nextInt();
//        M = sc.nextInt();
//        R = sc.nextInt();

        array = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
//                array[i][j] = sc.nextInt();
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//        sc.nextLine();
//        String input = sc.nextLine();

        String input = br.readLine();
        String[] command = input.split(" ");

        for(int i=0; i<command.length; i++) {
            output = change(command[i]);
        }

        StringBuilder sb = new StringBuilder();
        for(int[] temp : output) {
            for(int t : temp) {
                sb.append(t).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
        br.close();

//        for(int i=0; i<output.length; i++) {
//            for(int j=0; j<output[0].length; j++) {
//                System.out.print(output[i][j] + " ");
//            }
//            System.out.println();
//        }
    }

    private static int[][] change(String s) {
        int[][] temp;

        switch (s) {
            case "1":
                temp = new int[N][M];
                for(int i=0; i<N; i++) {
                    for(int j=0; j<M; j++) {
                        temp[N - i - 1][j] = array[i][j];
                    }
                }
                array = temp;
                break;

            case "2":
                temp = new int[N][M];
                for(int i=0; i<N; i++) {
                    for(int j=0; j<M; j++) {
                        temp[i][M - 1 - j] = array[i][j];
                    }
                }
                array = temp;
                break;

            case "3":
                temp = new int[M][N];
                int nn = N;
                N = M;
                M = nn;
                for(int i=0; i<N; i++) {
                    for(int j=0; j<M; j++) {
                        temp[i][j] = array[nn-1-j][i];
                    }
                }
                array = temp;
                break;

            case "4":
                temp = new int[M][N];
                int mm = M;
                M = N;
                N = mm;
                for(int i=0; i<N; i++) {
                    for(int j=0; j<M; j++) {
                        temp[i][j] = array[j][mm-1-i];
                    }
                }
                array = temp;
                break;

            case "5":
                temp = new int[N][M];
                n = N/2;
                m = M/2;

                for(int i=0; i<n; i++) {
                    for(int j=0; j<m; j++) {
                        temp[i][j] = array[i+n][j];
                    }
                }
                for(int i=0; i<n; i++) {
                    for(int j=0; j<m; j++) {
                        temp[i][j+m] = array[i][j];
                    }
                }
                for(int i=0; i<n; i++) {
                    for(int j=0; j<m; j++) {
                        temp[i+n][j+m] = array[i][j+m];
                    }
                }
                for(int i=0; i<n; i++) {
                    for(int j=0; j<m; j++) {
                        temp[i+n][j] = array[i+n][j+m];
                    }
                }

                array = temp;
                break;

            case "6":
                temp = new int[N][M];
                n = N/2;
                m = M/2;

                for(int i=0; i<n; i++) {
                    for(int j=0; j<m; j++) {
                        temp[i][j] = array[i][j+m];
                    }
                }
                for(int i=0; i<n; i++) {
                    for(int j=0; j<m; j++) {
                        temp[i][j+m] = array[i+n][j+m];
                    }
                }
                for(int i=0; i<n; i++) {
                    for(int j=0; j<m; j++) {
                        temp[i+n][j+m] = array[i+n][j];
                    }
                }
                for(int i=0; i<n; i++) {
                    for(int j=0; j<m; j++) {
                        temp[i+n][j] = array[i][j];
                    }
                }

                array = temp;
                break;
        }
        return array;
    }
}

import java.util.Queue;


public class Algorithms {
    class DijkstrasAlgorithm {
        private int n;
        private int[][] graph;
        private int[] distance;
        private boolean[] visited;
        private int start;

        public DijkstrasAlgorithm(int n, int[][] graph, int start) {
            this.n = n;
            this.graph = graph;
            this.start = start;
            this.distance = new int[n];
            this.visited = new boolean[n];
            Array.fill(distance, Integer.MAX_VALUE);
            distance[start] = 0;
        }

        public int[] shortestPath() {
            for (int i = 0; i < n - 1; i++) {
                int u = minDistance();
                visited[u] = true;
                for (int v = 0; v < n; v++) {
                    if (!visited[v] && graph[u][v] != 0 && distance[u] != Integer.MAX_VALUE
                            && distance[u] + graph[u][v] < distance[v]) {
                        distance[v] = distance[u] + graph[u][v];
                    }
                }
            }
            return distance;
        }

        private int minDistance() {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int i = 0; i < n; i++) {
                if (!visited[i] && distance[i] <= min) {
                    min = distance[i];
                    minIndex = i;
                }
            }
            return minIndex;
        }
    }

    class KruskalsMST {
        private int n;
        private int[][] graph;
        private int[] parent;

        public KruskalsMST(int n, int[][] graph) {
            this.n = n;
            this.graph = graph;
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int minimumSpanningTree() {
            int cost = 0;
            for (int i = 0; i < n - 1; i++) {
                int u = minEdge();
                int x = find(u);
                int v = minEdge();
                int y = find(v);
                if (x != y) {
                    cost += graph[u][v];
                    union(x, y);
                }
            }
            return cost;
        }

        private int minEdge() {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (graph[i][j] < min) {
                        min = graph[i][j];
                        minIndex = i;
                    }
                }
            }
            return minIndex;
        }

        private int find(int i) {
            while (parent[i] != i) {
                i = parent[i];
            }
            return i;
        }

        private void union(int x, int y) {
            int xSet = find(x);
            int ySet = find(y);
            parent[xSet] = ySet;
        }
    }

    class BreadthFirstSearch {
        private int n;
        private int[][] graph;
        private boolean[] visited;
        private Queue<Integer> queue;

        public BreadthFirstSearch(int n, int[][] graph) {
            this.n = n;
            this.graph = graph;
            this.visited = new boolean[n];
        }

        public void bfs(int start) {
            visited[start] = true;
            queue.add(start);
            while (!queue.isEmpty()) {
                int u = queue.poll();
                for (int v = 0; v < n; v++) {
                    if (!visited[v] && graph[u][v] != 0) {
                        visited[v] = true;
                        queue.add(v);
                    }
                }
            }
        }
    }

    class SelectionSort {
        public int[] sort(int[] arr) {
            int n = arr.length;
            for (int i = 0; i < n - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < n; j++) {
                    if (arr[j] < arr[minIndex]) {
                        minIndex = j;
                    }
                }
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
            return arr;
        }
    }

    class InsertionSort {
        public int[] sort(int[] arr) {
            int n = arr.length;
            for (int i = 1; i < n; i++) {
                int key = arr[i];
                int j = i - 1;
                while (j >= 0 && arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j--;
                }
                arr[j + 1] = key;
            }
            return arr;
        }
    }

    class MergeSort {
        public void sort(int[] arr, int l, int r) {
            if (l < r) {
                int m = l + (r - l) / 2;
                sort(arr, l, m);
                sort(arr, m + 1, r);
                merge(arr, l, m, r);
            }
        }

        private void merge(int[] arr, int l, int m, int r) {
            int n1 = m - l + 1;
            int n2 = r - m;
            int[] L = new int[n1];
            int[] R = new int[n2];
            for (int i = 0; i < n1; i++) {
                L[i] = arr[l + i];
            }
            for (int j = 0; j < n2; j++) {
                R[j] = arr[m + 1 + j];
            }
            int i = 0, j = 0, k = l;
            while (i < n1 && j < n2) {
                if (L[i] <= R[j]) {
                    arr[k] = L[i];
                    i++;
                } else {
                    arr[k] = R[j];
                    j++;
                }
                k++;
            }
            while (i < n1) {
                arr[k] = L[i];
                i++;
                k++;
            }
            while (j < n2) {
                arr[k] = R[j];
                j++;
                k++;
            }
        }
    }

    class QuickSort {
        public void sort(int[] arr, int low, int high) {
            if (low < high) {
                int pi = partition(arr, low, high);
                sort(arr, low, pi - 1);
                sort(arr, pi + 1, high);
            }
        }

        private int partition(int[] arr, int low, int high) {
            int pivot = arr[high];
            int i = low - 1;
            for (int j = low; j < high; j++) {
                if (arr[j] < pivot) {
                    i++;
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            int temp = arr[i + 1];
            arr[i + 1] = arr[high];
            arr[high] = temp;
            return i + 1;
        }
    }

    class BinarySearch {
        public int search(int[] arr, int target) {
            int low = 0;
            int high = arr.length - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (arr[mid] == target) {
                    return mid;
                } else if (arr[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return -1;
        }
    }
}

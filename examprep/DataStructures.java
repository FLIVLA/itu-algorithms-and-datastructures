public class DataStructures {
    class WeightedGraph {
        private int n;
        private int[][] graph;

        public WeightedGraph(int n) {
            this.n = n;
            this.graph = new int[n][n];
        }

        public void insertEdge(int u, int v, int w) {
            graph[u][v] = w;
            graph[v][u] = w;
        }

        public void removeEdge(int u, int v) {
            graph[u][v] = 0;
            graph[v][u] = 0;
        }

        public void print() {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(graph[i][j] + " ");
                }
                System.out.println();
            }
        }

        public void dijkstra(int start) {
            int[] dist = new int[n];
            boolean[] visited = new boolean[n];
            for (int i = 0; i < n; i++) {
                dist[i] = Integer.MAX_VALUE;
                visited[i] = false;
            }
            dist[start] = 0;
            for (int i = 0; i < n - 1; i++) {
                int u = minDistance(dist, visited);
                visited[u] = true;
                for (int v = 0; v < n; v++) {
                    if (!visited[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
                        dist[v] = dist[u] + graph[u][v];
                    }
                }
            }
            printDijkstra(dist);
        }

        class Node {
            int vertex;
            int weight;

            public Node(int vertex, int weight) {
                this.vertex = vertex;
                this.weight = weight;
            }
        }
    }
    
    class PriorityQueue {
        private Node[] data;
        private int size;
        private int capacity;

        public PriorityQueue(int capacity) {
            this.capacity = capacity;
            this.data = new Node[capacity];
            this.size = 0;
        }

        public void push(int vertex, int weight) {
            if (size == capacity) {
                throw new IllegalStateException("Queue is full");
            }
            data[size++] = new Node(vertex, weight);
            int i = size - 1;
            while (i > 0 && data[parent(i)].weight > data[i].weight) {
                swap(i, parent(i));
                i = parent(i);
            }
        }

        public Node pop() {
            if (size == 0) {
                throw new IllegalStateException("Queue is empty");
            }
            Node node = data[0];
            data[0] = data[--size];
            heapify(0);
            return node;
        }

        private void heapify(int i) {
            int l = left(i);
            int r = right(i);
            int smallest = i;
            if (l < size && data[l].weight < data[i].weight) {
                smallest = l;
            }
            if (r < size && data[r].weight < data[smallest].weight) {
                smallest = r;
            }
            if (smallest != i) {
                swap(i, smallest);
                heapify(smallest);
            }
        }

        private void swap(int i, int j) {
            Node temp = data[i];
            data[i] = data[j];
            data[j] = temp;
        }

        private int parent(int i) {
            return (i - 1) / 2;
        }

        private int left(int i) {
            return 2 * i + 1;
        }

        private int right(int i) {
            return 2 * i + 2;
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == capacity;
        }

        public void print() {
            for (int i = 0; i < size; i++) {
                System.out.print(data[i].vertex + " ");
            }
            System.out.println();
        }
    }

    /*
     * Definition of the stack datastructure:
     * A stack is a data structure that allows adding and
     * removing elements in a particular order. Every time an
     * element is added, it goes on the top of the stack, the
     * only element that can be removed is the element that is
     * at the top of the stack.
     */
    class Stack {
        private int[] data;
        private int top;
        private int capacity;

        public Stack(int capacity) {
            this.capacity = capacity;
            this.data = new int[capacity];
            this.top = 0;
        }

        public void push(int value) {
            if (top == capacity) {
                throw new IllegalStateException("Stack is full");
            }
            data[top++] = value;
        }

        public int pop() {
            if (top == 0) {
                throw new IllegalStateException("Stack is empty");
            }
            return data[--top];
        }

        public int size() {
            return top;
        }
    }

    /*
     * Definition of the queue datastructure:
     * A queue is a data structure that allows adding and
     * removing elements in a particular order. Every time an
     * element is added, it goes on the back of the queue, the
     * only element that can be removed is the element that is
     * at the front of the queue.
     */
    class DoubleEndedQueue {
        private int[] data;
        private int front;
        private int rear;
        private int size;
        private int capacity;

        public DoubleEndedQueue(int capacity) {
            this.capacity = capacity;
            this.data = new int[capacity];
            this.front = 0;
            this.rear = 0;
            this.size = 0;
        }

        public void pushLeft(int value) {
            if (size == capacity) {
                throw new IllegalStateException("Queue is full");
            }
            front = (front - 1 + capacity) % capacity;
            data[front] = value;
            size++;
        }

        public void pushRight(int value) {
            if (size == capacity) {
                throw new IllegalStateException("Queue is full");
            }
            data[rear] = value;
            rear = (rear + 1) % capacity;
            size++;
        }

        public int popLeft() {
            if (size == 0) {
                throw new IllegalStateException("Queue is empty");
            }
            int value = data[front];
            front = (front + 1) % capacity;
            size--;
            return value;
        }

        public int popRight() {
            if (size == 0) {
                throw new IllegalStateException("Queue is empty");
            }
            rear = (rear - 1 + capacity) % capacity;
            int value = data[rear];
            size--;
            return value;
        }

        public int size() {
            return size;
        }
    }

    /*
     * Definition of the priority queue datastructure:
     * A priority queue is a data structure that allows adding and
     * removing elements in a particular order. Every time an
     * element is added, it goes to the correct position in the queue
     * based on its priority. The only element that can be removed is
     * the element that has the highest priority.
     */
    class Stack {
        private int[] data;
        private int top;
        private int capacity;

        public Stack(int capacity) {
            this.capacity = capacity;
            this.data = new int[capacity];
            this.top = 0;
        }

        public void push(int value) {
            if (top == capacity) {
                throw new IllegalStateException("Stack is full");
            }
            data[top++] = value;
        }

        public int pop() {
            if (top == 0) {
                throw new IllegalStateException("Stack is empty");
            }
            return data[--top];
        }

        public int size() {
            return top;
        }
    }

    class Graph {
        private int n;
        private int[][] graph;
        private int[] parent;

        public Graph(int n, int[][] graph) {
            this.n = n;
            this.graph = graph;
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public void insertEdge(int u, int v, int w) {
            graph[u][v] = w;
            graph[v][u] = w;
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

    class BinarySearchTree {
        private Node root;

        public BinarySearchTree() {
            root = null;
        }

        public void insert(int value) {
            root = insert(root, value);
        }

        private Node insert(Node root, int value) {
            if (root == null) {
                root = new Node(value);
            } else if (value < root.value) {
                root.left = insert(root.left, value);
            } else {
                root.right = insert(root.right, value);
            }
            return root;
        }

        public void delete(int value) {
            root = delete(root, value);
        }

        private Node delete(Node root, int value) {
            if (root == null) {
                return null;
            }
            if (value < root.value) {
                root.left = delete(root.left, value);
            } else if (value > root.value) {
                root.right = delete(root.right, value);
            } else {
                if (root.left == null) {
                    return root.right;
                } else if (root.right == null) {
                    return root.left;
                }
                root.value = minValue(root.right);
                root.right = delete(root.right, root.value);
            }
            return root;
        }

        private int minValue(Node root) {
            int min = root.value;
            while (root.left != null) {
                min = root.left.value;
                root = root.left;
            }
            return min;
        }

        public boolean search(int value) {
            return search(root, value);
        }

        private boolean search(Node root, int value) {
            if (root == null) {
                return false;
            }
            if (value == root.value) {
                return true;
            } else if (value < root.value) {
                return search(root.left, value);
            } else {
                return search(root.right, value);
            }
        }

        public void inorder() {
            inorder(root);
        }

        private void inorder(Node root) {
            if (root != null) {
                inorder(root.left);
                System.out.print(root.value + " ");
                inorder(root.right);
            }
        }

        private class Node {
            private int value;
            private Node left;
            private Node right;

            public Node(int value) {
                this.value = value;
                this.left = null;
                this.right = null;
            }
        }
    }

    class priorityQueue {
        class Item {
            int value;
            int priority;

            public Item(int value, int priority) {
                this.value = value;
                this.priority = priority;
            }
        }

        private Item[] data;
        private int size;
        private int capacity;

        public priorityQueue(int capacity) {
            this.capacity = capacity;
            this.data = new Item[capacity];
            this.size = 0;
        }

        public void push(int value, int priority) {
            if (size == capacity) {
                throw new IllegalStateException("Queue is full");
            }
            data[size++] = new Item(value, priority);
            int i = size - 1;
            while (i > 0 && data[parent(i)].priority < data[i].priority) {
                swap(i, parent(i));
                i = parent(i);
            }
        }

        public int pop() {
            if (size == 0) {
                throw new IllegalStateException("Queue is empty");
            }
            int value = data[0].value;
            data[0] = data[--size];
            heapify(0);
            return value;
        }

        private void heapify(int i) {
            int l = left(i);
            int r = right(i);
            int largest = i;
            if (l < size && data[l].priority > data[i].priority) {
                largest = l;
            }
            if (r < size && data[r].priority > data[largest].priority) {
                largest = r;
            }
            if (largest != i) {
                swap(i, largest);
                heapify(largest);
            }
        }

        private void swap(int i, int j) {
            Item temp = data[i];
            data[i] = data[j];
            data[j] = temp;
        }

        private int parent(int i) {
            return (i - 1) / 2;
        }

        private int left(int i) {
            return 2 * i + 1;
        }

        private int right(int i) {
            return 2 * i + 2;
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == capacity;
        }

        public void print() {
            for (int i = 0; i < size; i++) {
                System.out.print(data[i].value + " ");
            }
            System.out.println();
        }
    }
}
